package com.hsieh.xiangzhui.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hsieh.xiangzhui.bean.Mural;
import com.hsieh.xiangzhui.R;
import com.hsieh.xiangzhui.adapter.MuralAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class DutifulFragment extends Fragment {

    private List<Mural> muralList = new ArrayList<>();
    public DutifulFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dutiful, container, false);
        initMurals();
        RecyclerView dutifulList = view.findViewById(R.id.dutifulList);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        dutifulList.setLayoutManager(layoutManager);
        MuralAdapter adapter = new MuralAdapter(muralList);
        dutifulList.setAdapter(adapter);
        return view;
    }

    private void initMurals(){
        for (int i = 0;i<2;i++){
            Mural mural1 = new Mural(R.mipmap.img2,"中国梦","山水、花鸟、自然", (float) 4.5,2510,1210);
            muralList.add(mural1);
            Mural mural2 = new Mural(R.mipmap.img3,"讲文明树新风", "花鸟、孩童", (float)4.9,2460,1200);
            muralList.add(mural2);
            Mural mural3 = new Mural(R.mipmap.img4,"文明乡风", "房屋、文化",(float)4.7,2830,1460);
            muralList.add(mural3);
            Mural mural4 = new Mural(R.mipmap.img5, "传统文化","龙舟、文化、信仰", (float)5.0,2220,1530);
            muralList.add(mural4);
        }

    }
}
