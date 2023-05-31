package com.example.second.ui.SanPham;

import com.google.firebase.firestore.DocumentId;

import java.io.Serializable;

public class SanPham implements Serializable {
    @DocumentId

    private int resourceId;
    private String loai_do_uong;
    private String ten_do_uong;
    private String gia;
    private String imageUrl;

    public SanPham( int resourceId, String loai_do_uong, String ten_do_uong, String gia) {
//        this.imageUrl = imageUrl;
        this.resourceId = resourceId;
        this.loai_do_uong = loai_do_uong;
        this.ten_do_uong = ten_do_uong;
        this.gia = gia;
    }

//    public String getImageUrl() {
//        return imageUrl;
//    }
//
//    public void setImageUrl(String imageUrl) {
//        this.imageUrl = imageUrl;
//    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String getLoai_do_uong() {
        return loai_do_uong;
    }

    public void setLoai_do_uong(String loai_do_uong) {
        this.loai_do_uong = loai_do_uong;
    }

    public String getTen_do_uong() {
        return ten_do_uong;
    }

    public void setTen_do_uong(String ten_do_uong) {
        this.ten_do_uong = ten_do_uong;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }
}
