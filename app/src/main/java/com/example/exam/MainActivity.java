package com.example.exam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        person[] myListData = new person[] {
                new person("Email"),
                new person("Info"),
                new person("Delete"),
                new person("Dialer"),
                new person("Alert"),
                new person("Map"),
                new person("Email"),
                new person("Info"),
                new person("Delete"),
                new person("Dialer"),
                new person("Alert"),
                new person("Map"),
        };
        // get the reference of RecyclerView
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rec1);
        // set a LinearLayoutManager with default vertical orientation
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        //  call the constructor of CustomAdapter to send the reference and data to Adapter
        CustomAdapter customAdapter = new CustomAdapter(myListData);
        recyclerView.setAdapter(customAdapter); // set the Adapter to RecyclerView
    }
}
