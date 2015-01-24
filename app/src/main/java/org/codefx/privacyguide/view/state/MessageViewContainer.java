package org.codefx.privacyguide.view.state;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import org.codefx.privacyguide.R;
import org.codefx.privacyguide.localized.LocalizedApp;

abstract class MessageViewContainer implements ViewContainer {

	private final View messageView;

	public MessageViewContainer(Context context, LocalizedApp app, int messageTextId) {
		messageView = createView(context);
		showMessage(context, app, messageTextId);
	}

	private View createView(Context context) {
		return LayoutInflater
				.from(context)
				.inflate(R.layout.app_item_state_message, null);
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
		TextView textView = (TextView) messageView.findViewById(R.id.appItem_stateMessage_textView);
		textView.setText(message);
	}

	@Override
	public View getView() {
		return messageView;
	}
}
