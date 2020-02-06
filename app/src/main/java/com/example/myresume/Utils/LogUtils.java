package com.example.myresume.Utils;

import android.util.Log;

public class LogUtils {
    private final static boolean isDebugging = true;

    public static void log(String tag, String msg) {
        if (isDebugging) {
            Log.i(tag, msg);
        }
    }

}
