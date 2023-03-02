package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import java.util.List;

public class HistoryActivity extends AppCompatActivity {

				@Override
				protected void onCreate(Bundle savedInstanceState) {
								super.onCreate(savedInstanceState);
								setContentView(R.layout.activity_history);

								RecyclerView recyclerViewHistory = findViewById(R.id.recyclerViewHistory);
								RecyclerHistoryAdapter historyAdapter = new RecyclerHistoryAdapter();
								recyclerViewHistory.setLayoutManager(new LinearLayoutManager(this));
								recyclerViewHistory.setAdapter(historyAdapter);

								HistoryViewModel viewModel = new ViewModelProvider(this).get(HistoryViewModel.class);
								viewModel.getHistoryCard().observe(this, new Observer<List<HistoryCard>>() {
												@Override
												public void onChanged(List<HistoryCard> historyCards) {
																historyAdapter.setHistoryCards(historyCards);
												}
								});
				}

				public static Intent newIntent(Context context) {
								return new Intent(context, HistoryActivity.class);
				}
}