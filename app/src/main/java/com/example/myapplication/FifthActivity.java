package com.example.myapplication;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
public class FifthActivity extends AppCompatActivity {
    DBHelp db;
    EditText ed;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fifth_activity);
        db=new DBHelp(this);
        b=findViewById(R.id.button9);
        ed=findViewById(R.id.editTextTextPersonName2);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id=ed.getText().toString();
                System.out.println(id);
                Boolean res=db.deletedata(id);
                if(res == true){
                    Toast.makeText(FifthActivity.this, "Data Deleted successfully",
                            Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(FifthActivity.this, "Failed to delete Data",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
