package com.duff.animation.anims;

import com.duff.animation.effect.RotationEffect;
import com.duff.animation.interfaces.IAnimation;
import com.nineoldandroids.animation.ObjectAnimator;

public class RotationAnimation extends BaseAnimation implements IAnimation {

    private float mRotation;

    public RotationAnimation(float rotation) {
        mRotation = rotation;
    }

    @Override
    public void initAnimation() {
        RotationEffect effect = new RotationEffect(this.mView, mRotation);
        mAnim = ObjectAnimator.ofFloat(effect, "percent", 0, 1);
        mAnim.setDuration(this.mDuration);
    }

}
