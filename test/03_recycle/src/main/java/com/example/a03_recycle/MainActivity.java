package com.example.a03_recycle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button btnTest;
    private Button btnTest2;
    private RecyclerView rvList;
    private List<String> mDate;

    TestAdapter adapter;

    boolean show = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDate = getData(5);
        btnTest = (Button) findViewById(R.id.btn_test);
        btnTest2 = (Button) findViewById(R.id.btn_test2);
        rvList = (RecyclerView) findViewById(R.id.rv_list);
        adapter = new TestAdapter(mDate, this);
        rvList.setAdapter(adapter);
        GridLayoutManager gridLayoutManager =new GridLayoutManager(this,4);

        rvList.setLayoutManager(gridLayoutManager);

        show=false;

        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.setShow(!adapter.ismShow());
                adapter.notifyDataSetChanged();
            }
        });

        btnTest2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.setDate(getData(new Random().nextInt(12)));
                Animation animation= new AlphaAnimation(0,1);
                animation.setDuration(3000);
                rvList.startAnimation(animation);
            }
        });
    }

    private List getData(int num) {
        List mDate = new ArrayList();
        for (int i = 0; i < num; i++) {
            mDate.add(new String("" + i));
        }

        return mDate;
    }
}