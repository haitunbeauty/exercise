package com.ultimate.www.basemodule.aidl;

import android.os.RemoteException;

public class CommonProviderImp extends CommonStub {
    @Override
    public String getJsonData(String jsonParm) throws RemoteException {



        return "result data string+parm:"+jsonParm;
    }
}
