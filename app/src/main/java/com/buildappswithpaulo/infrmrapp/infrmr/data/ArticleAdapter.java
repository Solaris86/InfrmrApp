package com.buildappswithpaulo.infrmrapp.infrmr.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.buildappswithpaulo.infrmrapp.infrmr.R;
import com.buildappswithpaulo.infrmrapp.infrmr.util.Util;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder> {

    private ArrayList<Article> articles = new ArrayList<>();
    private Context context;
    private OnItemClickListener onItemClickListener;

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
    public void onBindViewHolder(final ArticleAdapter.ViewHolder holder, int position) {
        Article article = (Article) articles.get(position);

        holder.author.setText(article.getAuthor());
        holder.title.setText(article.getTitle());
        holder.description.setText(article.getDescription());
        holder.date.setText(Util.dateFormatted(article.getPublishedDate()));

        BitmapDrawable bitmapDrawable = (BitmapDrawable) holder.articleImage.getDrawable();
        Bitmap photo = bitmapDrawable.getBitmap();
        Palette.from(photo).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                int bgColor = palette.getMutedColor(ContextCompat.getColor(context, android.R.color.black));
                holder.date.setBackgroundColor(bgColor);
                holder.author.setTextColor(bgColor);
            }
        });

        Picasso.with(context).load(article.getImageUrl()).into(holder.articleImage);
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView articleImage;
        public TextView author, title, description, date;

        public ViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            articleImage = itemView.findViewById(R.id.newsImageId);
            author = itemView.findViewById(R.id.author);
            title = itemView.findViewById(R.id.newsTitle);
            description = itemView.findViewById(R.id.descriptionNews);
            date = itemView.findViewById(R.id.date);
        }

        @Override
        public void onClick(View v) {
            onItemClickListener.onItemClick(v, getAdapterPosition());
        }
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }
}
