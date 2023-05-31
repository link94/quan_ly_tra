package com.example.second.ui.SanPham;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.second.R;
import com.example.second.databinding.FragmentSanPhamBinding;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class FragmentSanPham  extends Fragment{

    private FragmentSanPhamBinding binding;
    private RecyclerView rcvData;
    private SanPhamAdapter sanPhamAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        SanPhamViewModel sanPhamViewModel =
                new ViewModelProvider(this).get(SanPhamViewModel.class);
        binding = FragmentSanPhamBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        rcvData =root.findViewById(R.id.rcv_data);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        rcvData.setLayoutManager(linearLayoutManager);

        // Ngăn cách giữa 2 item
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        rcvData.addItemDecoration(itemDecoration);

        sanPhamAdapter = new SanPhamAdapter(getActivity(),getListSanPham());
        rcvData.setAdapter(sanPhamAdapter);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
    List<SanPham> list = new ArrayList<>();
//    public  void getSanpham(){
//        firebaseFirestore.collection("Sanpham").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//            @Override
//            public void onComplete(Task<QuerySnapshot> task) {
//                if(task.isSuccessful()){
//                    for (DocumentSnapshot ds: task.getResult().getDocuments()){
//                        SanPham sanPham = ds.toObject(SanPham.class);
//                    }
//                }
//            }
//        });
//    }

    private List<SanPham> getListSanPham() {
        List<SanPham> list = new ArrayList<>();
        list.add(new SanPham(R.drawable.tra_chanh_truyen_thong,"Trà chanh siêu ngon có mỗi trà với chanh","Trà chanh truyền thống","10.000VNĐ"));
        list.add(new SanPham(R.drawable.img,"Trà chanh cũng như trên nhưng có nha đam","Trà chanh nha đam","20.000VNĐ"));
        list.add(new SanPham(R.drawable.img_1,"Trà đào siêu ngon có trà, đào, cam, xả","Trà đào cam sả","20.000VNĐ"));
        list.add(new SanPham(R.drawable.img_2,"Trà đào truyền thống có trà và đào","Trà đào ","20.000VNĐ"));
        list.add(new SanPham(R.drawable.tra_chanh_truyen_thong,"Trà chanh","Trà chanh truyền thống","10.000VNĐ"));
        list.add(new SanPham(R.drawable.img,"Trà chanh","Trà chanh nha đam","20.000VNĐ"));
        list.add(new SanPham(R.drawable.img_1,"2 gói trà túi lọc, 10ml nước cốt chanh, 10ml nước đường, 20ml peach syrup (syrup đào), 3 cây sả, Đá viên, Đào miếng đóng hộp, 1 trái cam vàng","Trà đào cam sả","20.000VNĐ"));
        list.add(new SanPham(R.drawable.img_2,"Trà đào","Trà đào ","20.000VNĐ"));
        list.add(new SanPham(R.drawable.tra_chanh_truyen_thong,"Trà chanh","Trà chanh truyền thống","10.000VNĐ"));
        list.add(new SanPham(R.drawable.img,"Trà chanh","Trà chanh nha đam","20.000VNĐ"));
        list.add(new SanPham(R.drawable.img_1,"Trà đào","Trà đào cam sả","20.000VNĐ"));
        list.add(new SanPham(R.drawable.img_2,"Trà đào","Trà đào ","20.000VNĐ"));
        return list;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
        if(sanPhamAdapter != null){
            sanPhamAdapter.release();
        }
    }
}