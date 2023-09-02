package com.example.practicesql;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.HashMap;

public class ProfileDisplay extends AppCompatActivity {
    RecyclerView recyclerView;
    Logic[] g;
    MyAdapter2 myAdapter;
    HashMap<String,String> hm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_display);
        recyclerView=findViewById(R.id.recyclerView);
        hm=(HashMap<String,String>) getIntent().getSerializableExtra("hash");
        g=new Logic[]{new Logic(R.drawable.codechef,"CodeChef"),
                new Logic(R.drawable.gfg,"Geeks for Geeks"),
                new Logic(R.drawable.codeforces,"CodeForces"),
                new Logic(R.drawable.leetcode,"LeetCode"),
                new Logic(R.drawable.hackerrank,"HackerRank"),
                new Logic(R.drawable.coding_ninja,"CodingNinja"),
                new Logic(R.drawable.github,"GitHub")};
        myAdapter=new MyAdapter2(g,getApplicationContext(),hm);
        RecyclerView.LayoutManager layoutManager = new
                LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(myAdapter);

    }
}