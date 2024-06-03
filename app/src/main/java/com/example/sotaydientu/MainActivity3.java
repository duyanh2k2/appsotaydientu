package com.example.sotaydientu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    private MauDon mauDon;
    private TextView tieudeMD,noidungMD,linkMD;
    private ImageView backm3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        tieudeMD = findViewById(R.id.tieudemaudon);
        noidungMD = findViewById(R.id.noidungmaudon);
        linkMD = findViewById(R.id.linkmaudon);
        backm3= findViewById(R.id.backm3);
        init();
        setUp();
        backm3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
    private void init(){
        Bundle bundle = getIntent().getBundleExtra("data");
        mauDon=(MauDon) bundle.getSerializable("MauDon");
    }
    private void setUp(){
        tieudeMD.setText(mauDon.getTieuDeMD());
        noidungMD.setText(mauDon.getNdMD());
        linkMD.setText("Mẫu Đơn");
        linkMD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri webpage = Uri.parse(mauDon.getLinkMD());
                Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
                startActivity(webIntent);
            }
        });

    }

}