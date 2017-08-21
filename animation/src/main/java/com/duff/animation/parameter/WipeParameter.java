package com.duff.animation.parameter;


import com.duff.animation.AnimationType;

public class WipeParameter extends Parameter {

    public int direction = 0;

    public WipeParameter(long duration) {
        this(duration, 0);
    }

    public WipeParameter(long duration, int direction) {
        super(AnimationType.WIPE, duration);
        this.direction = direction;
    }

}
