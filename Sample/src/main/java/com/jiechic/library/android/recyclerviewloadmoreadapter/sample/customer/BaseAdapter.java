package com.jiechic.library.android.recyclerviewloadmoreadapter.sample.customer;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.jiechic.library.android.recyclerviewloadmoreadapter.LoadMoreViewHolder;
import com.jiechic.library.android.recyclerviewloadmoreadapter.RecyclerViewLoadMoreAdapter;
import com.jiechic.library.android.recyclerviewloadmoreadapter.sample.R;

/**
 * Created by <a href="http://www.jiechic.com" target="_blank">jiechic</a> on 15/8/18.
 */
public abstract class BaseAdapter<VH extends RecyclerView.ViewHolder> extends RecyclerViewLoadMoreAdapter<RecyclerView.ViewHolder> {

    @Override
    public LoadMoreViewHolder onCreateLoadMoreItemViewHolder(ViewGroup parent, int viewType) {
        return new BaseLoadViewHolder(LayoutInflater.from(parent.getContext()).inflate(BaseLoadViewHolder.LAYOUT_ID,parent,false));
    }

    @Override
    public void onBindLoadMoreItemView(LoadMoreViewHolder holder, int position) {
        ((BaseLoadViewHolder)holder).bind();
    }

    public static class BaseLoadViewHolder extends LoadMoreViewHolder {

        public static final int LAYOUT_ID = R.layout.loadmoreitem;
        @Bind(R.id.progressbar)
        ProgressBar progressbar;

        public BaseLoadViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        @Override
        protected void onLoadComplete() {
            progressbar.setVisibility(View.INVISIBLE);
        }

        public void bind() {
            progressbar.setVisibility(View.VISIBLE);
            loadMore();
        }
    }
}
