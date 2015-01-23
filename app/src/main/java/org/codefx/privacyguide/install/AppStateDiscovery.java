package org.codefx.privacyguide.install;

import org.codefx.privacyguide.localized.LocalizedApp;

/**
 * Discovers the {@link org.codefx.privacyguide.localized.LocalizedAppState state} of a {@link LocalizedApp}.
 */
public interface AppStateDiscovery {

	/**
	 * Discovers the {@link org.codefx.privacyguide.localized.LocalizedAppState state} of the specified app and writes
	 * it via {@link LocalizedApp#setState(org.codefx.privacyguide.localized.LocalizedAppState) setState}.
	 * <p/>
	 * This may happen asynchronously and the state may be written at any unspecified time in the future
	 *
	 * @param localizedApp the app whose state will be discovered and then set
	 */
	void discoverAndSetState(LocalizedApp localizedApp);

}
