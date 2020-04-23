package com.hsieh.xiangzhui.ui;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hsieh.xiangzhui.bean.Classification;
import com.hsieh.xiangzhui.R;
import com.hsieh.xiangzhui.adapter.ClassificationAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CivilizedVillageFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class CivilizedVillageFragment extends Fragment {

    private List<Classification> mChinaDreamList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_civilized_village, container, false);
        initList();
        RecyclerView civilizationVillageList = view.findViewById(R.id.civilizationVillageList);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        ClassificationAdapter adapter = new ClassificationAdapter(mChinaDreamList);
        civilizationVillageList.setLayoutManager(layoutManager);
        civilizationVillageList.setAdapter(adapter);
        return view;
    }


    private void initList() {
        for (int i = 0; i < 2; i++){
            Classification pic1 = new Classification(R.mipmap.img5);
            Classification pic2 = new Classification(R.mipmap.img6);
            Classification pic3 = new Classification(R.mipmap.img7);
            Classification pic4 = new Classification(R.mipmap.img8);
            Classification pic5 = new Classification(R.mipmap.img9);
            Classification pic6 = new Classification(R.mipmap.img10);
            Classification pic7 = new Classification(R.mipmap.img11);
            Classification pic8 = new Classification(R.mipmap.img12);
            Classification pic9 = new Classification(R.mipmap.img13);
            mChinaDreamList.add(pic1);
            mChinaDreamList.add(pic8);
            mChinaDreamList.add(pic3);
            mChinaDreamList.add(pic4);
            mChinaDreamList.add(pic5);
            mChinaDreamList.add(pic6);
            mChinaDreamList.add(pic7);
            mChinaDreamList.add(pic2);
            mChinaDreamList.add(pic9);
        }
    }
}
