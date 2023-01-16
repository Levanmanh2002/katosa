package com.user.manhitdz.katosa.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.user.manhitdz.katosa.R;
import com.user.manhitdz.katosa.model.User;
import com.user.manhitdz.katosa.retrofit.ApiShop;
import com.user.manhitdz.katosa.retrofit.RetrofitClient;
import com.user.manhitdz.katosa.utils.Utils;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.messaging.FirebaseMessaging;

import io.paperdb.Paper;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    ImageView SanPhamMoi, SanPhamChinh, Quanlitaikhoan,TrangCaNhan;
    ApiShop apiShop;
    CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        apiShop = RetrofitClient.getInstance(Utils.BASE_URL).create(ApiShop.class);
        Paper.init(this);
        if(Paper.book().read("user") != null){
            User user = Paper.book().read("user");
            Utils.user_current = user;
        }
        getToken();
        initView();
        initControl();
    }

    private void getToken(){
        FirebaseMessaging.getInstance().getToken()
                .addOnSuccessListener(new OnSuccessListener<String>() {
                    @Override
                    public void onSuccess(String s) {
                        if (!TextUtils.isEmpty(s)){
                            compositeDisposable.add(apiShop.updateToken(Utils.user_current.getId(), s)
                                    .subscribeOn(Schedulers.io())
                                    .observeOn(AndroidSchedulers.mainThread())
                                    .subscribe(
                                            messageModels -> {

                                            },
                                            throwable -> {
                                                Log.d("log", throwable.getMessage());
                                            }
                                    ));
                        }
                    }
                });
    }

    private void initControl() {
        SanPhamMoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SanPhamMoiActivity.class);
                startActivity(intent);
            }
        });
        SanPhamChinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SanPhamActivity.class);
                startActivity(intent);
            }
        });
        Quanlitaikhoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), QuanLyTaiKhoanActivity.class);
                startActivity(intent);
            }
        });
        TrangCaNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), TrangCTVActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initView(){
        SanPhamMoi = findViewById(R.id.sanphammoi);
        SanPhamChinh = findViewById(R.id.sanphamchinh);
        Quanlitaikhoan = findViewById(R.id.quanlitaikhoan);
        TrangCaNhan = findViewById(R.id.trangcanhan);
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder alerDialog = new AlertDialog.Builder(MainActivity.this);
        alerDialog.setTitle("Thông báo!!!");
        alerDialog.setMessage("Bạn có muốn thoát khỏi ứng dụng");
        alerDialog.setPositiveButton("Thoát", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finishAffinity();
            }
        });
        alerDialog.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        alerDialog.show();
    }

    @Override
    protected void onDestroy() {
        compositeDisposable.clear();
        super.onDestroy();
    }
}