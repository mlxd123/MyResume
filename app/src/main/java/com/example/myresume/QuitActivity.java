package com.example.myresume;

import android.os.Bundle;

import com.example.myresume.base.BaseActivity;

import androidx.annotation.Nullable;

public class QuitActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        finish();
    }
}
