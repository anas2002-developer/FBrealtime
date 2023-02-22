package com.example.firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText eName,eRoll,eCourse,eAge;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void process(View view){
        eName=findViewById(R.id.eName);
        eRoll=findViewById(R.id.eRoll);
        eAge=findViewById(R.id.eAge);
        eCourse=findViewById(R.id.eCourse);
        btnAdd=findViewById(R.id.btnAdd);

        String name=eName.getText().toString().trim();
        String roll=eRoll.getText().toString().trim();
        String age=eAge.getText().toString().trim();
        String course=eCourse.getText().toString().trim();

        FirebaseDatabase fdb=FirebaseDatabase.getInstance();
        DatabaseReference root= fdb.getReference("students");

        StudentDetailsData dataObj = new StudentDetailsData(name,course,age);

        root.child(roll).setValue(dataObj);

        eRoll.setText("");
        eName.setText("");
        eCourse.setText("");
        eAge.setText("");

        Toast.makeText(this, "added to firebase", Toast.LENGTH_SHORT).show();
    }
}