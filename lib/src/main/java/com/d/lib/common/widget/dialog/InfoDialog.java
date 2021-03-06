package com.d.lib.common.widget.dialog;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.d.lib.common.R;
import com.d.lib.pulllayout.rv.adapter.CommonAdapter;
import com.d.lib.pulllayout.rv.adapter.CommonHolder;

import java.util.List;

/**
 * InfoDialog
 * Created by D on 2018/6/15.
 */
public class InfoDialog extends AbsSheetDialog<InfoDialog.Bean> {
    private TextView tv_title;

    public InfoDialog(Context context, String title, List<Bean> datas) {
        super(context, R.style.lib_pub_dialog_style, false, 0, 0, 0);
        this.mTitle = title;
        this.mDatas = datas;
        bindView(mRootView);
        init();
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.lib_pub_dialog_info;
    }

    @Override
    protected RecyclerView.Adapter getAdapter() {
        return new SheetAdapter(mContext, mDatas, R.layout.lib_pub_adapter_dlg_info);
    }

    @Override
    protected void bindView(View rootView) {
        tv_title = (TextView) rootView.findViewById(R.id.tv_title);
    }

    @Override
    protected void init() {
        if (!TextUtils.isEmpty(mTitle)) {
            tv_title.setVisibility(View.VISIBLE);
            tv_title.setText(mTitle);
        } else {
            tv_title.setVisibility(View.GONE);
        }
        initRecyclerList(R.id.rv_list, LinearLayoutManager.VERTICAL);
    }

    public static class Bean {
        public String title;
        public String content;

        public Bean(String title, String content) {
            this.title = title;
            this.content = content;
        }
    }

    public class SheetAdapter extends CommonAdapter<Bean> {
        SheetAdapter(Context context, List<Bean> datas, int layoutId) {
            super(context, datas, layoutId);
        }

        @Override
        public void convert(final int position, CommonHolder holder, final Bean item) {
            holder.setText(R.id.tv_title, item.title);
            holder.setText(R.id.tv_content, item.content);
        }
    }
}
