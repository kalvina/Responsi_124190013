package com.upnyk.covid19.kasuscovid;

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
import com.upnyk.covid19.model.covid.ContentItem;

import java.util.ArrayList;
import java.util.List;

public class KasusCovidFragment extends Fragment {

    private RecyclerView recyclerCovid;
    private KasusCovidAdapter covidAdapter;
    private KasusCovidViewModel covidViewModel;
    private TextView loading;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kasus_covid, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        covidAdapter = new KasusCovidAdapter(getActivity(), new ArrayList<>());
        covidViewModel = new ViewModelProvider(this).get(KasusCovidViewModel.class);
        loading = view.findViewById(R.id.loading_covid);

        recyclerCovid = view.findViewById(R.id.recycler_covid);
        recyclerCovid.setAdapter(covidAdapter);
        recyclerCovid.setHasFixedSize(true);
        recyclerCovid.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, true));

        covidViewModel.getListCovid().observe(requireActivity(), new Observer<List<ContentItem>>() {
            @Override
            public void onChanged(List<ContentItem> contentItems) {
                covidAdapter.setListKasusCovid(contentItems);
                covidAdapter.notifyDataSetChanged();
                recyclerCovid.scrollToPosition(covidAdapter.getItemCount()-1);

                if (contentItems.size() == 0){
                    loading.setVisibility(View.VISIBLE);
                } else {
                    loading.setVisibility(View.INVISIBLE);
                }
            }
        });

        covidViewModel.ambilList();
    }
}