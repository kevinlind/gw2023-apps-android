package com.example.myapplication;

import android.app.Application;
import com.adobe.marketing.mobile.*;

public class MyFirstApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        MobileCore.setApplication(this);
        MobileCore.configureWithAppID("SAMPLE_APP_ID");

        try {
            Identity.registerExtension();
            Lifecycle.registerExtension();
            MobileCore.start(null);
        } catch (Exception e) {
            // Log the exception
        }
    }


    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        if (level == TRIM_MEMORY_UI_HIDDEN) {
            MobileCore.lifecyclePause();
        }
    }

    @Override
    public void onActivityResumed(Activity activity) {
        super.onActivityResumed(activity);
        MobileCore.setApplication(this);
        MobileCore.lifecycleStart(null);
    }
}