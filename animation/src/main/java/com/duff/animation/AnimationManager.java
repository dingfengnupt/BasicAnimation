package com.duff.animation;

import android.os.Build;
import android.util.Log;
import android.view.View;

import com.duff.animation.anims.AlphaAnimation;
import com.duff.animation.anims.AnimationSet;
import com.duff.animation.anims.FlickerAnimation;
import com.duff.animation.anims.HighlightAnimation;
import com.duff.animation.anims.RotationAnimation;
import com.duff.animation.anims.TextColorAnimation;
import com.duff.animation.anims.TypeAnimation;
import com.duff.animation.anims.UnderlineAnimation;
import com.duff.animation.anims.WipeAnimation;
import com.duff.animation.anims.ZoomAnimation;
import com.duff.animation.interfaces.IAnimation;
import com.duff.animation.parameter.HighLightParameter;
import com.duff.animation.parameter.Parameter;
import com.duff.animation.parameter.RotationParameter;
import com.duff.animation.parameter.TextColorParameter;
import com.duff.animation.parameter.TypeWriterParameter;
import com.duff.animation.parameter.UnderlineParameter;
import com.duff.animation.parameter.WipeParameter;
import com.duff.animation.parameter.ZoomInParameter;
import com.duff.animation.parameter.ZoomOutParameter;

import java.util.HashMap;
import java.util.Map;

import static android.view.View.LAYER_TYPE_SOFTWARE;

public class AnimationManager extends AbsAnimationManager{
    public static final String TAG = "AnimationManager";
    private Map<Integer, AnimationSet> mAnimSetMap = new HashMap<>();

    private static AnimationManager sInstance = null;

    public static AnimationManager instance() {
        if (sInstance == null) {
            sInstance = new AnimationManager();
        }
        return sInstance;
    }

    public AnimationManager() {

    }

    @Override
    public void start(View view, Parameter parameter) {
        if (view != null && parameter != null) {
            start(view, new Parameter[] {parameter});
        }
    }

    @Override
    public void start(View view, Parameter... parameters) {
        if (parameters == null || parameters.length == 0) return;
        AnimationSet animSet = new AnimationSet();
        for (Parameter parameter : parameters) {
            IAnimation animation = createAnimation(parameter);
            if (animation != null) {
                animation.setAnimationData(view, parameter.duration, parameter.type);
                closeHardwareAccelerateIfWipe(view, parameter);
                animSet.addAnimation(animation);
            }
        }
        mAnimSetMap.put(view.hashCode(), animSet);
        animSet.execute();
    }

    @Override
    public void pause(View view) {
        AnimationSet animSet = mAnimSetMap.get(view.hashCode());
        if (animSet != null) {
            animSet.pause();
        }
    }

    @Override
    public void resume(View view) {
        AnimationSet animSet = mAnimSetMap.get(view.hashCode());
        if (animSet != null) {
            animSet.resume();
        }
    }

    @Override
    public void cancel(View view) {
        AnimationSet animSet = mAnimSetMap.get(view.hashCode());
        if (animSet != null) {
            animSet.cancel();
        }
    }

    @Override
    public void release(View view) {
        cancel(view);
        mAnimSetMap.remove(view.hashCode());
    }

    private void closeHardwareAccelerateIfWipe(View v, Parameter p) {
        if (p.type == AnimationType.WIPE && Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
            v.setLayerType(LAYER_TYPE_SOFTWARE, null);
        }
    }

    private IAnimation createAnimation(Parameter parameter) {
        IAnimation animation = null;
        switch (parameter.type) {
            case AnimationType.FADE_IN:
                animation = new AlphaAnimation();
                break;

            case AnimationType.FADE_OUT:
                animation = new AlphaAnimation();
                break;

            case AnimationType.FLICKER:
                animation = new FlickerAnimation();
                break;

            case AnimationType.ROTATION:
                RotationParameter rotationParameter = (RotationParameter) parameter;
                animation = new RotationAnimation(rotationParameter.rotation);
                break;

            case AnimationType.ZOOM_OUT:
                ZoomOutParameter zoomOutParameter = (ZoomOutParameter) parameter;
                animation = new ZoomAnimation(zoomOutParameter.scale);
                break;

            case AnimationType.ZOOM_IN:
                ZoomInParameter zoomInParameter = (ZoomInParameter) parameter;
                animation = new ZoomAnimation(zoomInParameter.scale);
                break;

            case AnimationType.WIPE:
                WipeParameter wipeParameter = (WipeParameter) parameter;
                animation = new WipeAnimation(wipeParameter.direction);
                break;

            case AnimationType.TYPING:
                TypeWriterParameter typeWriterParameter = (TypeWriterParameter) parameter;
                animation = new TypeAnimation(typeWriterParameter.mode);
                break;

            case AnimationType.UNDERLINE:
                UnderlineParameter underlineParameter = (UnderlineParameter) parameter;
                animation = new UnderlineAnimation(underlineParameter.start, underlineParameter.end);
                break;

            case AnimationType.HIGHLIGHT:
                HighLightParameter highLightParameter = (HighLightParameter) parameter;
                animation = new HighlightAnimation(highLightParameter.color, highLightParameter.start, highLightParameter.end);
                break;

            case AnimationType.TEXT_COLOR:
                TextColorParameter textColorParameter = (TextColorParameter) parameter;
                animation = new TextColorAnimation(textColorParameter.color, textColorParameter.start, textColorParameter.end);
                break;

            default:
                Log.d(TAG, "Animation type is invalidate!");
                break;
        }

        return animation;
    }

}
