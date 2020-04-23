package com.hsieh.xiangzhui.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.hsieh.xiangzhui.R;
import com.hsieh.xiangzhui.util.ProgressDialogUtil;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        TextView tvConfirm = findViewById(R.id.tvConfirm);
         tvConfirm.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 ProgressDialogUtil.showProgressDialog(OrderActivity.this,"订单创建中，请稍后……");
                 new Thread(new Runnable() {
                     @Override
                     public void run() {
                         try {
                             Thread.sleep(1200);
                         } catch (InterruptedException e){
                             e.printStackTrace();
                         }
                         runOnUiThread(new Runnable() {
                             @Override
                             public void run() {
                                 ProgressDialogUtil.dismiss();
                                 Toast.makeText(OrderActivity.this, "订单创建完成，我们将竭诚为你服务", Toast.LENGTH_SHORT).show();
                             }
                         });

                     }
                 }).start();
             }
         });
    }
}
