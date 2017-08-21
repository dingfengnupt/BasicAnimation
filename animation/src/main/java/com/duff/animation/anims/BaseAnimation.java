package com.duff.animation.anims;

import android.view.View;

import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.ObjectAnimator;

public abstract class BaseAnimation {

    protected ObjectAnimator mAnim = null;
    protected View mView;
    protected long mDuration = 1000;
    protected int mType = -1;
    protected long currentPlayTime = 0L;

    public void setAnimationData(View view, long duration, int animType) {
        this.mView = view;
        this.mDuration = duration;
        this.mType = animType;
        this.initAnimation();
    }


    public abstract void initAnimation();

    public int getType() {
        return mType;
    }

    public void executeAnimation() {
        if (mAnim != null) {
            mAnim.start();
        }
    }

    public void pauseAnimation() {
        if (mAnim != null && mAnim.isRunning()) {
            currentPlayTime = mAnim.getCurrentPlayTime();
            mAnim.cancel();
        }
    }

    public void resumeAnimation() {
        if (mAnim != null && !mAnim.isRunning()) {
            mAnim.start();
            mAnim.setCurrentPlayTime(currentPlayTime);
        }
    }

    public void cancelAnimation() {
        if (mAnim != null) {
            mAnim.cancel();
        }
    }

    public void endAnimation() {
        if (mAnim != null) {
            mAnim.setCurrentPlayTime(mDuration);
        }
    }

    public Animator getAnimator() {
        return mAnim;
    }



}
