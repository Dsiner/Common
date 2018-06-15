package com.d.lib.common.view.toggle;

public interface ToggleView {
    boolean isOpen();

    void setOpen(boolean open);

    /**
     * Toggle
     */
    void toggle();
}
