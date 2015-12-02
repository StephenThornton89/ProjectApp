package csu.matos.fragments;

import java.util.Date;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class FragmentRed extends Fragment {
	MainActivity main;
	TextView txtRed = null;
	Button btnRedClock;

	// create an instance of a RED fragment
	public static FragmentRed newInstance(String strArg1) {
		FragmentRed fragment = new FragmentRed();
		Bundle bundle = new Bundle();
		bundle.putString("arg1", strArg1);
		fragment.setArguments(bundle);
		return fragment;
	}// newInstance

	// get a reference to MainActivity - verify callback implementation 
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (!(getActivity() instanceof MainCallbacks)) {
			throw new IllegalStateException(
					"MainActivity must implement MainCallbacks.");
		}
		main = (MainActivity) getActivity();
	}

	// -------------------------------------------------------------------------------
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		// inflate the LinearLayout called 'layout_red', it will be attached to the 
		// fragment-UI component named 'main_red_holder' 
		
		LinearLayout view4_layout_red = (LinearLayout) inflater.inflate(
				R.layout.layout_red, null);

		txtRed = (TextView) view4_layout_red.findViewById(R.id.textView1Red);

		try {
			Bundle arguments = getArguments();
			String redMessage = arguments.getString("arg1", "");
			txtRed.setText(redMessage);
		} catch (Exception e) {
			//Toast.makeText(getActivity(), "RED - NO BUNDLE", 1).show();
			Log.e("RED - NO BUNDLE ", "" + e.getMessage());
		}

		btnRedClock = (Button) view4_layout_red.findViewById(R.id.button1Red);
		btnRedClock.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String redMessage = "Red clock:\n" + new Date().toString();
				txtRed.setText(redMessage);
				main.onMsgFromFragToMain("RED-FRAG", redMessage);
			}
		});
		return view4_layout_red;
	}

	// --------------------------------------------------------------------------------------
	// receive a message from the MainActivity
	public void onMsgFromActivity(String strValue) {
		txtRed.setText("THIS MESSAGE COMES FROM MAIN:" + strValue);
	}

}// FragmentRed
