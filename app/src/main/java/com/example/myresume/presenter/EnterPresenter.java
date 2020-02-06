package com.example.myresume.presenter;

import android.content.Intent;

import com.example.myresume.CustomView.EnterView;
import com.example.myresume.EnterActivity;
import com.example.myresume.QuitActivity;
import com.example.myresume.fragment.LeftFragment;
import com.example.myresume.fragment.RightFragment;
import com.example.myresume.model.EnterModel;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;

public class EnterPresenter {
    public EnterActivity enterActivity;
    public EnterModel eModel;
    List<Fragment> fragments = new ArrayList<>();

    public EnterPresenter(EnterView view) {
        enterActivity = (EnterActivity) view;
        eModel = new EnterModel();
        initFragments();
    }

    public List<Fragment> getFragments() {
        return fragments;
    }

    public void quitApp() {

        Intent quitIntent = new Intent(enterActivity, QuitActivity.class);
//                双flag 新栈+清栈退出
        quitIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        enterActivity.startActivity(quitIntent);
    }

    public void initFragments() {
        fragments.add(new LeftFragment());
        fragments.add(new RightFragment());

    }


}
