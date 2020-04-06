package com.d.lib.common.component.mvp.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Window;

import com.d.lib.common.component.mvp.MvpBasePresenter;
import com.d.lib.common.component.mvp.MvpBaseView;
import com.d.lib.common.component.mvp.MvpView;
import com.d.lib.common.component.statusbarcompat.StatusBarCompat;
import com.d.lib.common.util.keyboard.KeyboardHelper;
import com.d.lib.common.view.DSLayout;
import com.d.lib.common.view.dialog.AlertDialogFactory;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * BaseActivity
 * Created by D on 2017/4/27.
 */
public abstract class BaseActivity<T extends MvpBasePresenter>
        extends Activity implements MvpBaseView {

    protected Context mContext;
    protected Activity mActivity;
    protected T mPresenter;
    protected DSLayout mDslDs;
    private Dialog mLoadingDlg;
    private Unbinder mUnbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        mActivity = this;
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        StatusBarCompat.changeStatusBar(this, StatusBarCompat.STYLE_MAIN);
        setContentView(getLayoutRes());
        if (getDSLayoutRes() != 0) {
            mDslDs = (DSLayout) findViewById(getDSLayoutRes());
        }
        bindView();
        mUnbinder = ButterKnife.bind(this);
        mPresenter = getPresenter();
        if (mPresenter != null) {
            mPresenter.attachView(getMvpView());
        }
        init();
    }

    @Override
    public void finish() {
        KeyboardHelper.hideKeyboard(this);
        super.finish();
    }

    @Override
    protected void onDestroy() {
        if (mPresenter != null) {
            mPresenter.detachView(false);
        }
        if (mUnbinder != null) {
            mUnbinder.unbind();
            mUnbinder = null;
        }
        super.onDestroy();
    }

    @Override
    public void setState(int state) {
        if (mDslDs != null) {
            mDslDs.setState(state);
        }
    }

    @Override
    public void showLoading() {
        if (mLoadingDlg == null) {
            mLoadingDlg = AlertDialogFactory.createFactory(mContext).getLoadingDialog();
        }
        if (!mLoadingDlg.isShowing()) {
            mLoadingDlg.show();
        }
    }

    @Override
    public void closeLoading() {
        if (mLoadingDlg != null && mLoadingDlg.isShowing()) {
            mLoadingDlg.dismiss();
        }
    }

    /**
     * Return the layout resource like R.layout.my_layout
     *
     * @return the layout resource or zero ("0"), if you don't want to have an UI
     */
    protected abstract int getLayoutRes();

    /**
     * Return the resId resource like R.id.dsl_ds
     *
     * @return the resId resource or zero ("0"), if you don't want to have an DSLayout
     */
    protected int getDSLayoutRes() {
        return 0;
    }

    public abstract T getPresenter();

    protected abstract MvpView getMvpView();

    protected void bindView() {
    }

    protected abstract void init();
}
