package com.example.myresume.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.example.myresume.R;
import com.example.myresume.RxActivity;
import com.example.myresume.Utils.LogUtils;
import com.example.myresume.adapter.EnterAdapter;
import com.example.myresume.bean.EventBusMessage;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class LeftFragment extends Fragment {
    View rootView;
    @BindView(R.id.rv_frag)
    RecyclerView rv;
    int touchCount = 0;
    ArrayList<String> sList;
    Unbinder ub;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.frag_enter_rv, container, false);
        }
        ub = ButterKnife.bind(this, rootView);
        sList = new ArrayList<>();
        sList.add("eventBus");
        sList.add("rxjava+retrofit2+okhttp");
        sList.add("2");
        sList.add("3");
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        rv.setLayoutManager(linearLayoutManager);
        EnterAdapter adapter = new EnterAdapter(sList);
        adapter.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                LogUtils.log("------------------", "  " + position);
                switch (position) {
                    case 0:
                        EventBus.getDefault().post(new EventBusMessage("点了 " + touchCount++ + " 次"));
                        break;
                    case 1:
                        getActivity().startActivity(new Intent(getActivity(), RxActivity.class));
                        break;
                }
            }
        });
        rv.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ub.unbind();
    }
}
