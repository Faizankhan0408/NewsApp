package com.faizanfirstproject.newsnow.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.faizanfirstproject.newsnow.Model.ModelClass;
import com.faizanfirstproject.newsnow.R;
import com.faizanfirstproject.newsnow.webView;

import java.util.ArrayList;

public class MyRecycleViewAdapter extends RecyclerView.Adapter<MyRecycleViewAdapter.ViewHolder> {
    private Context context;
    private ArrayList<ModelClass> articles;

    public MyRecycleViewAdapter(Context context, ArrayList<ModelClass> articles) {
        this.context = context;
        this.articles = articles;
    }

    @NonNull
    @Override
    public MyRecycleViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecycleViewAdapter.ViewHolder holder, int position) {

      holder.mTime.setText("Published At: "+articles.get(position).getPublishedAt());
      holder.mAuthor.setText(articles.get(position).getAuthor());
      holder.mContent.setText(articles.get(position).getDescription());
      holder.mHeading.setText(articles.get(position).getTitle());
        Glide.with(context).load(articles.get(position).getUrlToImage()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView mHeading,mAuthor,mContent,mTime;
        CardView cardView;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mHeading=itemView.findViewById(R.id.mainheading);
            mContent=itemView.findViewById(R.id.content);
            mAuthor=itemView.findViewById(R.id.author);
            mTime=itemView.findViewById(R.id.time);
            imageView=itemView.findViewById(R.id.imageview);
            cardView=itemView.findViewById(R.id.cardview);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent=new Intent(context, webView.class);
              intent.putExtra("url",articles.get(getAbsoluteAdapterPosition()).getUrl());
              context.startActivity(intent);
        }
    }
}
