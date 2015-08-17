package com.jiechic.lbrary.android.recyclerviewloadmoreadapter.sample;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.jiechic.lbrary.android.recyclerviewloadmoreadapter.RecyclerViewLoadMoreAdapter;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {
    List<String> myDataset = new ArrayList<>();
    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;

    Adapter adapter = new Adapter(myDataset);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);
        adapter.setCanLoadMore(true);


        myDataset.add("aa");
        myDataset.add("aa");
        myDataset.add("aa");
        myDataset.add("aa");
        myDataset.add("aa");
        myDataset.add("aa");
        myDataset.add("aa");
        myDataset.add("aa");
        myDataset.add("aa");
        myDataset.add("aa");
        myDataset.add("aa");
        myDataset.add("aa");
        myDataset.add("aa");
        myDataset.add("aa");
        myDataset.add("aa");
        adapter.notifyDataSetChanged();

    }

    public class Adapter extends RecyclerViewLoadMoreAdapter<RecyclerView.ViewHolder> {
        final List<String> list;

        public Adapter(List<String> list) {
            this.list = list;
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
            if (list == null) {
                return 0;
            } else {
                return list.size();
            }
        }

        @Override
        public int getContentItemType(int position) {
            return 0;
        }

        @Override
        public RecyclerView.ViewHolder onCreateLoadMoreItemViewHolder(ViewGroup parent, int viewType) {
            return new LoadHolder(LayoutInflater.from(parent.getContext()).inflate(LoadHolder.LAYOUT_ID, parent, false));
        }

        @Override
        public void onBindLoadMoreItemView(RecyclerView.ViewHolder holder, int position) {

        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            public TextView textView;

            public ViewHolder(View itemView) {
                super(itemView);
                textView = (TextView) itemView;
            }
        }

        public class LoadHolder extends RecyclerView.ViewHolder {

            public static final int LAYOUT_ID = R.layout.loadmoreitem;
            @Bind(R.id.progressbar)
            ProgressBar progressbar;
            @Bind(R.id.button)
            Button button;

            public LoadHolder(View itemView) {
                super(itemView);
                ButterKnife.bind(this, itemView);
                button.setVisibility(View.VISIBLE);
                progressbar.setVisibility(View.GONE);
                button.setOnClickListener((View v) -> {
                    button.setVisibility(View.GONE);
                    progressbar.setVisibility(View.VISIBLE);
                    button.postDelayed(() -> {
                        onLoadMore();
                        button.setVisibility(View.VISIBLE);
                        progressbar.setVisibility(View.GONE);
                    },2000);
                });

            }
        }
    }

    private void onLoadMore() {


        if (myDataset.size() < 50) {
            myDataset.add("ccccc");
            myDataset.add("ccccc");
            myDataset.add("ccccc");
            myDataset.add("ccccc");
            myDataset.add("ccccc");
            myDataset.add("ccccc");
            myDataset.add("ccccc");
            myDataset.add("ccccc");
            myDataset.add("ccccc");
            myDataset.add("ccccc");
            myDataset.add("ccccc");
            myDataset.add("ccccc");
            myDataset.add("ccccc");
            myDataset.add("ccccc");
            myDataset.add("ccccc");
            myDataset.add("ccccc");
            adapter.setCanLoadMore(true);
        } else {
            adapter.setCanLoadMore(false);
        }

        adapter.notifyDataSetChanged();
    }

}
