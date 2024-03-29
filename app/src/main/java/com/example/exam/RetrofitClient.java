package com.example.exam;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofit;

//Define the base URL//

    private static final String BASE_URL = "https://api.androidhive.info/contacts/";

//Create the Retrofit instance//

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)

//Add the converter//

                    .addConverterFactory(GsonConverterFactory.create())

//Build the Retrofit instance//

                    .build();
        }
        return retrofit;
    }
}
