package com.example.rnandandroid.embed_fragments;

import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;

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

//        FragmentTransaction ft = this.mCallerContext.getBaseContext().getApplicationContext(). .getCurrentActivity().getFragmentManager().beginTransaction();
//        ft.replace(R.id.your_placeholder, (Fragment) new CustomFragment());
//        ft.commit();

        return fragmentContrainerView;
    }
}
