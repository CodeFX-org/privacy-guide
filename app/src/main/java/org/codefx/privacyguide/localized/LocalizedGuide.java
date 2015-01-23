package org.codefx.privacyguide.localized;

import org.codefx.privacyguide.guide.App;
import org.codefx.privacyguide.guide.Guide;
import org.codefx.privacyguide.install.AppStateDiscovery;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Wraps a {@link Guide} with local state.
 */
public class LocalizedGuide {

	private final Guide guide;
	/** unmodifiable list of localized apps */
	private final List<LocalizedApp> localizedApps;

	public LocalizedGuide(Guide guide, AppStateDiscovery stateDiscovery) {
		this.guide = guide;
		this.localizedApps = localizeApps(guide.getApps(), stateDiscovery);
	}

	private static List<LocalizedApp> localizeApps(Collection<? extends App> apps, AppStateDiscovery stateDiscovery) {
		List<LocalizedApp> localizedApps = new ArrayList<>(apps.size());
		for (App app : apps) {
			LocalizedApp localizedApp = new LocalizedApp(app);
			stateDiscovery.discoverAndSetState(localizedApp);
			localizedApps.add(localizedApp);
		}
		return localizedApps;
	}

	/** @return apps with localized information as an unmodifiable list */
	public List<LocalizedApp> getLocalizedApps() {
		return localizedApps;
	}
}
