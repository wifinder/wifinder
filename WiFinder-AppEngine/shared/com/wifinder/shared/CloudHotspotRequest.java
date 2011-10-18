package com.wifinder.shared;

import java.util.List;

import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceName;

@ServiceName(value = "com.wifinder.server.CloudHotspotService", locator = "com.wifinder.server.CloudHotspotServiceLocator")
public interface CloudHotspotRequest extends RequestContext {

	Request<HotspotProxy> createHotspot();

	Request<HotspotProxy> readHotspot(Long id);

	Request<HotspotProxy> updateHotspot(HotspotProxy hotspot);

	Request<Void> deleteHotspot(HotspotProxy hotspot);

	Request<List<HotspotProxy>> queryHotspots();

}
