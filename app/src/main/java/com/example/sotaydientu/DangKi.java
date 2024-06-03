package com.example.sotaydientu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DangKi extends AppCompatActivity {

    private EditText mail,sdt,mk;
    private Button dk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ki);
        mail = findViewById(R.id.mail);
        sdt = findViewById(R.id.sdt);
        mk = findViewById(R.id.mk);
        dk = findViewById(R.id.dk);
        dk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String t1 = mail.getText().toString().trim();
                String t2 = sdt.getText().toString().trim();
                String t3 = mk.getText().toString().trim();
                new insertUser(t1,t2,t3).execute();
                Intent intent = new Intent(DangKi.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}