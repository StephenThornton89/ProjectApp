package csu.matos.fragments;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;


public class MainActivity extends Activity {

	// Declaring our tabs and the corresponding fragments.
	ActionBar.Tab stats, timer, settings;
	Fragment statsFragmentTab = new StatsFragmentTab();
	Fragment timerFragmentTab = new TimerFragmentTab();
	Fragment settingsFragmentTab = new SettingsFragmentTab();


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Asking for the default ActionBar element that our platform supports.
		ActionBar actionBar = getActionBar();

		// Screen handling while hiding ActionBar icon.
		actionBar.setDisplayShowHomeEnabled(false);

		// Screen handling while hiding Actionbar title.
		actionBar.setDisplayShowTitleEnabled(false);

		// Creating ActionBar tabs.
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		// Setting custom tab icons.
		stats = actionBar.newTab().setText("Stats");
		timer = actionBar.newTab().setText("Timer");
		settings = actionBar.newTab().setText("Settings");

		// Setting tab listeners.
		//ActionBar.Tab aTab= actionBar.newTab().setText("Tab A").setTabListener(new TabListener<AFragment>(this, "AFrag", AFragment.class));
		//stats.setTabListener(new TabListener<Fragment>(this, "Stats", statsFragmentTab));
		//timer.setTabListener(new TabListener(timerFragmentTab));
		//settings.setTabListener(new TabListener(settingsFragmentTab));

		// Adding tabs to the ActionBar.
		actionBar.addTab(stats);
		actionBar.addTab(timer);
		actionBar.addTab(settings);
	}
}
