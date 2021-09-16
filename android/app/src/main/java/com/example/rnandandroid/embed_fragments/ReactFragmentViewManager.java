package com.example.rnandandroid.embed_fragments;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentTransaction;

import com.example.rnandandroid.MyReactActivity;
import com.example.rnandandroid.R;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.touch.JSResponderHandler;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ThemedReactContext;

public class ReactFragmentViewManager extends SimpleViewManager<View> {

    public static final String REACT_NAME = "NativeFragmentView";

    private static ReactApplicationContext mCallerContext;


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

        fragmentContrainerView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
            @Override
            public void onViewAttachedToWindow(View v) {
                MyReactActivity currentActivity = (MyReactActivity) mCallerContext.getCurrentActivity();

                View fragmentHolder = fragmentContrainerView.findViewById(R.id.your_placeholder);
                Log.d("ReactFragmentViewManager", String.valueOf(fragmentHolder == null));

                if(fragmentHolder == null) {
                    return;
                }

                FragmentTransaction ft = currentActivity.getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.your_placeholder, new CustomFragment(), "frag");
                ft.commit();
            }

            @Override
            public void onViewDetachedFromWindow(View v) {
            }
        });

        return fragmentContrainerView;
    }
}
