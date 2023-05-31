package com.example.second.ui.KhachHang;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class KhachHangViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public KhachHangViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Khách hàng");
    }

    public LiveData<String> getText() {
        return mText;
    }
}