package org.codefx.privacyguide.localized;

import org.codefx.privacyguide.guide.Guide;
import org.codefx.privacyguide.guide.GuideManager;
import org.codefx.privacyguide.install.AppStateDiscovery;

/**
 * Discovers available {@link Guide guides}, localizes them to this system and makes them available to the rest of this
 * program.
 */
public class LocalizedGuideManager {

	private static LocalizedGuide singletonGuide;

	/** not thread safe! */
	public static LocalizedGuide getSingletonGuide(AppStateDiscovery discovery) {
		if (singletonGuide == null)
			singletonGuide = new LocalizedGuide(GuideManager.singletonGuide, discovery);
		return singletonGuide;
	}

}
