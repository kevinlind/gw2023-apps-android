package com.example.myapplication;

import android.app.Application;
import com.adobe.marketing.mobile.MobileCore;
import com.adobe.marketing.mobile.Identity;
import com.adobe.marketing.mobile.Lifecycle;
import java.util.Arrays;
import java.util.List;

public class MyFirstApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        MobileCore.setApplication(this);
        List<Class<? extends Extension>> extensions = Arrays.asList(Lifecycle.EXTENSION, Identity.EXTENSION);
        MobileCore.registerExtensions(extensions, o -> {
            // Any other post registration processing
        });
    }
}