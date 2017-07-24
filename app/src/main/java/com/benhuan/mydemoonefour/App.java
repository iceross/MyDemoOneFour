package com.benhuan.mydemoonefour;

import android.app.Application;

import com.benhuan.imageloader.ImageLoaderManager;

/**
 * Created by XieMinFeng.
 * Date: 2017-07-17
 * Time: 10:47
 * Desc:
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ImageLoaderManager.getInstance().init(this);
    }
}
