package com.jiechic.library.android.recyclerviewloadmoreadapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by <a href="http://www.jiechic.com" target="_blank">jiechic</a> on 15/8/17.
 */
public abstract class MoreViewHolder extends RecyclerView.ViewHolder {

    private OnLoadListener loadListener;
    private boolean isLoad = false;

    public MoreViewHolder(View itemView) {
        super(itemView);
    }

    protected interface OnLoadListener {
        void onLoad();
    }

    protected void loadMore() {
        if (!isLoad && loadListener != null) {
            loadListener.onLoad();
            isLoad = true;
        }

    }

    public void loadComplete() {
        isLoad=false;
        onLoadComplete();
    }

    protected abstract void onLoadComplete();

    public void setLoadListener(OnLoadListener loadListener) {
        this.loadListener = loadListener;
    }

}
