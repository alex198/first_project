package com.example.test;

import android.app.Application;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {HistoryCard.class}, version = 1, exportSchema = false)
public abstract class CardDatabase extends RoomDatabase {

				private static CardDatabase instance = null;
				private static final String DB_NAME = "history.db";

				public static CardDatabase getInstance(Application application) {
								if(instance == null) {
												instance = Room.databaseBuilder(
																application,
																CardDatabase.class,
																DB_NAME
												).build();
								}
								return instance;
				}

				public abstract HistoryDao historyDao();
}
