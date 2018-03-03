package com.d.commonapp.activity;

import android.view.View;

import com.d.commonapp.R;
import com.d.commonapp.fragment.LoaderFragment;
import com.d.lib.common.module.mvp.base.BaseFragmentActivity;
import com.d.lib.common.view.TitleLayout;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * LoaderActivity
 * Created by D on 2018/3/3.
 */
public class LoaderActivity extends BaseFragmentActivity {
    @BindView(R.id.tl_title)
    public TitleLayout tlTitle;

    @OnClick({R.id.iv_title_left})
    public void onClickListener(View v) {
        switch (v.getId()) {
            case R.id.iv_title_left:
                finish();
                break;
        }
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.lib_pub_activity_abs_content;
    }

    @Override
    protected void init() {
        tlTitle.setText(R.id.tv_title_title, "Loader");
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_content, new LoaderFragment()).commitAllowingStateLoss();
    }
}
