package com.d.common.mvp.view;

import com.d.common.mvp.model.MModel;
import com.d.lib.common.component.mvp.MvpBaseView;

import java.util.List;

/**
 * MVP Demo/模版 - View
 * Created by D on 2017/7/13.
 */
public interface IMView extends MvpBaseView {
    void setData(List<MModel> datas);
}
