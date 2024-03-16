package com.example.a10_thread_state;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.ConditionVariable;
import android.util.Log;
import android.view.View;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "thread_state";
    Thread thread = null;
    long time = 0;
    ConditionVariable conditionVariable=new ConditionVariable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addThread(View view) {
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
//                    try {
//                        Thread.sleep(2000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    Log.d(TAG, "thread is running");

//                    if (Thread.currentThread().isInterrupted()){
//                        Log.d(TAG, "thread is isInterrupted");
//
//                        break;
//                    }
                }


//                Log.d(TAG, "thread is exit");
            }
        });
        thread.start();
    }

    public void removeThread(View view) {
        if (null == thread){
            return;
        }

        thread.interrupt();
    }

}