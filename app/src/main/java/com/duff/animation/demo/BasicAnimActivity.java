package com.duff.animation.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.duff.animation.AnimationManager;
import com.duff.animation.anims.FlickerAnimation;
import com.duff.animation.parameter.FadeInParameter;
import com.duff.animation.parameter.FadeOutParameter;
import com.duff.animation.parameter.FlickerParameter;
import com.duff.animation.parameter.RotationParameter;
import com.duff.animation.parameter.WipeParameter;
import com.duff.animation.parameter.ZoomInParameter;
import com.duff.animation.parameter.ZoomOutParameter;

/**
 * Created by dingfeng on 2017/8/21.
 */

public class BasicAnimActivity extends AppCompatActivity implements View.OnClickListener{

    private Button bt_fade_in, bt_fade_out, bt_flicker, bt_rotation;
    private Button bt_zoom_out, bt_zoom_in, bt_wipe, bt_wipe_sector;
    private Button bt_pause, bt_resume;

    private ImageView iv_test;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_anim);
        iv_test = (ImageView) findViewById(R.id.iv_test) ;

        bt_fade_in = (Button) findViewById(R.id.bt_fade_in);
        bt_fade_in.setOnClickListener(this);
        bt_fade_out = (Button) findViewById(R.id.bt_fade_out);
        bt_fade_out.setOnClickListener(this);
        bt_flicker = (Button) findViewById(R.id.bt_flicker);
        bt_flicker.setOnClickListener(this);
        bt_rotation = (Button) findViewById(R.id.bt_rotation);
        bt_rotation.setOnClickListener(this);
        bt_zoom_out = (Button) findViewById(R.id.bt_zoom_out);
        bt_zoom_out.setOnClickListener(this);
        bt_zoom_in = (Button) findViewById(R.id.bt_zoom_in);
        bt_zoom_in.setOnClickListener(this);
        bt_wipe = (Button) findViewById(R.id.bt_wipe);
        bt_wipe.setOnClickListener(this);
        bt_wipe_sector = (Button) findViewById(R.id.bt_wipe_sector);
        bt_wipe_sector.setOnClickListener(this);

        bt_pause = (Button) findViewById(R.id.bt_pause);
        bt_pause.setOnClickListener(this);
        bt_resume = (Button) findViewById(R.id.bt_resume);
        bt_resume.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_fade_in:
                FadeInParameter fadeInParameter = new FadeInParameter(2000);
                AnimationManager.instance().start(iv_test, fadeInParameter);
                break;

            case R.id.bt_fade_out:
                FadeOutParameter fadeOutParameter = new FadeOutParameter(2000);
                AnimationManager.instance().start(iv_test, fadeOutParameter);
                break;

            case R.id.bt_flicker:
                FlickerParameter flickerParameter = new FlickerParameter(2000);
                AnimationManager.instance().start(iv_test, flickerParameter);
                break;

            case R.id.bt_rotation:
                RotationParameter rotationParameter = new RotationParameter(2000, 180);
                AnimationManager.instance().start(iv_test, rotationParameter);
                break;

            case R.id.bt_zoom_out:
                ZoomOutParameter zoomOutParameter = new ZoomOutParameter(2000, 0.5f);
                AnimationManager.instance().start(iv_test, zoomOutParameter);
                break;

            case R.id.bt_zoom_in:
                ZoomInParameter zoomInParameter = new ZoomInParameter(2000, 1.5f);
                AnimationManager.instance().start(iv_test, zoomInParameter);
                break;

            case R.id.bt_wipe:
                WipeParameter wipeParameter = new WipeParameter(2000, 0);
                AnimationManager.instance().start(iv_test, wipeParameter);
                break;

            case R.id.bt_wipe_sector:
                WipeParameter wipeParameter1 = new WipeParameter(2000, 4);
                AnimationManager.instance().start(iv_test, wipeParameter1);
                break;

            /******************************************************************************/

            case R.id.bt_pause:
                AnimationManager.instance().pause(iv_test);
                break;

            case R.id.bt_resume:
                AnimationManager.instance().resume(iv_test);
                break;

            default:
                break;
        }
    }

}
