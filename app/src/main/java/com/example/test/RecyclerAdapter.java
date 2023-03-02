package com.example.test;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.CardViewHolder> {

    private List<Map.Entry<String, String>> cards = new ArrayList<>();

				@SuppressLint("NotifyDataSetChanged")
				public void setList(@NonNull Map<String, String> map) {
								this.cards = new ArrayList<>(map.entrySet());
								notifyDataSetChanged();
				}

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
            R.layout.recyclerview_item,
            parent,
            false
        );
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        Map.Entry<String, String> item = cards.get(position);
        holder.textViewStaticName.setText(item.getKey());
        holder.textViewDataExport.setText(item.getValue());
    }

    @Override
    public int getItemCount() {
        return cards.size();
    }

    static class CardViewHolder extends RecyclerView.ViewHolder {

        private final TextView textViewStaticName;
        private final TextView textViewDataExport;

								public CardViewHolder(@NonNull View itemView) {
												super(itemView);
												textViewStaticName = itemView.findViewById(R.id.textViewStaticCardInfo);
												textViewDataExport = itemView.findViewById(R.id.textViewCardInfoFromServer);
								}
				}

}
