package org.codefx.privacyguide.view.state;

import android.content.Context;

import org.codefx.privacyguide.R;
import org.codefx.privacyguide.localized.LocalizedApp;

public class AppStateIsInstalled extends MessageViewContainer {

	public AppStateIsInstalled(Context context, LocalizedApp app) {
		super(context, app, R.string.appItem_stateInstalled_displayText);
	}

}
