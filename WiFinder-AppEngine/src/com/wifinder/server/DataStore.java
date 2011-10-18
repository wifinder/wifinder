package com.wifinder.server;

import com.google.android.c2dm.server.PMF;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.google.web.bindery.requestfactory.server.RequestFactoryServlet;

import java.util.Calendar;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.ServletContext;

public class DataStore {


  /**
   * Remove this object from the data store.
   */
  public void delete(Long id) {
    PersistenceManager pm = PMF.get().getPersistenceManager();
    try {
      Hotspot item = pm.getObjectById(Hotspot.class, id);
      pm.deletePersistent(item);
    } finally {
      pm.close();
    }
  }

  /**
     * Find a {@link Task} by id.
     * 
     * @param id the {@link Task} id
     * @return the associated {@link Task}, or null if not found
     */
    @SuppressWarnings("unchecked")
    public Hotspot find(Long id) {
      if (id == null) {
        return null;
      }
  
      PersistenceManager pm = PMF.get().getPersistenceManager();
      try {
        Query query = pm.newQuery("select from " + Hotspot.class.getName()
            + " where id==" + id.toString() + " && emailAddress=='" + getUserEmail() + "'");
        List<Hotspot> list = (List<Hotspot>) query.execute();
        return list.size() == 0 ? null : list.get(0);
      } catch (RuntimeException e) {
        System.out.println(e);
        throw e;
      } finally {
        pm.close();
      }
    }

@SuppressWarnings("unchecked")
public List<Hotspot> findAll() {
  PersistenceManager pm = PMF.get().getPersistenceManager();
  try {
      Query query = pm.newQuery("select from " + Hotspot.class.getName()
          + " where emailAddress=='" + getUserEmail() + "'");
      List<Hotspot> list = (List<Hotspot>) query.execute();
      if (list.size() == 0) {
           //Workaround for this issue:
           //http://code.google.com/p/datanucleus-appengine/issues/detail?id=24
          list.size();
        }

    return list;
  } catch (RuntimeException e) {
    System.out.println(e);
    throw e;
  } finally {
    pm.close();
  }
}

  /**
   * Persist this object in the datastore.
   */
  public Hotspot update(Hotspot item) {
    //set the user id (not sure this is where we should be doing this)
    item.setUserId(getUserId());
    item.setEmailAddress(getUserEmail());
    if (item.getDueDate() == null) {
        Calendar c = Calendar.getInstance();
        c.set(2011, 5, 11);
        item.setDueDate(c.getTime());
    }
    PersistenceManager pm = PMF.get().getPersistenceManager();
    try {
      pm.makePersistent(item);
      return item;
    } finally {
      pm.close();
    }
  }

  public static String getUserId() {
    UserService userService = UserServiceFactory.getUserService();
    User user = userService.getCurrentUser();
    return user.getUserId();
  }
  
  public static String getUserEmail() {
	    UserService userService = UserServiceFactory.getUserService();
	    User user = userService.getCurrentUser();
	    return user.getEmail();
	  }
	  
  
	
  public static void sendC2DMUpdate(String message) {
	    UserService userService = UserServiceFactory.getUserService();
	    User user = userService.getCurrentUser();
		ServletContext context = RequestFactoryServlet.getThreadLocalRequest().getSession().getServletContext();
		SendMessage.sendMessage(context, user.getEmail(), message);
}




}
