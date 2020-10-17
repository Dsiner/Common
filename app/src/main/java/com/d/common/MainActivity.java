package com.d.common;

import android.content.Intent;
import android.view.View;

import com.d.common.loader.activity.LoaderActivity;
import com.d.common.loader.activity.PagerActivity;
import com.d.common.mvp.MvpActivity;
import com.d.common.ui.UIActivity;
import com.d.lib.common.component.mvp.MvpBasePresenter;
import com.d.lib.common.component.mvp.MvpView;
import com.d.lib.common.component.mvp.app.BaseActivity;
import com.d.lib.common.util.ViewHelper;

public class MainActivity extends BaseActivity<MvpBasePresenter> implements MvpView, View.OnClickListener {

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_ui:
                startActivity(new Intent(MainActivity.this, UIActivity.class));
                break;
            case R.id.btn_mvp:
                startActivity(new Intent(MainActivity.this, MvpActivity.class));
                break;
            case R.id.btn_loader:
                startActivity(new Intent(MainActivity.this, LoaderActivity.class));
                break;
            case R.id.btn_pager:
                startActivity(new Intent(MainActivity.this, PagerActivity.class));
                break;
        }
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    public MvpBasePresenter getPresenter() {
        return new MvpBasePresenter(getApplicationContext());
    }

    @Override
    protected MvpView getMvpView() {
        return this;
    }

    @Override
    protected void bindView() {
        super.bindView();
        ViewHelper.setOnClickListener(this, this, R.id.btn_ui, R.id.btn_mvp, R.id.btn_loader,
                R.id.btn_pager);
    }

    @Override
    protected void init() {

    }
}
