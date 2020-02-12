package fr.isima.gudaniel1.pam2020;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListViewModel extends ViewModel {

    private MutableLiveData<List<Comic>> comics;

    public LiveData<List<Comic>> getComics(){
        if (comics == null){

            comics = new MutableLiveData<List<Comic>>();
            makeCall();
        }
        return comics;
    }

    private void makeCall() {

        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl("https://api.myjson.com/");
        builder.addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();
        XKCDApi api = retrofit.create(XKCDApi.class);
        Call<List<Comic>> call = api.getLastComic();
        call.enqueue(new Callback<List<Comic>>() {
            @Override
            public void onResponse(Call<List<Comic>> call, Response<List<Comic>> response) {

                comics.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Comic>> call, Throwable t) {

            }
        });
    }


}
