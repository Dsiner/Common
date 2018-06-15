package com.d.lib.common.view.toggle;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckedTextView;

/**
 * ToggleTextView
 * Created by D on 2018/1/16.
 */
@SuppressLint("AppCompatCustomView")
public class ToggleTextView extends CheckedTextView implements View.OnClickListener {

    private OnToggleListener listener;

    public ToggleTextView(Context context) {
        this(context, null);
    }

    public ToggleTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ToggleTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setOnClickListener(this);
    }

    public boolean isOpen() {
        return isChecked();
    }

    public void setOpen(boolean open) {
        setChecked(open);
    }

    /**
     * Toggle
     */
    public void toggle() {
        setChecked(!isChecked());
    }

    @Override
    public void onClick(View v) {
        toggle();
        if (listener != null) {
            listener.onToggle(isChecked());
        }
    }

    public interface OnToggleListener {
        /**
         * @param isOpen: isOpen
         */
        void onToggle(boolean isOpen);
    }

    public void setOnToggleListener(OnToggleListener listener) {
        this.listener = listener;
    }
}