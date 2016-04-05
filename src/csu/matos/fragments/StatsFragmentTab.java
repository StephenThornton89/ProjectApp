package csu.matos.fragments;

//import android.content.Context;
import android.graphics.Color;
//import android.location.Location;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Fragment;
import android.widget.*;
import android.view.ViewGroup.LayoutParams;
//import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.widget.PopupWindow;


//import android.util.Xml;
//import org.xmlpull.v1.XmlPullParser;
//import org.xmlpull.v1.XmlPullParserException;
//import java.io.IOException;

public class StatsFragmentTab extends Fragment implements View.OnClickListener {

    int i=0,k=0,j=0,l=0;
    TextView input1;
    TextView input2;
    TextView time_view1;
    RadioButton rb;

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
        Button updateTeams = (Button) rootView.findViewById(R.id.button9);
        updateTeams.setOnClickListener(this);
        Button Stats1 = (Button) rootView.findViewById(R.id.button6);
        Stats1.setOnClickListener(this);
        Button Stats2 = (Button) rootView.findViewById(R.id.button5);
        Stats2.setOnClickListener(this);
        input1 = (TextView)rootView.findViewById(R.id.textView);
        input2 = (TextView)rootView.findViewById(R.id.textView2);

        rb = (RadioButton) rootView.findViewById(R.id.radioButton7);


        return rootView;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.button:
                onClickPlusPoint2(v);
                break;
            case R.id.button2:
                onClickPlusPoint1(v);
                break;
            case R.id.button4:
                onClickPlusGoal1(v);
                break;
            case R.id.button3:
                onClickPlusGoal2(v);
                break;

