package com.duff.animation.parameter;

import com.duff.animation.AnimationType;

public class FadeOutParameter extends Parameter {

    public FadeOutParameter(long duration) {
        super(AnimationType.FADE_OUT, duration);
    }

}
