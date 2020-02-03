package com.hsieh.xiangzhui.ui;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hsieh.xiangzhui.Bean.Community;
import com.hsieh.xiangzhui.R;
import com.hsieh.xiangzhui.adapter.CommunityAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CommunityFragment extends Fragment {

    private List<Community> communityList = new ArrayList<>();


    public CommunityFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_community, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.community_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        initList();
        CommunityAdapter adapter = new CommunityAdapter(communityList);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    private void initList() {
        for (int i = 0; i < 10; i++) {
            Community community1 = new Community(R.mipmap.avatar,
                    "啊呜软",
                    "4:05pm",
                    getResources().getString(R.string.community_content1));
            communityList.add(community1);
        }
    }

}
