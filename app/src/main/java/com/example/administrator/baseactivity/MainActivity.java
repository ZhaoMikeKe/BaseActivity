package com.example.administrator.baseactivity;

import android.nfc.Tag;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.File;
import java.text.SimpleDateFormat;

public class MainActivity extends BaseActivity {
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat df1 = new SimpleDateFormat("HH:mm");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LogUtils.getConfig().setDir(new File(Environment.getExternalStorageDirectory().getPath() + "/myLogZ/" + TAG + "/" + df.format(System.currentTimeMillis()) + "/" + df1.format(System.currentTimeMillis())));
        LogUtils.d("zhaohulun");
    }
}
