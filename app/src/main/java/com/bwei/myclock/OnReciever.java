package com.bwei.myclock;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.WindowManager;

/**
 * Created by gjl on 2018/12/2.
 */

public class OnReciever extends BroadcastReceiver {
    private static final String TAG = "OnReciever----";

    @Override
    public void onReceive(Context context, Intent intent) {
        
        switch (intent.getAction()) {
            case Intent.ACTION_SCREEN_OFF:
//                context.getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
                intent.setClass(context,MainActivity.class);
                intent.addFlags(Intent.FLAG_RECEIVER_NO_ABORT);
                context.startActivity(intent);

                Log.d(TAG, "onReceive: 关闭");
                
                break;

            case Intent.ACTION_SCREEN_ON:
                Log.d(TAG, "onReceive: kaiqi ");
                break;
        }
    }
}
