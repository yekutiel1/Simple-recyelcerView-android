package com.example.stu.relearnandroid;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


public class MyAdapter extends RecyclerView.Adapter {

    Context context;
    private ItemClickListener itemClickListener;

    ;public MyAdapter(Context context){
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rowView = View.inflate(context, R.layout.recyclerview_row, null);
        return new ViewHolder(rowView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ViewHolder)holder).updateRow(position);
    }

    @Override
    public int getItemCount() {
        return MainActivity.namesArray.size();
    }

    void setClickListener(ItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }

    public interface ItemClickListener{
        void onItemClick(View view, int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        int position;
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.personName);
            itemView.setOnClickListener(this);
        }

        public void updateRow(int position){
            this.position = position;
            textView.setText("" + MainActivity.namesArray.get(position));
        }

        @Override
        public void onClick(View view) {
//            Toast.makeText(context, "dfdfdf", Toast.LENGTH_SHORT).show();
            if (itemClickListener != null) itemClickListener.onItemClick(view, position);
        }
    }

}
