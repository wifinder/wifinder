package com.wifinder.server;

import java.util.List;

import com.wifinder.annotation.ServiceMethod;


public class CloudHotspotService {
	
	static DataStore db = new DataStore();
	@ServiceMethod
	public Hotspot createHotspot() {
		return db.update(new Hotspot()); // Create new Hotspot
	}

	@ServiceMethod
	public Hotspot readHotspot(Long id) {
		return db.find(id); // Find the Hotspot
	}

	@ServiceMethod
	public Hotspot updateHotspot(Hotspot hotspot) {
		hotspot.setEmailAddress(DataStore.getUserEmail()); // Set the e-mail address
		return db.update(hotspot); 
	}

	@ServiceMethod
	public void deleteHotspot(Hotspot hotspot) {
		// TODO Auto-generated method stub

	}

	@ServiceMethod
	public List<Hotspot> queryHotspots() {
		// TODO Auto-generated method stub
		return null;
	}

}
