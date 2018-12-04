package com.bwei.myclock;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private CommenUtils commenUtils;
    private TextView main_tv;
    private OnReciever onReciever;
    private PowerManager.WakeLock mWakelock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        main_tv = findViewById(R.id.main_time);
        commenUtils = CommenUtils.getCommenUtils();

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                final String currentTime = commenUtils.getCurrentTime(MainActivity.this);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        main_tv.setText(currentTime);
                    }
                });

            }
        }, 0, 1000);

//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        PowerManager pm = (PowerManager)getSystemService(POWER_SERVICE);// init powerManager
        mWakelock = pm.newWakeLock(PowerManager.ACQUIRE_CAUSES_WAKEUP |
                PowerManager.SCREEN_DIM_WAKE_LOCK, "target");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mWakelock.acquire();
    }
}
