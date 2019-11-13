package com.example.moneymanager.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moneymanager.R;
import com.example.moneymanager.models.App;
import com.example.moneymanager.models.Item;

import java.util.ArrayList;

public class AddItemsAdapter extends RecyclerView.Adapter<AddItemsAdapter.ViewHolder> {

    Context mContext;
    private ArrayList<Item> mListItem;
    private App app;
    private ImageView icons;

    public AddItemsAdapter(Context mContext, ArrayList<Item>mListItem, ImageView icons){
        this.mContext = mContext;
        this.mListItem = mListItem;
        this.icons = icons;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_add_items, parent, false);
        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        app = new App();
        final Item an_item = mListItem.get(position);
        holder.icon.setImageResource(app.getICons(an_item.getType()));
        holder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                icons.setImageResource(app.getICons(an_item.getType()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mListItem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView icon;
        private LinearLayout item;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            item = itemView.findViewById(R.id.item);
            icon = itemView.findViewById(R.id.icon);
        }
    }
}
