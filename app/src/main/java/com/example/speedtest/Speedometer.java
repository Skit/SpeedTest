package com.example.speedtest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class Speedometer extends View {

    private static final float STROKE = 70f;
    private int[] gradientColors = {Color.GREEN, Color.YELLOW, Color.RED};
    private float[] gradientPositions = {0.0f, 0.5f, 1.0f};
    private final Paint paint = new Paint();
    private final Paint paintText = new Paint();
    private final Paint speedText = new Paint();
    private final RectF rectF = new RectF();
    //protected Drawable arrow = getResources().getDrawable(R.drawable.coursor, null);
    private int speed;
    private Rect textBound = new Rect();

    public Speedometer(Context context) {
        super(context);
    }

    public Speedometer(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Speedometer(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setSpeed(int s) {
        speed = s;
        invalidate();
    }

    public int getSpeed() {
        return speed;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(STROKE);
        paint.setAntiAlias(true);

        canvas.drawArc(rectF, 120f, 300f, false, paint);

        int speedTextOffset = 330;
        float speedTextTopOffset = rectF.height() + getPaddingTop() + STROKE;
        paintText.setTextSize(48);
        paintText.setTextAlign(Paint.Align.LEFT);
        canvas.drawText("0 km/h", rectF.centerX() - speedTextOffset, speedTextTopOffset, paintText);
        paintText.setTextAlign(Paint.Align.RIGHT);
        canvas.drawText("200 km/h", rectF.centerX() + speedTextOffset, speedTextTopOffset, paintText);

        speedText.setTextSize(48);
        String text = speed +  "km/h";
        float x = rectF.width() / 2f;
        float y = getWidth() / 2f + rectF.centerX() / 2f;
        canvas.drawText(text, x, y, speedText);

        /*arrow.setBounds((int) rectF.centerX(), (int) rectF.centerY(), 10, 10);
        arrow.draw(canvas);
        arrow.setLevel(speed);*/
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
