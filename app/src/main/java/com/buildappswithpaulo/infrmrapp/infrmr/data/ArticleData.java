package com.buildappswithpaulo.infrmrapp.infrmr.data;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.buildappswithpaulo.infrmrapp.infrmr.controller.AppController;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ArticleData {

    private ArrayList<Article> articles = new ArrayList<>();

    public void getNewsList() {
        String url = "https://newsapi.org/v2/top-headlines?sources=the-next-web&apiKey=c9ac2b7374144becab34b6a729e87f65";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray articleArray = response.getJSONArray("articles");
                    for (int i = 0; i < articleArray.length(); i++) {
                        JSONObject articleObject = articleArray.getJSONObject(i);

                        Article article = new Article();
                        article.setAuthor(articleObject.getString("author"));
                        article.setTitle(articleObject.getString("title"));
                        article.setDescription(articleObject.getString("description"));
                        article.setImageUrl(articleObject.getString("urlToImage"));
                        article.setPublishedDate(articleObject.getString("publishedAt"));
                        article.setNewsUrl(articleObject.getString("url"));

                        articles.add(article);
                    }
                    Log.v("Articles Object", articles.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        AppController.getInstance().addToRequestQueue(jsonObjectRequest);
    }

}
