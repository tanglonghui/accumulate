package com.example.a05_view;

import android.graphics.Color;
import android.graphics.Matrix;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends AppCompatActivity {
    private ImageView ivTest;
    private Button test1;
    private Button test2;
    private ConstraintLayout rootLayout;
int mCur=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rootLayout = (ConstraintLayout) findViewById(R.id.root_layout);
        ivTest = (ImageView) findViewById(R.id.iv_test);
        test1 = (Button) findViewById(R.id.test_1);
        test2 = (Button) findViewById(R.id.test_2);
        rootLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("testtouch", "my rootLayout ---");
                mCur+=90;
                ivTest.animate().rotation(mCur).start();
            }
        });
        getWindow().getDecorView().setBackgroundColor(Color.RED);
        getWindow().getDecorView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("testtouch", "my getDecorView ---");
                mCur+=90;
                ivTest.animate().rotation(mCur).start();
            }
        });

//        getWindow().getDecorView().setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                Log.e("testtouch", "my getDecorView ---");
//                mCur+=90;
//                ivTest.animate().rotation(mCur).start();
//                return false;
//            }
//        });

//        getWindow().getDecorView().setClickable(true);
        ivTest.setTranslationY(-100);
//        Matrix matrix= ivTest.getMatrix();
//        matrix.preTranslate(0,-100);
//        matrix.postRotate(90);
//        ivTest.setAnimationMatrix(matrix);
        test1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCur-=90;
                rootLayout.animate().rotation(mCur).start();
            }
        });

        test2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCur+=90;
                rootLayout.animate().rotation(mCur).start();
//                ivTest.transformMatrixToLocal(matrix);
//                ivTest.setAnimationMatrix(matrix);
//                ivTest.set
            }
        });
    }
}