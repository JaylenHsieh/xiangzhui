package com.hsieh.xiangzhui.adapter;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hsieh.xiangzhui.bean.Mural;
import com.hsieh.xiangzhui.R;
import com.hsieh.xiangzhui.ui.MuralDetailActivity;

import java.util.List;

public class MuralAdapter extends RecyclerView.Adapter<MuralAdapter.ViewHolder> {

    private List<Mural> mMuralList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView muralImage;
        TextView muralName;
        TextView muralClass;
        RatingBar muralScore;

        ViewHolder(View view){
            super(view);
            muralImage = view.findViewById(R.id.muralImg);
            muralName = view.findViewById(R.id.muralName);
            muralClass = view.findViewById(R.id.muralClass);
            muralScore = view.findViewById(R.id.muralScore);
        }
    }

    public MuralAdapter(List<Mural> muralList){
        mMuralList = muralList;
    }

    @NonNull
    @Override
    public MuralAdapter.ViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_mural, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Mural mural = mMuralList.get(position);
                Intent intent = new Intent(parent.getContext(), MuralDetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("mural_image",mural.getImageId());
                bundle.putString("mural_theme",mural.getMuralTheme());
                bundle.putString("mural_class",mural.getMuralClass());
                bundle.putFloat("mural_score", (float) mural.getMuralScore());
                bundle.putInt("mural_length", mural.getMuralLength());
                bundle.putInt("mural_width", mural.getMuralWidth());
                intent.putExtras(bundle);
                parent.getContext().startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Mural mural = mMuralList.get(position);
        holder.muralImage.setImageResource(mural.getImageId());
        holder.muralName.setText(mural.getMuralTheme());
        holder.muralClass.setText(mural.getMuralClass());
        holder.muralScore.setRating((float) mural.getMuralScore());
    }

    @Override
    public int getItemCount() {
        return mMuralList.size();
    }
}
