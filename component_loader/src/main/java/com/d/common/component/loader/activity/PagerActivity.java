package com.d.common.component.loader.activity;

import android.support.v4.app.Fragment;

import com.d.common.component.loader.R;
import com.d.common.component.loader.fragment.LoaderLazyFragment;
import com.d.lib.common.module.loader.AbsFragmentActivity;

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
        tlTitle.setText(R.id.tv_title_title, "Pager");
    }
}
