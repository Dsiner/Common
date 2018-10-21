package com.d.lib.common.module.receiver.netstate;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

/**
 * NetChangeReceiver
 * Created by D on 2017/5/28.
 */
public class NetChangeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        resetNetStatus(context);
    }

    /**
     * 重置当前网络状态
     */
    public static void resetNetStatus(Context context) {
        int networkType = getNetworkType(context);
        switch (networkType) {
            case 1:
                if (NetState.NET_STATUS != NetState.UN_CONNECTED) {
                    NetState.NET_STATUS = NetState.UN_CONNECTED;
                    NetBus.getInstance().onNetChange(NetState.UN_CONNECTED);
                }
                break;
            case 2:
            case 4:
                if (NetState.NET_STATUS != NetState.CONNECTED_MOBILE) {
                    NetState.NET_STATUS = NetState.CONNECTED_MOBILE;
                    NetBus.getInstance().onNetChange(NetState.CONNECTED_MOBILE);
                }
                break;
            case 3:
                if (NetState.NET_STATUS != NetState.CONNECTED_WIFI) {
                    NetState.NET_STATUS = NetState.CONNECTED_WIFI;
                    NetBus.getInstance().onNetChange(NetState.CONNECTED_WIFI);
                }
                break;
            default:
                if (NetState.NET_STATUS != NetState.NO_AVAILABLE) {
                    NetState.NET_STATUS = NetState.NO_AVAILABLE;
                    NetBus.getInstance().onNetChange(NetState.NO_AVAILABLE);
                }
                break;
        }
    }

    /**
     * 判断当前网络类型-1为未知网络0为没有网络连接1网络断开或关闭2为以太网3为WiFi4为2G5为3G6为4G
     */
    public static int getNetworkType(Context context) {
        ConnectivityManager connectMgr = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectMgr.getActiveNetworkInfo();
        if (networkInfo == null) {
            /** 没有任何网络 */
            return 0;
        }
        if (!networkInfo.isConnected()) {
            /** 网络断开或关闭 */
            return 1;
        }
        if (networkInfo.getType() == ConnectivityManager.TYPE_ETHERNET) {
            /** 以太网网络 */
            return 2;
        } else if (networkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
            /** wifi网络，当激活时，默认情况下，所有的数据流量将使用此连接 */
            return 3;
        } else if (networkInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
            /** 移动数据连接,不能与连接共存,如果wifi打开，则自动关闭 */
            switch (networkInfo.getSubtype()) {
                case TelephonyManager.NETWORK_TYPE_GPRS:
                case TelephonyManager.NETWORK_TYPE_EDGE:
                case TelephonyManager.NETWORK_TYPE_CDMA:
                case TelephonyManager.NETWORK_TYPE_1xRTT:
                case TelephonyManager.NETWORK_TYPE_IDEN:
                    /** 2G网络 */
                case TelephonyManager.NETWORK_TYPE_UMTS:
                case TelephonyManager.NETWORK_TYPE_EVDO_0:
                case TelephonyManager.NETWORK_TYPE_EVDO_A:
                case TelephonyManager.NETWORK_TYPE_HSDPA:
                case TelephonyManager.NETWORK_TYPE_HSUPA:
                case TelephonyManager.NETWORK_TYPE_HSPA:
                case TelephonyManager.NETWORK_TYPE_EVDO_B:
                case TelephonyManager.NETWORK_TYPE_EHRPD:
                case TelephonyManager.NETWORK_TYPE_HSPAP:
                    /** 3G网络 */
                case TelephonyManager.NETWORK_TYPE_LTE:
                    /** 4G网络 */
                    return 4;
            }
        }
        /** 未知网络 */
        return -1;
    }
}
