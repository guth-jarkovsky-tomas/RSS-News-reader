package com.example.recyclerview.RecyclerViewStuff;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.recyclerview.R;

import java.util.ArrayList;

/**
 * Created by TOMAS on 9.10.2017.
 */

public class MyAdapter extends RecyclerView.Adapter<FeedItemViewHolder> {

    private ArrayList<FeedItem> mDataset;
    public MyAdapter(ArrayList<FeedItem> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public FeedItemViewHolder onCreateViewHolder(ViewGroup parent,int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.inside_recycler_view, parent, false);
        FeedItemViewHolder vh = new FeedItemViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(FeedItemViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        FeedItem feedItem = mDataset.get(position);
        holder.txtview_src.setText(feedItem.getSource());
        holder.txtview_title.setText(feedItem.getTitle());
        holder.txtview_desc.setText(feedItem.getDescription());
        holder.txtview_url.setText(feedItem.getURL());
        String url = mDataset.get(position).getImgURL();
        Glide.with(holder.img_view.getContext())
                .load(url)
                .into(holder.img_view);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}