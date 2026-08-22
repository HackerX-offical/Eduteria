package com.appnew.android.datamodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/* JADX INFO: loaded from: classes6.dex */
public class IconModel extends ViewModel {
    final MutableLiveData<String> iconUrl;

    public IconModel(String iconUrl) {
        MutableLiveData<String> mutableLiveData = new MutableLiveData<>();
        this.iconUrl = mutableLiveData;
        mutableLiveData.setValue(iconUrl);
    }

    public MutableLiveData<String> getIconUrl() {
        return this.iconUrl;
    }
}
