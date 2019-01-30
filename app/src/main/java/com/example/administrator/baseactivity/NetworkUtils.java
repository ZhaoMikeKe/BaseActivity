package com.example.administrator.baseactivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

/**
 * 网络工具类
 * 判断当前网络状态工具类
 *
 * @author Su
 * @version [版本号，2016/12/28 10:45]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */

public class NetworkUtils {
    /**
     * 判断网络是否连接
     *
     * @param context 上下文
     * @return 返回值
     */
    public static boolean isNetworkConnected(Context context) {
        if (context != null) {
            //获取手机所有的连接管理对象（包括Wifi，net等的连接的管理）
            ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            // 获取NetworkInfo对象
            NetworkInfo networkInfo = manager.getActiveNetworkInfo();
            //判断networkInfo是否为空
            if (networkInfo != null) {
                return networkInfo.isAvailable();
            }
        }
        return false;
    }

    /**
     * 判断wifi网络是否可用
     *
     * @param context
     * @return
     */
    public static boolean isWifiConnected(Context context) {
        if (context != null) {
            ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = manager.getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
                return networkInfo.isAvailable();
            }
        }
        return false;
    }

    /**
     * 判断手机网络是否可用
     *
     * @param context
     * @return
     */
    public static boolean isMobileConnected(Context context) {
        if (context != null) {
            ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = manager.getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
                return networkInfo.isAvailable();
            }
        }
        return false;
    }

    /**
     * 返回当前网络连接类型信息
     * 状态结果在{@link ConnectivityManager} 中
     *
     * @param context
     * @return
     */
    public static int getConnectedType(Context context) {
        if (context != null) {
            ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = manager.getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.isAvailable()) {
                return networkInfo.getType();
            }
        }
        return -1;
    }

    /**
     * 返回当前网络连接状态
     *
     * @param context
     * @return
     */
    public static int getAPNType(Context context) {
        //结果返回值
        int netType = 0;
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        if (networkInfo == null) {
            //netWorkInfo对象为空，无网络
            return netType;
        }
        //netWorkInfo不为空，获取该netWorkInfo的类型
        if (networkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
            netType = 1;
        } else if (networkInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
            int subType = networkInfo.getSubtype();
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
            if (subType == TelephonyManager.NETWORK_TYPE_GPRS ||
                    subType == TelephonyManager.NETWORK_TYPE_EDGE ||
                    subType == TelephonyManager.NETWORK_TYPE_CDMA &&
                            !telephonyManager.isNetworkRoaming()) {
                netType = 2;
            } else if (subType == TelephonyManager.NETWORK_TYPE_UMTS ||
                    subType == TelephonyManager.NETWORK_TYPE_HSDPA ||
                    subType == TelephonyManager.NETWORK_TYPE_EVDO_0 &&
                            !telephonyManager.isNetworkRoaming()) {
                //3G 联通3G为UMTS或HSDPA 电信的3G为EVDO
                netType = 3;
            } else if (subType == TelephonyManager.NETWORK_TYPE_LTE &&
                    !telephonyManager.isNetworkRoaming()) {
                netType = 4;
            }
        }

        return netType;
    }



}
