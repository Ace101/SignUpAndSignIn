package com.example.zhangshihao.signupandsignin;

import android.bluetooth.BluetoothDevice;

public class BlueRxBean {

    public int id;
    public BluetoothDevice bluetoothDevice;

    public BlueRxBean(int id, BluetoothDevice bluetoothDevice) {
        this.id = id;
        this.bluetoothDevice = bluetoothDevice;
    }

    public BlueRxBean(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BluetoothDevice getBluetoothDevice() {
        return bluetoothDevice;
    }

    public void setBluetoothDevice(BluetoothDevice bluetoothDevice) {
        this.bluetoothDevice = bluetoothDevice;
    }
}
