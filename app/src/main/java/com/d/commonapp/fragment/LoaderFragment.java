package com.d.commonapp.fragment;

import com.d.commonapp.R;
import com.d.commonapp.adapter.LoaderAdapter;
import com.d.commonapp.model.LoaderModel;
import com.d.commonapp.presenter.LoaderPresenter;
import com.d.commonapp.view.ILoaderView;
import com.d.lib.common.module.loader.AbsFragment;
import com.d.lib.common.module.mvp.MvpView;
import com.d.lib.xrv.adapter.CommonAdapter;

import java.util.ArrayList;

/**
 * Loader
 * Created by D on 2018/3/3.
 */
public class LoaderFragment extends AbsFragment<LoaderModel, LoaderPresenter> implements ILoaderView {

    @Override
    public LoaderPresenter getPresenter() {
        return new LoaderPresenter(getActivity().getApplicationContext());
    }

    @Override
    protected MvpView getMvpView() {
        return this;
    }

    @Override
    protected CommonAdapter<LoaderModel> getAdapter() {
        return new LoaderAdapter(mContext, new ArrayList<LoaderModel>(), R.layout.adapter_loader);
    }

    @Override
    protected void onLoad(int page) {
        mPresenter.getData(page);
    }
}
