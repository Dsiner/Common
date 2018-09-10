package com.d.common.loader.fragment;

import com.d.common.loader.R;
import com.d.common.loader.adapter.LoaderAdapter;
import com.d.common.loader.model.LoaderModel;
import com.d.common.loader.presenter.LoaderPresenter;
import com.d.common.loader.view.ILoaderView;
import com.d.lib.common.component.loader.AbsFragment;
import com.d.lib.common.component.mvp.MvpView;
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
        return new LoaderAdapter(mContext, new ArrayList<LoaderModel>(), R.layout.module_loader_adapter_loader);
    }

    @Override
    protected void onLoad(int page) {
        mPresenter.getData(page);
    }
}
