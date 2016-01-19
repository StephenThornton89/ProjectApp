package csu.matos.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Fragment;
import android.widget.Button;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import android.util.Xml;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import java.io.IOException;

public class StatsFragmentTab extends Fragment implements View.OnClickListener {

    int i=0,k=0,j=0,l=0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.stats_layout, container, false);
        Button GoalsButton = (Button) rootView.findViewById(R.id.button2);
        GoalsButton.setOnClickListener(this);
        Button pointsButton1 = (Button) rootView.findViewById(R.id.button);
        pointsButton1.setOnClickListener(this);
        Button pointsButton2 = (Button) rootView.findViewById(R.id.button3);
        pointsButton2.setOnClickListener(this);
        Button goalButton2 = (Button) rootView.findViewById(R.id.button4);
        goalButton2.setOnClickListener(this);
        Button database = (Button) rootView.findViewById(R.id.button7);
        database.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.button2:
                onClickPlusGoal1(v);
                break;
            case R.id.button:
                onClickPlusPoint1(v);
                break;
            case R.id.button3:
                onClickPlusGoal2(v);
                break;
            case R.id.button4:
                onClickPlusPoint2(v);
                break;
            case R.id.button7:
                onClickDB(v);
                break;
        }
    }
    public void onClickPlusGoal1(View view) {
        Button GoalsButton = (Button) getView().findViewById(R.id.button2);
        i++;
        GoalsButton.setText(String.valueOf(i));
    }
    public void onClickPlusPoint1(View view) {
        Button pointsButton = (Button) getView().findViewById(R.id.button);
        k++;
        pointsButton.setText(String.valueOf(k));
    }
    public void onClickPlusGoal2(View view) {
        Button GoalsButton = (Button) getView().findViewById(R.id.button3);
        j++;
        GoalsButton.setText(String.valueOf(j));
    }

    public void onClickPlusPoint2(View view) {
        Button pointsButton = (Button) getView().findViewById(R.id.button4);
        l++;
        pointsButton.setText(String.valueOf(l));
    }
    public void onClickDB(View view) {
        Button pointsButton = (Button) getView().findViewById(R.id.button7);

        SQLiteDatabase db = getActivity().openOrCreateDatabase("GAAdb", android.content.Context.MODE_PRIVATE, null);
        Toast.makeText(getActivity(), "database created",Toast.LENGTH_LONG).show();
       // TextView txt2 = (TextView)findViewById(R.id.textView);
        //txt2.setText("Database Created\n");

      //  db.beginTransaction();
        /*try {
            db.execSQL("create table names (recid integer PRIMARY KEY autoincrement,FNAME text,MINIT text,LNAME text, SSN text, BDATE text, ADDRESS text, SEX text, SALARY text, SUPERSSN text,DNO text);");
           // txt2.append("New table created\n");
            db.execSQL("insert into names(FNAME, MINIT, LNAME, SSN, BDATE,ADDRESS, SEX, SALARY, SUPERSSN,DNO ) values ('Test','Test1','Test2','Test3','Test4','Test5','Test6','Test7','Test8','Test9')");
           // txt2.append("Data inserted\n");
            db.setTransactionSuccessful();
        } catch(SQLiteException e) {
            Toast.makeText(getActivity(), "roolback",Toast.LENGTH_LONG).show();
            //txt2.append("Database roolback Here!!!!!!!!!!!\n");

        }finally{
            db.endTransaction();
        }*/
    }
}

