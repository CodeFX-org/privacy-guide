package org.codefx.privacyguide.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import org.codefx.privacyguide.R;
import org.codefx.privacyguide.guide.Installer;
import org.codefx.privacyguide.install.InstallationManager;
import org.codefx.privacyguide.localized.LocalizedApp;
import org.codefx.privacyguide.localized.LocalizedGuide;
import org.codefx.privacyguide.localized.LocalizedGuideManager;

import java.util.Iterator;
import java.util.List;

public class PrivacyAppsActivity extends ActionBarActivity {

	private InstallationManager installationManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_privacy_apps);

		installationManager = new InstallationManager(getPackageManager());
		LocalizedGuide guide = LocalizedGuideManager.getSingletonGuide(installationManager);
		AppListAdapter appListAdapter = new AppListAdapter(guide.getLocalizedApps());
		ListView appList = (ListView) findViewById(R.id.appListView);
		appList.setAdapter(appListAdapter);
		appList.setOnItemClickListener(new AppListClickListener(appListAdapter));
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
			AppItemView appItemView = AppItemView.provideAppItemView(PrivacyAppsActivity.this, convertView);
			writeAppToView(getItem(position), appItemView);
			return appItemView;
		}

		private void writeAppToView(LocalizedApp app, AppItemView appItemView) {
			appItemView.setAppName(app.getName());
			appItemView.setAppDescription(app.getDescription());
			appItemView.setAppState(app.getState());
		}

	}

	private class AppListClickListener implements AdapterView.OnItemClickListener {

		private final AppListAdapter appListAdapter;

		private AppListClickListener(AppListAdapter appListAdapter) {
			this.appListAdapter = appListAdapter;
		}

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			LocalizedApp app = appListAdapter.getItem(position);
			Iterator<Installer> installers = app.getInstallers().iterator();
			if (installers.hasNext()) {
				Installer installer = installers.next();
				Intent goToMarket = new Intent(Intent.ACTION_VIEW, Uri.parse(installer.getLink()));
				PrivacyAppsActivity.this.startActivity(goToMarket);
			}
		}
	}

}
