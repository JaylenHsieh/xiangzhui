package com.hsieh.xiangzhui.ui;


import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.hsieh.xiangzhui.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MineFragment extends Fragment {


    public MineFragment() {
        // Required empty public constructor
    }

    private Context mContext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine, container, false);
        if (mContext == null) {
            mContext = getContext();
        }
        LinearLayout weather = view.findViewById(R.id.weather_reminder);
        weather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext, WeatherActivity.class));
            }
        });

        LinearLayout design = view.findViewById(R.id.design);
        design.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext, MyDesignActivity.class));
            }
        });

        LinearLayout collection = view.findViewById(R.id.collection);
        collection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext, MyCollectionActivity.class));
            }
        });

        LinearLayout arRuler = view.findViewById(R.id.ar_ruler);
        arRuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "功能开发中", Toast.LENGTH_SHORT).show();
            }
        });

        LinearLayout meetingReminder = view.findViewById(R.id.meeting_reminder);
        meetingReminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext, MeetingReminderActivity.class));
            }
        });

        LinearLayout service = view.findViewById(R.id.service);
        service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "客服电话已复制至您的剪贴板，正在前往拨号", Toast.LENGTH_SHORT).show();
                if (ContextCompat.checkSelfPermission(mContext, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CALL_PHONE}, 1);
                } else {
                    call();
                }
            }
        });
        return view;
    }



    private void call() {
        try {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:400 896 2351"));
            startActivity(intent);
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }

}
