package org.codefx.privacyguide.install;

import android.content.pm.PackageManager;

import org.codefx.privacyguide.localized.LocalizedApp;
import org.codefx.privacyguide.localized.LocalizedAppState;

public class InstallationManager implements AppStateDiscovery {

	private final PackageManager packageManager;

	public InstallationManager(PackageManager packageManager) {
		this.packageManager = packageManager;
	}

	@Override
	public void discoverAndSetState(LocalizedApp app) {
		LocalizedAppState state = discoverState(app);
		app.setState(state);
	}

	private LocalizedAppState discoverState(LocalizedApp app) {
		if (isInstalled(app))
			return LocalizedAppState.INSTALLED;

		return LocalizedAppState.UNINSTALLED;
	}

	private boolean isInstalled(LocalizedApp app) {
		// TODO use 'getInstalledApplications()' to avoid exceptions?
		// repeatedly iterating through the list or caching it both has downsides
		try {
			packageManager.getPackageInfo(app.getPackageName(), PackageManager.GET_ACTIVITIES);
			return true;
		} catch (PackageManager.NameNotFoundException e) {
			return false;
		}
	}
}
