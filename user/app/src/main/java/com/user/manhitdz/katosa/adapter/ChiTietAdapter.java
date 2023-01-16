package com.user.manhitdz.katosa.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.user.manhitdz.katosa.R;
import com.user.manhitdz.katosa.model.Item;
import com.user.manhitdz.katosa.utils.Utils;

import java.util.List;

public class ChiTietAdapter extends RecyclerView.Adapter<ChiTietAdapter.MyViewHolder> {
    Context context;
    List<Item> itemList;

    public ChiTietAdapter(Context context, List<Item> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chitiet, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Item item = itemList.get(position);
        holder.txtten.setText(item.getTensp() + "");
        holder.txtsoluong.setText("Số lượng: "+item.getSoluong() + "");
        holder.txtsize.setText("Size: "+item.getSize());
        holder.txtcolor.setText(item.getColor());
        String url = "";
        if (!item.getHinhanh().contains("http")){
            url = Utils.BASE_URL+"images/"+item.getHinhanh();
        }else {
            url = item.getHinhanh();
        }
        Glide.with(context).load(url).into(holder.imageChitiet);
        holder.txtgia.setText("Giá: "+item.getGia()+ "");
        holder.txtmota.setText("Mô tả: "+item.getMota()+ "");
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageChitiet;
        TextView txtten, txtsoluong, txtgia, txtcolor, txtsize, txtmota;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageChitiet = itemView.findViewById(R.id.item_imgchitiet);
            txtten = itemView.findViewById(R.id.item_tenspchitiet);
            txtsoluong = itemView.findViewById(R.id.item_soluongchitiet);
            txtgia = itemView.findViewById(R.id.item_giachitiet);
            txtcolor = itemView.findViewById(R.id.item_color);
            txtsize = itemView.findViewById(R.id.item_size);
            txtmota = itemView.findViewById(R.id.item_mota);
        }
    }
}
