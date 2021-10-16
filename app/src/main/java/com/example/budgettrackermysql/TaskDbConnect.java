package com.example.budgettrackermysql;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

class TaskDbConnect extends AsyncTask<Void, Void, String> {
    Activity activity = null;

    public TaskDbConnect(Activity act){
        activity = act;
    }

    @Override
    protected String doInBackground(Void... params) {
        String text1="";

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn= DriverManager.getConnection("jdbc:mysql://192.168.0.32:3306/budgettracker?characterEncoding=utf8","and_user","android0216");
            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery("select * from 2019_records");

            while(rs.next()){
                int id=rs.getInt(1);
                Date date=rs.getDate(2);
                String storeName=rs.getString(3);
                String productName=rs.getString(4);
                String type =rs.getString(5);
                int price=rs.getInt(6);
                text1+=id+" "+date+" "+storeName+" "+productName+" "+type+" "+price+" "+"\r\n";
            }

        }catch(Exception e){
            text1=e.getMessage();
        }

        return text1;
    }

    protected void onPostExecute(String result){
        TextView tv = (TextView)activity.findViewById(R.id.textview1);
        tv.setText(result);
    }
}
