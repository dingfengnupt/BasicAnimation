package com.duff.animation.anims;

import android.widget.TextView;

import com.duff.animation.effect.TextColorEffect;
import com.duff.animation.interfaces.IAnimation;
import com.nineoldandroids.animation.ObjectAnimator;

public class TextColorAnimation extends BaseAnimation implements IAnimation {

    private int mColor;
    private int mStart = -1;
    private int mEnd = -1;

    public TextColorAnimation(int color) {
        mColor = color;
    }

    public TextColorAnimation(int color, int start, int end) {
        mColor = color;
        mStart = start;
        mEnd = end;
    }

    @Override
    public void initAnimation() {
        TextColorEffect effect = new TextColorEffect((TextView) this.mView, mColor, mStart, mEnd);
        mAnim = ObjectAnimator.ofFloat(effect, "percent", 0, 1);
        mAnim.setDuration(this.mDuration);
    }


}
