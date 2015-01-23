package org.codefx.privacyguide.guide;

/**
 * Discovers available {@link Guide guides} and makes them available to the rest of this program.
 */
public class GuideManager {

	public static final Guide singletonGuide;

	static {
		App[] apps = new App[]{
				new App("F-Droid"),
				new App("Super-SU"),
				new App("X-Privacy"),
				new App("DroidWall"),
				new App("AdAway"),
				new App("BootManager"),
				new App("Orbot"),
				new App("TextSecure"),
				new App("RedPhone"),
		};
		singletonGuide = new Guide(apps);
	}

}
