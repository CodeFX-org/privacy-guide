package org.codefx.privacyguide.view.state;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.codefx.privacyguide.R;
import org.codefx.privacyguide.localized.LocalizedApp;

abstract class MessageView extends LinearLayout {

	public MessageView(Context context, LocalizedApp app, int messageTextId) {
		super(context);
		createView(context);
		showMessage(context, app, messageTextId);
	}

	private void createView(Context context) {
		LayoutInflater
				.from(context)
				.inflate(R.layout.app_item_state_message, this, true);
	}

	private void showMessage(Context context, LocalizedApp app, int messageTextId) {
		String message = getMessage(context, app, messageTextId);
		setMessage(message);
	}

	private String getMessage(Context context, LocalizedApp app, int messageTextId) {
		String message = context.getString(messageTextId);
		message = message
				.replace(AppItemStateViews.APP_NAME_VARIABLE, app.getName())
				.replace(AppItemStateViews.APP_PACKAGE_NAME_VARIABLE, app.getPackageName());
		return message;
	}

	private void setMessage(String message) {
		TextView textView = (TextView) findViewById(R.id.appItem_stateMessage_textView);
		textView.setText(message);
	}

}
