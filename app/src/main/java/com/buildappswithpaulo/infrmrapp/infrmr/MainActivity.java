package com.buildappswithpaulo.infrmrapp.infrmr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.buildappswithpaulo.infrmrapp.infrmr.data.ArticleData;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new ArticleData().getNewsList();
    }
}
