package com.user.manhitdz.katosa.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.user.manhitdz.katosa.R;

public class DangNhapDangKyActivity extends AppCompatActivity {
    TextView DangNhap, DangKy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap_dang_ky);
        initView();
        initControl();
    }

    private void initControl() {
        DangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), DangKyActivity.class);
                startActivity(intent);
            }
        });
        DangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), DangNhapActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initView(){
        DangKy =  findViewById(R.id.dangky);
        DangNhap = findViewById(R.id.dangnhap);
    }
}