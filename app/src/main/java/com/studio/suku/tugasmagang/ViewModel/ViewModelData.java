package com.studio.suku.tugasmagang.ViewModel;

import android.util.Log;

import com.studio.suku.tugasmagang.Model.RequestData;
import com.studio.suku.tugasmagang.Model.ResultData;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ViewModelData extends ViewModel  {

    private static final String BASE_URL = "https://info-malang-batu.firebaseapp.com";
    private static MutableLiveData<ResultData> data;

    public LiveData<ResultData> getAllData(){
        //Check dulu MutableLiveData nya
        if (data == null){
            data = new MutableLiveData<ResultData>();
            setLiveData();
        }
        return data;
    }

    private static void setLiveData(){
        //Make a request here
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RequestData requestData = retrofit.create(RequestData.class);
        Call<ResultData>call =requestData.getAllData();

        call.enqueue(new Callback<ResultData>() {
            @Override
            public void onResponse(Call<ResultData> call, Response<ResultData> response) {
                data.setValue(response.body());
                Log.d("Datanya", response.body().getCaption());
            }

            @Override
            public void onFailure(Call<ResultData> call, Throwable t) {
                Log.d("Ada Error", t.getMessage());
            }
        });
    }

}
