package org.codefx.privacyguide.guide;

/**
 * An app store like F-Droid or GooglePlay. Immediate download links also count as a store.
 */
public class Store {

	private final String name;

	public Store(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
