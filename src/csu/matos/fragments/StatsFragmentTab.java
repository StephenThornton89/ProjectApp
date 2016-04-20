package csu.matos.fragments;

//import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;
import android.graphics.Color;
//import android.location.Location;
import android.os.AsyncTask;
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
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;


public class StatsFragmentTab extends Fragment implements View.OnClickListener {

    int i=0,k=0,j=0,l=0,a=1,b=1,c=1,d=1,e=1,f=1,u=1,p=1,w=1,x=1,y=1,z=1;
    String detail ="";

    TextView input1;
    TextView input2;
   // TextView timeView;
    RadioButton rb;
    //private static final String SELECT_SQL = "SELECT * FROM names WHERE Position = '"+str+"'",null);

    private Cursor cur;

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
        Button Stats2 = (Button) rootView.findViewById(R.id.button5);
        Stats2.setOnClickListener(this);
        Button Stats1 = (Button) rootView.findViewById(R.id.button6);
        Stats1.setOnClickListener(this);
        Button database = (Button) rootView.findViewById(R.id.button7);
        database.setOnClickListener(this);

        Button updateTeams = (Button) rootView.findViewById(R.id.button9);
        updateTeams.setOnClickListener(this);
        Button server = (Button) rootView.findViewById(R.id.button11);
        server.setOnClickListener(this);
        input1 = (TextView)rootView.findViewById(R.id.textView);
        input2 = (TextView)rootView.findViewById(R.id.textView2);
        rb = (RadioButton) rootView.findViewById(R.id.radioButton7);
       // JSONObject json = new JSONObject();
       // new HttpAsyncTask().execute(baseUrl, json.toString());
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
            case R.id.button3:
                onClickPlusGoal2(v);
                break;
            case R.id.button4:
                onClickPlusGoal1(v);
                break;
            case R.id.button5:
                onClickStats1(v);
                break;
            case R.id.button6:
                onClickStats2(v);
                break;
            case R.id.button7:
                onClickDB(v);
                break;
            case R.id.button9:
                onClickupdateteams(v);
                break;
            case R.id.button11:
				Connect_to_server(v);
				break;
        }
    }

    public void onClickStats1(View view) {
        SQLiteDatabase db = getActivity().openOrCreateDatabase("GAAdb", android.content.Context.MODE_PRIVATE, null);

        Toast.makeText(getActivity(), "STATS 1",Toast.LENGTH_LONG).show();
        View popupView1 = getActivity().getLayoutInflater().inflate(R.layout.popup, null);
        PopupWindow popupWindow = new PopupWindow(popupView1,
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        Button enter = (Button) popupView1.findViewById(R.id.enter1);
        enter.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                RadioButton r1 = ((RadioButton)popupView1.findViewById(R.id.radioButton));
                RadioButton r2 = ((RadioButton)popupView1.findViewById(R.id.radioButton2));
                RadioButton r3 = ((RadioButton)popupView1.findViewById(R.id.radioButton3));
                RadioButton r4 = ((RadioButton)popupView1.findViewById(R.id.radioButton4));
                RadioButton r5 = ((RadioButton)popupView1.findViewById(R.id.radioButton5));
                RadioButton r6 = ((RadioButton)popupView1.findViewById(R.id.radioButton6));
                Spinner sp3 = ((Spinner)popupView1.findViewById(R.id.spinner3));
                String str = sp3.getSelectedItem().toString();
                String SELECT_SQL = "SELECT * FROM team2 WHERE Position2 = '"+str+"'";
                cur = db.rawQuery(SELECT_SQL, null);
                cur.moveToFirst();
                String name = cur.getString(1);
                String surname = cur.getString(2);


                TextView T2 = (TextView)getView().findViewById(R.id.textView11);

                String time2 =((TextView)getActivity().findViewById(R.id.textView13)).getText().toString();
                T2.setMovementMethod(new ScrollingMovementMethod());
                if(r1.isChecked()){
                    T2.append(input2.getText() + " | " + r1.getText()+" " + a + " Score: " + i + "-" + k+" " + j + "-" + l + " Time: " +time2 +"\n" + "Player name: "+ name +" "+ surname + "\n");
                    a++;
                }
                else if (r2.isChecked()){
                    T2.append(input2.getText() + " | " + r2.getText()+" " + b + " Score: " + i + "-" + k+" " + j + "-" + l +  " Time: " +time2 +"\n" + "Player name: "+ name +" "+ surname + "\n");
                    b++;
                }
                else if (r3.isChecked()){
                    T2.append(input2.getText() + " | " + r3.getText()+" " + c + " Score: " + i + "-" + k+" " + j + "-" + l +  " Time: " +time2 +"\n" + "Player name: "+ name +" "+ surname + "\n");
                    c++;
                }
                else if (r4.isChecked()){
                    T2.append(input2.getText() + " | " + r4.getText()+" " + d + " Score: " + i + "-" + k+" " + j + "-" + l +  " Time: " +time2 +"\n" + "Player name: "+ name +" "+ surname + "\n");
                    d++;
                }
                else if (r5.isChecked()){
                    T2.append(input2.getText() + " | " + r5.getText()+" " + e + " Score: " + i + "-" + k+" " + j + "-" + l +  " Time: " +time2 +"\n" + "Player name: "+ name +" "+ surname + "\n");
                    e++;
                }
                else if (r6.isChecked()){
                    T2.append(input2.getText() + " | " + r6.getText()+" " + f + " Score: " + i + "-" + k+" " + j + "-" + l +  " Time: " +time2 +"\n" + "Player name: "+ name +" "+ surname + "\n");
                    f++;
                }
                popupWindow.dismiss();
                //Toast.makeText(getActivity(), str,Toast.LENGTH_LONG).show();
            }
        });
        Button StatsButton = (Button) getView().findViewById(R.id.button6);
        popupWindow.showAsDropDown(StatsButton, 500, -300);
    }

    public void onClickStats2(View view) {

        SQLiteDatabase db = getActivity().openOrCreateDatabase("GAAdb", android.content.Context.MODE_PRIVATE, null);
       // String selectposition = "select position FROM names";


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
                TextView T1 = (TextView)getView().findViewById(R.id.textView11);
                String time1 =((TextView)getActivity().findViewById(R.id.textView13)).getText().toString();
                Spinner sp3 = ((Spinner)popupView.findViewById(R.id.spinner4));
                String str = sp3.getSelectedItem().toString();
                String SELECT_SQL = "SELECT * FROM team1 WHERE Position = '"+str+"'";
                cur = db.rawQuery(SELECT_SQL, null);
                cur.moveToFirst();
                String name = cur.getString(1);
                String surname = cur.getString(2);
                T1.setMovementMethod(new ScrollingMovementMethod());
                if(r1.isChecked()){
                    T1.append(input1.getText() + " | " + r1.getText()+" " + u + " score: " + i + "-" + k+" " + j + "-" + l +  " Time: " +time1+"\n" + "Player name: "+ name +" "+ surname + "\n");
                    u++;
                }
                else if (r2.isChecked()){
                    T1.append(input1.getText() + " | " + r2.getText()+" " + p + " score: " + i + "-" + k+" " + j + "-" + l + " Time: " +time1 +"\n" + "Player name: "+ name +" "+ surname + "\n");
                    p++;
                }
                else if (r3.isChecked()){
                    T1.append(input1.getText() + " | " + r3.getText()+" " + w + " score: " + i + "-" + k+" " + j + "-" + l + " Time: " +time1 +"\n" + "Player name: "+ name +" "+ surname + "\n");
                    w++;
                }
                else if (r4.isChecked()){
                    T1.append(input1.getText() + " | " + r4.getText()+" " + x + " score: " + i + "-" + k+" " + j + "-" + l + " Time: " +time1 +"\n" + "Player name: "+ name +" "+ surname + "\n");
                    x++;
                }
                else if (r5.isChecked()){
                    T1.append(input1.getText() + " | " + r5.getText()+" " + y + " score: " + i + "-" + k+" " + j + "-" + l + " Time: " +time1 +"\n" + "Player name: "+ name +" "+ surname + "\n");
                    y++;
                }
                else if (r6.isChecked()){
                    T1.append(input1.getText() + " | " + r6.getText()+" " + z + " score: " + i + "-" + k+" " + j + "-" + l + " Time: " +time1 +"\n" + "Player name: "+ name +" "+ surname + "\n");
                    z++;
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

        db.beginTransaction();
        try {
            db.execSQL("create table team1 (recid integer PRIMARY KEY autoincrement,Name text,LastName text,Position text);");
            db.execSQL("insert into team1(Name, LastName, Position  ) values ('Test','Test1','Test2')");
            db.execSQL("create table team2 (recid integer PRIMARY KEY autoincrement,Name text,LastName text,Position2 text);");
            db.execSQL("insert into team2(Name, LastName, Position2  ) values ('Test','Test1','Test2')");

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
    public void Connect_to_server (View v){
		// TextView T1 = (TextView)getView().findViewById(R.id.textView11);
		//String info2=T1.getText().toString();
		//Toast.makeText(getActivity(), info2,Toast.LENGTH_LONG).show();
		String info =((TextView)getActivity().findViewById(R.id.textView11)).getText().toString();
		detail=info;
        Toast.makeText(getActivity(), detail, Toast.LENGTH_LONG).show();
		JSONObject json = new JSONObject();
		try {
			json.accumulate("name",detail);
			String baseUrl = "http://10.12.15.39:8080/InputToDatabase";
			//String baseUrl = "http://192.168.1.103:8080/InputToDatabase";
			//Toast.makeText(getActivity(), "In try",Toast.LENGTH_LONG).show();
			new HttpAsyncTask().execute(baseUrl, json.toString());
			Toast.makeText(getActivity(), "Async task", Toast.LENGTH_LONG).show();
		}
		catch (JSONException e) {
			e.printStackTrace();
		}
	}
    public  class HttpAsyncTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {

            String jsonString = "";

            try {

                jsonString = HttpUtils.urlContentPost(urls[0], "GameStats", urls[1]);

            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println(jsonString);
            return jsonString;
        }
        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {
            JSONObject jsonResult = null;
            try {
                jsonResult = new JSONObject(result);
                System.out.println("Data");


            } catch (JSONException e) {
                e.printStackTrace();
            }


        }
    }



}

