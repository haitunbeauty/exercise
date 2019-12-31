package com.ultimate.www.component_application;

import android.app.Application;
import android.content.Context;

import com.alibaba.android.arouter.launcher.ARouter;
import com.androidnetworking.AndroidNetworking;

public class ComponentApplication extends Application {

    public ComponentApplication() {
        super();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);

    }

    @Override
    public void onCreate() {
        super.onCreate();
//        OkHttpClient okHttpClient = new OkHttpClient() .newBuilder()
//                .addNetworkInterceptor(new Interceptor() {
//                    @Override
//                    public Response intercept(Chain chain) throws IOException {
//                        //TODO you can do something youself
//                        return null;
//                    }
//                })
//                .build();
//        AndroidNetworking.initialize(getApplicationContext(),okHttpClient);
        AndroidNetworking.initialize(getApplicationContext());
        if (true) {           // These two lines must be written before init, otherwise these configurations will be invalid in the init process
            ARouter.openLog();     // Print log
            ARouter.openDebug();   // Turn on debugging mode (If you are running in InstantRun mode, you must turn on debug mode! Online version needs to be closed, otherwise there is a security risk)
        }
        ARouter.init(this); // As early as possible, it is recommended to initialize in the Application
    }

    //TODO 这里用单例 我就简单处理了
    public static Application getInstant(){
        return new ComponentApplication();
    }
}
