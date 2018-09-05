package com.d.lib.common.component.loader;

import android.content.Context;

import com.d.lib.common.component.mvp.MvpBasePresenter;

/**
 * 通用分页加载Presenter
 * Created by D on 2017/8/22.
 */
public class AbsPresenter<M> extends MvpBasePresenter<IAbsView<M>> {
    public AbsPresenter(Context context) {
        super(context);
    }
}
