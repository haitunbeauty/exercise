package com.ultimate.www.basemodule.aidl;

import android.os.IInterface;
import android.os.RemoteException;

public interface CommonProvider extends IInterface {

    String getJsonData(String jsonParm) throws RemoteException;

}
