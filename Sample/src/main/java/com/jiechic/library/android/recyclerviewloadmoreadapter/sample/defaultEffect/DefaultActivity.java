package com.jiechic.library.android.recyclerviewloadmoreadapter.sample.defaultEffect;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.jiechic.library.android.recyclerviewloadmoreadapter.sample.R;

import java.util.ArrayList;
import java.util.List;


public class DefaultActivity extends ActionBarActivity {
    List<String> myDataset = new ArrayList<>();
    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;

    DefaultAdapter adapter = new DefaultAdapter(myDataset);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loadmore);
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
        adapter.setOnLoadListener(() -> recyclerView.postDelayed(() -> {
            onLoadMore();
            adapter.loadComplete();
        }, 2000));

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
