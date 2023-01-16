package com.user.manhitdz.katosa.model.EventBus;


import com.user.manhitdz.katosa.model.SanPhamMoi;

public class SuaXoaEvent {
    SanPhamMoi sanPhamMoi;

    public SuaXoaEvent(SanPhamMoi sanPhamMoi) {
        this.sanPhamMoi = sanPhamMoi;
    }

    public SanPhamMoi getSanPhamMoi() {
        return sanPhamMoi;
    }

    public void setSanPhamMoi(SanPhamMoi sanPhamMoi) {
        this.sanPhamMoi = sanPhamMoi;
    }
}
