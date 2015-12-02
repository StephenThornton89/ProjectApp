package csu.matos.fragments;

// method(s) to send messages from Fragments to the MainActivity
public interface MainCallbacks {
	public void onMsgFromFragToMain(String sender, String strValue);

}
