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
import com.ultimate.www.component_application.data.PersonCenterMenuBean;
import com.ultimate.www.component_application.ui.activitys.TabActivity;
import com.ultimate.www.component_application.ui.adapters.PersonCenterGridViewMenuAdapter;
import com.ultimate.www.component_application.ui.adapters.PersonCenterMenuAdapter;
import com.ultimate.www.component_application.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

public class MeFragment extends Fragment implements View.OnClickListener {

    private MeViewModel meViewModel;
    private List<PersonCenterMenuBean> list = new ArrayList<>();
    private List<PersonCenterMenuBean> gridViewList = new ArrayList<>();
    private PersonCenterGridViewMenuAdapter personCenterGridViewMenuAdapter;
    private Intent intent;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        String[] gridViewNames = {
                getResources().getString(R.string.person_center_menu_one),
                getResources().getString(R.string.person_center_menu_two),
                getResources().getString(R.string.person_center_menu_three)
        };
        Integer[] gridViewIds = new Integer[]{
                R.mipmap.ic_person_center_dynamic,
                R.mipmap.ic_person_center_charge_station,
                R.mipmap.ic_person_center_wechat
        };
        String[] names = {
                "修改密码",
                "修改绑定手机",
                "消息推送",
                "修改组名",
                "清除缓存",
                "加入白名单",
                "关于我们",
                "意见反馈"
        };
        Integer[] ids = new Integer[]{
                R.mipmap.component_tomatoes_logo,
                R.mipmap.component_tomatoes_logo,
                R.mipmap.component_tomatoes_logo,
                R.mipmap.component_tomatoes_logo,
                R.mipmap.component_tomatoes_logo,
                R.mipmap.component_tomatoes_logo,
                R.mipmap.component_tomatoes_logo,
                R.mipmap.component_tomatoes_logo
        };


        meViewModel = ViewModelProviders.of(this).get(MeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_me, container, false);
        ListView menusLv = root.findViewById(R.id.memu_lv);
        GridView menusGv = root.findViewById(R.id.menu_gv);
        ImageView settingTv = root.findViewById(R.id.setting_tv);

        //=================================================================================
        PersonCenterMenuAdapter personCenterMenuAdapter = new PersonCenterMenuAdapter(getActivity());
        for (int i=0;i<8;i++){
            PersonCenterMenuBean personCenterMenuBean = new PersonCenterMenuBean();
            personCenterMenuBean.setMenuIcon(ids[i]);
            personCenterMenuBean.setMenuName(names[i]);
            list.add(personCenterMenuBean);
        }
        personCenterMenuAdapter.setMenuData(list);
        menusLv.setAdapter(personCenterMenuAdapter);

        //==================================================================================
        personCenterGridViewMenuAdapter = new PersonCenterGridViewMenuAdapter(getActivity());
        for (int i=0;i<gridViewNames.length;i++){
            PersonCenterMenuBean personCenterMenuBean = new PersonCenterMenuBean();
            personCenterMenuBean.setMenuIcon(gridViewIds[i]);
            personCenterMenuBean.setMenuName(gridViewNames[i]);
            gridViewList.add(personCenterMenuBean);
        }
        personCenterGridViewMenuAdapter.setMenuData(gridViewList,0);
        menusGv.setAdapter(personCenterGridViewMenuAdapter);
        menusGv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        ToastUtil.show(getActivity(),"菜单一");
                        break;
                    case 1:
                        ToastUtil.show(getActivity(),"菜单二");
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