package org.codefx.privacyguide.view.state;

import android.content.Context;
import android.widget.TextView;

import org.codefx.privacyguide.R;
import org.codefx.privacyguide.localized.LocalizedApp;

class AppStateIsUninstalledButNoInstallers extends MessageView {

	public AppStateIsUninstalledButNoInstallers(Context context, LocalizedApp app) {
		super(context, app, R.string.appItem_stateUninstalled_noInstallers_displayText);
	}

}
