package com.studio.suku.tugasmagang;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.studio.suku.tugasmagang.Adapter.listAdapter;
import com.studio.suku.tugasmagang.Model.ResultData;
import com.studio.suku.tugasmagang.ViewModel.ViewModelData;

import java.security.AccessController;
import java.util.ArrayList;
import java.util.List;

import static androidx.lifecycle.ViewModelProviders.*;

public class MainActivity extends AppCompatActivity {

    RecyclerView listItem;
    private final List<ResultData> beanList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listItem = findViewById(R.id.list_item);
        listItem.setHasFixedSize(true);
        listItem.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
        ViewModelData model = ViewModelProviders.of(this).get(ViewModelData.class);
        model.getAllData().observe(this, new Observer<ResultData>() {
            @Override
            public void onChanged(ResultData resultData) {
                beanList.add(resultData);
                if (beanList.get(0) == null){
                    Log.d("Datanya", "Kosong");
                }
                else{
                    Log.d("Datanya", "Ada");
                    listItem.setAdapter(new listAdapter(getBaseContext(), (List<ResultData>) beanList.get(0)));
                }
            }
        });

    }
}
