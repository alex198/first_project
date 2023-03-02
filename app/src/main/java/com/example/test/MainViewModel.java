package com.example.test;

import android.annotation.SuppressLint;
import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainViewModel extends AndroidViewModel {

    private static final String TAG = "MainViewModel";

<<<<<<< Updated upstream
    private final MutableLiveData<Map<String, String>> cards = new MutableLiveData<>();
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();
=======
				private final MutableLiveData<Map<String, String>> cards = new MutableLiveData<>();
				private final CompositeDisposable compositeDisposable = new CompositeDisposable();
				private final HistoryDao historyDao = CardDatabase.getInstance(getApplication()).historyDao();
>>>>>>> Stashed changes

    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Map<String, String>> getCards() {
        return cards;
    }

<<<<<<< Updated upstream
    public void loadCardInfo(String bin) {
        Disposable disposable = ApiFactory.apiService.loadCardInfo(bin)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Consumer<CardInfo>() {
                           @Override
                           public void accept(CardInfo cardInfo) throws Throwable {
                               cards.setValue(new MapConverter().convertToMap(cardInfo));
                           }
                       }, new Consumer<Throwable>() {
                           @Override
                           public void accept(Throwable throwable) throws Throwable {
                               Log.d(TAG, throwable.toString());
                           }
                       }
            );
        compositeDisposable.add(disposable);
    }
=======
				public void loadCardInfo(String bin) {
								Disposable disposable = ApiFactory.apiService.loadCardInfo(bin)
												.subscribeOn(Schedulers.io())
												.doOnSuccess(new Consumer<CardInfo>() {
																@Override
																public void accept(CardInfo cardInfo) throws Throwable {
																				Date date = new Date();
																				SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
																				HistoryCard historyCard = new ConverterToHistoryCard().convertToHistoryCard(
																								bin,
																								cardInfo,
																								sdf.format(date)
																				);
																				historyDao.add(historyCard);
																}
												})
												.observeOn(AndroidSchedulers.mainThread())
												.subscribe(new Consumer<CardInfo>() {
																           @Override
																           public void accept(CardInfo cardInfo) throws Throwable {
																				           cards.setValue(new MapConverter().convertToMap(cardInfo));
																           }
												           }, new Consumer<Throwable>() {
																           @Override
																           public void accept(Throwable throwable) throws Throwable {
																				           Log.d(TAG, throwable.toString());
																           }
												           }
												);
								compositeDisposable.add(disposable);
				}
>>>>>>> Stashed changes

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.dispose();
    }

}
