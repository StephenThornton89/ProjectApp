package csu.matos.fragments;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.app.Fragment;
import android.widget.*;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

public class SettingsFragmentTab extends Fragment {
    TextView A_input;
    Button A_enter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.settings_layout, container, false);
        A_input = (TextView)rootView.findViewById(R.id.textView9);

        return rootView;
    }

}
