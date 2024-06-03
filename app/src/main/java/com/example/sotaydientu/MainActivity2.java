package com.example.sotaydientu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    private TextView txtCauTL;
    private TextView txtCauHoi1;
    private CauHoi cauHoi;
    private ImageView backm2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txtCauTL=findViewById(R.id.cautl);
        txtCauHoi1=findViewById(R.id.ch);
        backm2 = findViewById(R.id.backm2);
        init();
        txtCauHoi1.setText(cauHoi.getCauhoi());
        txtCauTL.setText(cauHoi.getCauTL());
       // txtCauTL.setMovementMethod(new ScrollingMovementMethod());
        backm2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
    private void init(){
        Bundle bundle = getIntent().getBundleExtra("data");
        cauHoi=(CauHoi)bundle.getSerializable("cauhoi");
    }


}