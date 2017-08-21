package com.duff.animation.effect;

import android.view.View;

import com.duff.animation.parameter.Parameter;

public abstract class BaseEffect {

    public final static int STATUS_PREPARED = 0;
    public final static int STATUS_PLAYING = 1;
    public final static int STATUS_COMPLETED = 2;

    protected int mStatus = STATUS_PREPARED;

    protected View mView;

    protected float mOriginalAlpha;
    protected float mPercent = 0;

    public BaseEffect(View view) {
        mView = view;
        mOriginalAlpha = mView.getAlpha();
    }

    public void reset() {
        mPercent = 0;
        mStatus = STATUS_PREPARED;
    }

    public void setPercent(float percent) {
        mPercent = percent;
        if (percent == 0) {
            mStatus = STATUS_PREPARED;
        } else if (percent == 1) {
            mStatus = STATUS_COMPLETED;
        } else {
            mStatus = STATUS_PLAYING;
        }
    }

    public abstract int getEffectType();

    public abstract boolean compare(Parameter parameter);

}
