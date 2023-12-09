package com.example.myapplication;

import android.app.Application;
import com.adobe.marketing.mobile.MobileCore;
import com.adobe.marketing.mobile.Lifecycle;
import com.adobe.marketing.mobile.Identity;
import java.utils.Arrays;

public class MyFirstApplication extends Application {
  @Override public void onCreate() {
    super.onCreate();
    MobileCore.setApplication(this);
    MobileCore.configureWithAppID('yourAppId');
    MobileCore.registerExtension(
      Arrays.asList(Identity.EXTENSION, Lifecycle.EXTENSION),
      o -> Log.debug('MyFirstApplication', 'AEP Mobile SDK initialized')
    );
  }
}
