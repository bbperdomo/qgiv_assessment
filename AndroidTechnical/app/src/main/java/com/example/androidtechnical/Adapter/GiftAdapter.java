package com.example.androidtechnical.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.androidtechnical.Gift;
import com.example.androidtechnical.R;

import java.util.ArrayList;
import java.util.List;

public class GiftAdapter extends RecyclerView.Adapter<GiftAdapter.ViewHolder> {

    private List<Gift> gifts;

    public GiftAdapter(List<Gift> gifts) {
        this.gifts = gifts;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gift_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        Gift gift = gifts.get(position);
        viewHolder.amountTextView.setText("$" + gift.getAmount());
        viewHolder.timeTextView.setText(gift.getTimeElapsed());
    }

    @Override
    public int getItemCount() {
        return gifts.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView amountTextView;
        public TextView timeTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            amountTextView = itemView.findViewById(R.id.amount_text_view);
            timeTextView = itemView.findViewById(R.id.time_text_view);
        }
    }

    public void addGift(Gift gift) {
        gifts.add(gift);
        notifyDataSetChanged();
    }







}
