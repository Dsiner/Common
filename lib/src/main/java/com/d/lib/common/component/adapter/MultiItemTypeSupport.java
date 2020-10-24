package com.d.lib.common.component.adapter;

/**
 * MultiItemTypeSupport for RecyclerView
 * Created by D on 2017/4/25.
 */
public interface MultiItemTypeSupport<T> {
    int getItemViewType(int position, T t);

    int getLayoutId(int viewType);
}
