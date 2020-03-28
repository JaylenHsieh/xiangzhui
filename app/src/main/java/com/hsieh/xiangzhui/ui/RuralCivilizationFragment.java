package com.hsieh.xiangzhui.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hsieh.xiangzhui.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RuralCivilizationFragment extends Fragment {

    public RuralCivilizationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rural_civilization, container, false);
    }
}
