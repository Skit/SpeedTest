package com.example.speedtest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

public class Speedometer extends View {

    private static final float STROKE = 70f;
    private int[] gradientColors = {Color.GREEN, Color.YELLOW, Color.RED};
    private float[] gradientPositions = {0.0f, 0.5f, 1.0f};
    private final Paint paint = new Paint();
    private final Paint paintText = new Paint();
    private final Paint arrowPoint = new Paint();
    private final Paint arraow = new Paint();
    private final RectF rectF = new RectF();


    public Speedometer(Context context) {
        super(context);
    }

    public Speedometer(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Speedometer(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(STROKE);
        paint.setAntiAlias(true);

        canvas.drawArc(rectF, 120f, 300f, false, paint);

        int speedTextOffset = 330;
        float speedTextTopOffsset = rectF.height() + getPaddingTop() + STROKE;
        paintText.setTextSize(48);
        paintText.setTextAlign(Paint.Align.LEFT);
        canvas.drawText("0 km/h", rectF.centerX() - speedTextOffset, speedTextTopOffsset, paintText);
        paintText.setTextAlign(Paint.Align.RIGHT);
        canvas.drawText("200 km/h", rectF.centerX() + speedTextOffset, speedTextTopOffsset, paintText);

        arrowPoint.setColor(Color.BLACK);
        canvas.drawCircle(rectF.centerX(), rectF.centerY() + 100, 30, arrowPoint);

        arraow.setColor(Color.BLACK);
        arraow.setStrokeWidth(20f);
        double angle = Math.PI * 100 / 30 - Math.PI / 2;
        canvas.drawLine(rectF.centerX(), rectF.centerY() + 100, (float) (rectF.width() + Math.cos(angle) / 2 * 1000), (float) (rectF.height() / 2 + Math.sin(angle) * 1000), arraow);
        Log.d("ttt", "onDraw() [" +  Math.cos(angle) + "]  [" + Math.sin(angle) + "]");
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        rectF.set(STROKE - getPaddingLeft(), STROKE - getPaddingTop(), w - STROKE + getPaddingRight(),  h - getPaddingBottom() / 2);
        SweepGradient gradient = new SweepGradient(w / 2,  STROKE + getPaddingTop() + rectF.height() / 2, gradientColors, gradientPositions);
        Matrix gradientMatrix = new Matrix();
        gradientMatrix.preRotate(90f, rectF.centerX(), rectF.centerY());
        gradient.setLocalMatrix(gradientMatrix);
        paint.setShader(gradient);
    }

}
