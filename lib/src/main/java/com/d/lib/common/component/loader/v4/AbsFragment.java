package com.d.lib.common.component.loader.v4;

import android.os.Bundle;
import android.view.View;

import com.d.lib.common.R;
import com.d.lib.common.component.loader.CommonLoader;
import com.d.lib.common.component.loader.IAbsView;
import com.d.lib.common.component.mvp.MvpBasePresenter;
import com.d.lib.common.component.mvp.app.v4.BaseFragment;
import com.d.lib.common.util.ViewHelper;
import com.d.lib.common.view.DSLayout;
import com.d.lib.xrv.XRecyclerView;
import com.d.lib.xrv.adapter.CommonAdapter;

import java.util.List;

/**
 * Auto-Loader - Fragment
 * Created by D on 2017/8/23.
 */
public abstract class AbsFragment<M, P extends MvpBasePresenter>
        extends BaseFragment<P>
        implements IAbsView<M>, View.OnClickListener {

    protected XRecyclerView mXrvList;
    protected CommonAdapter<M> mAdapter;
    protected CommonLoader<M> mCommonLoader;

    @Override
    public void onClick(View v) {
        int resId = v.getId();
        if (resId == R.id.btn_dsl) {
            getData();
        }
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.lib_pub_fragment_abs;
    }

    @Override
    protected int getDSLayoutRes() {
        return R.id.dsl_ds;
    }

    @Override
    protected void bindView(View rootView) {
        super.bindView(rootView);
        mXrvList = ViewHelper.findView(rootView, R.id.xrv_list);

        ViewHelper.setOnClick(rootView, this, R.id.btn_dsl);
    }

    @Override
    protected void init() {
        initList();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getData();
    }

    protected void initList() {
        mAdapter = getAdapter();
        mXrvList.showAsList();
        mXrvList.setAdapter(mAdapter);
        mCommonLoader = new CommonLoader<M>(mXrvList, mAdapter);
        // Number of data per page
        mCommonLoader.setPageCount(CommonLoader.PAGE_COUNT);
        mCommonLoader.setOnLoaderListener(new CommonLoader.OnLoaderListener() {
            @Override
            public void onRefresh() {
                onLoad(mCommonLoader.page);
            }

            @Override
            public void onLoadMore() {
                onLoad(mCommonLoader.page);
            }

            @Override
            public void loadSuccess() {
                mDslDs.setState(DSLayout.GONE);
                mXrvList.setVisibility(View.VISIBLE);
            }

            @Override
            public void noContent() {
                mDslDs.setState(DSLayout.STATE_EMPTY);
            }

            @Override
            public void loadError(boolean isEmpty) {
                mDslDs.setState(isEmpty ? DSLayout.STATE_NET_ERROR : DSLayout.GONE);
            }
        });
    }

    @Override
    public void getData() {
        mCommonLoader.page = 1;
        mXrvList.setVisibility(View.GONE);
        mDslDs.setState(DSLayout.STATE_LOADING);
        onLoad(mCommonLoader.page);
    }

    @Override
    public void setData(List<M> datas) {
        mCommonLoader.setData(datas);
    }

    @Override
    public void loadError() {
        mCommonLoader.loadError();
    }

    /**
     * Return the adapter
     */
    protected abstract CommonAdapter<M> getAdapter();

    /**
     * Auto call this func to load data...
     *
     * @param page: from 1 to ...
     */
    protected abstract void onLoad(int page);
}
