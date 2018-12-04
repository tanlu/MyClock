package com.bwei.myclock;

import android.app.Application;
import android.content.Intent;
import android.content.IntentFilter;

/**
 * Created by gjl on 2018/12/2.
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_SCREEN_ON);
        intentFilter.addAction(Intent.ACTION_SCREEN_OFF);
        OnReciever onReciever = new OnReciever();
        registerReceiver(onReciever,intentFilter);


    }
}
