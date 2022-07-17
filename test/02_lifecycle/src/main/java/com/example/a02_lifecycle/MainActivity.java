package com.example.a02_lifecycle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lib_common.unit.FastBlur;

public class MainActivity extends AppCompatActivity {
    private LinearLayout llRoot;
    private ImageView ivImage;
    private TextView init;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        overridePendingTransition(R.anim.test_in,R.anim.test_out);
        llRoot = findViewById(R.id.ll_root);
        ivImage = findViewById(R.id.iv_image);
        init = findViewById(R.id.init);

        init.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivImage.setImageResource(R.drawable.pic_1);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        testIn2();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //        testIn2();
    }

    private void testIn2() {
        Log.e("archer ,","getHeight1:"+ivImage.getHeight());
        ivImage.post(new Runnable() {
            @Override
            public void run() {
                Log.e("archer ,","getHeight2:"+ivImage.getHeight());
                setBlurImage(ivImage);
            }
        });
    }

    private void testIn1() {
        llRoot.postDelayed(new Runnable() {
            @Override
            public void run() {
                llRoot.setBackgroundColor(getColor(R.color.title_text_color));
            }
        },1000);
//        new Thread(() -> {
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            runOnUiThread(() -> llRoot.setBackgroundColor(getColor(R.color.title_text_color)));
//        }).start();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    private void testOut2() {
    }

    private void testOut1() {
        llRoot.setBackgroundColor(getColor(R.color.background));
    }

    private int scaleRatio = 5;
    private int blurRadius = 10;

    private void setBlurImage(ImageView imageView) {
        Bitmap mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.pic_1);
        Bitmap scaledBitmap = Bitmap.createScaledBitmap(mBitmap,
                mBitmap.getWidth() / scaleRatio,
                mBitmap.getHeight() / scaleRatio,
                false);
        imageView.setImageBitmap(FastBlur.doBlur(scaledBitmap, blurRadius, true));
    }
}