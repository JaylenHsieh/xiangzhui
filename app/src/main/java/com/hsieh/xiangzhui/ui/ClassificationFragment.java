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
import com.google.android.material.tabs.TabLayoutMediator;
import com.hsieh.xiangzhui.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ClassificationFragment extends Fragment {

    public ClassificationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_classification, container, false);
        TabLayout tabLayout = view.findViewById(R.id.classification_tabs);
        ViewPager2 viewPager = view.findViewById(R.id.classification_viewpager);
        viewPager.setAdapter(new FragmentStateAdapter(this) {
            @NonNull
            @Override
            public Fragment createFragment(int position) {
                switch (position){
                    case 1:
                        return new CivilizedVillageFragment();
                    case 2:
                        return new NationalUnityFragment();
                    case 3:
                        return new TheTrueFragment();
                    case 4:
                        return new RemainTrueFragment();
                    default:
                        return new ChinaDreamFragment();
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
                        tab.setText(getContext().getString(R.string.china_dream));
                        break;
                    case 1:
                        tab.setText(getContext().getString(R.string.civilize_village));
                        break;
                    case 2:
                        tab.setText(getContext().getString(R.string.national_unity));
                        break;
                    case 3:
                        tab.setText(getContext().getString(R.string.the_true));
                        break;
                    case 4:
                        tab.setText(getContext().getString(R.string.remain_true));
                        break;
                }
            }
        });
        tabLayoutMediator.attach();
        return view;
    }
}
