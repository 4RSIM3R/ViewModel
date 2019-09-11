package com.studio.suku.tugasmagang.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.studio.suku.tugasmagang.Model.ResultData;
import com.studio.suku.tugasmagang.R;
import com.studio.suku.tugasmagang.View.DetailActivity;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class listAdapter extends RecyclerView.Adapter<listAdapter.listViewHolder> {

    private final Context context;
    private final List<ResultData> data;

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
    public void onBindViewHolder(@NonNull listViewHolder holder, final int position) {
        final ResultData resultData = new ResultData();
        final int pcc =holder.getAdapterPosition();
        Picasso.get().load(data.get(position).getThumbnail()).into(holder.imageView);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                //Toast.makeText(context, data.get(pcc).getCaption(), Toast.LENGTH_SHORT).show();
                resultData.setCaption(data.get(position).getCaption());
                resultData.setImage(data.get(position).getImage());
                intent.putExtra(DetailActivity.EXTRA_DATA, resultData);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class listViewHolder extends RecyclerView.ViewHolder {
        final ImageView imageView;
        listViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img_item_photo);
        }
    }
}
