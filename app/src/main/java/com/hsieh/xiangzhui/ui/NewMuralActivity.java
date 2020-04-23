package com.hsieh.xiangzhui.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hsieh.xiangzhui.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class NewMuralActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_mural);
        Intent intent = getIntent();
        TextView muralTheme = findViewById(R.id.tvMuralTheme);
        TextView pictureClass = findViewById(R.id.tvPictureClass);
        TextView articleClass = findViewById(R.id.tvArticleClass);
        TextView tvLength = findViewById(R.id.tvLength);
        TextView tvWidth = findViewById(R.id.tvWidth);
        TextView startDraw = findViewById(R.id.startDraw);
        ImageView muralImg = findViewById(R.id.muralImg);
        int[] mArray = {
                R.mipmap.img2,
                R.mipmap.img3,
                R.mipmap.img4,
                R.mipmap.img5,
                R.mipmap.img14,
                R.mipmap.img15,
                R.mipmap.img16};

        //生成随机数，设置为5，是[0,5)，包含0而不包含5。0,1,2,3,4 五个数
        Random random = new Random();
        int index = random.nextInt(7);

        muralImg.setImageResource(mArray[index]);
        muralTheme.setText(intent.getStringExtra("mural_theme"));
        pictureClass.setText(intent.getStringExtra("picture_class"));
        articleClass.setText(intent.getStringExtra("article_class"));
        tvLength.setText(String.valueOf(intent.getIntExtra("mural_length", 2233)));
        tvWidth.setText(String.valueOf(intent.getIntExtra("mural_width", 1267)));
        startDraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NewMuralActivity.this, OrderActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
