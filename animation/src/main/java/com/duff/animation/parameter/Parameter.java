package com.duff.animation.parameter;


import com.duff.animation.AnimationType;

/**
 * Created by dingfeng on 2017/6/14.
 */

public abstract class Parameter {
    /**
     * {@link AnimationType}
     */
    public int type;
    public long duration;

    public long currentTime = 0;
    public float alpha = 1;

    public Parameter(int type, long duration) {
        this.type = type;
        this.duration = duration;
    }

    public long getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(long currentTime) {
        this.currentTime = currentTime;
    }

}
