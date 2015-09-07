package com.jiechic.library.android.recyclerviewloadmoreadapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

/**
 * Created by <a href="http://www.jiechic.com" target="_blank">jiechic</a> on 15/8/17.
 */
public abstract class RecyclerViewLoadMoreAdapter<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    private static final int TYPE_LOADMORE = Integer.MIN_VALUE;
    private static final int TYPE_ADAPTEE_OFFSET = 2;
    private boolean canLoadMore = false;
    private MoreViewHolder loadMoreHolder;
    private OnLoadListener listener;
    protected MoreViewHolder.OnLoadListener viewHolderListener = new MoreViewHolder.OnLoadListener() {
        @Override
        public void onLoad() {
            if (listener != null) {
                listener.onLoad();
            }
        }
    };


    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_LOADMORE) {
            return (VH) onCreateLoadMoreItemViewHolder(parent, viewType);
        }
        return onCreateContentItemViewHolder(parent, viewType - TYPE_ADAPTEE_OFFSET);
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        if (position == getContentItemCount() && holder.getItemViewType() == TYPE_LOADMORE) {
            onBindLoadMoreItemView((MoreViewHolder) holder, position);
            loadMoreHolder = (MoreViewHolder) holder;
            loadMoreHolder.setLoadListener(viewHolderListener);
        } else {
            onBindContentItemView((VH) holder, position);
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

    public void setCanLoadMore(boolean canLoadMore) {
        this.canLoadMore = canLoadMore;
        notifyDataSetChanged();
    }

    public abstract VH onCreateContentItemViewHolder(ViewGroup parent, int viewType);//创建你要的普通item

    public abstract void onBindContentItemView(VH holder, int position);//绑定数据

    public abstract int getContentItemCount();

    public abstract int getContentItemType(int position);//没用到，返回0即可，为了扩展用的

    public MoreViewHolder onCreateLoadMoreItemViewHolder(ViewGroup parent, int viewType)//创建你要的普通item
    {
        MoreViewHolder holder=new LoadViewHolder(LayoutInflater.from(parent.getContext()).inflate(LoadViewHolder.LAYOUT_ID, parent, false));
        holder.setLoadListener(viewHolderListener);
        return holder;
    }

    public void onBindLoadMoreItemView(MoreViewHolder holder, int position)//绑定数据
    {

    }

    public void loadComplete() {
        if (loadMoreHolder != null) {
            loadMoreHolder.loadComplete();
        }
    }

    public interface OnLoadListener {
        void onLoad();
    }

    public void setOnLoadListener(OnLoadListener listener) {
        this.listener = listener;
    }


    public static class LoadViewHolder extends MoreViewHolder {

        public static final int LAYOUT_ID = com.jiechic.library.android.recyclerviewloadmoreadapter.R.layout.adapter_loadmore_item;
        Button button;
        ProgressBar progressbar;

        public LoadViewHolder(View itemView) {
            super(itemView);
            button = (Button) itemView.findViewById(com.jiechic.library.android.recyclerviewloadmoreadapter.R.id.button);
            progressbar = (ProgressBar) itemView.findViewById(com.jiechic.library.android.recyclerviewloadmoreadapter.R.id.progressbar);
            button.setOnClickListener((View v) -> {
                loadMore();
                button.setVisibility(View.GONE);
                progressbar.setVisibility(View.VISIBLE);
            });
            button.setVisibility(View.VISIBLE);
            progressbar.setVisibility(View.GONE);
        }

        @Override
        protected void onLoadComplete() {
            button.setVisibility(View.VISIBLE);
            progressbar.setVisibility(View.GONE);
        }
    }

}
