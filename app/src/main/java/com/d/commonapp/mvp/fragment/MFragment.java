package com.d.commonapp.mvp.fragment;

import android.os.Bundle;
import android.view.View;

import com.d.commonapp.mvp.presenter.MPresenter;
import com.d.commonapp.mvp.view.IMView;
import com.d.lib.common.module.mvp.MvpView;
import com.d.lib.common.module.mvp.base.BaseFragment;

/**
 * MVP Demo/模版 - Fragment
 * Created by D on 2017/7/13.
 */
public class MFragment extends BaseFragment<MPresenter> implements IMView {

    @Override
    protected int getLayoutRes() {
        //step 7-1: Xml布局
        return 0;
    }

    @Override
    public MPresenter getPresenter() {
        //step 7-2: new Presenter实例，Context必须ApplicationContext，避免内存泄漏
        return new MPresenter(getActivity().getApplicationContext());
    }

    @Override
    protected MvpView getMvpView() {
        //step 7-3: 返回View给Presenter持有，this即本身
        return this;
    }

    @Override
    protected void bindView(View rootView) {
        super.bindView(rootView);
        //step 7-4: 通过ViewHelper.findView(...)、ViewHelper.setOnClick(...)，绑定成员View变量及点击事件
    }

    @Override
    protected void init() {
        //step 7-5: View已绑定，初始化操作...这里的逻辑在onCreate的最后执行
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //step 7-5: Presenter已绑定View，可以调用Presenter逻辑
        mPresenter.getData();
    }

    @Override
    public void setData() {
        //step 7-7: 处理返回的数据
    }
}
