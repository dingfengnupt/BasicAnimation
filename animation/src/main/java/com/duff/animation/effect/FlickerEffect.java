package com.duff.animation.effect;

import android.util.Log;
import android.view.View;

import com.duff.animation.AnimationType;
import com.duff.animation.parameter.Parameter;

public class FlickerEffect extends BaseEffect {

    private float mOriginalValue;

    public FlickerEffect(View view) {
        super(view);
        mOriginalValue = view.getAlpha();
    }

    public void reset() {
        if (mStatus == STATUS_PREPARED) return;
        super.reset();
        Log.d("OCSAnimation", "FlickerEffect reset !!!");
        setValue(mOriginalValue);
    }

    @Override
    public void setPercent(float percent) {
        if (mPercent == percent) return;
        super.setPercent(percent);
        float p = 0;
        if (percent <= 0.5) {
            p = mOriginalValue * (1 - percent * 2);
            setValue(p);
        } else {
            p = 1 - (1 - percent) * 2;
        }
        setValue(p);
        mView.setVisibility(View.VISIBLE);
    }

    @Override
    public int getEffectType() {
        return AnimationType.FLICKER;
    }

    public void setValue(float alpha) {
        mView.setAlpha(alpha);
    }

    @Override
    public boolean compare(Parameter parameter) {
        return true;
    }

}
