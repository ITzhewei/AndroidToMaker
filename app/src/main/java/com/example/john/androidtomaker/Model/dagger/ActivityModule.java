package com.example.john.androidtomaker.Model.dagger;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ZheWei on 2016/9/12.
 */
@Module
public class ActivityModule {
    private DaggerActivity mActivity;

    public ActivityModule(DaggerActivity activity) {
        mActivity = activity;
    }

    @Provides
    public DaggerActivity provideActivity() {
        return mActivity;
    }

    @Provides
    public User provideUser() {
        return new User("zzw");
    }

    @Provides
    public DaggerPresenter providePresenter(DaggerActivity activity, User user) {
        return new DaggerPresenter(activity, user);
    }
}
