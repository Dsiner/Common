package com.d.commonapp.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.d.commonapp.R;
import com.d.commonapp.model.LoaderModel;
import com.d.lib.xrv.adapter.CommonAdapter;
import com.d.lib.xrv.adapter.CommonHolder;

import java.util.List;

/**
 * Loader
 * Created by D on 2018/3/3.
 */
public class LoaderAdapter extends CommonAdapter<LoaderModel> {

    public LoaderAdapter(Context context, List<LoaderModel> datas, int layoutId) {
        super(context, datas, layoutId);
    }

    @Override
    public void convert(int position, CommonHolder holder, LoaderModel item) {
        holder.setText(R.id.tv_title, item.title);
        holder.setText(R.id.tv_rating, getRating(item));
        holder.setText(R.id.tv_directors, "导演：" + getDirectors(item.directors));
        holder.setText(R.id.tv_casts, "主演：" + getCasts(item.casts));
        Glide.with(mContext).load(item.images != null ? item.images.medium : "")
                .apply(new RequestOptions().placeholder(R.color.lib_pub_color_bg_sub))
                .into((ImageView) holder.getView(R.id.iv_image));
    }

    private String getRating(LoaderModel item) {
        if (item.rating == null) {
            return "?";
        }
        if (item.rating.average >= 8) {
            return "⭐⭐⭐⭐⭐ " + item.rating.average;
        } else if (item.rating.average >= 6) {
            return "⭐⭐⭐⭐ " + item.rating.average;
        } else if (item.rating.average >= 4) {
            return "⭐⭐⭐ " + item.rating.average;
        } else if (item.rating.average >= 2) {
            return "⭐⭐ " + item.rating.average;
        } else {
            return "⭐ " + item.rating.average;
        }
    }

    private String getDirectors(List<LoaderModel.DirectorsBean> directors) {
        if (directors == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < directors.size(); i++) {
            sb.append(directors.get(i).name);
            if (i >= 2) {
                break;
            }
            sb.append(" ");
        }
        return sb.toString();
    }

    private String getCasts(List<LoaderModel.CastsBean> casts) {
        if (casts == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < casts.size(); i++) {
            sb.append(casts.get(i).name);
            if (i >= 2) {
                break;
            }
            sb.append(" ");
        }
        return sb.toString();
    }
}
