package com.example.myresume.base;

import android.app.Application;

import com.example.myresume.Utils.InterceptorUtils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

public class MyApp extends Application {
    public static final int TIMEOUT = 60;
    public static MyApp myApp;
    private static OkHttpClient mOkHttpClient;

    /**
     * 全局httpclient
     *
     * @return
     */
    public static OkHttpClient initOKHttp() {
        if (mOkHttpClient == null) {
            mOkHttpClient = new OkHttpClient.Builder()
                    .connectTimeout(TIMEOUT, TimeUnit.SECONDS)//设置连接超时时间
                    .readTimeout(TIMEOUT, TimeUnit.SECONDS)//设置读取超时时间
                    .writeTimeout(TIMEOUT, TimeUnit.SECONDS)//设置写入超时时间
                    .addInterceptor(InterceptorUtils.LogInterceptor())//添加日志拦截器
                    //cookie
//                    .addInterceptor(new CookieReadInterceptor())
//                    .addInterceptor(new CookiesSaveInterceptor())
                    .build();
        }
        return mOkHttpClient;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        myApp = this;
    }


}
