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
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
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

    private String articleClass;
    private String pictureClass;

    public DesignFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_design, container, false);
        Spinner articleList = view.findViewById(R.id.articleList);
        Spinner pictureList = view.findViewById(R.id.pictureList);
        SeekBar sbLength = view.findViewById(R.id.seekBarLength);
        SeekBar sbWidth = view.findViewById(R.id.seekBarWidth);
        TextView submit = view.findViewById(R.id.tvSubmit);
        RadioGroup rgIO = view.findViewById(R.id.radioGroup);
        final TextView tvLength = view.findViewById(R.id.tvLength);
        final TextView tvWidth = view.findViewById(R.id.tvWidth);
        final EditText edMuralTheme = view.findViewById(R.id.inputTheme);
        articleList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                articleClass = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        rgIO.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.radioIn:
                        break;
                    case R.id.radioOut:
                        break;
                }
            }
        });

        pictureList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                pictureClass = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        sbLength.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                double length = (progress / 60.0 + 1.4) * 1000;
                NumberFormat ddf1 = NumberFormat.getNumberInstance();
                ddf1.setMaximumFractionDigits(0);
                String s = ddf1.format(length);
                tvLength.setText(s + " mm");
            }


            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //Toast.makeText(getContext(), "开始微调长度", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //Toast.makeText(getContext(), "结束微调长度", Toast.LENGTH_SHORT).show();
            }
        });

        sbWidth.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                double width = (progress / 75.0 + 0.6) * 1000;
                NumberFormat ddf1 = NumberFormat.getNumberInstance();
                ddf1.setMaximumFractionDigits(0);
                String s = ddf1.format(width);
                tvWidth.setText(s + " mm");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //Toast.makeText(getContext(), "开始微调宽度", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //Toast.makeText(getContext(), "开始微调宽度", Toast.LENGTH_SHORT).show();
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
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                ProgressDialogUtil.dismiss();
                                Intent intent = new Intent(getContext(),NewMuralActivity.class);
                                Bundle bundle = new Bundle();
                                if (edMuralTheme.getText().toString().equals("")){
                                    Toast.makeText(getContext(), "好像忘记填写主题了……", Toast.LENGTH_SHORT).show();
                                }else {
                                    bundle.putString("mural_theme",edMuralTheme.getText().toString());
                                    bundle.putString("article_class",articleClass);
                                    bundle.putString("picture_class",pictureClass);
                                    bundle.putString("mural_length",tvLength.getText().toString());
                                    bundle.putString("mural_width",tvWidth.getText().toString());
                                    intent.putExtras(bundle);
                                    getContext().startActivity(intent);
                                }
                            }
                        });

                    }
                }).start();

            }
        });

        return view;
    }



}
