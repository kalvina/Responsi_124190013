package com.upnyk.covid19.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.upnyk.covid19.R;
import com.upnyk.covid19.model.covid.ContentItem;

import java.util.List;

public class KasusCovidAdapter extends RecyclerView.Adapter<KasusCovidAdapter.ViewHolder> {

    Context context;
    List<ContentItem> listKasusCovid;

    public KasusCovidAdapter(Context context, List<ContentItem> listKasusCovid) {
        this.context = context;
        this.listKasusCovid = listKasusCovid;
    }

    public void setListKasusCovid(List<ContentItem> listKasusCovid) {
        this.listKasusCovid = listKasusCovid;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_covid, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KasusCovidAdapter.ViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return listKasusCovid.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tanggal, terkonfirmasi, sembuh, meninggal;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tanggal = itemView.findViewById(R.id.tanggal);
            terkonfirmasi = itemView.findViewById(R.id.terkonfirmasi);
            sembuh = itemView.findViewById(R.id.sembuh);
            meninggal = itemView.findViewById(R.id.meninggal);
        }

        public void bind(int position) {
            tanggal.setText(listKasusCovid.get(position).getTanggal());
            terkonfirmasi.setText(String.valueOf(listKasusCovid.get(position).getConfirmationDiisolasi()));
            sembuh.setText(String.valueOf(listKasusCovid.get(position).getConfirmationSelesai()));
            meninggal.setText(String.valueOf(listKasusCovid.get(position).getConfirmationMeninggal()));
        }
    }
}
