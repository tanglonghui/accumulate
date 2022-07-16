package com.example.a01_anim;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private LinearLayout llRoot;
    private TextView init;

    List<TextView> list = new ArrayList<>();
    int selectI = 0;
    int select = Color.parseColor("#0d8ced");
    int unSelect = Color.parseColor("#C5215E");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init = findViewById(R.id.init);
        llRoot = findViewById(R.id.ll_root);
        init();

        init.setOnClickListener(v -> init());
    }

    private void init() {
        llRoot.removeAllViews();
        list.clear();
        for (int i = 0; i < 4; i++) {
            TextView tv = new TextView(this);
            tv.setText("" + i);
            tv.setPadding(50, 50, 50, 50);
            ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(20, 20, 20, 20);
            tv.setBackgroundColor(selectI == i ? select : unSelect);
            float scale = selectI == i ? 1.3f : 1f;
            tv.setScaleX(scale);
            tv.setScaleY(scale);
            int finalI = i;
            tv.setOnClickListener(v -> {
                selectI = finalI;
                updateText();
                new Thread(() -> {
                    try {
                        Thread.sleep(600);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    runOnUiThread(() -> init());
                }).start();
            });
            llRoot.addView(tv, layoutParams);
            list.add(tv);
        }
    }

    private void updateText() {
        for (int i = 0; i < 4; i++) {
            TextView tv = list.get(i);
            tv.setBackgroundColor(selectI == i ? select : unSelect);
            animateText(tv, selectI == i);
        }
    }

    private void animateText(TextView tv, boolean select) {
        float scale = select ? 1.3f : 1f;
        tv.animate().scaleX(scale).scaleY(scale).setDuration(300).start();
    }
}