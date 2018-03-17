package com.d.commonapp.mvp.activity;

import com.d.commonapp.mvp.fragment.MFragment;
import com.d.lib.common.module.mvp.base.BaseFragmentActivity;

/**
 * MVP Demo/模版 - FragmentActivity
 * Created by D on 2017/1/5.
 */
public class MFragmentActivity extends BaseFragmentActivity {
    @Override
    protected int getLayoutRes() {
        //step 3-1: Xml布局
        return 0;
    }

    @Override
    protected void bindView() {
        super.bindView();
        //step 3-2: 通过@BindView/ViewHelper.findView(...)、ViewHelper.setOnClick(...)，绑定成员View变量及点击事件
    }

    @Override
    protected void init() {
        //step 3-3: 初始化操作...这里的逻辑在onCreate的最后执行
        MFragment fragment = new MFragment();
        getSupportFragmentManager().beginTransaction().replace(0, fragment).commitAllowingStateLoss();
    }
}
