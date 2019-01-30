package com.example.administrator.baseactivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;




/**
 * Created by zhaoke on 2018/4/25.
 */

public class NetWorkStateReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

            if (NetworkUtils.isNetworkConnected(context)) {

                //Toast.makeText(context, "网络已连接。", Toast.LENGTH_LONG).show();
            } else {

                Toast.makeText(context, "网络已断开。", Toast.LENGTH_LONG).show();
            }
        }

}
