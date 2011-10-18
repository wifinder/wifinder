package com.wifinder.server;

import com.google.web.bindery.requestfactory.shared.Locator;


public class HotspotLocator extends Locator<Hotspot, Void> {

	@Override
	public Hotspot create(Class<? extends Hotspot> clazz) {
		return new Hotspot();
	}

	@Override
	public Hotspot find(Class<? extends Hotspot> clazz, Void id) {
		return create(clazz);
	}

	@Override
	public Class<Hotspot> getDomainType() {
		return Hotspot.class;
	}

	@Override
	public Void getId(Hotspot domainObject) {
		return null;
	}

	@Override
	public Class<Void> getIdType() {
		return Void.class;
	}

	@Override
	public Object getVersion(Hotspot domainObject) {
		return null;
	}

}
