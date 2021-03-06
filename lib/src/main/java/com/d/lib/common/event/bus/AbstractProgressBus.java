package com.d.lib.common.event.bus;

import androidx.annotation.NonNull;
import androidx.annotation.UiThread;

import com.d.lib.common.event.bus.callback.ProgressCallback;

/**
 * AbstractProgressBus
 * Created by D on 2018/1/26.
 */
public abstract class AbstractProgressBus<T, Callback extends ProgressCallback<T>>
        extends AbstractBus<T, Callback> implements ProgressCallback<T> {
    private int mState = DONE;
    private float mProgress;

    @State
    public int getState() {
        return mState;
    }

    public void setState(@State int state) {
        this.mState = state;
    }

    public float getProgress() {
        return mProgress;
    }

    public void setProgress(float progress) {
        this.mProgress = progress;
    }

    /**
     * Whether the task is running...
     */
    public boolean isRunning() {
        return mState >= RUNNING;
    }

    @UiThread
    @Override
    public void onStart() {
        for (int i = 0; i < mCallbacks.size(); i++) {
            Callback l = mCallbacks.get(i);
            if (l != null) {
                l.onStart();
            }
        }
    }

    @UiThread
    @Override
    public void onProgress(@NonNull T progress) {
        for (int i = 0; i < mCallbacks.size(); i++) {
            Callback l = mCallbacks.get(i);
            if (l != null) {
                l.onProgress(progress);
            }
        }
    }

    @UiThread
    @Override
    public void onPending() {
        for (int i = 0; i < mCallbacks.size(); i++) {
            Callback l = mCallbacks.get(i);
            if (l != null) {
                l.onPending();
            }
        }
    }

    @UiThread
    @Override
    public void onCancel() {
        for (int i = 0; i < mCallbacks.size(); i++) {
            Callback l = mCallbacks.get(i);
            if (l != null) {
                l.onCancel();
            }
        }
    }
}
