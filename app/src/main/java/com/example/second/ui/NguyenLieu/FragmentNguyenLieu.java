package com.example.second.ui.NguyenLieu;

import androidx.fragment.app.Fragment;

import com.example.second.databinding.FragmentNguyenLieuBinding;
public class FragmentNguyenLieu extends Fragment {

private FragmentNguyenLieuBinding binding;

//    public View onCreateView(@NonNull LayoutInflater inflater,
//            ViewGroup container, Bundle savedInstanceState) {
//        SanPhamViewModel sanPhamViewModel =
//                new ViewModelProvider(this).get(SanPhamViewModel.class);
//
//    binding = FragmentSanPhamBinding.inflate(inflater, container, false);
//    View root = binding.getRoot();
//
//        final TextView textView = binding.textSanPham;
//        sanPhamViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
//        return root;
//    }


@Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}