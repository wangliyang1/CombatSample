package com.bawei.combatsample.model.bean;

import com.bawei.combatsample.contract.IMainContract;
import com.bawei.combatsample.util.NetUtil;
import com.google.gson.Gson;

public class MainModel {
    public void getMainData(final IMainContract.IModelCallback iModelCallback){
        NetUtil.getInstance().getJson("http://blog.zhaoliang5156.cn/api/news/lawyer.json", new NetUtil.Callback() {
            @Override
            public void OnGetJson(String s) {
                Bean bean = new Gson().fromJson(s, Bean.class);
                iModelCallback.onHomeSuccess(bean);
            }

            @Override
            public void onError(Throwable throwable) {
                iModelCallback.onHomeFailure(throwable);
            }
        });
    }
}
