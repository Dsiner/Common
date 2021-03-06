package com.d.common.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.d.lib.common.util.ViewHelper;

public class TitleActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.module_ui_activity_title);
        initClick();
    }

    private void initClick() {
        ViewHelper.setOnClickListener((View) ViewHelper.findViewById(this, R.id.tl_title), new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        }, R.id.iv_title_left);
    }
}
