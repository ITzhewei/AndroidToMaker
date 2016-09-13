package com.example.john.androidtomaker.Model.dagger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.john.androidtomaker.R;

import javax.inject.Inject;


public class DaggerActivity extends AppCompatActivity {

    @Inject
    A a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger);

        a = DaggerAComponent.builder().build().a();
        a.doSomething();
    }

    public void showUser() {

    }


}
