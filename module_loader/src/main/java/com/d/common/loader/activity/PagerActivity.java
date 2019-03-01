package com.d.common.loader.activity;

import android.support.v4.app.Fragment;

import com.d.common.loader.R;
import com.d.common.loader.fragment.LoaderLazyFragment;
import com.d.lib.common.component.loader.v4.AbsFragmentActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * PagerActivity
 * Created by D on 2018/3/3.
 */
public class PagerActivity extends AbsFragmentActivity {

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
