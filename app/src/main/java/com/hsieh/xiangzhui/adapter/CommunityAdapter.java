package com.hsieh.xiangzhui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;
import com.hsieh.xiangzhui.Bean.Community;
import com.hsieh.xiangzhui.R;

import java.util.List;

public class CommunityAdapter extends RecyclerView.Adapter<CommunityAdapter.ViewHolder> {

    private List<Community> mCommunityList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        View communityView;
        ImageView avatar;
        MaterialTextView userName;
        MaterialTextView time;
        MaterialTextView content;

        public ViewHolder(View view){
            super(view);
            communityView = view;
            avatar = view.findViewById(R.id.avatar);
            userName = view.findViewById(R.id.userName);
            time = view.findViewById(R.id.time);
            content = view.findViewById(R.id.content);
        }
    }

    public CommunityAdapter (List<Community> communityList){
        mCommunityList = communityList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_community,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Community community = mCommunityList.get(position);
        holder.avatar.setImageResource(community.getImgId());
        holder.userName.setText(community.getName());
        holder.time.setText(community.getTime());
        holder.content.setText(community.getContent());
    }

    @Override
    public int getItemCount() {
        return mCommunityList.size();
    }
}
