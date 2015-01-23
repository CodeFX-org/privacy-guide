package org.codefx.privacyguide.view;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.codefx.privacyguide.R;
import org.codefx.privacyguide.localized.LocalizedGuideManager;
import org.codefx.privacyguide.localized.LocalizedApp;
import org.codefx.privacyguide.localized.LocalizedGuide;

import java.util.List;

public class PrivacyAppsActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_privacy_apps);

		LocalizedGuide guide = LocalizedGuideManager.singletonGuide;
		ListAdapter appListAdapter = new AppListAdapter(guide.getLocalizedApps());
		ListView appList = (ListView) findViewById(R.id.appListView);
		appList.setAdapter(appListAdapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_privacy_apps, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

	private class AppListAdapter extends BaseAdapter {

		private final List<LocalizedApp> apps;

		public AppListAdapter(List<LocalizedApp> apps) {
			this.apps = apps;
		}

		@Override
		public int getCount() {
			return apps.size();
		}

		@Override
		public LocalizedApp getItem(int position) {
			return apps.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View appView = provideAppView(convertView, parent);
			writeAppToView(getItem(position), appView);
			return appView;
		}

		private View provideAppView(View convertView, ViewGroup parent) {
			if (convertView != null)
				return convertView;
			return createNewAppView(parent);
		}

		private View createNewAppView(ViewGroup parent) {
			return LayoutInflater
					.from(PrivacyAppsActivity.this)
					.inflate(R.layout.layout_app_item, parent, false);
		}

		private void writeAppToView(LocalizedApp app, View appView) {
			TextView appNameView = (TextView) appView.findViewById(R.id.appName);
			appNameView.setText(app.getName());
		}

	}

}
