package com.example.administrator.baseactivity;

import android.app.Application;

public class App extends Application {
    public static App mApp;
    private LogUtils.Config config;

    public App() {

    }

    @Override
    public void onCreate() {

        super.onCreate();
        mApp = this;
        config = LogUtils.getConfig();
        config.setLogSwitch(true);
        config.setGlobalTag("myApp");
        config.setConsoleSwitch(true);
        config.setLog2FileSwitch(true);
    }

}
