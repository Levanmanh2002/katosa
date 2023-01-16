package com.user.manhitdz.katosa.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.user.manhitdz.katosa.R;
import com.user.manhitdz.katosa.adapter.PageSlideAdapter;
import com.user.manhitdz.katosa.retrofit.ApiShop;
import com.user.manhitdz.katosa.retrofit.RetrofitClient;
import com.user.manhitdz.katosa.utils.Utils;
import com.nex3z.notificationbadge.NotificationBadge;

import java.util.ArrayList;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class SanPhamMoiActivity extends AppCompatActivity {
    ImageView arrBack,imgseachSPmoi;
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    ApiShop apiShop;
    CardView quanaoNu, quanaoNam;
    NotificationBadge badge;
    FrameLayout frameLayout;
    ViewPager2 viewPager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_san_pham_moi);
        apiShop = RetrofitClient.getInstance(Utils.BASE_URL).create(ApiShop.class);
        initView();
        initControl();
        getSPSlider();
        if(isConnected(this)){

        }else{
            Toast.makeText(getApplicationContext(), "Không có Internet, vui lòng kết nối Internet", Toast.LENGTH_LONG).show();
        }
    }

    private void getSPSlider() {
        compositeDisposable.add(apiShop.getSlider()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        sanPhamMoiModel -> {
                            PageSlideAdapter adapter = new PageSlideAdapter(getApplicationContext(),sanPhamMoiModel.getResult());
                            viewPager2.setAdapter(adapter);
                        },
                        throwable -> {
                            Log.d("loggg", throwable.getMessage());
                        }
                ));
    }

    private void initControl(){
        arrBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        imgseachSPmoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SeachActivity.class);
                startActivity(intent);
            }
        });
        frameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent giohang = new Intent(getApplicationContext(), GioHangActivity.class);
                startActivity(giohang);
            }
        });
        quanaoNu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), NuActivity.class);
                startActivity(intent);
            }
        });
        quanaoNam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), NamActivity.class);
                startActivity(intent);
            }
        });
    }

    private  void initView(){
        viewPager2 = findViewById(R.id.viewpage);
        arrBack = findViewById(R.id.imgarrback);
        imgseachSPmoi = findViewById(R.id.imgseachSPmoi);
        quanaoNu = findViewById(R.id.quanaoNu);
        quanaoNam = findViewById(R.id.quanaoNam);
        badge = findViewById(R.id.menu_sl);
        frameLayout = findViewById(R.id.framegiohang);

        if(Utils.manggiohang == null) {
            Utils.manggiohang = new ArrayList<>();
        }else {
            int totalItem = 0;
            for (int i=0; i<Utils.manggiohang.size(); i++){
                totalItem = totalItem+Utils.manggiohang.get(i).getSoluong();
            }
            badge.setText(String.valueOf(totalItem));
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        int totalItem = 0;
        for (int i=0; i<Utils.manggiohang.size(); i++){
            totalItem = totalItem+Utils.manggiohang.get(i).getSoluong();
        }
        badge.setText(String.valueOf(totalItem));
    }

    private boolean isConnected(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifi = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo mobile = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if(wifi != null && wifi.isConnected() || (mobile !=null && mobile.isConnected())){
            return true;
        }else{
            return false;
        }
    }

    @Override
    protected void onDestroy() {
        compositeDisposable.clear();
        super.onDestroy();
    }
}