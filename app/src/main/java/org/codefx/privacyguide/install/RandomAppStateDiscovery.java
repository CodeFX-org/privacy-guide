package org.codefx.privacyguide.install;

import org.codefx.privacyguide.localized.LocalizedApp;
import org.codefx.privacyguide.localized.LocalizedAppState;

import java.util.Random;

public class RandomAppStateDiscovery implements AppStateDiscovery {

	private final Random random = new Random();

	@Override
	public void discoverAndSetState(LocalizedApp localizedApp) {
		int randomStateIndex = random.nextInt(LocalizedAppState.values().length);
		LocalizedAppState randomState = LocalizedAppState.values()[randomStateIndex];
		localizedApp.setState(randomState);
	}
}
