package com.example.simpletodo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

//display data from model to a row in the recycler view
public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ViewHolder>{

    public  interface  OnClickListener{
        void onItemClicked(int position);
    }
    public interface OnLongClickListener{
        void onItemLongClicked(int position);
    }

    List<String> items;
    OnLongClickListener longClickListener;
    OnClickListener clickListener;


    public ItemsAdapter(List<String> items, OnLongClickListener longClickListener, OnClickListener clickListener) {
        this.items = items;
        this.longClickListener = longClickListener;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Use layout inflator to inflate a view

        View todoView = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
        //wrap it inside a view holder and return it

        return new ViewHolder(todoView);
    }
    //binding data to Viewholder
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //Grab the item
        String item = items.get(position);
        //Bind the item
        holder.bind(item);
    }

    //Tells number of items
    @Override
    public int getItemCount() {
        return items.size();
    }

    //container to provide views that represent each row of the list
    class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvItem;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvItem = itemView.findViewById(android.R.id.text1);

        }

        //Update the view
        public void bind(String item) {
            tvItem.setText(item);
            tvItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    clickListener.onItemClicked(getAdapterPosition());
                }
            });
            tvItem.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    //which is long pressed
                    longClickListener.onItemLongClicked(getAdapterPosition());
                    return true;
                }
            });
        }
    }

}
