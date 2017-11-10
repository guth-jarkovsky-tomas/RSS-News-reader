package com.example.recyclerview.RecyclerViewStuff;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.recyclerview.ActivityDetail;
import com.example.recyclerview.R;

import java.util.ArrayList;

/**
 * Created by TOMAS on 9.10.2017.
 */

public class FeedItemAdapter extends RecyclerView.Adapter<FeedItemViewHolder> {

    private ArrayList<FeedItem> mDataset;
    public FeedItemAdapter(ArrayList<FeedItem> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public FeedItemViewHolder onCreateViewHolder(ViewGroup parent,int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.feeditem_recycler_view, parent, false);
        return new FeedItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(FeedItemViewHolder holder, int position) {

        final FeedItem feedItem = mDataset.get(position);
        holder.txtview_src.setText(feedItem.getSource());
        holder.txtview_title.setText(feedItem.getTitle());
        holder.txtview_desc.setText(feedItem.getDescription());
        holder.txtview_url.setText(feedItem.getURL());
        String url = mDataset.get(position).getImgURL();
        Glide.with(holder.img_view.getContext())
                .load(url)
                .into(holder.img_view);

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityDetail.starter(feedItem.getURL(),v.getContext());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}