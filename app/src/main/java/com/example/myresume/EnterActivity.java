package com.example.myresume;

import android.os.Bundle;
import android.widget.Toast;

import com.example.myresume.CustomView.EnterView;
import com.example.myresume.base.BaseActivity;
import com.example.myresume.model.EnterModel;
import com.example.myresume.presenter.EnterPresenter;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;

public class EnterActivity extends BaseActivity implements EnterView {
    //    app退出计时
    long appQuitTime = 0;
    EnterPresenter ePresenter;
    EnterModel eModel;
    @BindView(R.id.tab_enter)
    TabLayout tab;
    @BindView(R.id.vp_enter)
    ViewPager vp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter);
        ButterKnife.bind(this);
        ePresenter = new EnterPresenter(this);
        eModel = new EnterModel(this);

        bindData();
    }

    private void bindData() {
        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return ePresenter.getFragments().get(position);
            }

            @Override
            public int getCount() {
                return 2;
            }
        });
        tab.setupWithViewPager(vp);
        tab.getTabAt(0).setText("左边");
        tab.getTabAt(1).setText("右边");


    }


    @Override
    public void onBackPressed() {
        if (System.currentTimeMillis() - appQuitTime < 2000) {
            ePresenter.quitApp();
        }
        appQuitTime = System.currentTimeMillis();
        showToast(R.string.toast_quit);
    }

    @Override
    public void showToast(int resId) {
        Toast.makeText(EnterActivity.this, resId, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ePresenter.enterActivity = null;
        ePresenter = null;
    }
}
