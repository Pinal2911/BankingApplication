package com.example.myapplication;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
public class ThirdActivity extends AppCompatActivity {
    EditText ed1, ed2, ed3, ed4, ed5, ed6, ed7;
    Button b1, b2,b3;
    DBHelp db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        ed1 = (EditText) findViewById(R.id.editTextTextPersonName3);
        ed2 = (EditText) findViewById(R.id.editTextNumber);
        ed3 = findViewById(R.id.editTextTextPersonName4);
        ed4 = findViewById(R.id.editTextNumber2);
        ed5 = findViewById(R.id.editTextNumber3);
        ed6 = findViewById(R.id.editTextTextPersonName5);
        ed7 = findViewById(R.id.editTextNumber4);
        b1 = findViewById(R.id.button7);
        b2 = findViewById(R.id.button8);
        db=new DBHelp(this);
        try {
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String name = ed1.getText().toString();
                    String id = ed2.getText().toString();
                    String addr = ed3.getText().toString();
                    String amt = ed5.getText().toString();
                    String mob=ed4.getText().toString();
                    String acctype = ed6.getText().toString();
                    String age = ed7.getText().toString();
                    System.out.println(name);
                    Boolean ans = db.addaccount(name,id,addr,mob,amt,acctype,age);
                    if (ans == true) {
                        Toast.makeText(ThirdActivity.this, "ACCOUNT CREATED",
                                Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(ThirdActivity.this, "FAILED TO CREATE ACCOUNT",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}