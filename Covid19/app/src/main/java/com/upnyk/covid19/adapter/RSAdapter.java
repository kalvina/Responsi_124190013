package com.upnyk.covid19.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.upnyk.covid19.R;
import com.upnyk.covid19.model.rs.DataItem;
import com.upnyk.covid19.model.rs.RSResponse;

import java.util.List;

public class RSAdapter extends RecyclerView.Adapter<RSAdapter.ViewHolder> {
    Context context;
    List<DataItem> listRs;

    public RSAdapter(Context context, List<DataItem> listRs) {
        this.context = context;
        this.listRs = listRs;
    }

    public void setListRs(List<DataItem> listRs) {
        this.listRs = listRs;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_rs, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RSAdapter.ViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return listRs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView namaRs, alamat;
        Button maps;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            namaRs = itemView.findViewById(R.id.nama_rs);
            alamat = itemView.findViewById(R.id.alamat_rs);
            maps = itemView.findViewById(R.id.button_maps);
        }

        public void bind(int position) {
            namaRs.setText(listRs.get(position).getNama());
            alamat.setText(listRs.get(position).getAlamat());
            maps.setOnClickListener(v -> {
                String address = String.format("geo: 0, 0?q= %s", listRs.get(position).getNama());
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(address));
                intent.setPackage("com.google.android.apps.maps");
                context.startActivity(intent);
            });
        }
    }
}
