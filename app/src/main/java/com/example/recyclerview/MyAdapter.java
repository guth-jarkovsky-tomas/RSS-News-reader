package com.example.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(FeedItemViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.txtview_title.setText(mDataset.get(position).getTitle());
        holder.txtview_desc.setText(mDataset.get(position).getDescription());
        holder.txtview_url.setText(mDataset.get(position).getURL());
        holder.img_view.setImageResource(R.mipmap.ic_launcher);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}