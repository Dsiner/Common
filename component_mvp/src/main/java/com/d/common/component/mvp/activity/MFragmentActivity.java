package com.d.common.component.mvp.activity;

import android.view.View;
import android.widget.TextView;

import com.d.common.component.mvp.R;
import com.d.common.component.mvp.fragment.MFragment;
import com.d.lib.common.module.mvp.base.BaseFragmentActivity;
import com.d.lib.common.utils.ViewHelper;

/**
 * MVP Demo/模版 - FragmentActivity
 * Created by D on 2017/1/5.
 */
public class MFragmentActivity extends BaseFragmentActivity implements View.OnClickListener {
    private TextView tvTitle;

    @Override
    public void onClick(View v) {
        int resId = v.getId();
        if (resId == R.id.iv_title_left) {
            finish();
        }
    }

    @Override
    protected int getLayoutRes() {
        // Step 3-1: Xml布局
        return R.layout.lib_pub_activity_abs_content;
    }

    @Override
    protected void bindView() {
        super.bindView();
        // Step 3-2: 通过@BindView/ViewHelper.findView(...)、ViewHelper.setOnClick(...)，绑定成员View变量及点击事件
        tvTitle = ViewHelper.findView(this, R.id.tv_title_title);

        ViewHelper.setOnClick(this, this, R.id.iv_title_left);
    }

    @Override
    protected void init() {
        // Step 3-3: 初始化操作...这里的逻辑在onCreate的最后执行
        tvTitle.setText("FragmentActivity");

        MFragment fragment = new MFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_content, fragment).commitAllowingStateLoss();
    }
}
