package org.codefx.privacyguide.guide;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * A guide contains a list of apps which the user can choose to install.
 */
public class Guide {

	/** unmodifiable list of apps */
	private final List<App> apps;

	/**
	 * Creates a new guide containing the specified apps.
	 *
	 * @param apps the array of apps is defensively copied
	 */
	public Guide(App[] apps) {
		this.apps = Collections.unmodifiableList(Arrays.asList(apps));
	}

	/**
	 * Creates a new guide containing the specified apps.
	 *
	 * @param apps the list of apps is defensively copied
	 */
	public Guide(List<App> apps) {
		this.apps = Collections.unmodifiableList(new ArrayList<>(apps));
	}

	/** @return the apps as an unmodifiable list */
	public List<App> getApps() {
		return apps;
	}
}
