package org.codefx.privacyguide.guide;

/**
 * An app that the user can choose to install.
 */
public class App {

	private final String name;
	private final String description;

	public App(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}
}
