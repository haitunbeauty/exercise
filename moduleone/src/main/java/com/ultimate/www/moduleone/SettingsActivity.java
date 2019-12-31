package com.ultimate.www.moduleone;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceFragmentCompat;

//import com.ultimate.www.basemodule.aidl.CommonProvider;
//import com.ultimate.www.basemodule.aidl.CommonProxy;
//import com.ultimate.www.basemodule.aidl.PluginProviderService;

//import com.ultimate.www.basemodule.BaseTestUtil;

public class SettingsActivity extends AppCompatActivity implements ServiceConnection {

//    private CommonProvider provider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.settings, new SettingsFragment())
                .commit();
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        TextView textView = findViewById(R.id.test);


        //TODO
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("test://com.app.test:8888/app?id=1001")));
            }
        });


//        Intent intent=new Intent();
//        intent.setComponent(new ComponentName(getPackageName(), PluginProviderService.class.getName()));
//
//        bindService(intent,this, BIND_AUTO_CREATE);

        //Todo
//        String test = BaseTestUtil.test();
//        textView.setText(test);

    }

    public static class SettingsFragment extends PreferenceFragmentCompat {
        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            setPreferencesFromResource(R.xml.root_preferences, rootKey);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

//        unbindService(this);
    }

    @Override
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
//        provider = CommonProxy.asInterface(iBinder);
//        try {
//            Log.i(SettingsActivity.class.getSimpleName(), provider.getJsonData("input"));
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public void onServiceDisconnected(ComponentName componentName) {
//        provider=null;
    }






}