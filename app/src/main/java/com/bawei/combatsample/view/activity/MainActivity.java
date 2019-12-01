package com.bawei.combatsample.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridView;

import com.bawei.combatsample.R;
import com.bawei.combatsample.base.BaseActivity;
import com.bawei.combatsample.contract.IMainContract;
import com.bawei.combatsample.model.bean.Bean;
import com.bawei.combatsample.presenter.HomePresenter;
import com.bawei.combatsample.view.adapter.GridAdapter;

import java.util.List;

public class MainActivity extends BaseActivity {


    private GridView gv;

    @Override
    protected void initView() {
        HomePresenter homePresenter = new HomePresenter();
        homePresenter.onMainData(new IMainContract.IView() {
            @Override
            public void onHomeSuccess(Bean bean) {
                List<Bean.ListdataBean> listdata = bean.getListdata();
                gv.setAdapter(new GridAdapter(listdata));
            }

            @Override
            public void onHomeFailure(Throwable throwable) {
                Log.i("xxx", String.valueOf(throwable));
            }
        });
    }

    @Override
    protected void initId() {
        gv = findViewById(R.id.gv);
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }
}
