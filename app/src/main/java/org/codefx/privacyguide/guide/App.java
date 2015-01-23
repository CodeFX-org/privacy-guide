package org.codefx.privacyguide.guide;

/**
 * An app that the user can choose to install.
 */
public class App {

	private final String name;

	public App(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
