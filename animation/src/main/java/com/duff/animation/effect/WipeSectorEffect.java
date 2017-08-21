package com.duff.animation.effect;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;

import com.duff.animation.AnimationType;
import com.duff.animation.parameter.Parameter;
import com.duff.animation.parameter.WipeParameter;
import com.duff.animation.widget.EffectDrawable;
import com.duff.animation.widget.EffectTextView;

import static android.view.View.LAYER_TYPE_SOFTWARE;


public class WipeSectorEffect extends BaseEffect {

    private int mDirection;
    private EffectTextView mEffectTextView = null;
    private EffectDrawable mEffectDrawable = null;
    private Drawable mDrawable = null;

    public WipeSectorEffect(View view, int direction) {
        super(view);
        this.mDirection = direction;
        // 文字
        if (mView instanceof EffectTextView) {
            mEffectTextView = (EffectTextView) mView;
            mEffectTextView.setDirection(direction);
        }
        // 图片
        else if (mView instanceof ImageView) {
            mDrawable = ((ImageView) mView).getDrawable();
            if (mDrawable == null) return;
            mEffectDrawable = new EffectDrawable(mDrawable);
            mEffectDrawable.setDirection(direction);
            ((ImageView) mView).setImageDrawable(mEffectDrawable);
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
                mView.setLayerType(LAYER_TYPE_SOFTWARE, null);
            }
        }
    }

    public void reset() {
        super.reset();
        setValue(0);
        if (mDrawable != null && mEffectDrawable != null) {
            ((ImageView) mView).setImageDrawable(mDrawable);
        }
    }

    @Override
    public void setPercent(float percent) {
        if (mPercent == percent) return;
        super.setPercent(percent);
        if (mView instanceof ImageView) {
            ((ImageView) mView).setImageDrawable(mEffectDrawable);
        }
        setValue(percent);
    }

    private void setValue(float percent) {
        if (mEffectTextView != null) {
            mEffectTextView.setPercent(percent);
        }
        if (mEffectDrawable != null) {
            mEffectDrawable.setPercent(percent);
        }
    }

    @Override
    public int getEffectType() {
        return AnimationType.WIPE;
    }

    @Override
    public boolean compare(Parameter parameter) {
        WipeParameter p = (WipeParameter) parameter;
        if (mDirection == p.direction) {
            return true;
        }
        return false;
    }

}
