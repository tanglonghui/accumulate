package com.example.a01_canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class MyView extends View {
    String text = "SH十田一XAayl";
    float textSize = getResources().getDimension(R.dimen.dimen_24_dip);
    float padding = getResources().getDimension(R.dimen.dimen_10_dip);
    float height = getResources().getDimension(R.dimen.dimen_100_dip);
    float width = getResources().getDimension(R.dimen.dimen_200_dip);

    private Paint mPaint;

    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float centerX = padding + width / 2;
        float centerY = padding + height / 2;

        Paint a = new Paint();
        a.setColor(Color.RED);
// 设置样式-空心矩形
        a.setStyle(Paint.Style.STROKE);
// 绘制一个矩形
        canvas.drawRect(padding, padding, padding + width, padding + height, a);
        mPaint.setColor(Color.BLUE);
        canvas.drawLine(padding + 0, centerY, padding + width, centerY, mPaint);
        canvas.drawLine(centerX, padding + 0, centerX, padding + height, mPaint);
        canvas.drawText(text, padding, padding + getDrawTextY(height, mPaint), mPaint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = getMeasuredWidth() - padding * 2;
    }

    private void initPaint() {
        mPaint = new Paint();
        mPaint.setTextSize(textSize);
        mPaint.setColor(getResources().getColor(R.color.teal_200));
    }

    private float getDrawTextY(float measuredHeight, Paint paint) {
        Paint.FontMetricsInt metricsInt = paint.getFontMetricsInt();
        return measuredHeight * 0.5f + (metricsInt.descent - metricsInt.ascent) * 0.5f - metricsInt.descent;
    }
}
