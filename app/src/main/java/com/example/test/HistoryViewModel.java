package com.example.test;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class HistoryViewModel extends AndroidViewModel {

				private final HistoryDao historyDao;

				public HistoryViewModel(@NonNull Application application) {
								super(application);
								historyDao = CardDatabase.getInstance(application).historyDao();
				}

				public LiveData<List<HistoryCard>> getHistoryCard() {
								return historyDao.getHistory();
				}


}
