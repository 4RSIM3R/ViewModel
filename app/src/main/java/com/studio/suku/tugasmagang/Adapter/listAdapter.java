package com.studio.suku.tugasmagang.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.studio.suku.tugasmagang.Model.ResultData;
import com.studio.suku.tugasmagang.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

public class listAdapter extends RecyclerView.Adapter<listAdapter.listViewHolder> {

    private Context context;
    private List<ResultData> data;

    public listAdapter(Context context, List<ResultData> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public listViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        return new listViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull listViewHolder holder, int position) {
        final int pcc =holder.getAdapterPosition();
        Picasso.get().load(data.get(position).getThumbnail());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class listViewHolder extends RecyclerView.ViewHolder {
        final ImageView imageView;
        public listViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img_item_photo);
        }
    }
}
