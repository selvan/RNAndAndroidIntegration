package com.example.rnandandroid;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class ModuleForStartActivityFromRN extends ReactContextBaseJavaModule {
    ModuleForStartActivityFromRN(ReactApplicationContext context) {
        super(context);
    }

    @NonNull
    @Override
    public String getName() {
        return "StartActivityModule";
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public void startFragmentActivity() {
        Log.d("ModuleForStartActivityFromRN", "Starting an activity");
        // ReactApplicationContext context = getReactApplicationContext();
        Context context = getCurrentActivity();
        Intent intent = new Intent(context, FragmentStartActivity.class);
        context.startActivity(intent);
    }
}
