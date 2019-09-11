package com.studio.suku.tugasmagang;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.studio.suku.tugasmagang.Adapter.listAdapter;
import com.studio.suku.tugasmagang.Model.ResultData;
import com.studio.suku.tugasmagang.ViewModel.ViewModelData;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView listItem;
    private final List<ResultData> beanList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listItem = findViewById(R.id.list_item);
        listItem.setHasFixedSize(true);
        listItem.setLayoutManager(new GridLayoutManager(this, 2));
        ViewModelData model = ViewModelProviders.of(this).get(ViewModelData.class);
        model.getAllData().observe(this, new Observer<List<ResultData>>() {
            @Override
            public void onChanged(List<ResultData> resultData) {
                listItem.setAdapter(new listAdapter(getBaseContext(), resultData));
            }
        });
    }


}
