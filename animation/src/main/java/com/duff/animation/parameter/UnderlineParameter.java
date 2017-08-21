package com.duff.animation.parameter;

import com.duff.animation.AnimationType;

public class UnderlineParameter extends Parameter {

    public int start = -1;
    public int end = -1;

    public UnderlineParameter(long duration) {
        this(duration, -1, -1);
    }

    public UnderlineParameter(long duration, int start, int end) {
        super(AnimationType.UNDERLINE, duration);
        this.start = start;
        this.end = end;
    }

}
