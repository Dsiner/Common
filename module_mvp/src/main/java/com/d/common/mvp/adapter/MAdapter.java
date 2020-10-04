package com.d.common.mvp.adapter;

import android.content.Context;

import com.d.common.mvp.model.MModel;
import com.d.lib.pulllayout.rv.adapter.CommonAdapter;
import com.d.lib.pulllayout.rv.adapter.CommonHolder;

import java.util.List;

/**
 * MVP Demo/模版 - Adapter
 * Created by D on 2017/1/5.
 */
public class MAdapter extends CommonAdapter<MModel> {

    public MAdapter(Context context, List<MModel> datas, int layoutId) {
        super(context, datas, layoutId);
    }

    @Override
    public void convert(int position, CommonHolder holder, MModel item) {

    }
}
