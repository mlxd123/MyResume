package com.example.myresume.network;


import com.example.myresume.Utils.SpUtils;
import com.example.myresume.base.MyApp;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * @author: Allen.
 * @date: 2018/7/25
 * @description:
 */

public class CookiesSaveInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Response originalResponse = chain.proceed(chain.request());
        if (!originalResponse.headers("Set-Cookie").isEmpty()) {
            String header = originalResponse.header("Set-Cookie");
            SpUtils.setString(MyApp.myApp, "cookiess", header);
        }
        return originalResponse;
    }

}
