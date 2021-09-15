package com.example.rnandandroid;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentContainerView;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;

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
