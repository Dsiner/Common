package com.d.common.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.d.lib.common.util.ViewHelper;

public class ButtonActivity extends Activity implements View.OnClickListener {

    @Override
    public void onClick(View v) {
        int resId = v.getId();
        if (resId == R.id.iv_title_left) {
            finish();
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.module_ui_activity_button);
        initClick();
    }

    private void initClick() {
        ViewHelper.setOnClickListener(this, this, R.id.iv_title_left);
    }
}
