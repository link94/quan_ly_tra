package com.example.second.ui.SanPham;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.second.R;

public class DetailSanPham extends AppCompatActivity {
@Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_san_pham);

        Bundle bundle = getIntent().getExtras();
        if(bundle == null){
            return;
        }
    SanPham sanPham = (SanPham) bundle.get("object_sanpham");
    TextView tvTendouong = findViewById(R.id.tt_ten_do_uong);
    tvTendouong.setText(sanPham.getTen_do_uong());
    TextView tvGia = findViewById(R.id.gia);
    tvGia.setText(sanPham.getGia());
    TextView tvThanhphan = findViewById(R.id.thanh_phan);
    tvThanhphan.setText(sanPham.getLoai_do_uong());
    ImageView imgView = findViewById(R.id.tt_img);
    imgView.setImageResource(sanPham.getResourceId());


    }
}
