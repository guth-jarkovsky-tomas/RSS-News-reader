package com.example.recyclerview.RecyclerViewStuff;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.recyclerview.R;

import java.util.ArrayList;

/**
 * Created by TOMAS on 6.11.2017.
 */

public class SourceChoiceAdapter extends RecyclerView.Adapter<SourceChoiceItemViewHolder> {

    private ArrayList<SourceChoiceItem> mDataset;

    public SourceChoiceAdapter(ArrayList<SourceChoiceItem> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public SourceChoiceItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.sourcechoice_recycler_view, parent, false);
        return new SourceChoiceItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(SourceChoiceItemViewHolder holder, int position) {

        if(holder == null) {return;}
        final SourceChoiceItem sourceItem = mDataset.get(position);
        holder.txtview_name.setText(sourceItem.getName());
        holder.swch_allowed.setChecked(sourceItem.getAllowed());
        holder.swch_allowed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sourceItem.setAllowed(!sourceItem.getAllowed());
            }
        });

    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}