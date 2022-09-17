package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    AbsoluteLayout al;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText e1=(EditText)findViewById(R.id.editTextTextPersonName);
        EditText e2=(EditText)findViewById(R.id.editTextTextPassword);
        Button b1=(Button)findViewById(R.id.button);
        al=(AbsoluteLayout)findViewById(R.id.layout);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name,psw;
                name=e1.getText().toString();
                psw=e2.getText().toString();
                if(name.equals("Pinal22") && psw.equals("Pinal2911")){
                    Toast.makeText(MainActivity.this, "Login Done Successfully",
                            Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(getBaseContext(),SecondActivity.class);
                    startActivity(i);
                }else{
                    Toast.makeText(MainActivity.this, "Login Failed!\n Enter Valid Details",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}