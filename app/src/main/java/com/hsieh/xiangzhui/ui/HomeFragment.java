package com.hsieh.xiangzhui.ui;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.hsieh.xiangzhui.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        TabLayout tabLayout = view.findViewById(R.id.home_tabs);
        ViewPager2 viewPager = view.findViewById(R.id.home_viewpager);
        viewPager.setAdapter(new FragmentStateAdapter(this) {
            @NonNull
            @Override
            public Fragment createFragment(int position) {
                switch (position){
                    case 1:
                        return new OvercomePovertyFragment();
                    case 2:
                        return new RuralCivilizationFragment();
                    case 3:
                        return new DutifulFragment();
                    case 4:
                        return new NewSpiritFragment();
                    default:
                        return new RecommendFragment();
                }
            }

            @Override
            public int getItemCount() {
                return 5;
            }
        });

        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position){
                    case 0:
                        tab.setText(getContext().getString(R.string.recommend));
                        break;
                    case 1:
                        tab.setText(getContext().getString(R.string.poverty_alleviation));
                        break;
                    case 2:
                        tab.setText(getContext().getString(R.string.rural_civilization));
                        break;
                    case 3:
                        tab.setText(getContext().getString(R.string.filial_piety));
                        break;
                    case 4:
                        tab.setText(getContext().getString(R.string.new_trends));
                        break;
                }
            }
        });
        tabLayoutMediator.attach();

        return view;
    }

}
