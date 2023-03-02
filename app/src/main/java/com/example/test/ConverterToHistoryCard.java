package com.example.test;

public class ConverterToHistoryCard {

				public HistoryCard convertToHistoryCard(String bin, CardInfo card, String timeStamp) {
								HistoryCard historyCard = new HistoryCard(
												bin,
												"type: " + card.getType(),
												"scheme: " + card.getScheme(),
												"bank: " + card.getBankInfo().getBankName(),
												timeStamp
								);
								return historyCard;
				}
}
