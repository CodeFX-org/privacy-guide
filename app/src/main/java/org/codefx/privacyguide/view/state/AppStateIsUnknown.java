package org.codefx.privacyguide.view.state;

import android.content.Context;

import org.codefx.privacyguide.R;
import org.codefx.privacyguide.localized.LocalizedApp;

class AppStateIsUnknown extends MessageViewContainer {

	public AppStateIsUnknown(Context context, LocalizedApp app) {
		super(context, app, R.string.appItem_stateUnknown_displayText);
	}

}
