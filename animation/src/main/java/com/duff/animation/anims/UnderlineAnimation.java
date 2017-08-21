package com.duff.animation.anims;

import android.widget.TextView;

import com.duff.animation.effect.UnderlineEffect;
import com.duff.animation.interfaces.IAnimation;
import com.nineoldandroids.animation.ObjectAnimator;

public class UnderlineAnimation extends BaseAnimation implements IAnimation {

    private int mStart = -1;
    private int mEnd = -1;

    public UnderlineAnimation() {
    }

    public UnderlineAnimation(int start, int end) {
        this.mStart = start;
        this.mEnd = end;
    }

    @Override
    public void initAnimation() {
        UnderlineEffect effect = new UnderlineEffect((TextView) this.mView, mStart, mEnd);
        mAnim = ObjectAnimator.ofFloat(effect, "percent", 0, 1);
        mAnim.setDuration(this.mDuration);
    }


}
