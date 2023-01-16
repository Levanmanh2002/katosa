package com.user.manhitdz.katosa.retrofit;

import com.user.manhitdz.katosa.model.DonHangModel;
import com.user.manhitdz.katosa.model.MessageModels;
import com.user.manhitdz.katosa.model.SanPhamMoiModel;
import com.user.manhitdz.katosa.model.UserModel;
import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiShop {

    @POST("dangki.php")
    @FormUrlEncoded
    Observable<UserModel> dangKi(
            @Field("username") String username,
            @Field("email") String email,
            @Field("pass") String pass,
            @Field("mobile") String mobile,
            @Field("uid") String uid
    );

    @POST("dangnhap.php")
    @FormUrlEncoded
    Observable<UserModel> dangNhap(
            @Field("email") String taikhoan,
            @Field("pass") String matkhau
    );

//    @GET("getloaisp.php")
//    Observable<LoaiSpModel> getLoaiSp();

    @GET("getspmoi.php")
    Observable<SanPhamMoiModel> getSpMoi();

    @GET("getspslide.php")
    Observable<SanPhamMoiModel> getSlider();

    @POST("chitiet.php")
    @FormUrlEncoded
    Observable<SanPhamMoiModel> getSanPham(
            @Field("page") int page,
            @Field("loai") int loai
    );

    @POST("reset.php")
    @FormUrlEncoded
    Observable<UserModel> resetPass(
            @Field("email") String email
    );

    @POST("donhang.php")
    @FormUrlEncoded
    Observable<UserModel> createOder(
            @Field("email") String email,
            @Field("sdt") String sdt,
            @Field("tongtien") String tongtien,
            @Field("iduser") int id,
            @Field("diachi") String diachi,
            @Field("soluong") int soluong,
            @Field("chitiet") String chitiet
    );

    @POST("xemdonhang.php")
    @FormUrlEncoded
    Observable<DonHangModel> xemDonHang(
            @Field("iduser") int id
    );

    @POST("timkiem.php")
    @FormUrlEncoded
    Observable<SanPhamMoiModel> search(
            @Field("search") String search
    );

//    @POST("insertsp.php")
//    @FormUrlEncoded
//    Observable<MessageModels> insertSp(
//            @Field("tensp") String tensp,
//            @Field("gia") String gia,
//            @Field("hinhanh") String hinhanh,
//            @Field("mota") String mota,
//            @Field("loai") int id
//    );
//
//    @Multipart
//    @POST("upload.php")
//    Call<MessageModels> uploadFile(@Part MultipartBody.Part file);
//
//    @POST("xoa.php")
//    @FormUrlEncoded
//    Observable<MessageModels> xoaSanPham(
//            @Field("id") int id
//    );
//
//    @POST("updatesp.php")
//    @FormUrlEncoded
//    Observable<MessageModels> updatesp(
//            @Field("tensp") String tensp,
//            @Field("gia") String gia,
//            @Field("hinhanh") String hinhanh,
//            @Field("mota") String mota,
//            @Field("loai") int idloai,
//            @Field("id") int id
//    );
//
    @POST("updatetoken.php")
    @FormUrlEncoded
    Observable<MessageModels> updateToken(
            @Field("id") int id,
            @Field("token") String token
    );
//
//    @POST("updatedonhang.php")
//    @FormUrlEncoded
//    Observable<MessageModels> updatedonhang(
//            @Field("id") int id,
//            @Field("trangthai") int trangthai
//    );

    @POST("gettoken.php")
    @FormUrlEncoded
    Observable<UserModel> gettoken(
            @Field("status") int status,
            @Field("iduser") int iduser
    );

}

