package com.duff.animation.parameter;


import com.duff.animation.AnimationType;
import com.duff.animation.TypeMode;

public class TypeWriterParameter extends Parameter {

    public int mode = TypeMode.TYPE_LETTER;

    public TypeWriterParameter(long duration) {
        this(duration, TypeMode.TYPE_LETTER);
    }

    public TypeWriterParameter(long duration, int mode) {
        super(AnimationType.TYPING, duration);
        this.mode = mode;
    }

}
