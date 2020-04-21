package com.hsieh.xiangzhui.ui;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.hsieh.xiangzhui.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager2 viewPager;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        tabLayout = view.findViewById(R.id.home_tabs);
        viewPager = view.findViewById(R.id.home_viewpager);
        viewPager.setAdapter(new FragmentStateAdapter() {
            @NonNull
            @Override
            public Fragment createFragment(int position) {
                switch (position){
                    case 0:
                        return new RecommendFragment();
                        break;
                    case 1:
                        return new OvercomePovertyFragment();
                        break;
                    case 2:
                        return new RuralCivilizationFragment();
                        break;
                    case 3:
                        return new DutifulFragment();
                        break;
                    case 4:
                        return new NewSpiritFragment();
                        break;
                }
            }

            @Override
            public int getItemCount() {
                return 5;
            }
        });
        return view;
    }

}
