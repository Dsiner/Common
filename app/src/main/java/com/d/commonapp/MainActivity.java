package com.d.commonapp;

import android.content.Intent;
import android.view.View;

import com.d.common.component.ui.StatusActivity;
import com.d.commonapp.activity.LoaderActivity;
import com.d.commonapp.activity.PagerActivity;
import com.d.lib.common.module.mvp.MvpBasePresenter;
import com.d.lib.common.module.mvp.MvpView;
import com.d.lib.common.module.mvp.base.BaseActivity;

import butterknife.OnClick;

public class MainActivity extends BaseActivity<MvpBasePresenter> implements MvpView {

    @OnClick({R.id.btn_ui, R.id.btn_loader, R.id.btn_pager})
    public void onClickListener(View v) {
        switch (v.getId()) {
            case R.id.btn_ui:
                startActivity(new Intent(MainActivity.this, StatusActivity.class));
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
    protected void init() {

    }
}
