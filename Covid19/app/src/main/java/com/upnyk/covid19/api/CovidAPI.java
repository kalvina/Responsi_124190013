package com.upnyk.covid19.api;

import com.upnyk.covid19.model.covid.CovidResponse;
import com.upnyk.covid19.model.rs.RSResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CovidAPI {

    @GET("rekapitulasi_v2/jabar/harian")
    Call<CovidResponse> getKasusCovid();

    @GET("sebaran_v2/jabar/faskes")
    Call<RSResponse> getRumahSakit();

}
