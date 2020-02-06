package com.example.myresume.model;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;


public class EnterModel {
    public List<String> titles = new ArrayList<>();
    public List<String> items = new ArrayList<>();
    public Activity eActivity;

    public EnterModel() {
        initData();
    }

    public EnterModel(Activity activity) {
        eActivity = activity;
    }

    public void initData() {
        titles.add("左边");
        titles.add("右边");
        for (int i = 0; i < 10; i++) {
            items.add("第 " + i + " 项");
        }
    }
}
