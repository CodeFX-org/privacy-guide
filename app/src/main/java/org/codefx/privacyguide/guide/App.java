package org.codefx.privacyguide.guide;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * An app that the user can choose to install.
 */
public class App {

	private final String name;
	private final String description;
	/** unmodifiable list of installers */
	private final List<Installer> installers;

	/**
	 * Creates a new app with the specified arguments.
	 *
	 * @param installers the array of installers is defensively copied
	 */
	public App(String name, String description, Installer... installers) {
		this.name = name;
		this.description = description;
		this.installers = Collections.unmodifiableList(Arrays.asList(installers));
	}

	/**
	 * Creates a new app with the specified arguments.
	 *
	 * @param installers the list of installers is defensively copied
	 */
	public App(String name, String description, List<Installer> installers) {
		this.name = name;
		this.description = description;
		this.installers = Collections.unmodifiableList(new ArrayList<>(installers));
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	/** @return the installers as an unmodifiable list */
	public List<Installer> getInstallers() {
		return installers;
	}

	@Override
	public String toString() {
		return name;
	}

}
