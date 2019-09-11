package com.studio.suku.tugasmagang.ViewModel;

import android.util.Log;

import com.studio.suku.tugasmagang.Model.RequestData;
import com.studio.suku.tugasmagang.Model.ResultData;

import java.util.List;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ViewModelData extends ViewModel  {

    private static final String BASE_URL = "https://info-malang-batu.firebaseapp.com/";
    private MutableLiveData<List<ResultData>> liveData;

    public MutableLiveData<List<ResultData>> getAllData(){
        //Check dulu MutableLiveData nya
        if (liveData == null){
            liveData = new MutableLiveData<List<ResultData>>();
            setLiveData();
        }
        return liveData;
    }
    private void setLiveData(){
        //Make a request here
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RequestData requestData = retrofit.create(RequestData.class);
        Call<List<ResultData>> call =requestData.getAllData();
        call.enqueue(new Callback<List<ResultData>>() {
            @Override
            public void onResponse(Call<List<ResultData>> call, Response<List<ResultData>> response) {
                Log.d("Datanya", response.body().get(0).getCaption());
                liveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<ResultData>> call, Throwable t) {
                Log.e("Ada Error", t.getMessage());
            }
        });

    }

}
