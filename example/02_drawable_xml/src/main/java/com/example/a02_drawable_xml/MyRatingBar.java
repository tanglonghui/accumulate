package com.example.a02_drawable_xml;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RatingBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyRatingBar extends androidx.appcompat.widget.AppCompatRatingBar {

    public MyRatingBar(@NonNull Context context) {
        super(context);
    }

    public MyRatingBar(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyRatingBar(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
