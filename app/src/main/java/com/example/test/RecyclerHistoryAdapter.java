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

public class RecyclerHistoryAdapter extends RecyclerView.Adapter<RecyclerHistoryAdapter.HistoryViewHolder> {

				private List<HistoryCard> historyCards = new ArrayList<>();

				@SuppressLint("NotifyDataSetChanged")
				public void setHistoryCards(List<HistoryCard> historyCards) {
								this.historyCards = historyCards;
								notifyDataSetChanged();
				}

				@NonNull
				@Override
				public HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
								View view = LayoutInflater.from(parent.getContext()).inflate(
												R.layout.recyclerview_item,
												parent,
												false
								);
								return new HistoryViewHolder(view);
				}

				@Override
				public void onBindViewHolder(@NonNull HistoryViewHolder holder, int position) {
								HistoryCard historyCard = historyCards.get(position);
								String s = historyCard.getType() + ", " + historyCard.getScheme() + ", " + historyCard.
												getBankName() + ", " + historyCard.getTimeStamp();
								holder.textViewBin.setText(historyCard.getBin());
								holder.textViewCardInfo.setText(s);
				}

				@Override
				public int getItemCount() {
								return historyCards.size();
				}

				static class HistoryViewHolder extends RecyclerView.ViewHolder {

								private final TextView textViewBin;
								private final TextView textViewCardInfo;

								public HistoryViewHolder(@NonNull View itemView) {
												super(itemView);
												textViewBin = itemView.findViewById(R.id.textViewStaticCardInfo);
												textViewCardInfo = itemView.findViewById(R.id.textViewCardInfoFromServer);
								}
				}
}
