package com.hsieh.xiangzhui.ui;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hsieh.xiangzhui.bean.Community;
import com.hsieh.xiangzhui.R;
import com.hsieh.xiangzhui.adapter.CommunityAdapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日");
        String time = sdf.format(c.getTime());
        for (int i = 0; i<3;i++){
            Community c1 = new Community(R.mipmap.img_avatar_default,"张大爷", time + " 14:21",getString(R.string.news1));
            Community c2 = new Community(R.mipmap.img_avatar_default,"王大爷",time+" 14:36",getString(R.string.news2));
            Community c3 = new Community(R.mipmap.paddy,"赵大妈",time + " 14:29",getString(R.string.news3));
            Community c4 = new Community(R.mipmap.img_avatar_default,"张大爷",time+" 14:24",getString(R.string.news4));
            Community c5 = new Community(R.mipmap.mountain,"大力村李书记",time+" 14:38",getString(R.string.news5));
            Community c6 = new Community(R.mipmap.tea,"长胜村朱村长",time+" 14:17",getString(R.string.news6));
            Community c7 = new Community(R.mipmap.boat,"三港村陆女士",time+" 14:12",getString(R.string.news7));
            Community c8 = new Community(R.mipmap.tree,"解放村阮先生",time+" 14:01",getString(R.string.news8));
            communityList.add(c5);
            communityList.add(c2);
            communityList.add(c3);
            communityList.add(c4);
            communityList.add(c1);
            communityList.add(c6);
            communityList.add(c7);
            communityList.add(c8);
        }
    }

}
