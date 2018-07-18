package com.d.common.component.mvp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.d.common.component.mvp.activity.MActivity;
import com.d.common.component.mvp.activity.MFragmentActivity;

/**
 * MvpActivity
 * Created by D on 2018/7/18.
 */
public class MvpActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.component_mvp_activity_main);

        findViewById(R.id.btn_mvp_activity).setOnClickListener(this);
        findViewById(R.id.btn_mvp_fragment_activity).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int resId = v.getId();
        if (resId == R.id.btn_mvp_activity) {
            startActivity(new Intent(MvpActivity.this, MActivity.class));
        } else if (resId == R.id.btn_mvp_fragment_activity) {
            startActivity(new Intent(MvpActivity.this, MFragmentActivity.class));
        }
    }
}
