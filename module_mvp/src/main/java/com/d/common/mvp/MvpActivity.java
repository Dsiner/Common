package com.d.common.mvp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.d.common.mvp.activity.MActivity;
import com.d.common.mvp.activity.MFragmentActivity;
import com.d.lib.common.util.ViewHelper;

/**
 * MvpActivity
 * Created by D on 2018/7/18.
 */
public class MvpActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.module_mvp_activity_main);

        ViewHelper.setOnClickListener(this, this, R.id.iv_title_left,
                R.id.btn_mvp_activity, R.id.btn_mvp_fragment_activity);
    }

    @Override
    public void onClick(View v) {
        int resId = v.getId();
        if (resId == R.id.iv_title_left) {
            finish();
        } else if (resId == R.id.btn_mvp_activity) {
            startActivity(new Intent(MvpActivity.this, MActivity.class));
        } else if (resId == R.id.btn_mvp_fragment_activity) {
            startActivity(new Intent(MvpActivity.this, MFragmentActivity.class));
        }
    }
}
