package com.studio.suku.tugasmagang.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.studio.suku.tugasmagang.Model.ResultData;
import com.studio.suku.tugasmagang.R;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_DATA = "Extra Data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ResultData resultData = getIntent().getParcelableExtra(EXTRA_DATA);
        ImageView imageView = findViewById(R.id.img_detail);
        TextView textView = findViewById(R.id.txt_detail);
        Picasso.get().load(resultData.getImage()).into(imageView);
        textView.setText(resultData.getCaption());
    }
}
