package com.d.common.component.ui;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.d.lib.common.common.AlertDialogFactory;
import com.d.lib.common.utils.ViewHelper;
import com.d.lib.common.view.dialog.AbsSheetDialog;
import com.d.lib.common.view.dialog.BottomHorSheetDialog;
import com.d.lib.common.view.dialog.BottomShareSheetDialog;
import com.d.lib.common.view.dialog.BottomVerSheetDialog;

import java.util.Arrays;

public class SheetActivity extends Activity implements View.OnClickListener {

    @Override
    public void onClick(View v) {
        int resId = v.getId();
        if (resId == R.id.iv_title_left) {
            finish();
        } else if (resId == R.id.btn_style0) {
            AlertDialogFactory.createFactory(this).getBottomDialog(null,
                    Arrays.asList(new BottomVerSheetDialog.Bean(getResources().getString(R.string.component_ui_dialog_bottom_operation) + "1", R.color.lib_pub_color_text_main, true),
                            new BottomVerSheetDialog.Bean(getResources().getString(R.string.component_ui_dialog_bottom_operation) + "2", R.color.lib_pub_color_text_main, false)),
                    new AbsSheetDialog.OnItemClickListener() {
                        @Override
                        public void onClick(Dialog dlg, int position, String item) {

                        }

                        @Override
                        public void onCancel(Dialog dlg) {

                        }
                    });
        } else if (resId == R.id.btn_style1) {
            AlertDialogFactory.createFactory(this).getBottomDialog(getResources().getString(R.string.component_ui_dialog_bottom_title),
                    Arrays.asList(new BottomVerSheetDialog.Bean(getResources().getString(R.string.component_ui_dialog_bottom_operation) + "1", R.color.lib_pub_color_text_main, false),
                            new BottomVerSheetDialog.Bean(getResources().getString(R.string.component_ui_dialog_bottom_operation) + "2", R.color.lib_pub_color_text_main, false),
                            new BottomVerSheetDialog.Bean(getResources().getString(R.string.component_ui_dialog_bottom_operation) + "3", R.color.lib_pub_color_text_main, false),
                            new BottomVerSheetDialog.Bean(getResources().getString(R.string.component_ui_dialog_bottom_operation_dangerous), R.color.lib_pub_color_red, false),
                            new BottomVerSheetDialog.Bean(getResources().getString(R.string.component_ui_dialog_bottom_operation_none), R.color.lib_pub_color_text_hint, false)),
                    new AbsSheetDialog.OnItemClickListener() {
                        @Override
                        public void onClick(Dialog dlg, int position, String item) {

                        }

                        @Override
                        public void onCancel(Dialog dlg) {

                        }
                    });
        } else if (resId == R.id.btn_style2) {
            AlertDialogFactory.createFactory(this).getBottomHorDialog("分享",
                    Arrays.asList(new BottomHorSheetDialog.Bean(getResources().getString(R.string.component_ui_dialog_bottom_operation) + "1", R.drawable.lib_pub_circle_msg_number),
                            new BottomHorSheetDialog.Bean(getResources().getString(R.string.component_ui_dialog_bottom_operation) + "2", R.drawable.lib_pub_circle_msg_number),
                            new BottomHorSheetDialog.Bean(getResources().getString(R.string.component_ui_dialog_bottom_operation) + "3", R.drawable.lib_pub_circle_msg_number),
                            new BottomHorSheetDialog.Bean(getResources().getString(R.string.component_ui_dialog_bottom_operation_dangerous), R.drawable.lib_pub_circle_msg_number),
                            new BottomHorSheetDialog.Bean(getResources().getString(R.string.component_ui_dialog_bottom_operation_none), R.drawable.lib_pub_circle_msg_number)),
                    new AbsSheetDialog.OnItemClickListener() {
                        @Override
                        public void onClick(Dialog dlg, int position, String item) {

                        }

                        @Override
                        public void onCancel(Dialog dlg) {

                        }
                    });
        } else if (resId == R.id.btn_style3) {
            AlertDialogFactory.createFactory(this)
                    .getBottomShareDialog("文件名",
                            Arrays.asList(new BottomShareSheetDialog.Bean("链接地址: ", "https://www.baidu.com/link?url=eZH1yw2u1h-CNrpm7Q3jD_EfVnUxwUuBHlTGhLlA_KfhwtG0TGSl4a7kPsJNMqE8&wd=&eqid=f50ccdfc00009400000000065b232f14"),
                                    new BottomShareSheetDialog.Bean("提取密码: ", "3854", false)));
        } else if (resId == R.id.btn_style4) {
            AlertDialogFactory.createFactory(this)
                    .getBottomShareDialog("文件名",
                            Arrays.asList(new BottomShareSheetDialog.Bean("链接地址: ", "https://www.baidu.com/link?url=eZH1yw2u1h-CNrpm7Q3jD_EfVnUxwUuBHlTGhLlA_KfhwtG0TGSl4a7kPsJNMqE8&wd=&eqid=f50ccdfc00009400000000065b232f14"),
                                    new BottomShareSheetDialog.Bean("提取密码: ", "3854", true)));
        } else if (resId == R.id.btn_style5) {
            AlertDialogFactory.createFactory(this).getBottomHorDialog("分享",
                    Arrays.asList(new BottomHorSheetDialog.Bean(getResources().getString(R.string.component_ui_dialog_bottom_operation) + "1", R.drawable.lib_pub_circle_msg_number),
                            new BottomHorSheetDialog.Bean(getResources().getString(R.string.component_ui_dialog_bottom_operation) + "2", R.drawable.lib_pub_circle_msg_number),
                            new BottomHorSheetDialog.Bean(getResources().getString(R.string.component_ui_dialog_bottom_operation) + "3", R.drawable.lib_pub_circle_msg_number),
                            new BottomHorSheetDialog.Bean(getResources().getString(R.string.component_ui_dialog_bottom_operation_dangerous), R.drawable.lib_pub_circle_msg_number),
                            new BottomHorSheetDialog.Bean(getResources().getString(R.string.component_ui_dialog_bottom_operation_none), R.drawable.lib_pub_circle_msg_number)),
                    new AbsSheetDialog.OnItemClickListener() {
                        @Override
                        public void onClick(Dialog dlg, int position, String item) {

                        }

                        @Override
                        public void onCancel(Dialog dlg) {

                        }
                    });
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.component_ui_activity_sheet);
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
    }
}
