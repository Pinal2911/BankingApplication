package com.example.myapplication;
import android.database.Cursor;
import android.os.Bundle;

import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
public class FourthActivity extends AppCompatActivity {
    DBHelp db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fourth_activity);
        db=new DBHelp(this);
        Cursor c=db.getdata();
        if(c.getCount() == 0){
            Toast.makeText(this, "NO DATA AVAILABLE", Toast.LENGTH_SHORT).show();
        }
        StringBuffer sb=new StringBuffer();
        while(c.moveToNext()){
            sb.append("Name = "+c.getString(0)+"\n");
            sb.append("ID ="+c.getString(1)+"\n");
            sb.append("Address = "+c.getString(2)+"\n");
            sb.append("Mobile No = "+c.getString(3)+"\n");
            sb.append("Amount = "+c.getString(4)+"\n");
            sb.append("Account Type = "+c.getString(5)+"\n");
            sb.append("Age = "+c.getString(6)+"\n");
            AlertDialog.Builder d=new AlertDialog.Builder(FourthActivity.this);
            d.setCancelable(true);
            d.setTitle("USER ACCOUNTS");
            d.setMessage(sb);
            d.show();
        }

    }
}
