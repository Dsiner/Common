package com.d.commonapp.mvp.presenter;

import android.content.Context;

import com.d.commonapp.mvp.view.IMView;
import com.d.lib.common.module.mvp.MvpBasePresenter;

/**
 * MVP Demo/模版 - Presenter
 * Created by D on 2017/7/13.
 */
public class MPresenter extends MvpBasePresenter<IMView> {

    public MPresenter(Context context) {
        super(context);
    }

    /**
     * 网络请求 例子
     */
    public void getData() {
        //step 7-6: Presenter逻辑: 网络请求
        new Thread(new Runnable() {
            @Override
            public void run() {
                //do some thing e.g network requests...
                if (getView() == null) {
                    //activity 生命周期结束，不可回调回此activity，可执行非此activity操作
                    return;
                }
                //activity 生命周期内
                getView().setData();
            }
        }).start();
    }
}
