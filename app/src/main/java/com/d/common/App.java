package com.d.common;

import android.app.Application;

import com.d.common.loader.api.API;
import com.d.lib.aster.Aster;
import com.d.lib.aster.base.Config;
import com.d.lib.aster.util.SSLUtils;
import com.d.lib.common.component.network.NetworkBus;
import com.d.lib.common.component.network.NetworkCompat;
import com.d.lib.common.util.NetworkUtils;
import com.d.lib.common.util.log.ULog;

/**
 * Application
 * Created by D on 2018/3/3.
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ULog.setDebug(BuildConfig.DEBUG, "ULog");
        initAster();
        initNetwork();
    }

    private void initAster() {
        Aster.init()
                .baseUrl(API.API_BASE)
                .connectTimeout(10 * 1000)
                .readTimeout(10 * 1000)
                .writeTimeout(10 * 1000)
                .retryCount(0)
                .retryDelayMillis(3 * 1000)
                .sslSocketFactory(SSLUtils.getSslSocketFactory(null, null, null))
                .log("AsterLog Back = ", Config.Level.BODY)
                .debug(true)
                .build();
    }

    private void initNetwork() {
        NetworkCompat.init(this);
        NetworkBus.getInstance().addListener(new NetworkBus.OnNetworkTypeChangeListener() {
            @Override
            public void onNetworkTypeChange(NetworkUtils.NetworkType networkType) {
                ULog.d("onNetworkTypeChange: " + networkType);
            }
        });
    }
}
