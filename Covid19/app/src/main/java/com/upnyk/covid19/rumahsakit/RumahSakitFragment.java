package com.upnyk.covid19.rumahsakit;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.upnyk.covid19.R;
import com.upnyk.covid19.adapter.KasusCovidAdapter;
import com.upnyk.covid19.adapter.RSAdapter;
import com.upnyk.covid19.kasuscovid.KasusCovidViewModel;
import com.upnyk.covid19.model.rs.DataItem;

import java.util.ArrayList;
import java.util.List;

public class RumahSakitFragment extends Fragment {
    
    private RecyclerView recyclerRs;
    private RSAdapter rsAdapter;
    private RumahSakitViewModel rumahSakitViewModel;
    private TextView loading;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rumah_sakit, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rsAdapter = new RSAdapter(getActivity(), new ArrayList<>());
        rumahSakitViewModel = new ViewModelProvider(this).get(RumahSakitViewModel.class);
        loading = view.findViewById(R.id.loading_rs);

        recyclerRs = view.findViewById(R.id.recycler_rs);
        recyclerRs.setAdapter(rsAdapter);
        recyclerRs.setHasFixedSize(true);
        recyclerRs.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));
        
        rumahSakitViewModel.getListRumahSakit().observe(requireActivity(), new Observer<List<DataItem>>() {
            @Override
            public void onChanged(List<DataItem> dataItems) {
                rsAdapter.setListRs(dataItems);
                rsAdapter.notifyDataSetChanged();

                if (dataItems.size() == 0){
                    loading.setVisibility(View.VISIBLE);
                } else {
                    loading.setVisibility(View.INVISIBLE);
                }
            }
        });

        rumahSakitViewModel.ambilRs();
    }
}