package com.jiechic.lbrary.android.recyclerviewloadmoreadapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

/**
 * Created by <a href="http://www.jiechic.com" target="_blank">jiechic</a> on 15/8/17.
 */
public abstract class RecyclerViewLoadMoreAdapter<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private static final int TYPE_LOADMORE = Integer.MIN_VALUE;
    private static final int TYPE_ADAPTEE_OFFSET = 2;
    private boolean canLoadMore = false;


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_LOADMORE) {
            return onCreateLoadMoreItemViewHolder(parent, viewType);
        }
        return onCreateContentItemViewHolder(parent, viewType - TYPE_ADAPTEE_OFFSET);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position == getContentItemCount() && holder.getItemViewType() == TYPE_LOADMORE) {
            onBindLoadMoreItemView(holder, position);
        } else {
            onBindContentItemView(holder, position);
        }
    }

    @Override
    public int getItemViewType(int position) {

        if (position == getContentItemCount() && canLoadMore) {
            return TYPE_LOADMORE;
        }
        return getContentItemType(position) + TYPE_ADAPTEE_OFFSET;
    }

    @Override
    public int getItemCount() {
        int itemCount = getContentItemCount();
        if (canLoadMore) {
            itemCount += 1;
        }
        return itemCount;
    }

    public void setCanLoadMore(boolean canLoadMore){
        this.canLoadMore = canLoadMore;
        notifyDataSetChanged();
    }

    public abstract RecyclerView.ViewHolder onCreateContentItemViewHolder(ViewGroup parent, int viewType);//创建你要的普通item

    public abstract void onBindContentItemView(RecyclerView.ViewHolder holder, int position);//绑定数据

    public abstract int getContentItemCount();

    public abstract int getContentItemType(int position);//没用到，返回0即可，为了扩展用的

    public abstract RecyclerView.ViewHolder onCreateLoadMoreItemViewHolder(ViewGroup parent, int viewType);//创建你要的普通item

    public abstract void onBindLoadMoreItemView(RecyclerView.ViewHolder holder, int position);//绑定数据
}
