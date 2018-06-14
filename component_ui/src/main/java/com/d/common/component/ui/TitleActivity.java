package com.d.common.component.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

public class TitleActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.component_ui_activity_title);
    }
}
