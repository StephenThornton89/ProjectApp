package csu.matos.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends Activity implements MainCallbacks {
  
    FragmentRed redFragment;
    FragmentBlue  blueFragment ;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	// ---------------------------------------------------------------------------------
	@Override
	public void onAttachFragment(Fragment fragment) {
		super.onAttachFragment(fragment);
		// get a reference to each fragment attached to the GUI 
		if (fragment.getClass() == FragmentRed.class ){
			//Log.e("<<<onAttachFragment RED>>>", fragment + " " + fragment.getId() );
			redFragment = (FragmentRed) fragment;
		}
		if (fragment.getClass() == FragmentBlue.class ){
			//Log.e("<<<onAttachFragment BLUE>>>", fragment + " " + fragment.getId() );
			blueFragment = (FragmentBlue) fragment;
		}
		
	}
	// ------------------------------------------------------------------------------------------------	

	@Override
	public void onMsgFromFragToMain(String sender, String strValue) {
		Toast.makeText(getApplication(), " MAIN GOT MSG >> " + sender 
				      + "\n" + strValue, Toast.LENGTH_LONG).show();
		
		if (sender.equals("RED-FRAG")){
			//TODO: do here something smart on behalf of BLUE fragment

		}
		
		if (sender.equals("BLUE-FRAG")) {
			redFragment.onMsgFromActivity("\nSender: " + sender + "\nMsg: " + strValue);			
		}

	}

}
