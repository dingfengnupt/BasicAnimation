package com.duff.animation.effect;

import android.view.View;
import com.duff.animation.AnimationType;
import com.duff.animation.parameter.Parameter;

public class RotationEffect extends BaseEffect {
    private static final float DEFAULT_ROTATION = 360.0f;
    private float mStartRotation;
    private float mRotation = DEFAULT_ROTATION;

    public RotationEffect(View view, float rotation) {
        super(view);
        mStartRotation = view.getRotation();
        mRotation = rotation;
    }

    public void reset() {
        super.reset();
        setValue(mStartRotation);
    }

    @Override
    public void setPercent(float percent) {
        if (mPercent == percent) return;
        super.setPercent(percent);
        setValue(mStartRotation + mRotation * percent);
    }

    private void setValue(float rotation) {
        mView.setRotation(rotation);
    }

    @Override
    public int getEffectType() {
        return AnimationType.ROTATION;
    }

    @Override
    public boolean compare(Parameter parameter) {
        return true;
    }

}
