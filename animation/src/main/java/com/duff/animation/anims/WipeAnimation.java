package com.duff.animation.anims;

import com.duff.animation.WipeDirection;
import com.duff.animation.effect.BaseEffect;
import com.duff.animation.effect.WipeEffect;
import com.duff.animation.effect.WipeSectorEffect;
import com.duff.animation.interfaces.IAnimation;
import com.nineoldandroids.animation.ObjectAnimator;

public class WipeAnimation extends BaseAnimation implements IAnimation {

    private int mDirection = WipeDirection.DEFAULT_DIRECTION;

    public WipeAnimation() {
    }

    public WipeAnimation(int direction) {
        this.mDirection = direction;
    }

    @Override
    public void initAnimation() {
        BaseEffect effect = null;
        if (mDirection >= WipeDirection.LEFT_TO_RIGHT && mDirection <= WipeDirection.BOTTOM_TO_TOP) {
            effect = new WipeEffect(this.mView, this.mDirection);
        } else if (mDirection >= WipeDirection.CLOCKWISE && mDirection <= WipeDirection.ANTI_CLOCKWISE) {
            effect = new WipeSectorEffect(this.mView, this.mDirection);
        }
        mAnim = ObjectAnimator.ofFloat(effect, "percent", 0, 1);
        mAnim.setDuration(this.mDuration);
    }


}
