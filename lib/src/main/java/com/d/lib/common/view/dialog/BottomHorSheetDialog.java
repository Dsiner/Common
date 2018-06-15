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

public class BottomHorSheetDialog extends AbsBottomSheetDialog<BottomHorSheetDialog.Bean> {

    public BottomHorSheetDialog(Context context, List<Bean> datas, String title) {
        super(context);
        this.datas = datas;
        this.title = title;
        initView(rootView);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.lib_pub_dialog_bottom_style_hor;
    }

    @Override
    protected void initView(View rootView) {
        RecyclerView list = (RecyclerView) rootView.findViewById(R.id.rv_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        list.setLayoutManager(layoutManager);
        TextView tvCancle = (TextView) rootView.findViewById(R.id.tv_cancle);
        TextView tvTitle = (TextView) rootView.findViewById(R.id.tv_title);
        if (!TextUtils.isEmpty(title)) {
            tvTitle.setVisibility(View.VISIBLE);
            tvTitle.setText(title);
        } else {
            tvTitle.setVisibility(View.GONE);
        }
        BottomAdapter adapter = new BottomAdapter(context, datas, R.layout.lib_pub_adapter_dlg_bottom_hor);
        list.setAdapter(adapter);
        tvCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClick(-1, "");
            }
        });
    }

    public class BottomAdapter extends CommonAdapter<Bean> {
        BottomAdapter(Context context, List<Bean> datas, int layoutId) {
            super(context, datas, layoutId);
        }

        @Override
        public void convert(final int position, CommonHolder holder, final Bean item) {
            holder.setText(R.id.tv_item, item.item);
            holder.setImageResource(R.id.iv_item, item.drawble);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClick(position, item.item);
                }
            });
        }
    }

    public static class Bean {
        public String item;
        public int drawble;

        public Bean(String item, int drawble) {
            this.item = item;
            this.drawble = drawble;
        }
    }
}