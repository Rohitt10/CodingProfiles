package com.example.practicesql;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {


    EditText username,password;
    Button signin,signup;
    DBHandler dbHandler;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username=findViewById(R.id.userName);
        password=findViewById(R.id.password);
        signin=findViewById(R.id.signin);
        signup=findViewById(R.id.signup);
        dbHandler=new DBHandler(MainActivity.this);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),SignUpActivity.class);
                startActivity(i);
            }
        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usn=username.getText().toString();
                String pass=password.getText().toString();
//                if(dbHandler.check(usn,pass))
//                {
                    Profiles obj=dbHandler.readCourses(usn,pass,MainActivity.this);
                    if(obj!=null)
                    {
                        Intent i=new Intent(getApplicationContext(),ProfileDisplay.class);
//
                        HashMap<String,String> hm=new HashMap<>();
                        hm.put("CodeChef",obj.ccid);
                        hm.put("CodeForces",obj.cfid);
                        hm.put("LeetCode",obj.lcid);
                        hm.put("GitHub",obj.gitid);
                        hm.put("Geeks for Geeks",obj.gfgid);
                        hm.put("CodingNinja",obj.cnid);
                        hm.put("HackerRank",obj.hackid);
                        i.putExtra("hash",hm);
                        startActivity(i);
//                        Toast.makeText(MainActivity.this,obj.ccid+" codechef",Toast.LENGTH_SHORT).show();
                    }
                    else
                        Toast.makeText(MainActivity.this,"Username or Password is incorrect",Toast.LENGTH_SHORT).show();
//                Toast.makeText(MainActivity.this,"Username or Password is incorrect",Toast.LENGTH_SHORT).show();
            }
        });
    }
}