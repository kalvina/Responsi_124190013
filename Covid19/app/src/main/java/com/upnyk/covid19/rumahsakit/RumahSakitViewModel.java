package com.upnyk.covid19.rumahsakit;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.upnyk.covid19.api.APIService;
import com.upnyk.covid19.model.rs.DataItem;
import com.upnyk.covid19.model.rs.RSResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RumahSakitViewModel extends ViewModel {
    MutableLiveData<List<DataItem>> listRumahSakit;

    public RumahSakitViewModel() {
        listRumahSakit = new MutableLiveData<>();
    }

    public MutableLiveData<List<DataItem>> getListRumahSakit() {
        return listRumahSakit;
    }

    void ambilRs(){
        APIService api = new APIService();
        api.getCovid().getRumahSakit().enqueue(new Callback<RSResponse>() {
            @Override
            public void onResponse(Call<RSResponse> call, Response<RSResponse> response) {
                listRumahSakit.setValue(response.body().getData());
            }

            @Override
            public void onFailure(Call<RSResponse> call, Throwable t) {

            }
        });
    }
}
