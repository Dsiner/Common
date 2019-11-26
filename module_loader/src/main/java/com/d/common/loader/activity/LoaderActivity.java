package com.d.common.loader.activity;

import android.view.View;

import com.d.common.loader.R;
import com.d.common.loader.fragment.LoaderFragment;
import com.d.lib.common.component.mvp.MvpBasePresenter;
import com.d.lib.common.component.mvp.MvpView;
import com.d.lib.common.component.mvp.app.v4.BaseFragmentActivity;
import com.d.lib.common.util.ViewHelper;
import com.d.lib.common.view.TitleLayout;

/**
 * LoaderActivity
 * Created by D on 2018/3/3.
 */
public class LoaderActivity extends BaseFragmentActivity<MvpBasePresenter> implements View.OnClickListener {
    public TitleLayout tlTitle;

    @Override
    public MvpBasePresenter getPresenter() {
        return null;
    }

    @Override
    protected MvpView getMvpView() {
        return null;
    }

    @Override
    public void onClick(View v) {
        int resId = v.getId();
        if (resId == R.id.iv_title_left) {
            finish();
        }
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.lib_pub_activity_abs_content;
    }

    @Override
    protected void bindView() {
        super.bindView();
        tlTitle = ViewHelper.findView(this, R.id.tl_title);
        ViewHelper.setOnClick(this, this, R.id.iv_title_left);
    }

    @Override
    protected void init() {
        tlTitle.setText(R.id.tv_title_title, "Loader");
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_content, new LoaderFragment()).commitAllowingStateLoss();
    }
}
