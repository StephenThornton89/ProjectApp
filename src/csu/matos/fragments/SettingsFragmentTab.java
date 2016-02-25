package csu.matos.fragments;

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
    EditText A_input;
    Button A_enter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.settings_layout, container, false);
        A_input = (EditText)rootView.findViewById(R.id.editText3);
        A_enter = (Button)rootView.findViewById(R.id.button8);
        A_enter.setOnClickListener(A_enterOnClickListener);
        return rootView;
    }
    OnClickListener A_enterOnClickListener= new OnClickListener()
    {

        @Override
        public void onClick(View arg0) {

            String textPassToB = A_input.getText().toString();

            String TabOfFragmentB = ((MainActivity)getActivity()).getTabFragmentB();

            //StatsFragmentTab fragmentB = (StatsFragmentTab)getActivity().getSupportFragmentManager().findFragmentByTag(TabOfFragmentB);

            //fragmentB.b_updateText(textPassToB);

            Toast.makeText(getActivity(),
                    "text sent to Stats tabs:\n " + TabOfFragmentB,
                    Toast.LENGTH_LONG).show();
        }};
}
