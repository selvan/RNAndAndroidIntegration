package com.example.rnandandroid;

import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;

public class ReactFragmentViewManager extends ViewGroupManager<FrameLayout> {

    public static final String REACT_NAME = "NativeFragmentView";

    @NonNull
    @Override
    public String getName() {
        return REACT_NAME;
    }

    @NonNull
    @Override
    protected FrameLayout createViewInstance(@NonNull ThemedReactContext reactContext) {
        return new FrameLayout(reactContext);
    }
}
