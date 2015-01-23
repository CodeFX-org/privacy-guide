package org.codefx.privacyguide.localized;

import org.codefx.privacyguide.guide.Guide;
import org.codefx.privacyguide.guide.GuideManager;
import org.codefx.privacyguide.install.RandomAppStateDiscovery;

/**
 * Discovers available {@link Guide guides}, localizes them to this system and makes them available to the rest of this
 * program.
 */
public class LocalizedGuideManager {

	public static final LocalizedGuide singletonGuide;

	static {
		singletonGuide = new LocalizedGuide(GuideManager.singletonGuide, new RandomAppStateDiscovery());
	}

}
