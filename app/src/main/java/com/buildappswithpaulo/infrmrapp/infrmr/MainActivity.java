package com.buildappswithpaulo.infrmrapp.infrmr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.buildappswithpaulo.infrmrapp.infrmr.data.Article;
import com.buildappswithpaulo.infrmrapp.infrmr.data.ArticleAdapter;
import com.buildappswithpaulo.infrmrapp.infrmr.data.ArticleData;
import com.buildappswithpaulo.infrmrapp.infrmr.data.ArticleListAsyncResponse;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArticleAdapter articleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new ArticleData().getNewsList(new ArticleListAsyncResponse() {
            @Override
            public void processFinish(ArrayList<Article> articles) {
                recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
                articleAdapter = new ArticleAdapter(articles, getApplicationContext());

                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                recyclerView.setAdapter(articleAdapter);
            }
        });
    }
}
