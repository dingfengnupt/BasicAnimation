package com.duff.animation.demo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.duff.animation.AnimationManager;
import com.duff.animation.parameter.FadeInParameter;
import com.duff.animation.parameter.HighLightParameter;
import com.duff.animation.parameter.TextColorParameter;
import com.duff.animation.parameter.TypeWriterParameter;
import com.duff.animation.parameter.UnderlineParameter;

/**
 * Created by dingfeng on 2017/8/21.
 */

public class TextAnimActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView tv_test;
    private Button bt_type, bt_underline, bt_highlight, bt_color;
    private Button bt_pause, bt_resume;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_anim);
        tv_test = (TextView)  findViewById(R.id.tv_test);

        bt_type = (Button) findViewById(R.id.bt_type);
        bt_type.setOnClickListener(this);
        bt_underline = (Button) findViewById(R.id.bt_underline);
        bt_underline.setOnClickListener(this);
        bt_highlight = (Button) findViewById(R.id.bt_highlight);
        bt_highlight.setOnClickListener(this);
        bt_color = (Button) findViewById(R.id.bt_color);
        bt_color.setOnClickListener(this);

        bt_pause = (Button) findViewById(R.id.bt_pause);
        bt_pause.setOnClickListener(this);
        bt_resume = (Button) findViewById(R.id.bt_resume);
        bt_resume.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_type:
                TypeWriterParameter typeWriterParameter = new TypeWriterParameter(3000);
                AnimationManager.instance().start(tv_test, typeWriterParameter);
                break;

            case R.id.bt_underline:
                UnderlineParameter underlineParameter = new UnderlineParameter(3000, 0, 15);
                AnimationManager.instance().start(tv_test, underlineParameter);
                break;

            case R.id.bt_highlight:
                HighLightParameter highLightParameter = new HighLightParameter(3000, Color.YELLOW, 10, 20);
                AnimationManager.instance().start(tv_test, highLightParameter);
                break;

            case R.id.bt_color:
                TextColorParameter textColorParameter = new TextColorParameter(3000, Color.RED);
                AnimationManager.instance().start(tv_test, textColorParameter);
                break;

            /******************************************************************************/

            case R.id.bt_pause:
                AnimationManager.instance().pause(tv_test);
                break;

            case R.id.bt_resume:
                AnimationManager.instance().resume(tv_test);
                break;

            default:
                break;
        }
    }


}
