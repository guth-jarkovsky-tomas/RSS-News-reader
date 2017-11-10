package com.example.recyclerview.RecyclerViewStuff;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

import com.example.recyclerview.R;

/**
 * Created by TOMAS on 6.11.2017.
 */

class SourceChoiceItemViewHolder extends RecyclerView.ViewHolder{

    TextView txtview_name;
    Switch swch_allowed;

    SourceChoiceItemViewHolder(View v) {
        super(v);
        txtview_name = v.findViewById(R.id.txt_name);
        swch_allowed = v.findViewById(R.id.swch_allow);
    }
}
