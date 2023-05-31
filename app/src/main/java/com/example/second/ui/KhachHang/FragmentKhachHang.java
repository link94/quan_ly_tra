package com.example.second.ui.KhachHang;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.example.second.databinding.FragmentKhachHangBinding;

public class FragmentKhachHang extends Fragment {

private FragmentKhachHangBinding binding;

//    public View onCreateView(@NonNull LayoutInflater inflater,
//            ViewGroup container, Bundle savedInstanceState) {
//        KhachHangViewModel slideshowViewModel =
//                new ViewModelProvider(this).get(KhachHangViewModel.class);
//
//    binding = FragmentKhachHangBinding.inflate(inflater, container, false);
//    View root = binding.getRoot();
//
//        final TextView textView = binding.textKhachHang;
//        slideshowViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
//        return root;
//    }

@Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}