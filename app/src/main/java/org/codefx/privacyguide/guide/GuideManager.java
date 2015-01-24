package org.codefx.privacyguide.guide;

/**
 * Discovers available {@link Guide guides} and makes them available to the rest of this program.
 */
public class GuideManager {

	public static final Guide singletonGuide;

	static {
		Store googlePlay = new Store("Google Play");
		App[] apps = new App[]{
				App.build("F-Droid")
						.packageName("org.fdroid.fdroid")
						.description("Alternative app store containing only Free and Open Source Software.")
						.build(),
				App.build("Super-SU")
						.packageName("eu.chainfire.supersu")
						.description("Manages apps with superuser rights.")
						.build(),
				App.build("X-Privacy")
						.packageName("de.robv.android.xposed.installer")
						.description("Provides fake data for system calls, thus limiting access to private information " +
								"like location or address books. Behavior an be specified per level and per system call.")
						.build(),
				App.build("DroidWall")
						.packageName("com.googlecode.droidwall.free")
						.description("Limits which apps can access the internet. Access can be granted separately for WiFi and " +
								"mobile internet.")
						.installers(new Installer(googlePlay, "market://details?id=com.googlecode.droidwall.free"))
						.build(),
				App.build("AdAway")
						.packageName("org.adaway")
						.description("Blocks many apps from accessing their ad servers, thus removing ads.")
						.build(),
				App.build("BootManager")
						.packageName("de.defim.apk.bootmanager")
						.description("Enables the selection of apps which are allowed to start on boot.")
						.build(),
				App.build("Orbot")
						.packageName("org.torproject.android")
						.description("Tor client for Android.")
						.build(),
				App.build("TextSecure")
						.packageName("org.thoughtcrime.securesms")
						.description("Secure messaging app.")
						.build(),
				App.build("RedPhone")
						.packageName("org.thoughtcrime.redphone")
						.description("Secure phone app.")
						.build(),
		};
		singletonGuide = new Guide(apps);
	}

}
