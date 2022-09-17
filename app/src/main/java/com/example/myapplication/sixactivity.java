package com.example.myapplication;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
    public class sixactivity extends AppCompatActivity {
        Button b11,b22;
        DBHelp db;
        EditText ed1,ed2;
        String id,amt;
        EditText e3;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.six_activity);
            db=new DBHelp(this);
            b11=(Button) findViewById(R.id.button10);
            b22=(Button) findViewById(R.id.button11);
            ed1=findViewById(R.id.editTextTextPersonName6);
            ed2=findViewById(R.id.editTextTextPersonName7);
            e3=findViewById(R.id.editTextNumber3);
            b11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String id=ed1.getText().toString();
                    String amt=ed2.getText().toString();
                    System.out.println("con2"+amt+"");
                    Boolean b=db.updatedata(id,amt);
                    if(b==true){
                        Toast.makeText(sixactivity.this, "Amount Deposited Successfully",
                                Toast.LENGTH_SHORT).show();
                    }else{

                        Toast.makeText(sixactivity.this, "Failed to Deposite Amount",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            });
            b22.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String id=ed1.getText().toString();
                    String amt=ed2.getText().toString();
                    System.out.println("con2"+amt+"");
                    Boolean b=db.updatedata2(id,amt);
                    if(b==true){
                        Toast.makeText(sixactivity.this, "Withdraw Done Successfully",
                                Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(sixactivity.this, "Failed to Withdraw Money",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

