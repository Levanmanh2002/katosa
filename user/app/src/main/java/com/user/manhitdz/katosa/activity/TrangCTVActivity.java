package com.user.manhitdz.katosa.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.user.manhitdz.katosa.R;
import com.google.firebase.auth.FirebaseAuth;

import io.paperdb.Paper;

public class TrangCTVActivity extends AppCompatActivity {
    AppCompatButton dondathang, chats, spTrenTrang, datthemsp, dangxuat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_ctvactivity);
        initView();
        initControl();
    }

    private void initControl() {
        dondathang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), DonDatHangActivity.class);
                startActivity(intent);
            }
        });
        chats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ChatsActivity.class);
                startActivity(intent);
            }
        });
        spTrenTrang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SanPhamActivity.class);
                startActivity(intent);
            }
        });
        datthemsp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SanPhamMoiActivity.class);
                startActivity(intent);
            }
        });
        dangxuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Paper.book().delete("user");
                FirebaseAuth.getInstance().signOut();
                Intent dangnhap = new Intent(getApplicationContext(), DangNhapActivity.class);
                startActivity(dangnhap);
                finish();
            }
        });
    }

    private void initView() {
        dondathang = findViewById(R.id.dondathang);
        chats = findViewById(R.id.chats);
        spTrenTrang = findViewById(R.id.spTrenTrang);
        datthemsp = findViewById(R.id.datthemsp);
        dangxuat = findViewById(R.id.dangxuat);
    }
}