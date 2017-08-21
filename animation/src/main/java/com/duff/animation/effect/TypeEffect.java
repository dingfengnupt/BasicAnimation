package com.duff.animation.effect;

import android.text.SpannableString;
import android.widget.TextView;

import com.duff.animation.AnimationType;
import com.duff.animation.TypeMode;
import com.duff.animation.parameter.Parameter;
import com.duff.animation.parameter.TypeWriterParameter;

public class TypeEffect extends BaseEffect {
    private CharSequence mText;
    private int mTotalCount;
    private int mMode;
    private String[] mStr; // 字符串数组

    public TypeEffect(TextView view) {
        super(view);
        mText = view.getText();
        mTotalCount = mText.length();
    }

    public TypeEffect(TextView view, int mode) {
        this(view);
        mMode = mode;
        if (mMode == TypeMode.TYPE_WORD) {
            mStr = mText.toString().split(" ");
            mTotalCount = mStr.length;
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
        int count = (int) (mTotalCount * percent);
        if (mMode == 1) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < count; i++) {
                sb.append(mStr[i]);
                if (i != count -1) {
                    sb.append(" ");
                }
            }
            count = sb.length();
        }
        type(count);
    }

    private void type(int count) {
        CharSequence charSequence = mText.subSequence(0, count);
        SpannableString spannableString = new SpannableString(charSequence);
        if (charSequence != null) {
            ((TextView) mView).setText(spannableString);
        }
    }

    @Override
    public int getEffectType() {
        return AnimationType.TYPING;
    }

    @Override
    public boolean compare(Parameter parameter) {
        TypeWriterParameter p = (TypeWriterParameter) parameter;
        if (mMode == p.mode) {
            return true;
        }
        return false;
    }

}
