package com.duff.animation.anims;

import android.widget.TextView;

import com.duff.animation.effect.HighLightEffect;
import com.duff.animation.interfaces.IAnimation;
import com.nineoldandroids.animation.ObjectAnimator;

public class HighlightAnimation extends BaseAnimation implements IAnimation {

    private int mStart = -1;
    private int mEnd = -1;
    private int mColor;

    public HighlightAnimation(int color) {
        this(color, -1, -1);
    }

    public HighlightAnimation(int color, int start, int end) {
        mColor = color;
        this.mStart = start;
        this.mEnd = end;
    }

    @Override
    public void initAnimation() {
        HighLightEffect effect = new HighLightEffect((TextView) this.mView, mColor, mStart, mEnd);
        mAnim = ObjectAnimator.ofFloat(effect, "percent", 0, 1);
        mAnim.setDuration(this.mDuration);
    }


}
