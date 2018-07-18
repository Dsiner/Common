package com.d.common.component.mvp.activity;

import android.view.View;
import android.widget.TextView;

import com.d.common.component.mvp.R;
import com.d.common.component.mvp.model.MModel;
import com.d.common.component.mvp.presenter.MPresenter;
import com.d.common.component.mvp.view.IMView;
import com.d.lib.common.module.mvp.MvpView;
import com.d.lib.common.module.mvp.base.BaseActivity;
import com.d.lib.common.utils.ViewHelper;

import java.util.List;

/**
 * MVP Demo/模版 - Activity
 * Created by D on 2017/7/13.
 */
public class MActivity extends BaseActivity<MPresenter> implements IMView, View.OnClickListener {
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
        // Step 7-1: Xml布局
        return R.layout.lib_pub_activity_abs;
    }

    @Override
    public MPresenter getPresenter() {
        // Step 7-2: new Presenter实例，Context必须ApplicationContext，避免内存泄漏
        return new MPresenter(getApplicationContext());
    }

    @Override
    protected MvpView getMvpView() {
        // Step 7-3: 返回View给Presenter持有，this即本身
        return this;
    }

    @Override
    protected void bindView() {
        super.bindView();
        // Step 7-4: 通过@BindView/ViewHelper.findView(...)、ViewHelper.setOnClick(...)，绑定成员View变量及点击事件
        tvTitle = ViewHelper.findView(this, R.id.tv_title_title);

        ViewHelper.setOnClick(this, this, R.id.iv_title_left);
    }

    @Override
    protected void init() {
        // Step 7-5: View已绑定，初始化操作...这里的逻辑在onCreate的最后执行
        tvTitle.setText("Activity");

        // Presenter已绑定View，可以调用Presenter逻辑
        mPresenter.getData();
    }

    @Override
    public void setData(List<MModel> datas) {
        // Step 7-7: 处理返回的数据
    }
}
