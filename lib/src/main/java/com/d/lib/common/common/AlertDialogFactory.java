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
import com.d.lib.common.view.dialog.BottomDialog;

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

    public BottomDialog getBottomDialog(List<BottomDialog.Bean> datas, BottomDialog.OnItemClickListener listener) {
        return getBottomDialog(datas, null, listener);
    }

    public BottomDialog getBottomDialog(List<BottomDialog.Bean> datas, String title, BottomDialog.OnItemClickListener listener) {
        BottomDialog dialog = new BottomDialog(context, datas, title);
        dialog.setOnItemClickListener(listener);
        return dialog;
    }

    public AlertDialog getOperationDialog() {
        return null;
    }

    public interface OnClickListener {
        void onClick(AlertDialog dlg, View v);
    }
}
