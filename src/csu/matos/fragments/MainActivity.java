package csu.matos.fragments;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

import static android.app.ActionBar.*;


public class MainActivity extends Activity {

	// Declaring our tabs and the corresponding fragments.
	Tab stats, timer, settings;
	Fragment statsFragmentTab = new StatsFragmentTab();
	Fragment timerFragmentTab = new TimerFragmentTab();
	Fragment settingsFragmentTab = new SettingsFragmentTab();


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//screen rotate set to portrait
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		// Asking for the default ActionBar element that our platform supports.
		ActionBar actionBar = getActionBar();

		// Screen handling while hiding ActionBar icon.
		actionBar.setDisplayShowHomeEnabled(false);

		// Screen handling while hiding Actionbar title.
		actionBar.setDisplayShowTitleEnabled(false);

		// Creating ActionBar tabs.
		actionBar.setNavigationMode(NAVIGATION_MODE_TABS);

		// Setting custom tab icons.
		stats = actionBar.newTab().setText("Stats");
		timer = actionBar.newTab().setText("Timer");
		settings = actionBar.newTab().setText("Settings");

		// Setting tab listeners.
		Tab stats1= actionBar.newTab().setText("Stats").setTabListener(new TabListener<StatsFragmentTab>(this, "StatsFrag", StatsFragmentTab.class));
		Tab timer1= actionBar.newTab().setText("Timer").setTabListener(new TabListener<TimerFragmentTab>(this, "TimerFrag", TimerFragmentTab.class));
		Tab settings1= actionBar.newTab().setText("Settings").setTabListener(new TabListener<SettingsFragmentTab>(this, "SettingsFrag", SettingsFragmentTab.class));
		//stats.setTabListener(new TabListener<Fragment>(this, "Stats", statsFragmentTab));
		//timer.setTabListener(new TabListener(timerFragmentTab));
		//settings.setTabListener(new TabListener(settingsFragmentTab));

		// Adding tabs to the ActionBar.
		actionBar.addTab(stats1);
		actionBar.addTab(timer1);
		actionBar.addTab(settings1);
	}
}
