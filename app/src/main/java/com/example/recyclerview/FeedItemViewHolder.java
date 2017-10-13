package com.example.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by TOMAS on 13.10.2017.
 */

public class FeedItemViewHolder extends RecyclerView.ViewHolder {
    // each data item is just a string in this case
    public TextView txtview_title;
    public TextView txtview_desc;
    public TextView txtview_url;
    public ImageView img_view;

    public FeedItemViewHolder(View v) {
        super(v);
        txtview_title = (TextView) v.findViewById(R.id.txt_title);
        txtview_desc = (TextView) v.findViewById(R.id.txt_description);
        txtview_url = (TextView) v.findViewById(R.id.txt_url);
        img_view = (ImageView) v.findViewById(R.id.img);
    }
}