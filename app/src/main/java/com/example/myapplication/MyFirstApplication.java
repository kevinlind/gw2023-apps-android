package com.example.myapplication;

import android.app.Application;
import com.adobe.marketing.mobile.*;
import java.util.HashMap;

public class MyFirstApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        MobileCore.setApplication(this);
        MobileCore.configureWithAppId("SAMPLE_APP_ID");

        HashMap<String, Object> data = new HashMap<String, Object>();
        data.put("global.privacy", "optedout");
        MobileCore.updateConfiguration(data);

        try {
            MobileCore.start(new AdobeCallback() {
                @Override
                public void call(Object o) {
                    MobileCore.configureWithAppId("SAMPLE_APP_ID");
                }
            });
        } catch (InvalidInitException e) {
            //Log the exception
        }
    }
}