            case R.id.button5:
                onClickStats1(v);
                break;
            case R.id.button6:
                onClickStats2(v);
                break;
            case R.id.button7:
                onClickDB(v);
            case R.id.button9:
                onClickupdateteams(v);
                break;
        }
    }
    public void onClickStats1(View view) {
        Toast.makeText(getActivity(), "STATS 1",Toast.LENGTH_LONG).show();
        View popupView = getActivity().getLayoutInflater().inflate(R.layout.popup, null);
        PopupWindow popupWindow = new PopupWindow(popupView,
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        Button enter = (Button) popupView.findViewById(R.id.enter1);
        enter.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
        Button StatsButton = (Button) getView().findViewById(R.id.button6);
        popupWindow.showAsDropDown(StatsButton, 500, -300);
    }

    public void onClickStats2(View view) {
        Toast.makeText(getActivity(), "STATS 2",Toast.LENGTH_LONG).show();
        View popupView = getActivity().getLayoutInflater().inflate(R.layout.popup2, null);
        PopupWindow popupWindow = new PopupWindow(popupView,
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        Button enter = (Button) popupView.findViewById(R.id.enter2);
        enter.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                RadioButton r1 = ((RadioButton)popupView.findViewById(R.id.radioButton7));
                RadioButton r2 = ((RadioButton)popupView.findViewById(R.id.radioButton8));
                RadioButton r3 = ((RadioButton)popupView.findViewById(R.id.radioButton9));
                RadioButton r4 = ((RadioButton)popupView.findViewById(R.id.radioButton10));
                RadioButton r5 = ((RadioButton)popupView.findViewById(R.id.radioButton11));
                RadioButton r6 = ((RadioButton)popupView.findViewById(R.id.radioButton12));
                TextView prs1 = (TextView)getView().findViewById(R.id.textView11);
                TextView timeView = (TextView) view.findViewById(R.id.time_view);
                prs1.setMovementMethod(new ScrollingMovementMethod());
                if(r1.isChecked()){
                    prs1.append(input1.getText() + ": " + r1.getText() + " score: " + i + "-" + k + " Time: "+ timeView + "\n");
                }
                else if (r2.isChecked()){
                    prs1.append(input1.getText() + ": " + r2.getText() + " score: " + i + "-" + k + "\n");
                }
                else if (r3.isChecked()){
                    prs1.append(input1.getText() + ": " + r3.getText() + " score: " + i + "-" + k + "\n");
                }
                else if (r4.isChecked()){
                    prs1.append(input1.getText() + ": " + r4.getText() + " score: " + i + "-" + k + "\n");
                }
                else if (r5.isChecked()){
                    prs1.append(input1.getText() + ": " + r5.getText() + " score: " + i + "-" + k + "\n");
                }
                else if (r6.isChecked()){
                    prs1.append(input1.getText() + ": " + r6.getText() + " score: " + i + "-" + k + "\n");
                }
                popupWindow.dismiss();

            }
        });


        Button StatsButton = (Button) getView().findViewById(R.id.button6);
        popupWindow.showAsDropDown(StatsButton, 0, -300);
    }


    public void onClickPlusGoal1(View view) {
        Button GoalsButton = (Button) getView().findViewById(R.id.button4);
        i++;
        GoalsButton.setText(String.valueOf(i));
    }

    public void onClickPlusPoint1(View view) {
        Button pointsButton = (Button) getView().findViewById(R.id.button2);
        k++;
        pointsButton.setText(String.valueOf(k));
    }

    public void onClickPlusGoal2(View view) {
        Button GoalsButton = (Button) getView().findViewById(R.id.button3);
        j++;
        GoalsButton.setText(String.valueOf(j));
    }

    public void onClickPlusPoint2(View view) {
        Button pointsButton = (Button) getView().findViewById(R.id.button);
        l++;
        pointsButton.setText(String.valueOf(l));
    }

    public void onClickDB(View view) {
        //Button DBbutton = (Button) getView().findViewById(R.id.button7);

        SQLiteDatabase db = getActivity().openOrCreateDatabase("GAAdb", android.content.Context.MODE_PRIVATE, null);
        Toast.makeText(getActivity(), "database created",Toast.LENGTH_LONG).show();
        // TextView txt2 = (TextView)findViewById(R.id.textView);
        //txt2.setText("Database Created\n");

        db.beginTransaction();
        try {
            db.execSQL("create table names (recid integer PRIMARY KEY autoincrement,Name text,LastName text,Position text);");
            db.execSQL("insert into names(Name, LastName, Position ) values ('Test','Test1','Test2')");
            db.setTransactionSuccessful();
        } catch(SQLiteException e) {
            Toast.makeText(getActivity(), "roolback",Toast.LENGTH_LONG).show();

        }finally{
            db.endTransaction();
        }
    }
    public void onClickupdateteams(View view) {
        String team1 =((EditText)getActivity().findViewById(R.id.editText3)).getText().toString();
        input1.setText(team1);
        String team2 =((EditText)getActivity().findViewById(R.id.editText4)).getText().toString();
        input2.setText(team2);
        Spinner sp1 = ((Spinner)getActivity().findViewById(R.id.spinner));
        String str = sp1.getSelectedItem().toString();
        if(str.equals("Blue"))
        {
            Toast.makeText(getActivity(),
                    "text sent to Stats tabs:\n "+ str,
                    Toast.LENGTH_LONG).show();
            input1.setBackgroundColor(Color.BLUE);
        }
        else if (str.equals("Red"))
        {
            input1.setBackgroundColor(Color.RED);
        }
        else if (str.equals("Maroon"))
        {
            input1.setBackgroundColor(0xFF830B39);
        }
        else if (str.equals("Black"))
        {
            input1.setBackgroundColor(Color.BLACK);
        }
        else if (str.equals("Green"))
        {
            input1.setBackgroundColor(Color.GREEN);
        }
        Spinner sp2 = ((Spinner)getActivity().findViewById(R.id.spinner2));
        String str2 = sp2.getSelectedItem().toString();
        if(str2.equals("Blue"))
        {
            input2.setBackgroundColor(Color.BLUE);
        }
        else if (str2.equals("Red"))
        {
            input2.setBackgroundColor(Color.RED);
        }
        else if (str2.equals("Maroon"))
        {
            input2.setBackgroundColor(0xFF830B39);
        }
        else if (str2.equals("Black"))
        {
            input2.setBackgroundColor(Color.BLACK);
        }
        else if (str2.equals("Green"))
        {
            input2.setBackgroundColor(Color.GREEN);
        }
    }
}

