package org.codefx.privacyguide.guide;

/**
 * An installer belongs to exactly one app and contains all necessary information to install it.
 */
public class Installer {

	private final Store store;
	private final String link;

	public Installer(Store store, String link) {
		this.store = store;
		this.link = link;
	}

	public Store getStore() {
		return store;
	}

	public String getLink() {
		return link;
	}

}
