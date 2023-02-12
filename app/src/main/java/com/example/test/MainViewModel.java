package com.example.test;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;
import java.util.Map;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainViewModel extends AndroidViewModel {

    private static final String TAG = "MainViewModel";

    private final MutableLiveData<Map<String, String>> cards = new MutableLiveData<>();
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();

    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Map<String, String>> getCards() {
        return cards;
    }

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

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.dispose();
    }
}
