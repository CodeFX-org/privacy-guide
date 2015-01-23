package org.codefx.privacyguide.localized;

/**
 * Defines in which state an App is on this system.
 */
public enum LocalizedAppState {

	/** The state of this app is currently unknown */
	UNKNOWN,

	/** The user did not yet install the app. */
	UNINSTALLED,

	/** The user decided to not install this app. */
	IGNORED,

	/** The user installed this app. */
	INSTALLED
}
