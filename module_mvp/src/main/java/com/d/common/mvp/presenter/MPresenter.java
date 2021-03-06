package com.d.common.mvp.presenter;

import android.content.Context;

import androidx.annotation.NonNull;

import com.d.common.mvp.model.MModel;
import com.d.common.mvp.view.IMView;
import com.d.lib.common.component.mvp.MvpBasePresenter;
import com.d.lib.common.widget.DSLayout;
import com.d.lib.taskscheduler.TaskScheduler;
import com.d.lib.taskscheduler.callback.Observer;
import com.d.lib.taskscheduler.callback.Task;
import com.d.lib.taskscheduler.schedule.Schedulers;

import java.util.ArrayList;
import java.util.List;

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
        // Step 7-6: Presenter逻辑: 网络请求
        TaskScheduler.create(new Task<List<MModel>>() {
            @Override
            public List<MModel> run() {
                // Do some thing e.g network requests in io thread...
                return new ArrayList<>();
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(Schedulers.mainThread())
                .subscribe(new Observer<List<MModel>>() {
                    @Override
                    public void onNext(@NonNull List<MModel> datas) {
                        if (getView() == null) {
                            // Activity 生命周期结束，不可回调回此activity，可执行非此activity操作
                            return;
                        }
                        // Activity 生命周期内
                        getView().setData(datas);
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (getView() == null) {
                            // Activity 生命周期结束，不可回调回此activity，可执行非此activity操作
                            return;
                        }
                        // Activity 生命周期内
                        getView().setState(DSLayout.STATE_NET_ERROR);
                    }
                });
    }
}
