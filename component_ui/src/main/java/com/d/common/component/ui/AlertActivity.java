package com.d.common.component.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.d.lib.common.common.AlertDialogFactory;
import com.d.lib.common.utils.ViewHelper;
import com.d.lib.common.view.dialog.AbsBottomSheetDialog;
import com.d.lib.common.view.dialog.AlertSubDialog;
import com.d.lib.common.view.dialog.EditDialog;
import com.d.lib.common.view.dialog.InfoDialog;
import com.d.lib.common.view.dialog.OperationDialog;

import java.util.Arrays;

public class AlertActivity extends Activity implements View.OnClickListener {

    @Override
    public void onClick(View v) {
        int resId = v.getId();
        if (resId == R.id.iv_title_left) {
            finish();
        } else if (resId == R.id.btn_style0) {
            AlertDialogFactory.createFactory(this).getAlertDialog(null,
                    getResources().getString(R.string.component_ui_dialog_content),
                    getResources().getString(R.string.component_ui_dialog_gotit), null,
                    new AlertDialogFactory.OnClickListener() {
                        @Override
                        public void onClick(AlertDialog dlg, View v) {

                        }
                    }, null);
        } else if (resId == R.id.btn_style1) {
            AlertDialogFactory.createFactory(this).getAlertDialog(null,
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
            AlertDialogFactory.createFactory(this).getAlertDialog(getResources().getString(R.string.component_ui_dialog_title),
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
            AlertDialogFactory.createFactory(this).getAlertSubDialog(getResources().getString(R.string.component_ui_dialog_title),
                    null,
                    getResources().getString(R.string.component_ui_dialog_sub_tips),
                    false, new AlertSubDialog.OnCheckListener() {
                        @Override
                        public void onSubmit(AlertSubDialog dlg, boolean isChecked) {

                        }

                        @Override
                        public void onCancel(AlertSubDialog dlg) {

                        }
                    });
        } else if (resId == R.id.btn_style4) {
            AlertDialogFactory.createFactory(this).getAlertSubDialog(getResources().getString(R.string.component_ui_dialog_title),
                    getResources().getString(R.string.component_ui_dialog_content),
                    getResources().getString(R.string.component_ui_dialog_sub_tips),
                    true, new AlertSubDialog.OnCheckListener() {
                        @Override
                        public void onSubmit(AlertSubDialog dlg, boolean isChecked) {

                        }

                        @Override
                        public void onCancel(AlertSubDialog dlg) {

                        }
                    });
        } else if (resId == R.id.btn_style5) {
            AlertDialogFactory.createFactory(this)
                    .getAlertDialog(getResources().getString(R.string.component_ui_dialog_title),
                            getResources().getString(R.string.component_ui_dialog_content),
                            getResources().getString(R.string.component_ui_dialog_ok), null,
                            new AlertDialogFactory.OnClickListener() {
                                @Override
                                public void onClick(AlertDialog dlg, View v) {

                                }
                            }, null);
        } else if (resId == R.id.btn_style6) {
            AlertDialogFactory.createFactory(this).getEditDialog(getResources().getString(R.string.component_ui_dialog_title)
                    , "", new EditDialog.OnEditListener() {
                        @Override
                        public void onSubmit(EditDialog dlg, String content) {

                        }

                        @Override
                        public void onCancel(EditDialog dlg) {

                        }
                    });
        } else if (resId == R.id.btn_style7) {
            AlertDialogFactory.createFactory(this).getInfoDialog(Arrays.asList(new InfoDialog.Bean(getResources().getString(R.string.component_ui_dialog_title) + "1", "" + 1111111),
                    new InfoDialog.Bean(getResources().getString(R.string.component_ui_dialog_title) + "2", "" + 2222222),
                    new InfoDialog.Bean(getResources().getString(R.string.component_ui_dialog_title) + "3", "" + 3333333),
                    new InfoDialog.Bean(getResources().getString(R.string.component_ui_dialog_title) + "4", "" + 4444444),
                    new InfoDialog.Bean(getResources().getString(R.string.component_ui_dialog_title) + "5", "" + 5555555)),
                    getResources().getString(R.string.component_ui_dialog_title));
        } else if (resId == R.id.btn_style8) {
            AlertDialogFactory.createFactory(this).getOperationDialog(Arrays.asList(new OperationDialog.Bean(getResources().getString(R.string.component_ui_dialog_bottom_operation) + "1", R.color.lib_pub_color_main, false),
                    new OperationDialog.Bean(getResources().getString(R.string.component_ui_dialog_bottom_operation) + "2", R.color.lib_pub_color_main, false)),
                    getResources().getString(R.string.component_ui_dialog_content), new AbsBottomSheetDialog.OnItemClickListener() {
                        @Override
                        public void onClick(AbsBottomSheetDialog dlg, int position, String item) {

                        }

                        @Override
                        public void onCancel(AbsBottomSheetDialog dlg) {

                        }
                    });
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.component_ui_activity_alert);
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
