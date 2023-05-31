package com.example.second.ui.SanPham;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.second.R;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.List;

public class SanPhamAdapter extends RecyclerView.Adapter<SanPhamAdapter.SanPhamViewHolder>{

    private List<SanPham> mListSanPham;
    private Context mContext;

    public SanPhamAdapter(FragmentActivity context, List<SanPham> mListSanPham) {
        this.mListSanPham = mListSanPham;
        this.mContext = context;
    }

    @NonNull
    @Override
    public SanPhamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.san_pham, parent, false);
        return new SanPhamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SanPhamViewHolder holder, int position) {
        final SanPham sanPham = mListSanPham.get(position);
        if(sanPham == null){
            return;
        }
        holder.imgview.setImageResource(sanPham.getResourceId());
        holder.Loai_Do_Uong.setText(sanPham.getLoai_do_uong());
        holder.Ten_Do_Uong.setText(sanPham.getTen_do_uong());
        holder.Gia.setText(sanPham.getGia());

        holder.layoutItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickGoToDetail(sanPham);
            }
        });
    }
    private void onClickGoToDetail(SanPham sanPham) {
        Intent intent = new Intent(mContext, DetailSanPham.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("object_sanpham", sanPham);
        intent.putExtras(bundle);
        mContext.startActivity(intent);
    }
    public void release(){
        mContext = null;
    }

    @Override
    public int getItemCount() {
        if(mListSanPham != null){
            return mListSanPham.size();
        }
        return 0;
    }

    public class SanPhamViewHolder extends RecyclerView.ViewHolder {
        private RelativeLayout layoutItem;
        private ImageView imgview;
        private TextView Loai_Do_Uong;
        private TextView Ten_Do_Uong;
        private TextView Gia;

        public SanPhamViewHolder(@NonNull View itemView) {

            super(itemView);
            layoutItem =itemView.findViewById(R.id.layout_item);
            imgview = itemView.findViewById(R.id.imgview);
            Loai_Do_Uong = itemView.findViewById(R.id.loai_do_uong);
            Ten_Do_Uong = itemView.findViewById(R.id.ten_do_uong);
            Gia = itemView.findViewById(R.id.gia);

        }
    }
}

