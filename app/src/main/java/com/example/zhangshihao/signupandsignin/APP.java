package com.example.zhangshihao.signupandsignin;

import android.app.Application;
import android.bluetooth.BluetoothSocket;
import android.content.Context;

public class APP extends Application {

    //不管是蓝牙连接方还是服务器方，得到socket对象后都传入
    public static BluetoothSocket bluetoothSocket;
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
//        com.orhanobut.logger.Logger.init();
    }


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }
}
