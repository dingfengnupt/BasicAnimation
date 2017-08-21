package com.duff.animation.interfaces;

import android.view.View;

import com.nineoldandroids.animation.Animator;

/**
 * Created by liuwenhui on 2017/6/5.
 */

public interface IAnimation {
    void setAnimationData(View view, long duration, int animType);

    void executeAnimation();

    void pauseAnimation();

    void resumeAnimation();

    void cancelAnimation();

    void endAnimation();

    Animator getAnimator();

}
