package com.d.lib.common.widget.toggle;

public interface ToggleView {

    /**
     * Toggle
     */
    void toggle();

    boolean isOpen();

    void setOpen(boolean open);

    void setOnToggleListener(OnToggleListener l);

    interface OnToggleListener {

        /**
         * @param isOpen isOpen
         */
        void onToggle(boolean isOpen);
    }
}
