package org.codefx.privacyguide.view.state;

import android.content.Context;

import org.codefx.privacyguide.R;
import org.codefx.privacyguide.localized.LocalizedApp;

class AppStateIsUninstalledButNoInstallers extends MessageViewContainer {

	public AppStateIsUninstalledButNoInstallers(Context context, LocalizedApp app) {
		super(context, app, R.string.appItem_stateUninstalled_noInstallers_displayText);
	}

}
