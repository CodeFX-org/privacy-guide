package org.codefx.privacyguide.guide;

/**
 * Discovers available {@link Guide guides} and makes them available to the rest of this program.
 */
public class GuideManager {

	public static final Guide singletonGuide;

	private static final String loremIpsum = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do " +
			"eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud " +
			"exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.";

	static {
		Store downloadApk = new Store("Download APK");
		Store googlePlay = new Store("Google Play");
		App[] apps = new App[]{
				App.build("F-Droid")
						.packageName("org.fdroid.fdroid")
						.summary("Alternative app store for FOSS.")
						.description(loremIpsum)
						.installers(
								new Installer(downloadApk, "https://f-droid.org/FDroid.apk"))
						.build(),
				App.build("Super-SU")
						.packageName("eu.chainfire.supersu")
						.summary("Manages apps with superuser rights.")
						.description(loremIpsum)
						.installers(
								new Installer(googlePlay, "market://details?id=eu.chainfire.supersu"))
						.build(),
				App.build("X-Privacy")
						.packageName("biz.bokhorst.xprivacy.installer")
						.summary("Defines fine-grained app permissions.")
						.description(loremIpsum)
						.installers(
								new Installer(googlePlay, "market://details?id=biz.bokhorst.xprivacy.installer"))
						.build(),
				App.build("DroidWall")
						.packageName("com.googlecode.droidwall.free")
						.summary("Limits internet access for apps.")
						.description(loremIpsum)
						.installers(
								new Installer(downloadApk, "https://droidwall.googlecode.com/files/droidwall-v1_5_7.apk"),
								new Installer(googlePlay, "market://details?id=com.googlecode.droidwall.free"))
						.build(),
				App.build("AdAway")
						.packageName("org.adaway")
						.summary("Blocks ads in many apps.")
						.description(loremIpsum)
						.build(),
				App.build("BootManager")
						.packageName("de.defim.apk.bootmanager")
						.summary("Defines which apps are started on boot.")
						.description(loremIpsum)
						.installers(
								new Installer(googlePlay, "market://details?id=de.defim.apk.bootmanager"))
						.build(),
				App.build("Orbot")
						.packageName("org.torproject.android")
						.summary("Tor client for Android.")
						.description(loremIpsum)
						.installers(
								new Installer(downloadApk, "https://guardianproject.info/releases/orbot-latest.apk"),
								new Installer(googlePlay, "market://details?id=org.torproject.android"))
						.build(),
				App.build("TextSecure")
						.packageName("org.thoughtcrime.securesms")
						.summary("Secure messaging app.")
						.description(loremIpsum)
						.installers(
								new Installer(googlePlay, "market://details?id=org.thoughtcrime.securesms"))
						.build(),
				App.build("RedPhone")
						.packageName("org.thoughtcrime.redphone")
						.summary("Secure phone app.")
						.description(loremIpsum)
						.installers(
								new Installer(googlePlay, "market://details?id=org.thoughtcrime.redphone"))
						.build(),
		};
		singletonGuide = new Guide(apps);
	}

}
