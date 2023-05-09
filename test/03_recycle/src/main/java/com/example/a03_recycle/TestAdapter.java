package com.example.a03_recycle;

import android.app.Activity;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TestAdapter extends RecyclerView.Adapter {
    private List mDate;
    private Activity mActivity;
    private boolean mShow = false;

    public TestAdapter(List mDate, Activity mActivity) {
        this.mDate = mDate;
        this.mActivity = mActivity;
    }

    public void setShow(boolean mShow) {
        this.mShow = mShow;
    }

    public boolean ismShow() {
        return mShow;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TestViewGroup layout = new TestViewGroup(mActivity);

        RelativeLayout.LayoutParams layoutParams =
                new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        layout.setBackgroundColor(Color.BLUE);
        layoutParams.topMargin = 20;
        layout.setLayoutParams(layoutParams);

        ImageView view = new ImageView(mActivity);
        view.setId(R.id.test);
        RelativeLayout.LayoutParams params =
                new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

        view.setLayoutParams(params);
        view.setImageResource(R.drawable.ic_launcher_background);
        layout.addView(view);

//        View layout =View.inflate(mActivity,R.layout.layout_item,null);

        return new TestViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        TestViewHolder viewHolder = (TestViewHolder) holder;
        viewHolder.addView.setVisibility(mShow ? View.VISIBLE : View.INVISIBLE);
        Log.e("tlh","position"+position);
//        holder.itemView.setVisibility(View.VISIBLE);
    }

    @Override
    public int getItemCount() {
        return mDate.size();
    }

    class TestViewHolder extends RecyclerView.ViewHolder {
        public ImageView addView;

        public TestViewHolder(@NonNull View itemView) {
            super(itemView);
            addView = itemView.findViewById(R.id.test);
        }
    }
}
