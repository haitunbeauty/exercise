package com.ultimate.www.basemodule.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class PluginProviderService extends Service {
    public PluginProviderService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return new CommonProviderImp();
    }
}
