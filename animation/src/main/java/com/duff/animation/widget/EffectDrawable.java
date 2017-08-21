package com.duff.animation.widget;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;

import com.duff.animation.WipeDirection;

public class EffectDrawable extends Drawable implements Drawable.Callback, Runnable {

    private static final int ANIM_INTERVAL = 50;
    private static float ANIM_FACTOR = 1.0f;

    private Drawable mDrawable;
    private Path mPath = new Path();
    private float mPercent = -1;
    private int direction = WipeDirection.CLOCKWISE;

    private boolean mStart;
    private int mDuring;

    public EffectDrawable(Drawable drawable) {
        this.mDrawable = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public void startAnimation(int during) {
        mDuring = during;
        mPercent = 0;
        start();
    }

    @Override
    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | mDrawable.getChangingConfigurations();
    }

    @Override
    public boolean getPadding(Rect padding) {
        return mDrawable.getPadding(padding);
    }

    @Override
    public boolean setVisible(boolean visible, boolean restart) {
        mDrawable.setVisible(visible, restart);
        return super.setVisible(visible, restart);
    }

    @Override
    public void draw(Canvas canvas) {
        if (direction == WipeDirection.CLOCKWISE) {
            onDrawClockWise(canvas);
        } else {
            onDrawAntiClockWise(canvas);
        }
    }

    //  顺时针
    public void onDrawClockWise(Canvas canvas) {
        mPath.reset();
        RectF rect = new RectF(getBounds());
        double radius = Math.pow(Math.pow(rect.right, 2) + Math.pow(rect.bottom, 2), 0.5);
        mPath.moveTo(rect.right / 2, rect.bottom / 2);
        mPath.lineTo(rect.right / 2, 0);
        if (mPercent > 0.125f) {
            mPath.lineTo(rect.right, 0);
        }
        if (mPercent > 0.375f) {
            mPath.lineTo(rect.right, rect.bottom);
        }
        if (mPercent > 0.625f) {
            mPath.lineTo(0, rect.bottom);
        }
        if (mPercent > 0.875f) {
            mPath.lineTo(0, 0);
        }
        if (mPercent > 1) {
            mPercent = 1;
        }
        mPath.lineTo((float) (rect.right / 2 + radius * Math.sin(Math.PI * 2 * mPercent)),
                (float) (rect.bottom / 2 - radius * Math.cos(Math.PI * 2 * mPercent)));
        mPath.close();
        if (mPercent >= 0 && mPercent <= 1) {
            canvas.save();
            canvas.clipPath(mPath);
            mDrawable.draw(canvas);
            canvas.restore();
        }
    }

    // 逆时针
    public void onDrawAntiClockWise(Canvas canvas) {
        mPath.reset();
        RectF rect = new RectF(getBounds());
        double radius = Math.pow(Math.pow(rect.right, 2) + Math.pow(rect.bottom, 2), 0.5);
        mPath.moveTo(rect.right / 2, rect.bottom / 2);
        mPath.lineTo(rect.right / 2, 0);
        if (mPercent > 0.125f) {
            mPath.lineTo(0, 0);
        }
        if (mPercent > 0.375f) {
            mPath.lineTo(0, rect.bottom);
        }
        if (mPercent > 0.625f) {
            mPath.lineTo(rect.right, rect.bottom);
        }
        if (mPercent > 0.875f) {
            mPath.lineTo(rect.right, 0);
        }
        if (mPercent > 1) {
            mPercent = 1;
        }

        mPath.lineTo((float) (rect.right / 2 - radius * Math.sin(Math.PI * 2 * mPercent)),
                (float) (rect.bottom / 2 - radius * Math.cos(Math.PI * 2 * mPercent)));

        mPath.close();
        if (mPercent >= 0 && mPercent <= 1) {
            canvas.save();
            canvas.clipPath(mPath);
            mDrawable.draw(canvas);
            canvas.restore();
        }
    }

    @Override
    public void setAlpha(int alpha) {
        mDrawable.setAlpha(alpha);
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    public int getAlpha() {
        return mDrawable.getAlpha();
    }

    @Override
    public void setColorFilter(ColorFilter cf) {
        mDrawable.setColorFilter(cf);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void setTintList(ColorStateList tint) {
        mDrawable.setTintList(tint);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void setTintMode(PorterDuff.Mode tintMode) {
        mDrawable.setTintMode(tintMode);
    }

    @Override
    public int getOpacity() {
        // TODO Auto-generated method stub
        return mDrawable.getOpacity();
    }

    @Override
    public boolean isStateful() {
        // TODO Auto-generated method stub
        return mDrawable.isStateful();
    }

    @Override
    protected boolean onStateChange(int[] state) {
        return mDrawable.setState(state);
    }

    @Override
    protected boolean onLevelChange(int level) {
        mDrawable.setLevel(level);
        invalidateSelf();
        return true;
    }

    @Override
    protected void onBoundsChange(Rect bounds) {
        mDrawable.setBounds(bounds);
    }

    @Override
    public int getIntrinsicHeight() {
        return mDrawable.getIntrinsicHeight();
    }

    @Override
    public int getIntrinsicWidth() {
        return mDrawable.getIntrinsicWidth();
    }

    /**
     * 显示的区域范围
     *
     * @param percent 0至1
     */
    public void setPercent(float percent) {
        if (percent > 1) {
            percent = 1;
        } else if (percent < 0) {
            percent = 0;
        }
        if (percent != mPercent) {
            this.mPercent = percent;
            invalidateSelf();
        }
    }

    @Override
    public void invalidateDrawable(Drawable who) {
        final Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long l) {
        invalidateDrawable(drawable);
    }

    @Override
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        super.unscheduleSelf(runnable);
    }

    public void nextFrame() {
        unscheduleSelf(this);
        scheduleSelf(this, SystemClock.uptimeMillis() + ANIM_INTERVAL);
    }

    private void stop() {
        mStart = false;
        unscheduleSelf(this);
    }

    private void start() {
        if (!mStart) {
            mStart = true;
            nextFrame();
        }
    }

    @Override
    public void run() {
        if (mPercent < 1) {
            mPercent += ANIM_INTERVAL * ANIM_FACTOR / mDuring;
            invalidateSelf();
            nextFrame();
        }
    }

}
