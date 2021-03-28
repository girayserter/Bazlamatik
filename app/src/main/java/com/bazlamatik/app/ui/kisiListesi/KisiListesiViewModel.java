package com.bazlamatik.app.ui.kisiListesi;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class KisiListesiViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public KisiListesiViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}