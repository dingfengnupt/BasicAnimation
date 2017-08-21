package com.duff.animation.parameter;

import com.duff.animation.AnimationType;

public class HighLightParameter extends Parameter {

    public int start = -1;
    public int end = -1;
    public int color;

    public HighLightParameter(long duration, int color) {
        this(duration, color, -1, -1);
    }

    public HighLightParameter(long duration, int color, int start, int end) {
        super(AnimationType.HIGHLIGHT, duration);
        this.color = color;
        this.start = start;
        this.end = end;
    }

}
