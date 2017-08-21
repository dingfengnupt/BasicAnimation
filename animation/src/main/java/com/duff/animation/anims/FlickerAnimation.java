package com.duff.animation.anims;

import com.duff.animation.effect.FlickerEffect;
import com.duff.animation.interfaces.IAnimation;
import com.nineoldandroids.animation.ObjectAnimator;

public class FlickerAnimation extends BaseAnimation implements IAnimation {

    public FlickerAnimation() {
    }

    @Override
    public void initAnimation() {
        FlickerEffect effect = new FlickerEffect(this.mView);
        mAnim = ObjectAnimator.ofFloat(effect, "percent", 0, 1);
        mAnim.setDuration(this.mDuration);
    }


}
