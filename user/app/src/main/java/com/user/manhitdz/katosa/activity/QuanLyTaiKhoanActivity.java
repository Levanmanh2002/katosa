package com.user.manhitdz.katosa.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.user.manhitdz.katosa.R;
import com.user.manhitdz.katosa.utils.Utils;

public class QuanLyTaiKhoanActivity extends AppCompatActivity {
    TextView textViewName, textViewGmail, textViewMobile;
    LinearLayout quanAoNu, quanAoNam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly_tai_khoan);
        initView();
        initControl();
    }

    private void initControl() {
        quanAoNu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), NuActivity.class);
                startActivity(intent);
            }
        });
        quanAoNam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), NamActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        textViewName = findViewById(R.id.textViewName);
        textViewGmail = findViewById(R.id.textViewGmail);
        textViewMobile = findViewById(R.id.textViewMobile);
        quanAoNu = findViewById(R.id.quanaoNu);
        quanAoNam = findViewById(R.id.quanaoNam);
    }

    @Override
    protected void onResume() {
        super.onResume();
        textViewName.setText(Utils.user_current.getUsername());
        textViewGmail.setText(Utils.user_current.getEmail());
        textViewMobile.setText(Utils.user_current.getMobile());
    }
}