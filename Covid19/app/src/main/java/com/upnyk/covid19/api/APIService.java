package com.upnyk.covid19.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIService {
    private Retrofit retrofit = null;

    public CovidAPI getCovid(){
        if (retrofit == null){
            retrofit =new Retrofit.Builder()
                    .baseUrl("https://covid19-public.digitalservice.id/api/v1/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(CovidAPI.class);
    }
}
