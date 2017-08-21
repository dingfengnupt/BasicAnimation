package com.duff.animation.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bt_normal_animation, bt_text_animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_normal_animation = (Button) findViewById(R.id.bt_normal_animation);
        bt_text_animation = (Button) findViewById(R.id.bt_text_animation);
        bt_normal_animation.setOnClickListener(this);
        bt_text_animation.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_normal_animation:
                startActivity(new Intent(MainActivity.this, BasicAnimActivity.class));
                break;

            case R.id.bt_text_animation:
                startActivity(new Intent(MainActivity.this, TextAnimActivity.class));
                break;

            default:
                break;
        }
    }


}
