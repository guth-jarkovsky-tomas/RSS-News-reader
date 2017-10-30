package com.example.recyclerview.RecyclerViewStuff;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.recyclerview.R;

/**
 * Created by TOMAS on 13.10.2017.
 */

class FeedItemViewHolder extends RecyclerView.ViewHolder {
    // each data item is just a string in this case
    TextView txtview_src;
    TextView txtview_title;
    TextView txtview_desc;
    TextView txtview_url;
    ImageView img_view;

    FeedItemViewHolder(View v) {
        super(v);
        txtview_src = (TextView) v.findViewById(R.id.txt_src);
        txtview_title = (TextView) v.findViewById(R.id.txt_title);
        txtview_desc = (TextView) v.findViewById(R.id.txt_description);
        txtview_url = (TextView) v.findViewById(R.id.txt_url);
        img_view = (ImageView) v.findViewById(R.id.img);

    }
}