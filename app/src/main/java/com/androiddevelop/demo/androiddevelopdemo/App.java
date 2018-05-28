package com.androiddevelop.demo.androiddevelopdemo;

import android.app.Application;

/**
 * @ Creator     :     chenchao
 * @ CreateDate  :     2018/5/28 0028 14:43
 * @ Description :     AndroidDevelopDemo
 */

public class App extends Application {
    private static volatile App application;

    public static App getInstance(){
        return application;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        application=this;
    }
}
