package com.user.manhitdz.katosa.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.user.manhitdz.katosa.Interface.ItemClickListener;
import com.user.manhitdz.katosa.R;
import com.user.manhitdz.katosa.activity.ChiTietActivity;
import com.user.manhitdz.katosa.model.SanPhamMoi;
import com.user.manhitdz.katosa.utils.Utils;


import java.util.ArrayList;
import java.util.List;

public class PageSlideAdapter extends RecyclerView.Adapter<PageSlideAdapter.MyViewHolder> {

    Context context;
    List<SanPhamMoi> sanPhamMois;

    public PageSlideAdapter(Context context, List<SanPhamMoi> sanPhamMois) {
        this.context = context;
        this.sanPhamMois = sanPhamMois;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_slider, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        SanPhamMoi sanPhamMoi = sanPhamMois.get(position);
        String url = "";
        if (!sanPhamMoi.getHinhanh().contains("http")){
            url = Utils.BASE_URL+"images/"+sanPhamMoi.getHinhanh();
        }else {
            url = sanPhamMoi.getHinhanh();
        }

        Glide.with(context).load(url).into(holder.imageView);
        holder.txtsize.setText("Size: "+sanPhamMoi.getSize());
        holder.txtcolor.setText("Color: "+sanPhamMoi.getColor());
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int pos, boolean isLongClick) {
                if (isLongClick == false){
                    Intent intent = new Intent(context, ChiTietActivity.class);
                    intent.putExtra("chitiet", sanPhamMoi);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            }
        });

    }



    @Override
    public int getItemCount() {
        return sanPhamMois.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView;
        TextView txtsize, txtcolor;
        private ItemClickListener itemClickListener;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_slider);
            txtsize = itemView.findViewById(R.id.txtsize);
            txtcolor = itemView.findViewById(R.id.txtcolor);
            itemView.setOnClickListener(this);
        }

        public void setItemClickListener(ItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }

        @Override
        public void onClick(View view) {
            itemClickListener.onClick(view,getAdapterPosition(),false);
        }
    }
}
