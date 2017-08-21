package com.duff.animation.parameter;


import com.duff.animation.AnimationType;

public class TranslationParameter extends Parameter {

    public int direction;
    public float offset;

    public TranslationParameter(long duration, int direction) {
        this(duration, direction, 100f);
    }

    public TranslationParameter(long duration, int direction, float offset) {
        super(AnimationType.TRANSLATION, duration);
        this.direction = direction;
        this.offset = offset;
    }

}
