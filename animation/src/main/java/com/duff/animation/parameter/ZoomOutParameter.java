package com.duff.animation.parameter;

import com.duff.animation.AnimationType;

public class ZoomOutParameter extends Parameter {
    private static final float DEFAULT_SCALE = 0;
    public float scale = DEFAULT_SCALE;

    public ZoomOutParameter(long duration) {
        this(duration, 0);
    }

    public ZoomOutParameter(long duration, float scale) {
        super(AnimationType.ZOOM_OUT, duration);
        this.scale = scale;
    }

}
