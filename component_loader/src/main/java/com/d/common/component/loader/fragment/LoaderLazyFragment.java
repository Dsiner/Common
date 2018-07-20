package com.d.common.component.loader.fragment;

import com.d.common.component.loader.R;
import com.d.common.component.loader.adapter.LoaderAdapter;
import com.d.common.component.loader.model.LoaderModel;
import com.d.common.component.loader.presenter.LoaderPresenter;
import com.d.common.component.loader.view.ILoaderView;
import com.d.lib.common.module.loader.AbsLazyFragment;
import com.d.lib.common.module.mvp.MvpView;
import com.d.lib.xrv.adapter.CommonAdapter;

import java.util.ArrayList;

/**
 * Pager
 * Created by D on 2018/3/3.
 */
public class LoaderLazyFragment extends AbsLazyFragment<LoaderModel, LoaderPresenter> implements ILoaderView {

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
        return new LoaderAdapter(mContext, new ArrayList<LoaderModel>(), R.layout.component_loader_adapter_loader);
    }

    @Override
    protected void onLoad(int page) {
        mPresenter.getData(page);
    }
}
