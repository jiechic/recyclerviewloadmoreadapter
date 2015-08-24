package com.jiechic.library.android.recyclerviewloadmoreadapter.sample.customer;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by <a href="http://www.jiechic.com" target="_blank">jiechic</a> on 15/8/18.
 */
public class CustomerAdapter extends BaseAdapter<RecyclerView.ViewHolder> {

    final List<String> list;

    public CustomerAdapter(List<String> list) {
        if (list!=null){
            this.list = list;
        }else{
            this.list=new ArrayList<>();
        }
    }


    @Override
    public RecyclerView.ViewHolder onCreateContentItemViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false));

    }

    @Override
    public void onBindContentItemView(RecyclerView.ViewHolder holder, int position) {
        ((ViewHolder) holder).textView.setText(list.get(position));
    }

    @Override
    public int getContentItemCount() {
        return this.list.size();
    }

    @Override
    public int getContentItemType(int position) {
        return 0;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView;
        }
    }
}
