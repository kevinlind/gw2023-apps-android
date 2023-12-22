package com.example.myapplication;

import android.app.Application;
import com.adobe.marketing.mobile.AdobeCallback;
import com.adobe.marketing.mobile.InvalidInitException;
import com.adobe.marketing.mobile.MobileCore;
import com.adobe.marketing.mobile.Identity;
import com.adobe.marketing.mobile.Lifecycle;
import com.adobe.marketing.mobile.LoggingMode;
import java.util.HashMap;

public class MyFirstApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        MobileCore.setApplication(this);
        MobileCore.setLogLevel(LoggingMode.DEBUG);

        try {
            MobileCore.start(new AdobeCallback() {
                @Override
                public void call(Object o) {
                    MobileCore.configureWithAppId("SAMPLE_APP_ID");
                }
            });
        } catch (InvalidInitException e) {
            // Log the exception
        }        
        
        HashMap<String, Object> data = new HashMap<String, Object>();
        data.put("global.privacy", "optedout");
        MobileCore.updateConfiguration(data);
        
        MobileCore.configureWithFileInPath("absolute/path/to/exampleJSONfile.json");
        MobileCore.configureWithFileInAssets("exampleJSONfile.json");
        
        MobileCore.clearUpdatedConfiguration();
        
        try {
            Lifecycle.registerExtension();
            Identity.registerExtension();
        } catch (InvalidInitException e) {
            // Log the exception
        }
    }
}