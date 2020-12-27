package com.d.common.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.d.lib.common.util.ViewHelper;
import com.d.lib.common.widget.RowLayout;

public class RowActivity extends Activity implements View.OnClickListener {
    private RowLayout[] rlRows = new RowLayout[6];

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
        setContentView(R.layout.module_ui_activity_row);
        initView();
    }

    private void initView() {
        rlRows[0] = ViewHelper.findViewById(this, R.id.rl_row0);
        rlRows[1] = ViewHelper.findViewById(this, R.id.rl_row1);
        rlRows[2] = ViewHelper.findViewById(this, R.id.rl_row2);
        rlRows[3] = ViewHelper.findViewById(this, R.id.rl_row3);
        rlRows[4] = ViewHelper.findViewById(this, R.id.rl_row4);
        rlRows[5] = ViewHelper.findViewById(this, R.id.rl_row5);

        rlRows[1].setNumber("99", View.VISIBLE);

        rlRows[3].setOpen(false);
        rlRows[4].setOpen(true);

        ViewHelper.setOnClickListener(this, this, R.id.iv_title_left);

        ViewHelper.setOnClickListener(this, this, R.id.rl_row0);
        ViewHelper.setOnClickListener(this, this, R.id.rl_row1);
        ViewHelper.setOnClickListener(this, this, R.id.rl_row2);
        ViewHelper.setOnClickListener(this, this, R.id.rl_row3);
        ViewHelper.setOnClickListener(this, this, R.id.rl_row4);
        ViewHelper.setOnClickListener(this, this, R.id.rl_row5);
    }
}
