package com.user.manhitdz.katosa.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.user.manhitdz.katosa.R;
import com.user.manhitdz.katosa.adapter.SanPhamMoiAdapter;
import com.user.manhitdz.katosa.model.SanPhamMoi;
import com.user.manhitdz.katosa.model.User;
import com.user.manhitdz.katosa.retrofit.ApiShop;
import com.user.manhitdz.katosa.retrofit.RetrofitClient;
import com.user.manhitdz.katosa.utils.Utils;
import com.bumptech.glide.Glide;
import com.nex3z.notificationbadge.NotificationBadge;

import java.util.ArrayList;
import java.util.List;

import io.paperdb.Paper;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class SanPhamActivity extends AppCompatActivity {
    ImageView imgarrbackSPChinh,imgseachSPChinh, nu, nam;
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    ApiShop apiShop;
    NotificationBadge badge;
    FrameLayout frameLayout;
    RecyclerView recyclerViewTrangChinh;
    List<SanPhamMoi> mangSpMoi;
    SanPhamMoiAdapter spAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_san_pham);
        apiShop = RetrofitClient.getInstance(Utils.BASE_URL).create(ApiShop.class);
        Paper.init(this);
        if(Paper.book().read("user") != null){
            User user = Paper.book().read("user");
            Utils.user_current = user;
        }
        initView();
        initControl();
        if(isConnected(this)){
            getSpMoi();
        }else{
            Toast.makeText(getApplicationContext(), "Không có Internet, vui lòng kết nối Internet", Toast.LENGTH_LONG).show();
        }
    }
    private void initControl(){
        imgarrbackSPChinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        imgseachSPChinh.setOnClickListener(new View.OnClickListener() {
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
        nu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent giohang = new Intent(getApplicationContext(), NuActivity.class);
                startActivity(giohang);
            }
        });
        nam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent giohang = new Intent(getApplicationContext(), NamActivity.class);
                startActivity(giohang);
            }
        });
    }

    private void getSpMoi() {
        compositeDisposable.add(apiShop.getSpMoi()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        sanPhamMoiModel -> {
                            if(sanPhamMoiModel.isSuccess()){
                                mangSpMoi = sanPhamMoiModel.getResult();
                                spAdapter = new SanPhamMoiAdapter(getApplicationContext(), mangSpMoi);
                                recyclerViewTrangChinh.setAdapter(spAdapter);
                            }
                        },
                        throwable -> {
                            Toast.makeText(getApplicationContext(), "Không kết nối được với sever" + throwable.getMessage(), Toast.LENGTH_LONG).show();
                        }
                )
        );
    }

//    private void ActionViewFlipper() {
//        List<String> mangquangcao = new ArrayList<>();
//        mangquangcao.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQvN-C8MYargelidHt8gfVkMKO_i6dixZHZZg&usqp=CAU");
//        mangquangcao.add("https://dangyenhoa.com/wp-content/uploads/2021/08/Banner_sale-off-0.jpg");
//        mangquangcao.add("https://plus24h.com/upload/editor/images/giam-gia-san-pham.jpg");
//        for (int i=0; i<mangquangcao.size(); i++){
//            ImageView imageView = new ImageView(getApplicationContext());
//            Glide.with(getApplicationContext()).load(mangquangcao.get(i)).into(imageView);
//            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
//            viewFlipper.addView(imageView);
//        }
//        viewFlipper.setFlipInterval(3000);
//        viewFlipper.setAutoStart(true);
//        Animation slide_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in_right);
//        Animation slide_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_out_right);
//        viewFlipper.setInAnimation(slide_in);
//        viewFlipper.setOutAnimation(slide_out);
//
//    }

    private void initView(){
        imgarrbackSPChinh = findViewById(R.id.imgarrbackSPChinh);
        imgseachSPChinh = findViewById(R.id.imgseachSPChinh);
        badge = findViewById(R.id.menu_sl);
        frameLayout = findViewById(R.id.framegiohang);
        recyclerViewTrangChinh =  findViewById(R.id.recycleview);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerViewTrangChinh.setLayoutManager(layoutManager);
        recyclerViewTrangChinh.setHasFixedSize(true);
        nu = findViewById(R.id.nu);
        nam = findViewById(R.id.nam);

        mangSpMoi = new ArrayList<>();
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