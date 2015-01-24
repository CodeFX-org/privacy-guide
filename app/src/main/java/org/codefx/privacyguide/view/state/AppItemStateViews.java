package org.codefx.privacyguide.view.state;

import android.content.Context;
import android.view.View;

import org.codefx.privacyguide.localized.LocalizedApp;

public abstract class AppItemStateViews {

	static final String APP_NAME_VARIABLE = "${appName}";
	static final String APP_PACKAGE_NAME_VARIABLE = "${appPackageName}";

	private AppItemStateViews() {
		// private constructor to prevent instantiation of utility class
	}

	public static View getViewForState(Context context, LocalizedApp app) {
		switch (app.getState()) {
			case UNKNOWN:
				return new AppStateIsUnknown(context, app);
			case UNINSTALLED:
				if (app.getInstallers().size() == 0)
					return new AppStateIsUninstalledButNoInstallers(context, app);
				else
					return new AppStateIsUninstalled(context, app);
			default:
				return new AppStateIsUnknown(context, app);
		}
	}

}
