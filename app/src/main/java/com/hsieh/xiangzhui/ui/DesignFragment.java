package com.hsieh.xiangzhui.ui;


import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.hsieh.xiangzhui.R;
import com.hsieh.xiangzhui.util.ProgressDialogUtil;

import java.text.NumberFormat;

/**
 * A simple {@link Fragment} subclass.
 */
public class DesignFragment extends Fragment {


    public DesignFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_design, container, false);
        Spinner articleList = view.findViewById(R.id.articleList);
        Spinner pictureList = view.findViewById(R.id.pictureList);
        SeekBar sbLength = view.findViewById(R.id.seekBarLength);
        SeekBar sbWidth = view.findViewById(R.id.seekBarWidth);
        TextView submit = view.findViewById(R.id.tvSubmit);
        final TextView tvLength = view.findViewById(R.id.tvLength);
        final TextView tvWidth = view.findViewById(R.id.tvWidth);
        articleList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        pictureList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        sbLength.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                double length = (progress / 60.0 + 1.5) * 1000;
                NumberFormat ddf1 = NumberFormat.getNumberInstance();
                ddf1.setMaximumFractionDigits(0);
                String s = ddf1.format(length);
                tvLength.setText(s + " mm");
            }


            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getContext(), "开始微调长度", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getContext(), "结束微调长度", Toast.LENGTH_SHORT).show();
            }
        });

        sbWidth.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                double width = (progress / 75.0 + 1.2) * 1000;
                NumberFormat ddf1 = NumberFormat.getNumberInstance();
                ddf1.setMaximumFractionDigits(0);
                String s = ddf1.format(width);
                tvWidth.setText(s + " mm");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getContext(), "开始微调宽度", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getContext(), "开始微调宽度", Toast.LENGTH_SHORT).show();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialogUtil.showProgressDialog(getContext());
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                        ProgressDialogUtil.dismiss();
                        Intent intent = new Intent(getContext(),NewMuralActivity.class);
                        getContext().startActivity(intent);

                    }
                }).start();

            }
        });

        return view;
    }


}
