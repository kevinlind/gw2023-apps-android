package com.example.myapplication;

import android.app.Application;
import com.adobe.marketing.mobile.MobileCore;
import com.adobe.marketing.mobile.Lifecycle;
import com.adobe.marketing.mobile.Identity;
import java.util.Arrays;
import java.util.List;

public class MyFirstApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        MobileCore.setApplication(this);
        MobileCore.configureWithAppId("94f571f308d5/d916733af7a9/launch-91cbae1918ae-development");
        List<Class<? extends Extension>> extensions = Arrays.asList(Lifecycle.EXTENSION, Identity.EXTENSION);
        MobileCore.registerExtensions(extensions, o -> {
        });
    }
}