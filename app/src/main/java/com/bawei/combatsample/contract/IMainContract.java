package com.bawei.combatsample.contract;

import com.bawei.combatsample.model.bean.Bean;

public interface IMainContract {
    interface IModelCallback{
        void onHomeSuccess(Bean bean);
        void onHomeFailure(Throwable throwable);
    }
    interface IView{
        void onHomeSuccess(Bean bean);
        void onHomeFailure(Throwable throwable);
    }
}
