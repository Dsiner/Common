package com.d.lib.common.view.btb;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * CommonHolder for ListView
 * Created by D on 2017/4/25.
 */
public class CommonHolder {
    public final View itemView;
    public final int layoutId;
    private int mPosition;
    private final SparseArray<View> mViews;

    private CommonHolder(Context context, ViewGroup parent, int layoutId, int position) {
        this.layoutId = layoutId;
        this.mPosition = position;
        this.mViews = new SparseArray<>();
        this.itemView = LayoutInflater.from(context).inflate(layoutId, parent, false);
        this.itemView.setTag(this);
    }

    @NonNull
    public static CommonHolder createViewHolder(@NonNull Context context,
                                                @Nullable View convertView, ViewGroup parent,
                                                int layoutId, int position) {
        if (convertView == null) {
            return new CommonHolder(context, parent, layoutId, position);
        }
        CommonHolder holder = (CommonHolder) convertView.getTag();
        if (holder.layoutId != layoutId) {
            return new CommonHolder(context, parent, layoutId, position);
        }
        holder.mPosition = position;
        return holder;
    }

    public int getPosition() {
        return mPosition;
    }

    /**
     * Finds the first descendant view with the given ID
     */
    public <T extends View> T getView(@IdRes int id) {
        View view = mViews.get(id);
        if (view == null) {
            view = itemView.findViewById(id);
            mViews.put(id, view);
        }
        return (T) view;
    }

    /**
     * Sets the text to be displayed
     */
    public CommonHolder setText(@IdRes int id, CharSequence text) {
        TextView view = getView(id);
        view.setText(text);
        return this;
    }

    /**
     * Changes the enabled state of this button.
     */
    public CommonHolder setEnable(@IdRes int id, boolean enable) {
        Button view = getView(id);
        view.setEnabled(enable);
        return this;
    }

    /**
     * Changes the checked state of this button.
     */
    public CommonHolder setChecked(@IdRes int id, boolean checked) {
        CheckBox view = getView(id);
        view.setChecked(checked);
        return this;
    }

    /**
     * Set the visibility state of this view.
     */
    public CommonHolder setVisibility(@IdRes int id, int visibility) {
        View view = getView(id);
        view.setVisibility(visibility);
        return this;
    }

    public CommonHolder setOnClickListener(@IdRes int id, @Nullable View.OnClickListener l) {
        View view = getView(id);
        view.setOnClickListener(l);
        return this;
    }

    public CommonHolder setTag(@IdRes int id, Object tag) {
        View view = getView(id);
        view.setTag(tag);
        return this;
    }

    public Object getTag(@IdRes int id) {
        return getView(id).getTag();
    }

    /**
     * Sets a drawable as the content of this ImageView.
     */
    public CommonHolder setImageResource(@IdRes int id, @DrawableRes int resId) {
        ImageView view = getView(id);
        view.setImageResource(resId);
        return this;
    }

    /**
     * Sets a Bitmap as the content of this ImageView.
     */
    public CommonHolder setImageBitmap(@IdRes int id, Bitmap bitmap) {
        ImageView view = getView(id);
        view.setImageBitmap(bitmap);
        return this;
    }

    /**
     * Set the background to a given resource.
     */
    public CommonHolder setBackgroundResource(@IdRes int id, @DrawableRes int resId) {
        View view = getView(id);
        view.setBackgroundResource(resId);
        return this;
    }

    /**
     * Sets the background color for this view.
     */
    public CommonHolder setBackgroundColor(@IdRes int id, @ColorInt int color) {
        View view = getView(id);
        view.setBackgroundColor(color);
        return this;
    }

    /**
     * Sets the text color for all the states (normal, selected,
     * focused) to be this color.
     */
    public CommonHolder setTextColor(@IdRes int id, @ColorInt int color) {
        TextView view = getView(id);
        view.setTextColor(color);
        return this;
    }
}
