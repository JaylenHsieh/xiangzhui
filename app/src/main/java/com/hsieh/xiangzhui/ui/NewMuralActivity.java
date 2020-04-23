package com.hsieh.xiangzhui.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;

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
        ImageView muralImg = findViewById(R.id.muralImg);
        int[] mArray = {
                R.mipmap.img2,
                R.mipmap.img3,
                R.mipmap.img4,
                R.mipmap.img5};

        //生成随机数，设置为5，是[0,5)，包含0而不包含5。0,1,2,3,4 五个数
        Random random = new Random();
        int index = random.nextInt(4);


        muralImg.setImageResource(mArray[index]);
    }
}
