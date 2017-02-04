package com.example.sunnick.shake;

import android.app.Activity;
import android.app.Service;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Sunnick on 2017/2/4.
 */

public abstract class BaseActivity extends Activity implements Shakeable{
    //传感器管理器
    private SensorManager manager;

    //传感器监听器
    private MySensorEventListener listener;

    //是否可摇一摇，如果某些页面不想处理摇一摇，则设置为false
    private boolean isShakeable = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        manager = (SensorManager) this.getSystemService(Service.SENSOR_SERVICE);
        listener = new MySensorEventListener(this);
    }

    protected void onResume(){
        super.onResume();
        manager.registerListener(listener,
                    manager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                    SensorManager.SENSOR_DELAY_NORMAL);

    }

    //摇一摇的回调方法
    public void onShake(Object... objs){
        if(isShakeable) {
            float[] values = (float[]) objs[0];
            Toast.makeText(this, "x:" + values[0] + ",y:" + values[1] + ",z:" + values[2], Toast.LENGTH_SHORT).show();
        }
    }

    //如果某个页面不想处理摇一摇事件，将isShakeable设置为false即可
    protected void setShakeable(boolean isShakeable){
        this.isShakeable = isShakeable;
    }

}
