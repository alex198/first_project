package com.example.test;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    @GET("{inputBin}")
    Single<CardInfo> loadCardInfo(@Path("inputBin") int inputBin);
}
