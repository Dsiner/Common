package com.d.lib.common.view.dialog;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.d.lib.common.R;
import com.d.lib.xrv.LRecyclerView;
import com.d.lib.xrv.adapter.CommonAdapter;
import com.d.lib.xrv.adapter.CommonHolder;

import java.util.List;

/**
 * BottomDialog
 * Created by D on 2017/7/27.
 * Modify by whb:
 * <p>需要显示标题则调用含有title参数的构造方法BottomDialog(Context context, List<String> datas,String title)
 * 不需要显示时则调用BottomDialog(Context context, List<String> datas)构造方法，或上面方法传入title=null或""
 * </p>
 */
public class BottomDialog extends AbstractDialog {
    private List<Bean> datas;
    private String title;
    private OnItemClickListener listener;

    public BottomDialog(Context context, List<Bean> datas, String title) {
        super(context, R.style.lib_pub_dialog_style, true,
                Gravity.BOTTOM, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        this.datas = datas;
        this.title = title;
        initView(rootView);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.lib_pub_dialog_bottom;
    }

    @Override
    protected void init(View rootView) {

    }

    protected void initView(View rootView) {
        LRecyclerView list = (LRecyclerView) rootView.findViewById(R.id.lrv_list);
        TextView tvCancle = (TextView) rootView.findViewById(R.id.tv_cancle);
        TextView tvTitle = (TextView) rootView.findViewById(R.id.tv_title);
        if (!TextUtils.isEmpty(title)) {
            tvTitle.setVisibility(View.VISIBLE);
            tvTitle.setText(title);
        } else {
            tvTitle.setVisibility(View.GONE);
        }
        BottomAdapter adapter = new BottomAdapter(context, datas, R.layout.lib_pub_adapter_dlg_bottom);
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
            holder.setTextColor(R.id.tv_item, ContextCompat.getColor(mContext, item.color));
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClick(position, item.item);
                }
            });
        }
    }

    private void onItemClick(int position, String item) {
        dismiss();
        if (listener != null) {
            if (position == -1) {
                listener.onCancel(this);
            } else {
                listener.onClick(this, position, item);
            }
        }
    }

    public static class Bean {
        public String item;
        public int color;
        public boolean isChecked;

        public Bean(String item, int color, boolean isChecked) {
            this.item = item;
            this.color = color;
            this.isChecked = isChecked;
        }
    }

    public interface OnItemClickListener {
        /**
         * Click item
         *
         * @param position: from 0 to datas.size()-1;
         */
        void onClick(BottomDialog dlg, int position, String item);

        /**
         * Click cancel
         */
        void onCancel(BottomDialog dlg);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}
