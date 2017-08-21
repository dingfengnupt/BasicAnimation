package com.duff.animation.anims;

import android.view.animation.LinearInterpolator;
import com.duff.animation.effect.ZoomEffect;
import com.duff.animation.interfaces.IAnimation;
import com.nineoldandroids.animation.ObjectAnimator;

public class ZoomAnimation extends BaseAnimation implements IAnimation {

    private float mScale;

    public ZoomAnimation() {
        mScale = 0;
    }

    public ZoomAnimation(float scale) {
        mScale = scale;
    }

    @Override
    public void initAnimation() {
        ZoomEffect effect = new ZoomEffect(this.mView, this.mType, mScale);
        mAnim = ObjectAnimator.ofFloat(effect, "percent", 0, 1);
        mAnim.setInterpolator(new LinearInterpolator());
        mAnim.setDuration(this.mDuration);
    }


}
