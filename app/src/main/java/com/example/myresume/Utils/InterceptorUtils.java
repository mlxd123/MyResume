package com.example.myresume.Utils;

import okhttp3.logging.HttpLoggingInterceptor;

public class InterceptorUtils {
    public static HttpLoggingInterceptor LogInterceptor() {
        return new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                LogUtils.log("InterceptorUtils", message);
            }
        }).setLevel(HttpLoggingInterceptor.Level.BODY);//设置打印数据的级别
    }
}
