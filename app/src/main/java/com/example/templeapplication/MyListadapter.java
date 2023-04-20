package com.example.templeapplication;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

public class MyListadapter extends RecyclerView.Adapter<MyListadapter.ViewHolder> {
    private MyListData[] listdata;
    

    public MyListadapter(MyListData[] listData) {
        this.listdata = listData;
    }
    int amt;
    int total;
    String items;
    int img;


    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewHolder viewHolder;
             View listItem = layoutInflater.inflate(R.layout.list_item, parent, false);
        viewHolder = new ViewHolder(listItem);
        return viewHolder;

    }
    public void onBindViewHolder(ViewHolder holder, int position) {


        final MyListData myListData = listdata[position];
        holder.textView.setText(listdata[position].getItem());
        holder.textView1.setText(String.valueOf(listdata[position].getAmount()));
        holder.imageView.setImageResource(listdata[position].getImgid());

        holder.imageView.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                items=myListData.item;
                total= myListData.amount;
                img=myListData.imgid;
                amt+=total;
                Toast.makeText(view.getContext(), "Total amount: "+amt, Toast.LENGTH_SHORT).show();
                Tickets.txt.setText("Total Amount : "+amt);
                
                Tickets.databaseHelper.insertData(new MyListData(items,total,img));



            }
        });
        Tickets.cbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                amt=0;
                Tickets.txt.setText("Total Amount: "+amt);

            }
        });
        Tickets.pbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
    @Override
    public int getItemCount() {
        return listdata.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textView;
        public TextView textView1;
        TextView textview3;
        LinearLayout ll;
        public ViewHolder(View itemView) {
            super(itemView);
            this.imageView = itemView.findViewById(R.id.image);
            this.textView = itemView.findViewById(R.id.txt);
            this.textView1 = itemView.findViewById(R.id.txt1);
            this.textview3 = itemView.findViewById(R.id.textView2);
            this.ll = itemView.findViewById(R.id.ll);
        }
    }
}