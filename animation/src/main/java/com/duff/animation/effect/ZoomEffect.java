package com.duff.animation.effect;

import android.util.Log;
import android.view.View;

import com.duff.animation.AnimationType;
import com.duff.animation.parameter.Parameter;


public class ZoomEffect extends BaseEffect {

    private float mScaleX, mScaleY;
    private int mType;
    private float mScale;

    public ZoomEffect(View view, int type, float scale) {
        super(view);
        this.mType = type;
        this.mScaleX = view.getScaleX();
        this.mScaleY = view.getScaleY();
        mScale = scale;
    }

    public void reset() {
        super.reset();
        setValue(mScaleX, mScaleY);
    }

    @Override
    public void setPercent(float percent) {
        if (mPercent == percent) return;
        super.setPercent(percent);
        if (mType == AnimationType.ZOOM_OUT) {
            if (mScaleX == 0 || mScaleY == 0) {
                setValue(0);
            } else {
                setValue(1 + (mScale - 1) * percent);
            }
        } else if (mType == AnimationType.ZOOM_IN) { // 缩放1.1倍
            if (percent <= 0.5) {
                setValue(1 + (float) 0.2 * percent);
            } else {
                setValue((float) 1.2 - (float) 0.2 * percent);
            }
        }
    }

    private void setValue(float scaleX, float scaleY) {
        mView.setScaleX(scaleX);
        mView.setScaleY(scaleY);
    }

    @Override
    public int getEffectType() {
        return mType;
    }

    public void setValue(float scale) {
        setValue(scale, scale);
    }

    @Override
    public boolean compare(Parameter parameter) {
        return true;
    }

}
