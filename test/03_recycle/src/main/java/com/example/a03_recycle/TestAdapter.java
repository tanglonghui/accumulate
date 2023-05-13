package com.example.a03_recycle;

import android.app.Activity;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
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

    public void setDate(List mDate) {
        this.mDate.clear();
        this.mDate.addAll(mDate);
        notifyDataSetChanged();
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
//        layoutParams.topMargin = 20;
        layoutParams.setMargins(20,20,20,20);
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
        Animation animation= new AlphaAnimation(0,1);
        animation.setDuration(3000);

        Animation scaleAnimation = getAnimation();
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                Log.e("tlh","onAnimationStart");
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Log.e("tlh","onAnimationEnd");
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                Log.e("tlh","onAnimationEnd");
            }
        });


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.itemView.startAnimation(animation);
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return false;
            }
        });
    }

    @NonNull
    private Animation getAnimation() {
        Animation scaleAnimation=new ScaleAnimation(0,0,1,1);
        scaleAnimation.setDuration(3000);
        return scaleAnimation;
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
