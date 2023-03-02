package com.example.test;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "history")
public class HistoryCard {

				@PrimaryKey
				@NonNull
				private String bin;
				private String type;
				private String scheme;
				private String bankName;
				private String timeStamp;

				public HistoryCard(
								@NonNull String bin,
								String type,
								String scheme,
								String bankName,
								String timeStamp
				) {
								this.bin = bin;
								this.type = type;
								this.scheme = scheme;
								this.bankName = bankName;
								this.timeStamp = timeStamp;
				}

				@NonNull
				public String getBin() {
								return bin;
				}

				public String getType() {
								return type;
				}

				public String getScheme() {
								return scheme;
				}

				public String getBankName() {
								return bankName;
				}

				public String getTimeStamp() {
								return timeStamp;
				}

				@Override
				public String toString() {
								return "HistoryCard{" +
												"bin='" + bin + '\'' +
												", type='" + type + '\'' +
												", scheme='" + scheme + '\'' +
												", bankName=" + bankName +
												", timeStamp='" + timeStamp + '\'' +
												'}';
				}

}
