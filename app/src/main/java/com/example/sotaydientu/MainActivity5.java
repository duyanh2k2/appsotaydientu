package com.example.sotaydientu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity5 extends AppCompatActivity {

    private EditText td,nd,ld;
    private Button them;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        td = findViewById(R.id.edtd);
        nd = findViewById(R.id.ednd);
        ld = findViewById(R.id.edld);
        them = findViewById(R.id.them);
        Intent intent = getIntent();
        String Action= intent.getAction();

        if(Action == "update"){
            MauDon mauDon =(MauDon) intent.getExtras().get("mauDon");
            td.setText(mauDon.getTieuDeMD());
            nd.setText(mauDon.getNdMD());
            ld.setText(mauDon.getLinkMD());
        }
        them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tieude=td.getText().toString().trim();
                String noidung=nd.getText().toString().trim();
                String linkdon=ld.getText().toString().trim();
                if(Action=="insert") {
                    new insertMD(tieude, noidung, linkdon).execute();
                }
                if(Action=="update"){
                    MauDon mauDon =(MauDon) intent.getExtras().get("mauDon");
                    String id = mauDon.getIdMD();
                    new updateMD(id,tieude,noidung,linkdon).execute();
                }
                finish();
            }
        });
    }
}