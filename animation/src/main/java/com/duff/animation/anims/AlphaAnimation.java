package com.duff.animation.anims;

import com.duff.animation.effect.AlphaEffect;
import com.duff.animation.interfaces.IAnimation;
import com.nineoldandroids.animation.ObjectAnimator;

public class AlphaAnimation extends BaseAnimation implements IAnimation {

    public AlphaAnimation() {
    }

    @Override
    public void initAnimation() {
        AlphaEffect alphaEffect = new AlphaEffect(this.mView, this.mType);
        mAnim = ObjectAnimator.ofFloat(alphaEffect, "percent", 0, 1);
        mAnim.setDuration(this.mDuration);
    }


}
