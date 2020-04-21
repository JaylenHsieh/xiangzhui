package com.hsieh.xiangzhui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hsieh.xiangzhui.Bean.Classification;
import com.hsieh.xiangzhui.R;

import java.util.List;

public class ClassificationAdapter extends RecyclerView.Adapter<ClassificationAdapter.ViewHolder> {
    private List<Classification> mClassificationList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView classificationImg;

        public ViewHolder(View view){
            super(view);
            classificationImg = view.findViewById(R.id.classificationImg);
        }
    }

    public ClassificationAdapter(List<Classification> classificationList){
        mClassificationList = classificationList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_classification,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Classification classification = mClassificationList.get(position);
        holder.classificationImg.setImageResource(classification.getImageId());
    }

    @Override
    public int getItemCount() {
        return mClassificationList.size();
    }
}
