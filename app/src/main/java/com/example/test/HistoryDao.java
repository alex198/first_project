package com.example.test;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface HistoryDao {

				@Query("SELECT * FROM history")
				LiveData<List<HistoryCard>> getHistory();

				@Insert(onConflict = OnConflictStrategy.REPLACE)
				void add(HistoryCard cardHistory);

				@Query("DELETE FROM history WHERE bin = :bin")
				void remove(String bin);
}
