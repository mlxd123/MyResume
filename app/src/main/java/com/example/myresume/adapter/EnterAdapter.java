package com.example.myresume.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.myresume.R;

import java.util.List;

public class EnterAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    List<String> sList;

    public EnterAdapter(List<String> data) {
        super(R.layout.item_tx, data);
        sList = data;
    }


    @Override
    protected void convert(BaseViewHolder baseViewHolder, String s) {


        baseViewHolder.setText(R.id.item_tv, "Item " + sList.get(baseViewHolder.getAdapterPosition()));

    }


}
