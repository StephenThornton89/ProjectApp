package csu.matos.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

// this fragment shows a simple ListView 
public class FragmentBlue extends Fragment {

	MainActivity main;
	TextView txtBlue = null;
	String message = "";

	// Context context = null;

	// data to fill-up the ListView
	private String items[] = { "Timer", "Settings",
			"Stats" };

	// --------------------------------------------------------------------
	// create an instance of a BLUE fragment
	public static FragmentBlue newInstance(String strArg) {
		FragmentBlue fragment = new FragmentBlue();
		Bundle args = new Bundle();
		args.putString("strArg1", strArg);
		fragment.setArguments(args);
		return fragment;
	}

	// --------------------------------------------------------------------
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// make sure MainActivity implements callback method(s)
		try {
			main = (MainActivity) getActivity();
		} catch (Exception e) {
			// TODO STOP - throw exception...
			e.printStackTrace();
		}
	}

	// ---------------------------------------------------------------------
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		// instead of an XML spec, this view is created with code
		LinearLayout view4_layout_blue = (LinearLayout) inflater.inflate(
				R.layout.layout_blue, null);
		//txtBlue = (TextView) view4_layout_blue.findViewById(R.id.textView1Blue);
		ListView listView = (ListView) view4_layout_blue
				.findViewById(R.id.listView1Blue);

		listView.setBackgroundColor(Color.parseColor("#FF4991FF"));
		// set adapter to feed ListView
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(main,
				android.R.layout.simple_list_item_1, items);

		listView.setAdapter(adapter);

		listView.setSelection(0);
		listView.smoothScrollToPosition(0);

		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
				// send a message to MainActivity
				main.onMsgFromFragToMain("BLUE-FRAG", "Blue chosen row is "
						+ position);

			}
		});

		return view4_layout_blue;
	}// onCreateView

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		// TODO: if needed, do something when BLUE gets attached

	}// onAttach

	public void onMsgFromActivity(String strValue) {
		// TODO: if needed, process here messages sent by MainActivity
	}

}// class
