package com.ultimate.www.component_application.ui.me;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.ultimate.www.component_application.R;
import com.ultimate.www.component_application.ui.activitys.ui.TestActivity;
import com.ultimate.www.component_application.ui.activitys.ui.tab.TabActivity;
import com.ultimate.www.component_application.ui.adapters.PersonCenterGridViewMenuAdapter;
import com.ultimate.www.component_application.ui.adapters.PersonCenterMenuAdapter;
import com.ultimate.www.component_application.utils.ToastUtil;
import com.ultimate.www.moduleone.SettingsActivity;

public class MeFragment extends Fragment implements View.OnClickListener {

    private MeViewModel meViewModel;
    private PersonCenterGridViewMenuAdapter personCenterGridViewMenuAdapter;
    private PersonCenterMenuAdapter personCenterMenuAdapter;
    private Intent intent;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        meViewModel = ViewModelProviders.of(getActivity()).get(MeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_me, container, false);
        ListView menusLv = root.findViewById(R.id.memu_lv);
        GridView menusGv = root.findViewById(R.id.menu_gv);
        ImageView settingTv = root.findViewById(R.id.setting_tv);
        //=================================================================================
        if (personCenterMenuAdapter == null) {
            personCenterMenuAdapter = new PersonCenterMenuAdapter(getActivity());
        }
        if (personCenterGridViewMenuAdapter == null) {
            personCenterGridViewMenuAdapter = new PersonCenterGridViewMenuAdapter(getActivity());
        }
        personCenterMenuAdapter.setMenuData(meViewModel.getData().getValue());
        menusLv.setAdapter(personCenterMenuAdapter);
        personCenterGridViewMenuAdapter.setMenuData(meViewModel.getGridViewData().getValue(),0);
        menusGv.setAdapter(personCenterGridViewMenuAdapter);
        menusGv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        ToastUtil.show(getActivity(),"菜单一");
                        intent = new Intent(getActivity(), SettingsActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        ToastUtil.show(getActivity(),"测试页面");
                        intent = new Intent(getActivity(),TestActivity.class);
                        startActivity(intent);
                        break;
                    case 2:
                        ToastUtil.show(getActivity(),"菜单三");
                        break;
                }
            }
        });

        settingTv.setOnClickListener(this);

        return root;
    }





    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.setting_tv:
                intent = new Intent(getActivity(), TabActivity.class);
                startActivity(intent);
                break;
        }
    }
}