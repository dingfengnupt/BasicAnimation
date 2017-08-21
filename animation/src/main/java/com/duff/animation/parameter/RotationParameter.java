package com.duff.animation.parameter;

import com.duff.animation.AnimationType;

public class RotationParameter extends Parameter {

    public float rotation = 360.0f;

    public RotationParameter(long duration) {
        this(duration, 360.0f);
    }

    public RotationParameter(long duration, float rotation) {
        super(AnimationType.ROTATION, duration);
        this.rotation = rotation;
    }

}
