package com.d.common.loader.activity;

import android.support.v4.app.Fragment;

import com.d.common.loader.R;
import com.d.common.loader.fragment.LoaderLazyFragment;
import com.d.lib.common.component.loader.v4.AbsPageFragmentActivity;
import com.d.lib.common.component.mvp.MvpBasePresenter;
import com.d.lib.common.component.mvp.MvpView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * PagerActivity
 * Created by D on 2018/3/3.
 */
public class PagerActivity extends AbsPageFragmentActivity<MvpBasePresenter> {

    @Override
    public MvpBasePresenter getPresenter() {
        return null;
    }

    @Override
    protected MvpView getMvpView() {
        return null;
    }

    @Override
    protected List<String> getTitles() {
        return Arrays.asList("TITLE0", "TITLE1", "TITLE2", "TITLE3");
    }

    @Override
    protected List<Fragment> getFragments() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new LoaderLazyFragment());
        fragments.add(new LoaderLazyFragment());
        fragments.add(new LoaderLazyFragment());
        fragments.add(new LoaderLazyFragment());
        return fragments;
    }

    @Override
    protected void init() {
        super.init();
        mTlTitle.setText(R.id.tv_title_title, "Pager");
    }
}
