package com.example.a03_recycle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button btnTest;
    private RecyclerView rvList;
    private List<String> mDate;

    TestAdapter adapter;

    boolean show = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDate = new ArrayList();
        for (int i = 0; i < 10; i++) {
            mDate.add(new String("" + i));
        }

        btnTest = (Button) findViewById(R.id.btn_test);
        rvList = (RecyclerView) findViewById(R.id.rv_list);
        adapter = new TestAdapter(mDate, this);
        rvList.setAdapter(adapter);
        rvList.setLayoutManager(new LinearLayoutManager(this));

        show=false;

        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.setShow(!adapter.ismShow());
                adapter.notifyDataSetChanged();
            }
        });
    }
}