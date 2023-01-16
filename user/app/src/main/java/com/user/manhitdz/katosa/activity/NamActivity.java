package com.user.manhitdz.katosa.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.user.manhitdz.katosa.R;
import com.user.manhitdz.katosa.adapter.NamAdapter;
import com.user.manhitdz.katosa.model.SanPhamMoi;
import com.user.manhitdz.katosa.retrofit.ApiShop;
import com.user.manhitdz.katosa.retrofit.RetrofitClient;
import com.user.manhitdz.katosa.utils.Utils;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class NamActivity extends AppCompatActivity {
    Toolbar toolbar;
    ImageView search;
    RecyclerView recyclerView;
    ApiShop apiShop;
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    int page = 1;
    int loai;
    NamAdapter adapterNam;
    List<SanPhamMoi> sanPhamMoiList;
    LinearLayoutManager linearLayoutManager;
    Handler handler = new Handler();
    boolean isLoading = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nam);
        apiShop = RetrofitClient.getInstance(Utils.BASE_URL).create(ApiShop.class);
        loai = getIntent().getIntExtra("loai", 2);
        App();
        ActionToolBar();
        getData(page);
        addEventLoad();
    }

    private void addEventLoad() {
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if(isLoading == false ){
                    if(linearLayoutManager.findFirstCompletelyVisibleItemPosition() == sanPhamMoiList.size()-1){
                        isLoading = true;
                        loadMore();
                    }
                }
            }
        });
    }

    private void loadMore() {
        handler.post(new Runnable() {
            @Override
            public void run() {
                sanPhamMoiList.add(null);
                adapterNam.notifyItemInserted(sanPhamMoiList.size()-1);
            }
        });
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                sanPhamMoiList.remove(sanPhamMoiList.size()-1);
                adapterNam.notifyItemRemoved(sanPhamMoiList.size());
                page = page+1;
                getData(page);
                adapterNam.notifyDataSetChanged();
                isLoading = false;
            }
        }, 2000);
    }

    private void getData(int page) {
        compositeDisposable.add(apiShop.getSanPham(page, 2)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        sanPhamMoiModel -> {
                            Log.d("loggg", sanPhamMoiModel.getResult().get(0).getTensp());
                            if(sanPhamMoiModel.isSuccess()){
                                if(adapterNam == null){
                                    sanPhamMoiList = sanPhamMoiModel.getResult();
                                    adapterNam = new NamAdapter(getApplicationContext(), sanPhamMoiList);
                                    recyclerView.setAdapter(adapterNam);
                                }else {
                                    int vitri = sanPhamMoiList.size()-1;
                                    int soluongadd = sanPhamMoiModel.getResult().size();
                                    for (int i=0; i<soluongadd; i++){
                                        sanPhamMoiList.add(sanPhamMoiModel.getResult().get(i));
                                    }
                                    adapterNam.notifyItemRangeInserted(vitri, soluongadd);
                                }
                            }else {
                                Toast.makeText(getApplicationContext(), "Hết dữ liệu", Toast.LENGTH_SHORT).show();
                                isLoading = true;
                            }
                        },
                        throwable -> {
                            Log.d("loggg", throwable.getMessage());
                            Toast.makeText(getApplicationContext(), "Không kết nối được với sever", Toast.LENGTH_LONG).show();
                        }
                ));

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SeachActivity.class);
                startActivity(intent);
            }
        });
    }

    private void ActionToolBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void App() {
        toolbar = findViewById(R.id.toobar);
        recyclerView = findViewById(R.id.recycleview_nam);
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        sanPhamMoiList = new ArrayList<>();
        search = findViewById(R.id.search);
    }

    @Override
    protected void onDestroy() {
        compositeDisposable.clear();
        super.onDestroy();
    }
}