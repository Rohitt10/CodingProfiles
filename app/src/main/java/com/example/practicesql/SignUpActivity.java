package com.example.practicesql;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {
    EditText usn,pass,ccid,cfid,lcid,gfgid,hackid,gitid,cnid;
    Button add;
    private DBHandler dbHandler;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        usn=findViewById(R.id.usn);
        pass=findViewById(R.id.pass);
        ccid=findViewById(R.id.ccid);
        cfid=findViewById(R.id.cfid);
        lcid=findViewById(R.id.lcid);
        add=findViewById(R.id.add);
        gitid=findViewById(R.id.gitid);
        gfgid=findViewById(R.id.gfgid);
        cnid=findViewById(R.id.cnid);
        hackid=findViewById(R.id.hackid);
        dbHandler = new DBHandler(SignUpActivity.this);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userid=usn.getText().toString();
                String usp=pass.getText().toString();
                String ccun=ccid.getText().toString();
                String cfun=cfid.getText().toString();
                String lcun=lcid.getText().toString();
                String cnun=cnid.getText().toString();
                String gfgun=gfgid.getText().toString();
                String hackun=hackid.getText().toString();
                String gitun=gitid.getText().toString();
                if (userid.isEmpty()&&usp.isEmpty()&&ccun.isEmpty()&&cfun.isEmpty()&&lcun.isEmpty()) {
                    Toast.makeText(SignUpActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }
                dbHandler.addNewCourse(userid,usp,ccun,cfun,lcun,gfgun,cnun,gitun,hackun);
                Toast.makeText(SignUpActivity.this, "Information has been added.", Toast.LENGTH_SHORT).show();
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });
    }
}