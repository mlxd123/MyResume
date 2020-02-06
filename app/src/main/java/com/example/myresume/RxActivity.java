package com.example.myresume;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.myresume.Utils.RetrofitUtil;
import com.example.myresume.base.BaseActivity;
import com.example.myresume.base.BaseObserver;
import com.example.myresume.base.BaseResp;
import com.example.myresume.bean.Menu;

import java.util.HashMap;

import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class RxActivity extends BaseActivity {

    @BindView(R.id.btn_rx)
    Button btnRx;
    @BindView(R.id.tv1_rx)
    TextView tv1Rx;

    HashMap<String, String> map;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxj);
        ButterKnife.bind(this);
        map = new HashMap<>();
        map.put("key", "7c5e20da8459bd20addb2c5edc5c39aa");
        map.put("id", "1001");


    }


    @OnClick(R.id.btn_rx)
    public void onViewClicked() {

        RetrofitUtil.getInstance().initRetrofit().getCook(map).
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<Menu>(this, "      ") {

                    @Override
                    protected void onSuccees(BaseResp<Menu> t) throws Exception {

                        tv1Rx.setText(t.getResult().getData().get(0).toString());
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {

                    }
                });


    }
}
