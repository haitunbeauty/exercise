package com.ultimate.www.component_application.ui.activitys.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.ultimate.www.component_application.R;

public class TestActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        TextView test1 = findViewById(R.id.test1);
        test1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.test1:
                // 1. Simple jump within application (Jump via URL in 'Advanced usage')
//                ARouter.getInstance().build("/ui/activitys/ui/tab/TabActivity").navigation();
                ARouter.getInstance().build("/test/CommonBaseEnptyActivity").navigation();
                break;


            case R.id.test2:
                break;
        }

    }
}
