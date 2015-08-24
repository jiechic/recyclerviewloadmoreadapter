package com.jiechic.library.android.recyclerviewloadmoreadapter.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.jiechic.lbrary.android.recyclerviewloadmoreadapter.sample.customer.CustomerActivity;
import com.jiechic.lbrary.android.recyclerviewloadmoreadapter.sample.defaultEffect.DefaultActivity;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    @Bind(R.id.bt_default)
    Button btDefault;
    @Bind(R.id.bt_customer)
    Button btCustomer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        btCustomer.setOnClickListener(this);
        btDefault.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent=null;
        switch (v.getId()){
            case R.id.bt_default:
                intent=new Intent(MainActivity.this, DefaultActivity.class);
                break;
            case R.id.bt_customer:
                intent=new Intent(MainActivity.this, CustomerActivity.class);
                break;
        }
        if (intent!=null){
            startActivity(intent);
        }
    }
}
