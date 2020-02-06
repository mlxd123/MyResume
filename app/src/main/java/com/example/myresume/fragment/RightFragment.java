package com.example.myresume.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myresume.R;
import com.example.myresume.adapter.EnterAdapter;
import com.example.myresume.bean.EventBusMessage;
import com.example.myresume.model.EnterModel;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class RightFragment extends Fragment {
    View rootView;
    @BindView(R.id.rv_frag)
    RecyclerView rvFrag;
    EnterModel enterModel;
    private EnterAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.frag_enter_rv, container, false);
        }
        ButterKnife.bind(this, rootView);
        EventBus.getDefault().register(this);
        enterModel = new EnterModel();
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        rvFrag.setLayoutManager(linearLayoutManager);
        adapter = new EnterAdapter(enterModel.items);
        rvFrag.setAdapter(adapter);
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onMessageEvent(EventBusMessage msg) {
        enterModel.items.add(0, msg.getMessage());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
    }
}
