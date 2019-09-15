package com.example.exam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        person[] myListData = new person[] {
//                new person("Email"),
//                new person("Info"),
//                new person("Delete"),
//                new person("Dialer"),
//                new person("Alert"),
//                new person("Map"),
//                new person("Email"),
//                new person("Info"),
//                new person("Delete"),
//                new person("Dialer"),
//                new person("Alert"),
//                new person("Map"),
//        };
        GetData service = RetrofitClient.getRetrofitInstance().create(GetData.class);

        Call<List<person>> call = service.getAllcontacts();

//Execute the request asynchronously//

        call.enqueue(new Callback<List<person>>() {

            @Override

//Handle a successful response//

            public void onResponse(Call<List<person>> call, Response<List<person>> response) {
                loadDataList(response.body());
            }

            @Override

//Handle execution failures//

            public void onFailure(Call<List<person>> call, Throwable throwable) {

//If the request fails, then display the following toast//

                Toast.makeText(MainActivity.this, "Unable to load users", Toast.LENGTH_SHORT).show();
            }
        });
//        // get the reference of RecyclerView
//        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rec1);
//        // set a LinearLayoutManager with default vertical orientation
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
//        myRecyclerView.setLayoutManager(linearLayoutManager);
//        //  call the constructor of CustomAdapter to send the reference and data to Adapter
////        CustomAdapter customAdapter = new CustomAdapter(myListData);
//        recyclerView.setAdapter(customAdapter); // set the Adapter to RecyclerView
    }

    private void loadDataList(List<person> pdata) {

//Get a reference to the RecyclerView//

        RecyclerView myRecyclerView = findViewById(R.id.rec1);
        CustomAdapter customAdapter = new CustomAdapter(pdata);

//Use a LinearLayoutManager with default vertical orientation//

//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//
//        myRecyclerView.setLayoutManager(linearLayoutManager);
//
//
////Set the Adapter to the RecyclerView//
//
//        myRecyclerView.setAdapter(customAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        myRecyclerView.setLayoutManager(layoutManager);
        myRecyclerView.setHasFixedSize(true);
        myRecyclerView.setAdapter(customAdapter);
    }
}
