package com.d.common.component.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.d.lib.common.common.AlertDialogFactory;
import com.d.lib.common.utils.ViewHelper;
import com.d.lib.common.view.dialog.BottomDialog;

import java.util.Arrays;

public class DialogActivity extends Activity implements View.OnClickListener {

    @Override
    public void onClick(View v) {
        int resId = v.getId();
        if (resId == R.id.iv_title_left) {
            finish();
        } else if (resId == R.id.btn_style0) {
            AlertDialogFactory.createFactory(this)
                    .getAlertDialog(null,
                            getResources().getString(R.string.component_ui_dialog_content),
                            getResources().getString(R.string.component_ui_dialog_gotit), null,
                            new AlertDialogFactory.OnClickListener() {
                                @Override
                                public void onClick(AlertDialog dlg, View v) {

                                }
                            }, null);
        } else if (resId == R.id.btn_style1) {
            AlertDialogFactory.createFactory(this)
                    .getAlertDialog(null,
                            getResources().getString(R.string.component_ui_dialog_content),
                            getResources().getString(R.string.component_ui_dialog_ok), getResources().getString(R.string.component_ui_dialog_cancel),
                            new AlertDialogFactory.OnClickListener() {
                                @Override
                                public void onClick(AlertDialog dlg, View v) {

                                }
                            }, new AlertDialogFactory.OnClickListener() {
                                @Override
                                public void onClick(AlertDialog dlg, View v) {

                                }
                            });
        } else if (resId == R.id.btn_style2) {
            AlertDialogFactory.createFactory(this)
                    .getAlertDialog(getResources().getString(R.string.component_ui_dialog_title),
                            getResources().getString(R.string.component_ui_dialog_content),
                            getResources().getString(R.string.component_ui_dialog_ok), getResources().getString(R.string.component_ui_dialog_cancel),
                            new AlertDialogFactory.OnClickListener() {
                                @Override
                                public void onClick(AlertDialog dlg, View v) {

                                }
                            }, new AlertDialogFactory.OnClickListener() {
                                @Override
                                public void onClick(AlertDialog dlg, View v) {

                                }
                            });
        } else if (resId == R.id.btn_style3) {
            AlertDialogFactory.createFactory(this)
                    .getAlertDialog(getResources().getString(R.string.component_ui_dialog_title),
                            getResources().getString(R.string.component_ui_dialog_content),
                            getResources().getString(R.string.component_ui_dialog_ok), getResources().getString(R.string.component_ui_dialog_cancel),
                            new AlertDialogFactory.OnClickListener() {
                                @Override
                                public void onClick(AlertDialog dlg, View v) {

                                }
                            }, new AlertDialogFactory.OnClickListener() {
                                @Override
                                public void onClick(AlertDialog dlg, View v) {

                                }
                            });
        } else if (resId == R.id.btn_style4) {
            AlertDialogFactory.createFactory(this)
                    .getBottomDialog(Arrays.asList(new BottomDialog.Bean(getResources().getString(R.string.component_ui_dialog_bottom_operation) + "1", R.color.lib_pub_color_text_main, false),
                            new BottomDialog.Bean(getResources().getString(R.string.component_ui_dialog_bottom_operation) + "2", R.color.lib_pub_color_text_main, false),
                            new BottomDialog.Bean(getResources().getString(R.string.component_ui_dialog_bottom_operation) + "3", R.color.lib_pub_color_text_main, false),
                            new BottomDialog.Bean(getResources().getString(R.string.component_ui_dialog_bottom_operation_dangerous), R.color.lib_pub_color_red, false),
                            new BottomDialog.Bean(getResources().getString(R.string.component_ui_dialog_bottom_operation_none), R.color.lib_pub_color_text_hint, false)),
                            getResources().getString(R.string.component_ui_dialog_bottom_title), new BottomDialog.OnItemClickListener() {
                                @Override
                                public void onClick(BottomDialog dlg, int position, String item) {

                                }

                                @Override
                                public void onCancel(BottomDialog dlg) {

                                }
                            }).show();
        } else if (resId == R.id.btn_style5) {
            AlertDialogFactory.createFactory(this)
                    .getAlertDialog(null,
                            getResources().getString(R.string.component_ui_dialog_content),
                            getResources().getString(R.string.component_ui_dialog_ok), getResources().getString(R.string.component_ui_dialog_cancel),
                            new AlertDialogFactory.OnClickListener() {
                                @Override
                                public void onClick(AlertDialog dlg, View v) {

                                }
                            }, new AlertDialogFactory.OnClickListener() {
                                @Override
                                public void onClick(AlertDialog dlg, View v) {

                                }
                            });
        } else if (resId == R.id.btn_style6) {
            AlertDialogFactory.createFactory(this)
                    .getAlertDialog(null,
                            getResources().getString(R.string.component_ui_dialog_content),
                            getResources().getString(R.string.component_ui_dialog_ok), getResources().getString(R.string.component_ui_dialog_cancel),
                            new AlertDialogFactory.OnClickListener() {
                                @Override
                                public void onClick(AlertDialog dlg, View v) {

                                }
                            }, new AlertDialogFactory.OnClickListener() {
                                @Override
                                public void onClick(AlertDialog dlg, View v) {

                                }
                            });
        } else if (resId == R.id.btn_style7) {
            AlertDialogFactory.createFactory(this)
                    .getAlertDialog(null,
                            getResources().getString(R.string.component_ui_dialog_content),
                            getResources().getString(R.string.component_ui_dialog_ok), getResources().getString(R.string.component_ui_dialog_cancel),
                            new AlertDialogFactory.OnClickListener() {
                                @Override
                                public void onClick(AlertDialog dlg, View v) {

                                }
                            }, new AlertDialogFactory.OnClickListener() {
                                @Override
                                public void onClick(AlertDialog dlg, View v) {

                                }
                            });
        } else if (resId == R.id.btn_style8) {
            AlertDialogFactory.createFactory(this)
                    .getAlertDialog(null,
                            getResources().getString(R.string.component_ui_dialog_content),
                            getResources().getString(R.string.component_ui_dialog_ok), getResources().getString(R.string.component_ui_dialog_cancel),
                            new AlertDialogFactory.OnClickListener() {
                                @Override
                                public void onClick(AlertDialog dlg, View v) {

                                }
                            }, new AlertDialogFactory.OnClickListener() {
                                @Override
                                public void onClick(AlertDialog dlg, View v) {

                                }
                            });
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.component_ui_activity_dialog);
        initClick();
    }

    private void initClick() {
        ViewHelper.setOnClick(this, this, R.id.iv_title_left);
        ViewHelper.setOnClick(this, this, R.id.btn_style0);
        ViewHelper.setOnClick(this, this, R.id.btn_style1);
        ViewHelper.setOnClick(this, this, R.id.btn_style2);
        ViewHelper.setOnClick(this, this, R.id.btn_style3);
        ViewHelper.setOnClick(this, this, R.id.btn_style4);
        ViewHelper.setOnClick(this, this, R.id.btn_style5);
        ViewHelper.setOnClick(this, this, R.id.btn_style6);
        ViewHelper.setOnClick(this, this, R.id.btn_style7);
        ViewHelper.setOnClick(this, this, R.id.btn_style8);
    }
}
