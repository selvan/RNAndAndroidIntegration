package com.example.rnandandroid.embed_fragments;

import android.view.LayoutInflater;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;

import com.example.rnandandroid.R;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;

public class ReactFragmentViewManager extends SimpleViewManager<FrameLayout> {

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
    protected FrameLayout createViewInstance(@NonNull ThemedReactContext reactContext) {
        FrameLayout fragmentContrainerView = (FrameLayout) LayoutInflater.from(reactContext).inflate(
                R.layout.fragment_container_view,
                null
        );
        return fragmentContrainerView;
    }
}
