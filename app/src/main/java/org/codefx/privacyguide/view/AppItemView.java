package org.codefx.privacyguide.view;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.codefx.privacyguide.R;
import org.codefx.privacyguide.localized.LocalizedAppState;

public class AppItemView extends RelativeLayout {

	private static final int paddingInDip = 6;

	private static final int[] STATE_UNKNOWN = {R.attr.app_state_unknown};
	private static final int[] STATE_UNINSTALLED = {R.attr.app_state_uninstalled};
	private static final int[] STATE_IGNORED = {R.attr.app_state_ignored};
	private static final int[] STATE_INSTALLED = {R.attr.app_state_installed};

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

		iconView = (ImageView) findViewById(R.id.appIcon);
		nameView = (TextView) findViewById(R.id.appName);
		descriptionView = (TextView) findViewById(R.id.appDescription);
	}

	private void createView() {
		LayoutInflater
				.from(getContext())
				.inflate(R.layout.app_item, this, true);
		setBackgroundResource(R.drawable.app_item_inset);
	}

	private static int getListPreferredItemHeight(Context context) {
		TypedValue value = new TypedValue();
		context.getTheme().resolveAttribute(android.R.attr.listPreferredItemHeight, value, true);
		DisplayMetrics metrics = context.getResources().getDisplayMetrics();
		return TypedValue.complexToDimensionPixelSize(value.data, metrics);
	}

	private static int dipToPixels(int dip, Context context) {
		DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
		return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dip, displayMetrics);
	}

	/*
	 * DRAW STATE
	 */

	@Override
	protected int[] onCreateDrawableState(int extraSpace) {
		final int[] drawableState = super.onCreateDrawableState(extraSpace + 1);
		mergeDrawableStates(drawableState, state);
		return drawableState;
	}

	private static void mergeDrawableStates(int[] drawableState, LocalizedAppState state) {
		switch (state) {
			case UNKNOWN:
				mergeDrawableStates(drawableState, STATE_UNKNOWN);
				break;
			case UNINSTALLED:
				mergeDrawableStates(drawableState, STATE_UNINSTALLED);
				break;
			case IGNORED:
				mergeDrawableStates(drawableState, STATE_IGNORED);
				break;
			case INSTALLED:
				mergeDrawableStates(drawableState, STATE_INSTALLED);
				break;
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
		refreshDrawableState();
	}

}
