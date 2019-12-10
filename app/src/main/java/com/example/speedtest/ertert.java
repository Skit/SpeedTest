/*package com.example.speedtest;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
        mv = {1, 1, 15},
        bv = {1, 0, 3},
        k = 1,
        d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0014J\u0018\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0007H\u0014J(\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0007H\u0014R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"},
        d2 = {"Lcom/example/speedtest/SweepGradientView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "archBounds", "Landroid/graphics/RectF;", "archInset", "", "archPaint", "Landroid/graphics/Paint;", "gradientColors", "", "gradientPositions", "", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onSizeChanged", "w", "h", "oldw", "oldh", "app_debug"}
)
public final class SweepGradientView extends View {
    private final Paint archPaint;
    private final RectF archBounds;
    private final float archInset;
    private final int[] gradientColors;
    private final float[] gradientPositions;
    private HashMap _$_findViewCache;

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        int size = Math.min(width, height);
        this.setMeasuredDimension(size, size);
    }

    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.archPaint.setShader((Shader)(new SweepGradient((float)this.getWidth() / 2.0F, (float)this.getHeight() / 2.0F, this.gradientColors, this.gradientPositions)));
        this.archBounds.set(this.archInset, this.archInset, (float)this.getWidth() - this.archInset, (float)this.getHeight() - this.archInset);
    }

    protected void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkParameterIsNotNull(canvas, "canvas");
        super.onDraw(canvas);
        float cx = (float)this.getWidth() / 2.0F;
        float cy = (float)this.getHeight() / 2.0F;
        canvas.save();
        canvas.rotate(115.0F, cx, cy);
        canvas.drawArc(this.archBounds, 0.0F, 310.0F, false, this.archPaint);
        canvas.drawCircle(cx, cy, (float)this.getWidth() / 2.2F, this.archPaint);
        canvas.restore();
    }

    @JvmOverloads
    public SweepGradientView(@NotNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        super(context, attrs, defStyleAttr);
        Paint var4 = new Paint(1);
        boolean var5 = false;
        boolean var6 = false;
        int var8 = false;
        var4.setStyle(Style.STROKE);
        float var10001 = (float)32;
        Resources var10002 = context.getResources();
        Intrinsics.checkExpressionValueIsNotNull(var10002, "context.resources");
        var4.setStrokeWidth(var10001 * var10002.getDisplayMetrics().density);
        this.archPaint = var4;
        this.archBounds = new RectF();
        var10001 = (float)72;
        var10002 = context.getResources();
        Intrinsics.checkExpressionValueIsNotNull(var10002, "context.resources");
        this.archInset = var10001 * var10002.getDisplayMetrics().density;
        this.gradientColors = new int[]{-65281, -16776961};
        this.gradientPositions = new float[]{0.0F, 0.8611111F};
    }

    // $FF: synthetic method
    public SweepGradientView(Context var1, AttributeSet var2, int var3, int var4, DefaultConstructorMarker var5) {
        if ((var4 & 2) != 0) {
            var2 = (AttributeSet)null;
        }

        if ((var4 & 4) != 0) {
            var3 = 0;
        }

        this(var1, var2, var3);
    }

    @JvmOverloads
    public SweepGradientView(@NotNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0, 4, (DefaultConstructorMarker)null);
    }

    @JvmOverloads
    public SweepGradientView(@NotNull Context context) {
        this(context, (AttributeSet)null, 0, 6, (DefaultConstructorMarker)null);
    }

    public View _$_findCachedViewById(int var1) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }

        View var2 = (View)this._$_findViewCache.get(var1);
        if (var2 == null) {
            var2 = this.findViewById(var1);
            this._$_findViewCache.put(var1, var2);
        }

        return var2;
    }

    public void _$_clearFindViewByIdCache() {
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }

    }
}
*/
