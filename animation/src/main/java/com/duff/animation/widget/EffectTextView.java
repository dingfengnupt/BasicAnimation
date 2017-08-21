package com.duff.animation.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.text.Layout;
import android.text.StaticLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import com.duff.animation.WipeDirection;

public class EffectTextView extends TextView {

    private float percent = 0;
    private Path mPath = new Path();
    private int direction = WipeDirection.CLOCKWISE;

    public EffectTextView(Context context) {
        super(context);
    }

    public EffectTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public EffectTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (percent == 0) {
            super.onDraw(canvas);
            return;
        }

        if (direction == WipeDirection.CLOCKWISE) {
            onDrawClockWise(canvas);
        } else {
            onDrawAntiClockWise(canvas);
        }
    }

    //  顺时针
    public void onDrawClockWise(Canvas canvas) {
        mPath.reset();
        Rect rect = new Rect();
        this.getDrawingRect(rect);
        double radius = Math.pow(Math.pow(rect.right, 2) + Math.pow(rect.bottom, 2), 0.5);
        mPath.moveTo(rect.right / 2, rect.bottom / 2);
        mPath.lineTo(rect.right / 2, 0);
        if (percent > 0.125f) {
            mPath.lineTo(rect.right, 0);
        }
        if (percent > 0.375f) {
            mPath.lineTo(rect.right, rect.bottom);
        }
        if (percent > 0.625f) {
            mPath.lineTo(0, rect.bottom);
        }
        if (percent > 0.875f) {
            mPath.lineTo(0, 0);
        }
        mPath.lineTo((float) (rect.right / 2 + radius * Math.sin(Math.PI * 2 * percent)),
                (float) (rect.bottom / 2 - radius * Math.cos(Math.PI * 2 * percent)));
        mPath.close();
        Layout layout = getLayout();
        if (percent >= 0 && percent <= 1) {
            setLayerType(LAYER_TYPE_SOFTWARE, getPaint());
            canvas.save();
            canvas.clipPath(mPath);
            StaticLayout sl = new StaticLayout(getText(), getPaint(), getWidth(), getLayout().getAlignment(), layout.getSpacingMultiplier(), layout.getSpacingAdd(), true);
            sl.draw(canvas);
            canvas.restore();
        }
    }

    // 逆时针
    public void onDrawAntiClockWise(Canvas canvas) {
        mPath.reset();
        Rect rect = new Rect();
        this.getDrawingRect(rect);
        double radius = Math.pow(Math.pow(rect.right, 2) + Math.pow(rect.bottom, 2), 0.5);
        mPath.moveTo(rect.right / 2, rect.bottom / 2);
        mPath.lineTo(rect.right / 2, 0);
        if (percent > 0.125f) {
            mPath.lineTo(0, 0);
        }
        if (percent > 0.375f) {
            mPath.lineTo(0, rect.bottom);
        }
        if (percent > 0.625f) {
            mPath.lineTo(rect.right, rect.bottom);
        }
        if (percent > 0.875f) {
            mPath.lineTo(rect.right, 0);
        }
        mPath.lineTo((float) (rect.right / 2 - radius * Math.sin(Math.PI * 2 * percent)),
                (float) (rect.bottom / 2 - radius * Math.cos(Math.PI * 2 * percent)));
        mPath.close();
        Layout layout = getLayout();
        if (percent >= 0 && percent <= 1) {
            setLayerType(LAYER_TYPE_SOFTWARE, getPaint());
            canvas.save();
            canvas.clipPath(mPath);
            StaticLayout sl = new StaticLayout(getText(), getPaint(), getWidth(), getLayout().getAlignment(), layout.getSpacingMultiplier(), layout.getSpacingAdd(), true);
            sl.draw(canvas);
            canvas.restore();
        }
    }

    public float getPercent() {
        return percent;
    }

    public void setPercent(float percent) {
        this.percent = percent;
        this.setVisibility(View.VISIBLE);
        invalidate();
    }

}
