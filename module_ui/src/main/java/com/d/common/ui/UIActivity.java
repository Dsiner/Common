package com.d.common.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.d.lib.common.util.ViewHelper;

public class UIActivity extends Activity implements View.OnClickListener {

    @Override
    public void onClick(View v) {
        int resId = v.getId();
        if (resId == R.id.iv_title_left) {
            finish();
        } else if (resId == R.id.btn_0) {
            startActivity(new Intent(UIActivity.this, TitleActivity.class));
        } else if (resId == R.id.btn_1) {
            startActivity(new Intent(UIActivity.this, DSActivity.class));
        } else if (resId == R.id.btn_2) {
            startActivity(new Intent(UIActivity.this, RowActivity.class));
        } else if (resId == R.id.btn_3) {
            startActivity(new Intent(UIActivity.this, ToolBarActivity.class));
        } else if (resId == R.id.btn_4) {
            startActivity(new Intent(UIActivity.this, AlertActivity.class));
        } else if (resId == R.id.btn_5) {
            startActivity(new Intent(UIActivity.this, SheetActivity.class));
        } else if (resId == R.id.btn_6) {
            startActivity(new Intent(UIActivity.this, StatusActivity.class));
        } else if (resId == R.id.btn_7) {
            startActivity(new Intent(UIActivity.this, ButtonActivity.class));
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.module_ui_activity_ui);
        initClick();
    }

    private void initClick() {
        ViewHelper.setOnClickListener(this, this, R.id.iv_title_left);

        ViewHelper.setOnClickListener(this, this, R.id.btn_0);
        ViewHelper.setOnClickListener(this, this, R.id.btn_1);
        ViewHelper.setOnClickListener(this, this, R.id.btn_2);
        ViewHelper.setOnClickListener(this, this, R.id.btn_3);
        ViewHelper.setOnClickListener(this, this, R.id.btn_4);
        ViewHelper.setOnClickListener(this, this, R.id.btn_5);
        ViewHelper.setOnClickListener(this, this, R.id.btn_6);
        ViewHelper.setOnClickListener(this, this, R.id.btn_7);
    }
}
