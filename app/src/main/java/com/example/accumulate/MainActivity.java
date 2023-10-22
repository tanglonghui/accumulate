package com.example.accumulate;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lib_common.unit.SystemPropertyUtil;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * adb shell setprop "s" "1"
     * adb shell getprop "s"
     */
    public void propTest(View view) throws IOException {
//        String value=PropUnit.PropUnit.getProperty("s","0");
//        Properties properties = new Properties();
//        String value = System.getProperties("s");
        String value = SystemPropertyUtil.get(this, "s", "0");
        Toast.makeText(this, "s :" + value, Toast.LENGTH_LONG).show();
    }
}