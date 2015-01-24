package org.codefx.privacyguide.view;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.codefx.privacyguide.R;
import org.codefx.privacyguide.localized.LocalizedAppState;

public class AppItemView extends RelativeLayout {

	private static final int paddingInDip = 6;

	private final ImageView iconView;
	private final TextView nameView;
	private final TextView descriptionView;

	private LocalizedAppState state;

	/*
	 * CONSTRUCTION
	 */

	/**
	 * Provides an app item view.
	 *
	 * @return the {@code view} if it is not null and an instance of this class, or a new instance of this class
	 */
	public static AppItemView provideAppItemView(Context context, View view) {
		if (view instanceof AppItemView)
			return (AppItemView) view;
		else
			return new AppItemView(context);
	}

	private AppItemView(Context context) {
		super(context);
		createView();

		iconView = (ImageView) findViewById(R.id.appItem_appIconView);
		nameView = (TextView) findViewById(R.id.appItem_appNameView);
		descriptionView = (TextView) findViewById(R.id.appItem_appDescriptionView);
	}

	private void createView() {
		LayoutInflater
				.from(getContext())
				.inflate(R.layout.app_item_layout, this, true);
		setBackgroundResource(R.drawable.app_item_background_drawable_with_inset);
	}

	/*
	 * DRAW STATE
	 */

	private void updateViewToCurrentState() {
		int color = getColorForState(state);
		// TODO this looks more promising but has the same limited effect
//		Drawable background = ((InsetDrawable) getBackground()).getDrawable();
		Drawable background = getBackground();
		background.setColorFilter(color, PorterDuff.Mode.MULTIPLY);
	}

	private int getColorForState(LocalizedAppState state) {
		switch (state) {
			case UNKNOWN:
				return getResources().getColor(R.color.app_state_unknown);
			case UNINSTALLED:
				return getResources().getColor(R.color.app_state_uninstalled);
			case IGNORED:
				return getResources().getColor(R.color.app_state_ignored);
			case INSTALLED:
				return getResources().getColor(R.color.app_state_installed);
			default:
				throw new IllegalArgumentException(
						"Unknown " + LocalizedAppState.class.getSimpleName() + ": " + state + ".");
		}
	}

	/*
	 * MUTATORS
	 */

	public void setAppName(String name) {
		nameView.setText(name);
	}

	public void setAppDescription(String description) {
		descriptionView.setText(description);
	}

	public void setAppState(LocalizedAppState state) {
		if (this.state == state)
			return;

		this.state = state;
		updateViewToCurrentState();
	}

}
