package com.hsieh.xiangzhui.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.hsieh.xiangzhui.R;

public class MuralDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mural_detail);
        Intent intent = getIntent();

        String muralTheme = intent.getStringExtra("mural_theme");
        String muralClass = intent.getStringExtra("mural_class");
        Float muralScore = intent.getFloatExtra("mural_score",(float) 4.7);
        int muralLength = intent.getIntExtra("mural_length",2510);
        int muralWidth = intent.getIntExtra("mural_width",1210);

        TextView tvMuralTheme = findViewById(R.id.tvMuralTheme);
        TextView tvMuralClass = findViewById(R.id.tvMuralClass);
        TextView tvMuralScore = findViewById(R.id.tvMuralScore);
        TextView tvMuralLength = findViewById(R.id.tvLength);
        TextView tvMuralWidth = findViewById(R.id.tvWidth);
        
        tvMuralTheme.setText(muralTheme);
        tvMuralClass.setText(muralClass);
        tvMuralScore.setText(String.valueOf(muralScore));
        tvMuralLength.setText(String.valueOf(muralLength));
        tvMuralWidth.setText(String.valueOf(muralWidth));

    }
}
