package com.duff.animation.effect;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.BackgroundColorSpan;
import android.util.Log;
import android.widget.TextView;

import com.duff.animation.AnimationType;
import com.duff.animation.parameter.HighLightParameter;
import com.duff.animation.parameter.Parameter;

public class HighLightEffect extends BaseEffect {
    private CharSequence mText;
    private int highLineColor = Color.YELLOW;
    private int mOrinStart, mOrinEnd;
    private int mStart, mEnd;
    private int mOriginalColor;

    public HighLightEffect(TextView view, int color, int start, int end) {
        super(view);
        mText = view.getText();
        Drawable drawable = view.getBackground();
        if (drawable != null && drawable instanceof ColorDrawable) {
            mOriginalColor = ((ColorDrawable) view.getBackground()).getColor();
        }
        highLineColor = color;
        mOrinStart = start;
        mOrinEnd = end;
        mStart = start < 0 ? 0 : start;
        mEnd = (end < 0 || end > mText.length()) ? mText.length() : end;
        if (mStart >= mEnd) {
            mStart = 0;
            mEnd = mText.length();
        }
    }

    public void reset() {
        super.reset();
        ((TextView) mView).setText(mText);
        mView.setBackgroundColor(mOriginalColor);
    }

    @Override
    public void setPercent(float percent) {
        if (mPercent == percent) return;
        super.setPercent(percent);
        setHighLight(highLineColor, mStart, mEnd);
    }

    private void setHighLight(int color, int start, int end) {
        BackgroundColorSpan backgroundColorSpan = new BackgroundColorSpan(color);
        CharSequence charSequence = ((TextView) mView).getText();
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(backgroundColorSpan, start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ((TextView) mView).setText(spannableString);
    }

    @Override
    public int getEffectType() {
        return AnimationType.HIGHLIGHT;
    }

    @Override
    public boolean compare(Parameter parameter) {
        HighLightParameter p = (HighLightParameter) parameter;
        if (highLineColor == p.color
                && mOrinStart == p.start
                && mOrinEnd == p.end) {
            return true;
        }
        return false;
    }

}
