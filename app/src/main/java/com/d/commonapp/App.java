package com.d.commonapp;

import android.app.Application;

import com.d.commonapp.api.API;
import com.d.lib.rxnet.RxNet;
import com.d.lib.rxnet.util.SSLUtil;

import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Application
 * Created by D on 2018/3/3.
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initRxNet();
    }

    private void initRxNet() {
        RxNet.init().baseUrl(API.API_BASE)
                .connectTimeout(10 * 1000)
                .readTimeout(10 * 1000)
                .writeTimeout(10 * 1000)
                .retryCount(3)
                .retryDelayMillis(2 * 1000)
                .sslSocketFactory(SSLUtil.getSslSocketFactory(null, null, null))
                .setLog("RetrofitLog Back = ", HttpLoggingInterceptor.Level.BODY)
                .build();
    }
}
