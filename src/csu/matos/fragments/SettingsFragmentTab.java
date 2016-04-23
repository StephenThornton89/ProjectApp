package csu.matos.fragments;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Fragment;
import android.widget.Button;
import android.widget.EditText;
import android.widget.*;


public class SettingsFragmentTab extends Fragment implements View.OnClickListener {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView1 = inflater.inflate(R.layout.settings_layout, container, false);
        Button InsertDatabase = (Button) rootView1.findViewById(R.id.button8);
        InsertDatabase.setOnClickListener(this);
        Button InsertDatabase2 = (Button) rootView1.findViewById(R.id.button10);
        InsertDatabase2.setOnClickListener(this);
        return rootView1;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button8:
                onClickInsert(v);
                break;
            case R.id.button10:
                onClickInsert2(v);
                break;
        }
    }

    public void onClickInsert(View view) {
        SQLiteDatabase db = getActivity().openOrCreateDatabase("GAAdb", android.content.Context.MODE_PRIVATE, null);
        String team1 =((EditText)getActivity().findViewById(R.id.editText)).getText().toString();
            String team2 =((EditText)getActivity().findViewById(R.id.editText2)).getText().toString();
            String pos =((EditText)getActivity().findViewById(R.id.editText5)).getText().toString();
        String Insert_data = "insert into team1(Name,LastName,Position) values ('"+team1+"','"+team2+"','"+pos+"');";

        db.beginTransaction();
        try{
            db.execSQL(Insert_data);
            Toast.makeText(getActivity(), "Name data saved to database ", Toast.LENGTH_SHORT).show();
            db.setTransactionSuccessful();
        }catch (SQLiteException e){
            Toast.makeText(getActivity(), "roolback inserted", Toast.LENGTH_LONG).show();
        }finally{
            db.endTransaction();
        }

    }

    public void onClickInsert2(View view) {
        SQLiteDatabase db = getActivity().openOrCreateDatabase("GAAdb", android.content.Context.MODE_PRIVATE, null);
            String Name2 =((EditText)getActivity().findViewById(R.id.editText6)).getText().toString();
            String Sname2 =((EditText)getActivity().findViewById(R.id.editText7)).getText().toString();
            String pos2 =((EditText)getActivity().findViewById(R.id.editText8)).getText().toString();
            String Insert_data2 = "insert into team2(Name,LastName,Position2) values ('"+Name2+"','"+Sname2+"','"+pos2+"');";

        db.beginTransaction();
        try{
            db.execSQL(Insert_data2);
            Toast.makeText(getActivity(), "Name data saved to database 2 ", Toast.LENGTH_SHORT).show();
            db.setTransactionSuccessful();
        }catch (SQLiteException e){
            Toast.makeText(getActivity(), "roolback inserted", Toast.LENGTH_LONG).show();
        }finally{
            db.endTransaction();
        }

    }
}
