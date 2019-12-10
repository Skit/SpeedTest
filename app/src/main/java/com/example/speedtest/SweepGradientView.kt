package com.example.speedtest

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class SweepGradientView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
): View(context, attrs, defStyleAttr) {


    private val archPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.STROKE
        strokeWidth = 32 * context.resources.displayMetrics.density
    }

    private val archBounds = RectF()
    private val archInset = 72 * context.resources.displayMetrics.density

    private val gradientColors = intArrayOf(Color.MAGENTA, Color.BLUE)
    private val gradientPositions = floatArrayOf(0/360f, 310/360f)

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val width = MeasureSpec.getSize(widthMeasureSpec)
        val height = MeasureSpec.getSize(heightMeasureSpec)
        val size = Math.min(width, height)
        setMeasuredDimension(size, size)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        archPaint.shader = SweepGradient(width / 2f, height / 2f, gradientColors, gradientPositions)
        archBounds.set(archInset, archInset, width.toFloat() - archInset, height.toFloat() - archInset)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val cx = width / 2f
        val cy = height / 2f

        canvas.save()
        canvas.rotate(115f, cx, cy)
        canvas.drawArc(archBounds, 0f, 310f, false, archPaint)
        canvas.drawCircle(cx, cy, width / 2.2f, archPaint)
        canvas.restore()
    }

}