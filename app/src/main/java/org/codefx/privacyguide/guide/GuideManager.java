package org.codefx.privacyguide.guide;

/**
 * Discovers available {@link Guide guides} and makes them available to the rest of this program.
 */
public class GuideManager {

	public static final Guide singletonGuide;

	static {
		Store googlePlay = new Store("Google Play");
		App[] apps = new App[]{
				new App("F-Droid",
						"Alternative app store containing only Free and Open Source Software."
						),
				new App("Super-SU",
						"Manages apps with superuser rights."
						),
				new App("X-Privacy",
						"Provides fake data for system calls, thus limiting access to private information like " +
								"location or address books. Behavior an be specified per level and per system call."
						),
				new App("DroidWall",
						"Limits which apps can access the internet. Access can be granted separately for WiFi and " +
								"mobile internet.",
						new Installer(googlePlay, "market://details?id=com.googlecode.droidwall.free")
						),
				new App("AdAway",
						"Blocks many apps from accessing their ad servers, thus removing ads."
						),
				new App("BootManager",
						"Enables the selection of apps which are allowed to start on boot."
						),
				new App("Orbot",
						"Tor client for Android."
						),
				new App("TextSecure",
						"Secure messaging app."
						),
				new App("RedPhone",
						"Secure phone app."
						),
		};
		singletonGuide = new Guide(apps);
	}

}
