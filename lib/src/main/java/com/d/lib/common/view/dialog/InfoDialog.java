package com.d.lib.common.view.dialog;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.d.lib.common.R;
import com.d.lib.xrv.adapter.CommonAdapter;
import com.d.lib.xrv.adapter.CommonHolder;

import java.util.List;

/**
 * OperationDialog
 * Created by D on 2018/6/15.
 */
public class InfoDialog extends AbsBottomSheetDialog<InfoDialog.Bean> {

    public InfoDialog(Context context, List<Bean> datas, String title) {
        super(context, R.style.lib_pub_dialog_style, false, 0, 0, 0);
        this.datas = datas;
        this.title = title;
        initView(rootView);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.lib_pub_dialog_info;
    }

    @Override
    protected void initView(View rootView) {
        TextView tvTitle = (TextView) rootView.findViewById(R.id.tv_title);
        if (!TextUtils.isEmpty(title)) {
            tvTitle.setVisibility(View.VISIBLE);
            tvTitle.setText(title);
        } else {
            tvTitle.setVisibility(View.GONE);
        }
        RecyclerView list = (RecyclerView) rootView.findViewById(R.id.rv_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        list.setLayoutManager(layoutManager);
        BottomAdapter adapter = new BottomAdapter(context, datas, R.layout.lib_pub_adapter_dlg_info);
        list.setAdapter(adapter);
    }

    public class BottomAdapter extends CommonAdapter<Bean> {
        BottomAdapter(Context context, List<Bean> datas, int layoutId) {
            super(context, datas, layoutId);
        }

        @Override
        public void convert(final int position, CommonHolder holder, final Bean item) {
            holder.setText(R.id.tv_title, item.title);
            holder.setText(R.id.tv_content, item.content);
        }
    }

    public static class Bean {
        public String title;
        public String content;

        public Bean(String title, String content) {
            this.title = title;
            this.content = content;
        }
    }
}
