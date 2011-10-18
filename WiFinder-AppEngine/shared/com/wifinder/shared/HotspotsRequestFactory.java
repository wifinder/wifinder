package com.wifinder.shared;

import com.google.web.bindery.requestfactory.shared.RequestFactory;


public interface HotspotsRequestFactory extends RequestFactory {
    
    CloudHotspotRequest HotspotRequest();
    
}