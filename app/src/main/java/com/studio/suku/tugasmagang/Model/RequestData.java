package com.studio.suku.tugasmagang.Model;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RequestData {

    //Disini sebuah interface
    //Biasanya digunakan jika ada query
    //Ataupun Header yang mau dikirim

    @GET("Gallery_Malang_Batu.json")
    Call<ResultData> getAllData();

}
