package com.bawei.combatsample.presenter;

import com.bawei.combatsample.contract.IMainContract;
import com.bawei.combatsample.model.bean.Bean;
import com.bawei.combatsample.model.bean.MainModel;

public class HomePresenter {
    public void onMainData(final IMainContract.IView iView){
        MainModel mainModel = new MainModel();
        mainModel.getMainData(new IMainContract.IModelCallback() {
            @Override
            public void onHomeSuccess(Bean bean) {
                iView.onHomeSuccess(bean);
            }

            @Override
            public void onHomeFailure(Throwable throwable) {
                iView.onHomeFailure(throwable);
            }
        });
    }
}
