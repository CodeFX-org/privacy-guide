package org.codefx.privacyguide.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.codefx.privacyguide.R;
import org.codefx.privacyguide.localized.LocalizedApp;
import org.codefx.privacyguide.localized.LocalizedAppState;

public abstract class AppItemStateViews {

	private static final String APP_NAME_VARIABLE = "${appName}";
	private static final String APP_PACKAGE_NAME_VARIABLE = "${appPackageName}";

	public static View getViewForState(Context context, LocalizedApp app) {
		switch (app.getState()) {
			default:
				return new AppStateIsUnknown(context, app);
		}
	}

	private static class AppStateIsUnknown extends LinearLayout {

		public AppStateIsUnknown(Context context, LocalizedApp app) {
			super(context);
			createView(context);
			setText(context, app);
		}

		private void createView(Context context) {
			LayoutInflater
					.from(context)
					.inflate(R.layout.app_item_state_unknown, this, true);
		}

		private void setText(Context context, LocalizedApp app) {
			String text = context.getString(R.string.appItem_stateUnknown_displayText);
			text = text
					.replace(APP_NAME_VARIABLE, app.getName())
					.replace(APP_PACKAGE_NAME_VARIABLE, app.getPackageName());

			TextView textView = (TextView) findViewById(R.id.appItem_unknownState_textView);
			textView.setText(text);
		}

	}

}
