package com.duff.animation.effect;

import android.content.res.ColorStateList;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

import com.duff.animation.AnimationType;
import com.duff.animation.parameter.Parameter;
import com.duff.animation.parameter.TextColorParameter;

public class TextColorEffect extends BaseEffect {
    private CharSequence mText;
    private int mTextColor;
    private int mOrinStart, mOrinEnd;
    private int mStart, mEnd;
    private ColorStateList mOriginalColor;

    public TextColorEffect(TextView view, int color, int start, int end) {
        super(view);
        mText = view.getText();
        mOriginalColor = view.getTextColors();
        mOrinStart = start;
        mOrinEnd = end;
        mTextColor = color;
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
        ((TextView) mView).setTextColor(mOriginalColor);
    }

    @Override
    public void setPercent(float percent) {
        if (mPercent == percent) return;
        super.setPercent(percent);
        setTextColor(mTextColor, mStart, mEnd);
    }

    private void setTextColor(int color, int start, int end) {
        ForegroundColorSpan colorSpan = new ForegroundColorSpan(color);
        CharSequence charSequence = ((TextView) mView).getText();
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(colorSpan, start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ((TextView) mView).setText(spannableString);
    }

    @Override
    public int getEffectType() {
        return AnimationType.TEXT_COLOR;
    }

    @Override
    public boolean compare(Parameter parameter) {
        TextColorParameter p = (TextColorParameter) parameter;
        if (mTextColor == p.color
                && mOrinStart == p.start
                && mOrinEnd == p.end) {
            return true;
        }
        return false;
    }

}
