package com.example.rnandandroid.embed_fragments;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentTransaction;

import com.example.rnandandroid.MyReactActivity;
import com.example.rnandandroid.R;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;

public class ReactFragmentViewManager extends SimpleViewManager<View> {

    public static final String REACT_NAME = "NativeFragmentView";

    ReactApplicationContext mCallerContext;


    public ReactFragmentViewManager(ReactApplicationContext reactContext) {
        mCallerContext = reactContext;
    }

    @NonNull
    @Override
    public String getName() {
        return REACT_NAME;
    }

    @NonNull
    @Override
    protected View createViewInstance(@NonNull ThemedReactContext reactContext) {
        View fragmentContrainerView = (View) LayoutInflater.from(reactContext).inflate(
                R.layout.fragment_outter_view,
                null
        );

        MyReactActivity currentActivity = (MyReactActivity) this.mCallerContext.getCurrentActivity();

        FragmentTransaction ft = currentActivity.getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.your_placeholder, new CustomFragment());
        ft.commit();

        return fragmentContrainerView;
    }
}
