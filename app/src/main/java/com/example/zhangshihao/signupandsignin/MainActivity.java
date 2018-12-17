package com.example.zhangshihao.signupandsignin;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.et_psw)
    EditText etPsw;
    @BindView(R.id.btn_sign_in)
    Button btnSignIn;
    @BindView(R.id.btn_sign_up)
    TextView btnSignUp;

    SharedPreferences userPswSettings;
    SharedPreferences.Editor editor;

    static boolean isOpen = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        userPswSettings = getSharedPreferences("setting", 0);

    }

    @OnClick({R.id.btn_sign_in, R.id.btn_sign_up})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_sign_in:
                if (!userPswSettings.contains(etName.getText().toString())) {
                    Toast.makeText(MainActivity.this, "该用户不存在", Toast.LENGTH_LONG).show();
                } else {
                    if (!userPswSettings.getString(etName.getText().toString(), "").equals(etPsw.getText().toString())) {
                        Toast.makeText(MainActivity.this, "密码错误", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(MainActivity.this, ActionsActivity.class));
                    }
                }
                break;
            case R.id.btn_sign_up:
                startActivity(new Intent(MainActivity.this, SingUpActivity.class));
                break;
        }
    }
}
