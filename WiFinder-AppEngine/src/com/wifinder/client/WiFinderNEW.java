package com.wifinder.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;
import com.google.web.bindery.requestfactory.shared.Receiver;

import com.wifinder.shared.HotspotsRequestFactory;
import com.wifinder.shared.HotspotProxy;
import com.wifinder.shared.CloudHotspotRequest;

import java.util.List;

public class WiFinder implements EntryPoint {

  private static final String BUTTON_STYLE = "send centerbtn";
  
  HotspotProxy hotspotProxy;
  final HotspotsRequestFactory hotspotRequestFactory = GWT.create(HotspotsRequestFactory.class);

  public void onModuleLoad() {
    RootPanel.get().add(new WiFinderWidget());
    FlowPanel panel = new FlowPanel();
    panel.getElement().setId("header");

    HorizontalPanel hp = new HorizontalPanel();
    hp.setSpacing(10);

    HorizontalPanel wrapper = new HorizontalPanel();
    wrapper.setWidth("100%");
    wrapper.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
    wrapper.add(hp);

    Button createButton = new Button();
    createButton.setText("Create");
    createButton.getElement().setClassName(BUTTON_STYLE);
    hp.add(createButton);
    Button updateButton = new Button();
    updateButton.setText("Update");
    updateButton.getElement().setClassName(BUTTON_STYLE);
    hp.add(updateButton);
    Button queryButton = new Button();
    queryButton.setText("Query");
    queryButton.getElement().setClassName(BUTTON_STYLE);
    hp.add(queryButton);
    Button deleteButton = new Button();
    deleteButton.setText("Delete");
    deleteButton.getElement().setClassName(BUTTON_STYLE);
    hp.add(deleteButton);

    final EventBus eventBus = new SimpleEventBus();
    final MyRequestFactory requestFactory = GWT.create(MyRequestFactory.class);
    requestFactory.initialize(eventBus);
    hotspotRequestFactory.initialize(eventBus);

    createButton.addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
        create();
      }
    });

    updateButton.addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
        update(hotspotProxy);
      }
    });

    deleteButton.addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
        delete(hotspotProxy);
      }
    });

    queryButton.addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
        query();
      }
    });

    panel.add(wrapper);
    RootPanel.get().add(panel);
  }

  private void create() {
    CloudHotspotRequest request = hotspotRequestFactory.HotspotRequest();
    request.createHotspot().fire(new Receiver<HotspotProxy>() {
      @Override
      public void onSuccess(HotspotProxy hotspot) {
        Window.alert("CREATE SUCCESS:(" + hotspot.getId() + ")");
          hotspotProxy = hotspot;
      }
    });
  }

  private void update(HotspotProxy hotspot) {
    CloudHotspotRequest request = hotspotRequestFactory.HotspotRequest();
    hotspotProxy = request.edit(hotspotProxy);
    hotspotProxy.setName(getHotspotName());
    request.updateHotspot(hotspot).fire(new Receiver<HotspotProxy>() {
      @Override
      public void onSuccess(HotspotProxy hotspot) {
        Window.alert("UPDATE SUCCESS:(" + hotspot.getId() + "): " + hotspot.getName());
      }
    });
  }

  private void delete(HotspotProxy hotspotProxy) {
    hotspotRequestFactory.HotspotRequest().deleteHotspot(hotspotProxy).fire(
        new Receiver<Void>() {
          @Override
          public void onSuccess(Void v) {
            Window.alert("DELETE SUCCESS");
          }
        });
  }

  private void query() {
    hotspotRequestFactory.HotspotRequest().queryHotspots().fire(
        new Receiver<List<HotspotProxy>>() {
          @Override
          public void onSuccess(List<HotspotProxy> hotspotList) {
            String names = "\n";
            for (HotspotProxy hotspot : hotspotList) {
              names += " (" + hotspot.getId() + "): " + hotspot.getName() + "\n";
            }
            Window.alert("QUERY SUCCESS: Count[" + hotspotList.size()
                + "] Values:" + names);
          }
        });
  }

  static int hotspotNameCt = 0;

  static String hotspotNames[] = {
     "Use *really big* blimps for streetview",
      "Implement plans to increase the speed of light",
      "Talk to Sergey about renting his aircraft carrier",
      "Make final payment on orbital death ray", "Give.",
      "Design coast-to-coast high-speed escape tunnel",};

  static String getHotspotName() {
    if (hotspotNameCt >= hotspotNames.length) {
      hotspotNameCt = 0;
    }
    return hotspotNames[hotspotNameCt++];
  }

}