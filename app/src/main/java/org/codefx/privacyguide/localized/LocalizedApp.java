package org.codefx.privacyguide.localized;

import org.codefx.privacyguide.guide.App;
import org.codefx.privacyguide.guide.Installer;

import java.util.List;

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

	public String getPackageName() {
		return app.getPackageName();
	}

	public String getDescription() {
		return app.getDescription();
	}

	/** @return the installers as an unmodifiable list */
	public List<Installer> getInstallers() {
		return app.getInstallers();
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
