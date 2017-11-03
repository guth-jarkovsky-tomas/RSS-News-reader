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

    TextView txtview_src;
    TextView txtview_title;
    TextView txtview_desc;
    TextView txtview_url;
    ImageView img_view;
    View view;

    FeedItemViewHolder(View v) {
        super(v);
        txtview_src = v.findViewById(R.id.txt_src);
        txtview_title = v.findViewById(R.id.txt_title);
        txtview_desc = v.findViewById(R.id.txt_description);
        txtview_url = v.findViewById(R.id.txt_url);
        img_view = v.findViewById(R.id.img);
        view = v;
    }
}