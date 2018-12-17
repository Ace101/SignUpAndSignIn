package com.example.zhangshihao.signupandsignin;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SingUpActivity extends AppCompatActivity {

    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.et_psw)
    EditText etPsw;
    @BindView(R.id.et_psw_2)
    EditText etPsw2;
    @BindView(R.id.btn_sign_up)
    Button btnSignUp;

    SharedPreferences userSettings;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);

        userSettings = getSharedPreferences("setting", 0);
        editor = userSettings.edit();

    }

    @OnClick(R.id.btn_sign_up)
    public void onViewClicked() {
        if (TextUtils.isEmpty(etName.getText().toString())) {
            Toast.makeText(SingUpActivity.this, "用户名不能为空", Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(etPsw.getText().toString()) || TextUtils.isEmpty(etPsw2.getText().toString())) {
            Toast.makeText(SingUpActivity.this, "密码不能为空", Toast.LENGTH_LONG).show();
            return;
        }

        if (!TextUtils.equals(etPsw.getText().toString(), etPsw2.getText().toString())) {
            Toast.makeText(SingUpActivity.this, "两次输入密码不一致", Toast.LENGTH_LONG).show();
            return;
        }

        if (userSettings.contains(etName.getText().toString())){
            Toast.makeText(SingUpActivity.this, "该用户已存在", Toast.LENGTH_LONG).show();
            return;
        }
        editor.putString(etName.getText().toString(), etPsw.getText().toString());
        editor.commit();

        Toast.makeText(SingUpActivity.this, "注册成功！", Toast.LENGTH_LONG).show();
        finish();
    }
}
