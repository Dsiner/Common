package com.d.common.component.mvp.view;

import com.d.common.component.mvp.model.MModel;
import com.d.lib.common.component.mvp.MvpView;

import java.util.List;

/**
 * MVP Demo/模版 - View
 * Created by D on 2017/7/13.
 */
public interface IMView extends MvpView {
    void setData(List<MModel> datas);
}
