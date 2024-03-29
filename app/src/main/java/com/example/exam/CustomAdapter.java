package com.example.exam;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;


public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private List<person> pdata;
    public CustomAdapter(List<person> pdata){
        this.pdata= pdata;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // infalte the item Layout
//        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.raw, parent, false);
//        // set the view's size, margins, paddings and layout parameters
//        MyViewHolder vh = new MyViewHolder(v); // pass the view to View Holder
//        return vh;
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.raw, parent, false);
        return new MyViewHolder(view);
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        // set the data in items
        holder.name.setText(pdata.get(position).getName());

//        final person pd= pdata.get(position);
//        holder.name.setText(pdata.get(position).getName());
//        // implement setOnClickListener event on item view.
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // display a toast with person name on item click
//                Toast.makeText(view.getContext(),pd.getName(), Toast.LENGTH_SHORT).show();
//            }
//        });
    }
    @Override
    public int getItemCount() {
        return pdata.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name;// init the item view's
        public MyViewHolder(View itemView) {
            super(itemView);
            // get the reference of item view's
            name = (TextView) itemView.findViewById(R.id.name);
        }
    }
}

