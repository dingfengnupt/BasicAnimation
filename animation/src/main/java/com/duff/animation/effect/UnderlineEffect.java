package com.duff.animation.effect;

import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.widget.TextView;

import com.duff.animation.AnimationType;
import com.duff.animation.parameter.Parameter;
import com.duff.animation.parameter.UnderlineParameter;

public class UnderlineEffect extends BaseEffect {
    private int mOrinStart, mOrinEnd;
    private int mStart, mEnd;
    private final CharSequence mText;

    public UnderlineEffect(TextView view, int start, int end) {
        super(view);
        mText = view.getText();
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
    }

    @Override
    public void setPercent(float percent) {
        if (mPercent == percent) return;
        super.setPercent(percent);
        setUnderLine(mStart, mStart + (int) ((mEnd - mStart) * percent));
    }

    private void setUnderLine(int start, int end) {
        CharSequence charSequence = mText.subSequence(0, mText.length());
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new UnderlineSpan(), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        if (charSequence != null) {
            ((TextView) mView).setText(spannableString);
        }
    }

    @Override
    public int getEffectType() {
        return AnimationType.UNDERLINE;
    }

    public int getStart() {
        return mStart;
    }

    public int getEnd() {
        return mEnd;
    }

    @Override
    public boolean compare(Parameter parameter) {
        UnderlineParameter p = (UnderlineParameter) parameter;
        if (mOrinStart == p.start && mOrinEnd == p.end) {
            return true;
        }
        return false;
    }

}
