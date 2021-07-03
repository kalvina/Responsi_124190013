package com.upnyk.covid19.kasuscovid;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.upnyk.covid19.api.APIService;
import com.upnyk.covid19.model.covid.ContentItem;
import com.upnyk.covid19.model.covid.CovidResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class KasusCovidViewModel extends ViewModel {
    MutableLiveData<List<ContentItem>> listCovid;

    public KasusCovidViewModel() {
        listCovid = new MutableLiveData<>();
    }

    public MutableLiveData<List<ContentItem>> getListCovid() {
        return listCovid;
    }

    void ambilList(){
        APIService api = new APIService();
        api.getCovid().getKasusCovid().enqueue(new Callback<CovidResponse>() {
            @Override
            public void onResponse(Call<CovidResponse> call, Response<CovidResponse> response) {
                listCovid.setValue(response.body().getData().getContent());
            }

            @Override
            public void onFailure(Call<CovidResponse> call, Throwable t) {

            }
        });
    }
}
