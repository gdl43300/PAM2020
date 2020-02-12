package fr.isima.gudaniel1.pam2020;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface XKCDApi {

    @GET("bins/16fnc2")
    Call<List<Comic>> getLastComic();
}
