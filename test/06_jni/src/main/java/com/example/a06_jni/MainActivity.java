package com.example.a06_jni;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * 1、下载 NDK
 * 2、右键 add c++ to module
 * 3、创建一个 native 方法，并更具提示，自动创建对应的 JNI 实现
 * 4、实现对应 JNI 方法
 * 5、static loadLibrary
 * 6、调用执行
 */
public class MainActivity extends AppCompatActivity {
    static {
        System.loadLibrary("a06_jni");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.test);
        textView.setText(makeMsg());
    }

    public native String makeMsg();
}