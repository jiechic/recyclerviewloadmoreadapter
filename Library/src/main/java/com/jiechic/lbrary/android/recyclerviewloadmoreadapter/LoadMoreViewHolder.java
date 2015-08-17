package com.jiechic.lbrary.android.recyclerviewloadmoreadapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by <a href="http://www.jiechic.com" target="_blank">jiechic</a> on 15/8/17.
 */
public abstract class LoadMoreViewHolder extends RecyclerView.ViewHolder {

    private OnLoadListener loadListener;

    public LoadMoreViewHolder(View itemView) {
        super(itemView);
    }

    protected interface OnLoadListener{
        void onLoad();
    }

    protected void loadMore(){
        if (loadListener!=null){
            loadListener.onLoad();
        }
    }

    protected abstract void loadComplete();

}
