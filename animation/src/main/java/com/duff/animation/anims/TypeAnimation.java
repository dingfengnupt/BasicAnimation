package com.duff.animation.anims;

import android.view.animation.LinearInterpolator;
import android.widget.TextView;

import com.duff.animation.TypeMode;
import com.duff.animation.effect.TypeEffect;
import com.duff.animation.interfaces.IAnimation;
import com.nineoldandroids.animation.ObjectAnimator;

public class TypeAnimation extends BaseAnimation implements IAnimation {

    private int mode;

    public TypeAnimation() {
        this.mode = TypeMode.TYPE_LETTER;
    }

    public TypeAnimation(int mode) {
        this.mode = mode;
    }

    @Override
    public void initAnimation() {
        TypeEffect effect = new TypeEffect((TextView) this.mView, mode);
        mAnim = ObjectAnimator.ofFloat(effect, "percent", 0, 1);
        mAnim.setInterpolator(new LinearInterpolator());
        mAnim.setDuration(this.mDuration);
    }

}
