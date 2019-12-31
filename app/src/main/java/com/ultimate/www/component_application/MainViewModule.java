package com.ultimate.www.component_application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModule extends ViewModel {

    private MutableLiveData<String> mText;
    private MutableLiveData<Integer> mCount;

    public MainViewModule() {
        mText = new MutableLiveData<>();
        mCount = new MutableLiveData<>();
        mText.setValue("This is MainActivity Content!");
    }

    public LiveData<String> getText() {
        return mText;
    }

    public LiveData<Integer> getMsgCount() {
        mCount.setValue(5);
        return mCount;
    }

}
