package com.buildappswithpaulo.infrmrapp.infrmr.data;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.buildappswithpaulo.infrmrapp.infrmr.R;

import java.util.ArrayList;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder> {

    private ArrayList<Article> articles = new ArrayList<>();
    private Context context;

    public ArticleAdapter(ArrayList<Article> articles, Context context) {
        this.articles = articles;
        this.context = context;
    }

    @Override
    public ArticleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View articleRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_row, parent, false);
        return new ViewHolder(articleRow);
    }

    @Override
    public void onBindViewHolder(ArticleAdapter.ViewHolder holder, int position) {
        Article article = (Article) articles.get(position);

        holder.author.setText(article.getAuthor());
        holder.title.setText(article.getTitle());
        holder.description.setText(article.getDescription());
        holder.date.setText(article.getPublishedDate());
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView articleImage;
        public TextView author, title, description, date;

        public ViewHolder(View itemView) {
            super(itemView);

            articleImage = itemView.findViewById(R.id.newsImageId);
            author = itemView.findViewById(R.id.author);
            title = itemView.findViewById(R.id.newsTitle);
            description = itemView.findViewById(R.id.descriptionNews);
            date = itemView.findViewById(R.id.date);
        }
    }
}
