package com.duff.animation.anims;

import com.duff.animation.interfaces.IAnimation;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorSet;

import java.util.ArrayList;

public class AnimationSet {

    private AnimatorSet mAnimatorSet;
    private ArrayList<IAnimation> mAnimations = new ArrayList<>();

    public AnimationSet() {
        mAnimatorSet = new AnimatorSet();
    }

    public void execute() {
        if (hasAnimations()) {
            Animator[] animators = new Animator[mAnimations.size()];
            for (int i = 0; i < mAnimations.size(); i++) {
                animators[i] = mAnimations.get(i).getAnimator();
            }
            mAnimatorSet.playTogether(animators);
            mAnimatorSet.start();
        }
    }

    public void addAnimation(IAnimation animation) {
        mAnimations.add(animation);
    }

    public ArrayList<IAnimation> getAnimations() {
        return mAnimations;
    }

    public boolean hasAnimations() {
        return (mAnimations.size() > 0);
    }

    public void pause() {
        for (IAnimation animation : mAnimations) {
            animation.pauseAnimation();
        }
    }

    public void resume() {
        for (IAnimation animation : mAnimations) {
            animation.resumeAnimation();
        }
    }

    public void cancel() {
        for (IAnimation animation : mAnimations) {
            animation.cancelAnimation();
        }
    }

    public void end() {
        for (IAnimation animation : mAnimations) {
            animation.endAnimation();
        }
    }

}
