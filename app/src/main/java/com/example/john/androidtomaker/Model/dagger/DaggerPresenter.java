package com.example.john.androidtomaker.Model.dagger;

/**
 * Created by ZheWei on 2016/9/12.
 */
public class DaggerPresenter {
    DaggerActivity mActivity;
    User mUser;

    public DaggerPresenter(DaggerActivity activity, User user) {
        mActivity = activity;
        mUser = user;
    }

    public void shwoData() {
        mActivity.showUser();
    }
}
