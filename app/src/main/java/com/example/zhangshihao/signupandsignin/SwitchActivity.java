package com.example.zhangshihao.signupandsignin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SwitchActivity extends AppCompatActivity {

    @BindView(R.id.sw)
    Switch sw;
    @BindView(R.id.tv_status)
    TextView tvStatus;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_switch);
        ButterKnife.bind(this);

        sw.setChecked(MainActivity.isOpen);
        tvStatus.setText(MainActivity.isOpen ? "开" : "关");

        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    tvStatus.setText("开");
                    MainActivity.isOpen = true;
                } else {
                    tvStatus.setText("关");
                    MainActivity.isOpen = false;
                }
            }
        });

    }
}
