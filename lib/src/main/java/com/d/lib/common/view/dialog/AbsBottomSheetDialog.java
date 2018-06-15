package com.d.lib.common.view.dialog;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;

import com.d.lib.common.R;

import java.util.List;

public abstract class AbsBottomSheetDialog<T> extends AbstractDialog {
    protected List<T> datas;
    protected String title;
    protected OnItemClickListener listener;

    protected AbsBottomSheetDialog(Context context) {
        super(context, R.style.lib_pub_dialog_style, true,
                Gravity.BOTTOM, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
    }

    protected AbsBottomSheetDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    protected AbsBottomSheetDialog(Context context, int themeResId, boolean isSetWin, int gravity, int width, int heith) {
        super(context, themeResId, isSetWin, gravity, width, heith);
    }


    @Override
    protected void init(View rootView) {

    }

    protected void onItemClick(int position, String item) {
        dismiss();
        if (listener != null) {
            if (position == -1) {
                listener.onCancel(this);
            } else {
                listener.onClick(this, position, item);
            }
        }
    }

    protected abstract void initView(View rootView);

    public interface OnItemClickListener {
        /**
         * Click item
         *
         * @param position: from 0 to datas.size()-1;
         */
        void onClick(AbsBottomSheetDialog dlg, int position, String item);

        /**
         * Click cancel
         */
        void onCancel(AbsBottomSheetDialog dlg);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}
