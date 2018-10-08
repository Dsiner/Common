package com.d.common.loader.presenter;

import android.content.Context;

import com.d.common.loader.api.API;
import com.d.common.loader.model.LoaderInfo;
import com.d.common.loader.model.LoaderModel;
import com.d.lib.common.component.loader.AbsPresenter;
import com.d.lib.common.component.loader.CommonLoader;
import com.d.lib.rxnet.RxNet;
import com.d.lib.rxnet.base.Params;
import com.d.lib.rxnet.callback.SimpleCallback;

import java.util.ArrayList;

/**
 * Loader
 * Created by D on 2018/3/3.
 */
public class LoaderPresenter extends AbsPresenter<LoaderModel> {

    public LoaderPresenter(Context context) {
        super(context);
    }

    public void getData(int page) {
        Params params = new Params(API.MovieTop.rtpType);
        params.addParam(API.MovieTop.start, String.valueOf(CommonLoader.PAGE_COUNT * (page - 1)));
        params.addParam(API.MovieTop.count, String.valueOf(CommonLoader.PAGE_COUNT));

        RxNet.getDefault().get(API.MovieTop.rtpType, params)
                .request(new SimpleCallback<LoaderInfo>() {
                    @Override
                    public void onSuccess(LoaderInfo response) {
                        if (getView() == null) {
                            return;
                        }
                        if (response == null || response.subjects == null) {
                            getView().setData(new ArrayList<LoaderModel>());
                        } else {
                            getView().setData(response.subjects);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (getView() == null) {
                            return;
                        }
                        getView().loadError();
                    }
                });
    }
}
