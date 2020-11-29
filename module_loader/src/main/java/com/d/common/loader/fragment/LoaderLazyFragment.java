package com.d.common.loader.fragment;

import com.d.common.loader.R;
import com.d.common.loader.adapter.LoaderAdapter;
import com.d.common.loader.model.LoaderModel;
import com.d.common.loader.presenter.LoaderPresenter;
import com.d.common.loader.view.ILoaderView;
import com.d.lib.common.component.loader.v4.BaseLazyLoaderFragment;
import com.d.lib.common.component.mvp.MvpView;
import com.d.lib.pulllayout.rv.adapter.CommonAdapter;

import java.util.ArrayList;

/**
 * Pager
 * Created by D on 2018/3/3.
 */
public class LoaderLazyFragment extends BaseLazyLoaderFragment<LoaderModel, LoaderPresenter> implements ILoaderView {

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
