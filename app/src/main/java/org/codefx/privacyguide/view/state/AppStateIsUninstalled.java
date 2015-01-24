package org.codefx.privacyguide.view.state;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;

import org.codefx.privacyguide.R;
import org.codefx.privacyguide.guide.Installer;
import org.codefx.privacyguide.localized.LocalizedApp;

class AppStateIsUninstalled extends ScrollView {

	public AppStateIsUninstalled(Context context, LocalizedApp app) {
		super(context);
		createView(context);
		createButtons(context, app);
	}

	private void createView(Context context) {
		LayoutInflater
				.from(context)
				.inflate(R.layout.app_item_state_uninstalled, this, true);
	}

	private void createButtons(Context context, LocalizedApp app) {
		if (app.getInstallers().size() == 0)
			throw new IllegalArgumentException("Do not create an empty installer button bar. Show a message instead.");

		ViewGroup buttonContainer = (ViewGroup) findViewById(R.id.appItem_stateUninstalled_buttonContainer);
		for (Installer installer : app.getInstallers()) {
			Button button = createButton(context, installer);
			buttonContainer.addView(button);
		}
	}

	private Button createButton(final Context context, final Installer installer) {
		Button button = (Button) LayoutInflater
				.from(context)
				.inflate(R.layout.app_item_state_uninstalled_install_button, null);

		button.setText(installer.getStore().getName());
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent goToMarket = new Intent(Intent.ACTION_VIEW, Uri.parse(installer.getLink()));
				context.startActivity(goToMarket);
			}
		});

		return button;
	}

}
