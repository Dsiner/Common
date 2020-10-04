package com.d.lib.common.component.loader;

import com.d.lib.common.component.mvp.MvpBaseView;

import java.util.List;

/**
 * Auto-Loader - IView
 * Created by D on 2017/8/22.
 */
public interface IAbsView<T> extends MvpBaseView {
    void getData();

    void loadSuccess(List<T> datas);

    void loadError();
}
