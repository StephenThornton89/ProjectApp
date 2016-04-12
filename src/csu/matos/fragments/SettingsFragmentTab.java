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
        return rootView1;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button8:
                onClickInsert(v);
                break;
        }
    }
        public void onClickInsert(View view) {
        SQLiteDatabase db = getActivity().openOrCreateDatabase("GAAdb", android.content.Context.MODE_PRIVATE, null);
        String team1 =((EditText)getActivity().findViewById(R.id.editText)).getText().toString();
            String team2 =((EditText)getActivity().findViewById(R.id.editText2)).getText().toString();
            String pos =((EditText)getActivity().findViewById(R.id.editText5)).getText().toString();
        String Insert_data = "insert into names(Name,LastName,Position) values ('"+team1+"','"+team2+"','"+pos+"');";

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
//        ContentValues initialValues = new ContentValues();
//        //EditText txtDescription = (EditText)findViewById(R.id.editText);
//
//        //String string = txtDescription.getText().toString();
//        initialValues.put("Name", team1);
//        db.update("names", initialValues, "2", null);

    }
}
