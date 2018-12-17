package com.example.zhangshihao.signupandsignin;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ActionsActivity extends AppCompatActivity {

    @BindView(R.id.btn_bluetooth)
    Button btnBluetooth;
    @BindView(R.id.btn_photo)
    Button btnPhoto;
    @BindView(R.id.btn_switch)
    Button btnSwitch;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_actions);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_bluetooth, R.id.btn_photo, R.id.btn_switch})
    public void onViewClicked(View view) {

        switch (view.getId()) {
            case R.id.btn_bluetooth:
                startActivity(new Intent(ActionsActivity.this,BlueToothActivity.class));
                break;
            case R.id.btn_photo:
                startActivity(new Intent(ActionsActivity.this,PhotoActivity.class));
                break;
            case R.id.btn_switch:
                startActivity(new Intent(ActionsActivity.this,SwitchActivity.class));
                break;
        }
    }
}
