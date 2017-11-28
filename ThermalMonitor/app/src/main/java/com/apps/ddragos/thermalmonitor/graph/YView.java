package com.apps.ddragos.thermalmonitor.graph;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;


public class YView extends View {
    Paint axisPaint;
    Paint textPaint;
    Context context;
    DisplayMetrics metrics;
    float scaler;

    public static final int offset = 30;
    private static int yValues[];
    public static final int yUnits = 12;
    public static final int ST_DPI = 445;

    public YView(Context context) {
        super(context);
        this.context = context;
        metrics = new DisplayMetrics();
        initValues();
        initPaint();
    }

    public YView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        metrics = new DisplayMetrics();
        initValues();
        initPaint();
    }


    public YView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        metrics = new DisplayMetrics();
        initValues();
        initPaint();
    }

    private void initValues() {
        yValues = new int[yUnits];
        for (int i=0; i< yUnits; i++)
            yValues[i] = 10*i;
    }

    private void initPaint() {
        DisplayMetrics metrics = new DisplayMetrics();
        ((Activity)context).getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int screenDensity = metrics.densityDpi;
        scaler = (float)screenDensity/ST_DPI;

        axisPaint = new Paint();
        axisPaint.setStyle(Paint.Style.STROKE);
        axisPaint.setStrokeWidth(3);
        axisPaint.setColor(Color.BLACK);

        textPaint = new Paint();
        axisPaint.setStyle(Paint.Style.STROKE);
        axisPaint.setColor(Color.BLACK);
        textPaint.setTextSize(28*scaler);
    }

    @Override
    public void onDraw(Canvas canvas) {

        if (!this.isInEditMode()) {
            float unit = (getHeight() - offset)/(yUnits -1);
            for(int i=0; i<yUnits; i++) {
                canvas.drawLine(getWidth() - 20*scaler, getHeight() - (offset+i*unit), getWidth(), getHeight() - (offset+i*unit), axisPaint);
                canvas.drawText(String.valueOf(i*10),getWidth() - 60*scaler, getHeight() - (offset + i * unit - 5),textPaint);
            }

            canvas.drawLine(getWidth()-1, 0, getWidth()-1, getHeight(), axisPaint);
        }

    }
}
