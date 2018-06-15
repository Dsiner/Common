package com.d.lib.common.common;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.d.lib.common.R;
import com.d.lib.common.view.dialog.AbsBottomSheetDialog;
import com.d.lib.common.view.dialog.AlertSubDialog;
import com.d.lib.common.view.dialog.BottomHorSheetDialog;
import com.d.lib.common.view.dialog.BottomShareSheetDialog;
import com.d.lib.common.view.dialog.BottomVerSheetDialog;
import com.d.lib.common.view.dialog.EditDialog;
import com.d.lib.common.view.dialog.InfoDialog;
import com.d.lib.common.view.dialog.OperationDialog;

import java.util.List;

/**
 * AlertDialogFactory
 * Created by D on 2017/4/29.
 */
public class AlertDialogFactory {
    private Context context;

    private AlertDialogFactory(Context context) {
        this.context = context;
    }

    public static AlertDialogFactory createFactory(Context context) {
        return new AlertDialogFactory(context);
    }

    /**
     * LoadingDialog
     */
    public AlertDialog getLoadingDialog() {
        return getLoadingDialog(null);
    }

    /**
     * LoadingDialog
     */
    public AlertDialog getLoadingDialog(String text) {
        final AlertDialog dlg = new AlertDialog
                .Builder(new ContextThemeWrapper(context, R.style.lib_pub_dialog_style))
                .create();
        if (context instanceof Activity && !((Activity) context).isFinishing()) {
            dlg.show();
        }
        dlg.setContentView(R.layout.lib_pub_dialog_loading);
        TextView tips = (TextView) dlg.findViewById(R.id.tv_tips);
        if (text != null) {
            tips.setText(text);
        }
        return dlg;
    }

    public AlertDialog getAlertDialog(String title, String content, String btnOkText, String btnCancelText, final OnClickListener btnOkListener, final OnClickListener btnCancelListener) {
        final AlertDialog dlg = new AlertDialog
                .Builder(new ContextThemeWrapper(context, R.style.lib_pub_dialog_style))
                .create();
        if (context instanceof Activity && !((Activity) context).isFinishing()) {
            dlg.show();
        }
        dlg.setContentView(R.layout.lib_pub_dialog);

        TextView tv_title = (TextView) dlg.findViewById(R.id.tv_title);
        tv_title.setVisibility(!TextUtils.isEmpty(title) ? View.VISIBLE : View.GONE);
        tv_title.setText(!TextUtils.isEmpty(title) ? title : "");

        TextView tv_content = (TextView) dlg.findViewById(R.id.tv_content);
        tv_content.setVisibility(!TextUtils.isEmpty(content) ? View.VISIBLE : View.GONE);
        tv_content.setText(!TextUtils.isEmpty(content) ? content : "");

        Button btnOk = (Button) dlg.findViewById(R.id.btn_ok);
        btnOk.setText(TextUtils.isEmpty(btnOkText) ? btnOkText : context.getResources().getString(R.string.lib_pub_ok));

        Button btnCancel = (Button) dlg.findViewById(R.id.btn_cancel);
        btnCancel.setText(!TextUtils.isEmpty(btnCancelText) ? btnCancelText : "");
        btnCancel.setVisibility(!TextUtils.isEmpty(btnCancelText) ? View.VISIBLE : View.GONE);

        View lineBottom = dlg.findViewById(R.id.line_bottom);
        lineBottom.setVisibility(!TextUtils.isEmpty(btnCancelText) ? View.VISIBLE : View.GONE);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dlg.dismiss();
                if (btnOkListener != null) {
                    btnOkListener.onClick(dlg, v);
                }
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dlg.dismiss();
                if (btnCancelListener != null) {
                    btnCancelListener.onClick(dlg, v);
                }
            }
        });
        return dlg;
    }

    public AlertSubDialog getAlertSubDialog(String title, String content, String subTips, boolean isChecked, AlertSubDialog.OnCheckListener listener) {
        AlertSubDialog dialog = new AlertSubDialog(context, title, content, subTips, isChecked);
        dialog.setOnCheckListener(listener);
        dialog.show();
        return dialog;
    }

    public EditDialog getEditDialog(String title, String content, EditDialog.OnEditListener listener) {
        EditDialog dialog = new EditDialog(context, title, content);
        dialog.setOnEditListener(listener);
        dialog.show();
        return dialog;
    }

    public InfoDialog getInfoDialog(List<InfoDialog.Bean> datas, String title) {
        InfoDialog dialog = new InfoDialog(context, datas, title);
        dialog.show();
        return dialog;
    }

    public OperationDialog getOperationDialog(List<OperationDialog.Bean> datas, String title, AbsBottomSheetDialog.OnItemClickListener listener) {
        OperationDialog dialog = new OperationDialog(context, datas, title);
        dialog.show();
        return dialog;
    }

    public BottomVerSheetDialog getBottomDialog(List<BottomVerSheetDialog.Bean> datas, AbsBottomSheetDialog.OnItemClickListener listener) {
        return getBottomDialog(datas, null, listener);
    }

    public BottomVerSheetDialog getBottomDialog(List<BottomVerSheetDialog.Bean> datas, String title, AbsBottomSheetDialog.OnItemClickListener listener) {
        BottomVerSheetDialog dialog = new BottomVerSheetDialog(context, datas, title);
        dialog.setOnItemClickListener(listener);
        dialog.show();
        return dialog;
    }

    public BottomHorSheetDialog getBottomHorDialog(List<BottomHorSheetDialog.Bean> datas, String title, AbsBottomSheetDialog.OnItemClickListener listener) {
        BottomHorSheetDialog dialog = new BottomHorSheetDialog(context, datas, title);
        dialog.setOnItemClickListener(listener);
        dialog.show();
        return dialog;
    }

    public BottomShareSheetDialog getBottomShareDialog(List<BottomShareSheetDialog.Bean> datas, String title) {
        BottomShareSheetDialog dialog = new BottomShareSheetDialog(context, datas, title);
        dialog.show();
        return dialog;
    }

    public interface OnClickListener {
        void onClick(AlertDialog dlg, View v);
    }
}
