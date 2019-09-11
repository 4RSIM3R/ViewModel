package com.studio.suku.tugasmagang.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResultData implements Parcelable {


    /**
     * caption : Zona Infinite World di Jatim Park 3
     * thumbnail : https://lh3.googleusercontent.com/zy_WHEEo0voNwh0MO-gym4h60R3MqZ3-0U_h1CpNxXozaDISsfVLmMnyQ8--UD9Qwbu2XuJT-IWusv3TS4kg8rSTUFhM1IhFoNph6yYcNJy0E_M4zuvlWJzNXcugkpplI4qkCgWC3REEBD68ka_zYoP2XzRlREgK56iehIBvop3nxc0i2LaLhO83qi5zis2GQsVP5ajAESVXxj5ssU1yTm1lbfPyL45ceQk6liBFp4_8ZngFDTmfysB288r8jbvjCnWjYzr5_aJIs7HeSbCs15VBAg2N4o4Xbc4ztwjfSGdoJ7YJfQ2F0UL2Q7IiXCLmG6sgdm8AcKJideHXivze53wYUdl8tlB-LOKJFYvN5QECY-iGg76wBI-VIiQpvrqH7HLBixAnoAUOVwxKLTcqMK8Z3-TZ5cbnaL_4IjMek0iX_VTkIN3kGjhHcriC1yQtO-0QdVnutiWflpM6aDs3GPP66tRWUERihV4ogDKxhnFVx8aBWn_D2iBwiO8V2rXg54y6O0lBZGtXU3-QBwjLUBwi_rywJlu6FT5pAexq5jbvi_Uk_7p2kF24oRepR3jQ1XvyNn4wY7sdQqPWga7XximckILE6RIQaSSALhLO0l_9GD9wrXDWSlaVmWPzz1IxB0RDJhUDaz0vzKZtIG4Ds8yT89JAVSk=s250-no
     * image : https://lh3.googleusercontent.com/dW9YPpwziNIVhrxwJ7hMVJg2t1BUbx-33inyqljfEW_GvZFbniFX07n6YcOi9FZvhaU2ZUt-AW1NRsdk3YRw6Uj6Qqk0giNmSfTbZ0IhILDTPxxa9XAA3K9ba9ncvKH2U_CRA7Vl9VzKylD0RinJJElQtHLtXAIFHBlCZC5m9yDnBKztF7OWfexQvS-perMGvqgZy1j6V3_Q_b3lsZUNIHsQDFvvxK9U3kF1c52MqJaR-0RboiFfohpfYV9VgegvLM9TXkNtM4gl3TP1ZtyXizJe7AtQVUloZSAfN5FN9oSiveIDPQX_QG0tEGD66N5tt4bsm-VHxZNyyHAj1tfm40tr2frGFElOoBLDEk6-l-JhOKNckBc9zaMEi1sE6Mw-o91DWY3p2wxqg6ygtdHHwhkl7ya-oUG5BZ8tG7NJjC6XyB45dSdG7QaiK1f1L_pew3ZPKx5WXGPW2pBA_Z37xFiwaPpIDVR628VOXgs3FB-9qAnr3hS_czWTf4Kz0GBQ8FGkfj5oW67XHPzicJJ9gmGHYuWJmanP2TirbP6MqGQ4kKAnAGi5VRkAmR0vmIOJpJYAvgmxbBfG-_MzoIyUBrjCsN07e-ZJFp3Vy22NWXBhKc1wNdLRuU78aTs8gVULOLW8l_8oqLjrstdQcBMsVmE_BgRVtcA=w855-h641-no
     */

    @SerializedName("caption")
    @Expose
    private String caption;
    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;
    @SerializedName("image")
    @Expose
    private String image;

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.caption);
        dest.writeString(this.thumbnail);
        dest.writeString(this.image);
    }

    public ResultData() {
    }

    private ResultData(Parcel in) {
        this.caption = in.readString();
        this.thumbnail = in.readString();
        this.image = in.readString();
    }

    public static final Parcelable.Creator<ResultData> CREATOR = new Parcelable.Creator<ResultData>() {
        @Override
        public ResultData createFromParcel(Parcel source) {
            return new ResultData(source);
        }

        @Override
        public ResultData[] newArray(int size) {
            return new ResultData[size];
        }
    };
}
