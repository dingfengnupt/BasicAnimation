package com.duff.animation.effect;

import android.annotation.TargetApi;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;

import com.duff.animation.AnimationType;
import com.duff.animation.WipeDirection;
import com.duff.animation.parameter.Parameter;
import com.duff.animation.parameter.WipeParameter;

public class WipeEffect extends BaseEffect {

    private int mDirection;

    public WipeEffect(View view, int direction) {
        super(view);
        this.mDirection = direction;
    }

    public void reset() {
        super.reset();
        setValue(0);
    }

    @Override
    public void setPercent(float percent) {
        if (mPercent == percent) return;
        super.setPercent(percent);
        setValue(percent);
    }

    @Override
    public int getEffectType() {
        return AnimationType.WIPE;
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
    private void setValue(float percent) {
        Rect local = new Rect();
        this.mView.getLocalVisibleRect(local);
        Rect from = new Rect(local);
        switch (mDirection) {
            case WipeDirection.LEFT_TO_RIGHT:
                from.left = (int) (local.width() * (1.0 - percent));
                from.top = 0;
                from.right = local.width();
                from.bottom = local.height();
                break;

            case WipeDirection.RIGHT_TO_LEFT:
                from.left = 0;
                from.top = 0;
                from.right = (int) (local.width() * percent);
                from.bottom = local.height();
                break;

            case WipeDirection.TOP_TO_BOTTOM:
                from.left = 0;
                from.top = (int) (local.height() * (1.0 - percent));
                from.right = local.width();
                from.bottom = local.height();
                break;

            case WipeDirection.BOTTOM_TO_TOP:
                from.left = 0;
                from.top = 0;
                from.right = local.width();
                from.bottom = (int) (local.height() * percent);
                break;
        }
        mView.setClipBounds(from);
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
