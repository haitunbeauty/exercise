package com.ultimate.www.component_application.ui.me;


import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ultimate.www.component_application.R;
import com.ultimate.www.component_application.data.PersonCenterMenuBean;

import java.util.ArrayList;
import java.util.List;

public class MeViewModel extends ViewModel {


    Integer[] mNames = new Integer[]{
            R.string.person_center_menu_one,
            R.string.person_center_menu_two,
            R.string.person_center_menu_three,
            R.string.person_center_menu_three,
            R.string.person_center_menu_three,
            R.string.person_center_menu_three,
            R.string.person_center_menu_three,
            R.string.person_center_menu_three
    };
    Integer[] mGridViewNames = new Integer[]{
            R.string.person_center_menu_one,
            R.string.person_center_menu_two,
            R.string.person_center_menu_three
    };
    Integer[] mIds = new Integer[]{
            R.mipmap.ic_component_tomatoes_logo,
            R.mipmap.ic_component_tomatoes_logo,
            R.mipmap.ic_component_tomatoes_logo,
            R.mipmap.ic_component_tomatoes_logo,
            R.mipmap.ic_component_tomatoes_logo,
            R.mipmap.ic_component_tomatoes_logo,
            R.mipmap.ic_component_tomatoes_logo,
            R.mipmap.ic_component_tomatoes_logo
    };
    Integer[] mGridViewIds = new Integer[]{
            R.mipmap.ic_person_center_dynamic,
            R.mipmap.ic_person_center_charge_station,
            R.mipmap.ic_person_center_wechat
    };


    MutableLiveData<List<PersonCenterMenuBean>> datas = new MutableLiveData<>();
    ArrayList<PersonCenterMenuBean> list = new ArrayList<>();
    MutableLiveData<List<PersonCenterMenuBean>> gridViewDatas = new MutableLiveData<>();
    ArrayList<PersonCenterMenuBean> gridViewList = new ArrayList<>();

    public MeViewModel() {

    }

    public MutableLiveData<Integer[]> getNames(){
        MutableLiveData<Integer[]> names = new MutableLiveData<>();
        names.setValue(mNames);
        return names;
    }

    public MutableLiveData<Integer[]> getGridViewNames(){
        MutableLiveData<Integer[]> gridViewNames = new MutableLiveData<>();
        gridViewNames.setValue(mGridViewNames);
        return gridViewNames;
    }
    public MutableLiveData<Integer[]> getIds(){
        MutableLiveData<Integer[]> ids = new MutableLiveData<>();
        ids.setValue(mIds);
        return ids;
    }
    public MutableLiveData<Integer[]> getGridViewIds(){
        MutableLiveData<Integer[]> gridViewIds = new MutableLiveData<>();
        gridViewIds.setValue(mGridViewIds);
        return gridViewIds;
    }

    public MutableLiveData<List<PersonCenterMenuBean>> getData(){
        if (list.size() == 0) {
            for (int i = 0; i < 8; i++) {
                PersonCenterMenuBean personCenterMenuBean = new PersonCenterMenuBean();
                personCenterMenuBean.setMenuIcon(mIds[i]);
                personCenterMenuBean.setMenuName(mNames[i]);
                list.add(personCenterMenuBean);
            }
            datas.setValue(list);
        }
        return datas;
    }

    public MutableLiveData<List<PersonCenterMenuBean>> getGridViewData(){
        if (gridViewList.size() == 0) {
            for (int i = 0; i < 3; i++) {
                PersonCenterMenuBean personCenterMenuBean = new PersonCenterMenuBean();
                personCenterMenuBean.setMenuIcon(mGridViewIds[i]);
                personCenterMenuBean.setMenuName(mGridViewNames[i]);
                gridViewList.add(personCenterMenuBean);
            }
            gridViewDatas.setValue(gridViewList);
        }
        return gridViewDatas;
    }

}