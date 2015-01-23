package org.codefx.privacyguide.localized;

import org.codefx.privacyguide.guide.App;

/**
 * Wraps an {@link App} in local context which defines in what {@link LocalizedAppState} the app is on this system.
 */
public class LocalizedApp {

	private final App app;
	private LocalizedAppState state;

	public LocalizedApp(App app) {
		this.app = app;
		this.state = LocalizedAppState.UNKNOWN;
	}

	public String getName() {
		return app.getName();
	}

	public String getDescription() {
		return app.getDescription();
	}

	public LocalizedAppState getState() {
		return state;
	}

	public void setState(LocalizedAppState state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return app.getName() + "[state: " + state + "]";
	}
}
