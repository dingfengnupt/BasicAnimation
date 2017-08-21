package com.duff.animation;

import android.view.View;

import com.duff.animation.parameter.Parameter;

/**
 * Created by dingfeng on 2017/8/21.
 */

public abstract class AbsAnimationManager {

    public abstract void start(View view, Parameter parameter);

    public abstract void start(View view, Parameter... parameter);

    public abstract void pause(View view);

    public abstract void resume(View view);

    public abstract void cancel(View view);

    public abstract void release(View view);
}
