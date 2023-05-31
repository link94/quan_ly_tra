package com.example.second.ui.NguyenLieu;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NguyenLieuViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public NguyenLieuViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Nguyên Liệu");
    }

    public LiveData<String> getText() {
        return mText;
    }
}