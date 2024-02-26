package com.example.a08_thread_res;

import androidx.appcompat.app.AppCompatActivity;
import androidx.collection.ArraySet;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    String TAG ="threadTest";
    ArraySet<Thread> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list =new ArraySet<>();
    }

    public void addThread(View view) {
        for (int i=0;i<10;i++){
            Thread thread=new Thread(new Runnable() {
                @Override
                public void run() {
//                    Bitmap bitmap= Bitmap.createBitmap(10000,10000,Bitmap.Config.ARGB_8888);
                    while (true){
                        Log.d(TAG,"start");
                        try {
                            Thread.currentThread().sleep(10000);

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
//                        Log.d(TAG,"end"+ bitmap.getConfig());
                    }
                }
            });

            thread.start();
            list.add(thread);
        }

    }

    public void removeThread(View view) {
    }
}