package com.duff.animation.parameter;

import com.duff.animation.AnimationType;

public class ZoomInParameter extends Parameter {

    private static final float DEFAULT_SCALE = 1.5f;
    public float scale = DEFAULT_SCALE;

    public ZoomInParameter(long duration) {
        this(duration, DEFAULT_SCALE);
    }

    public ZoomInParameter(long duration, float scale) {
        super(AnimationType.ZOOM_IN, duration);
        this.scale = scale;
    }

}
