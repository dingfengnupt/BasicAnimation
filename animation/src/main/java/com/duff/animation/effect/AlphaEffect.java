package com.duff.animation.effect;

import android.util.Log;
import android.view.View;

import com.duff.animation.AnimationType;
import com.duff.animation.parameter.Parameter;

public class AlphaEffect extends BaseEffect {

    private int mType;

    public AlphaEffect(View view, int type) {
        super(view);
        mType = type;
    }

    public void reset() {
        super.reset();
        mView.setAlpha(mOriginalAlpha);
    }

    @Override
    public void setPercent(float percent) {
        if (mPercent == percent) return;
        super.setPercent(percent);
        if (mType == AnimationType.FADE_IN) {
            setValue(percent * mOriginalAlpha);
        } else if (mType == AnimationType.FADE_OUT) {
            setValue(mOriginalAlpha * (1 - percent));
        }
    }

    private void setValue(float alpha) {
        mView.setAlpha(alpha);
    }

    @Override
    public int getEffectType() {
        return mType;
    }

    @Override
    public boolean compare(Parameter parameter) {
        return true;
    }

}
