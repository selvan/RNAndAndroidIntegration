package com.example.rnandandroid;

import com.example.rnandandroid.embed_fragments.ReactFragmentViewManager;
import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyAppPackage implements ReactPackage {

    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
        return Arrays.<ViewManager>asList(
                new ReactFragmentViewManager(reactContext)
        );
    }

    @Override
    public List<NativeModule> createNativeModules(
            ReactApplicationContext reactContext) {
        List<NativeModule> modules = new ArrayList<>();

        modules.add(new ModuleForStartActivityFromRN(reactContext));

        return modules;
    }

}