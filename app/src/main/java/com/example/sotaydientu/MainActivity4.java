package com.example.sotaydientu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity4 extends AppCompatActivity implements LayMauDon{

    private ListView listView;
    private MauDonAdapter mauDonAdapter;
   // private CauHoiAdapter cauHoiAdapter;
    private ArrayList<MauDon> list;

    private ArrayList<MauDon> mauDons;
   // private ArrayList<CauHoi> listch,cauHois;
    private EditText timkiem;
    private ImageView backm4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        listView = findViewById(R.id.listtk);
        timkiem = findViewById(R.id.timkiem);
       // lvch = findViewById(R.id.listch);
        list = new ArrayList<>();
        mauDons = new ArrayList<>();
       // listch = new ArrayList<>();
        //cauHois = new ArrayList<>();
        new APILayMauDon(this).execute();
       // new APILayCauHoi(this).execute();
        timkiem.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {



            }

            @Override
            public void afterTextChanged(Editable editable) {
                search(editable.toString());
               // search1(editable.toString());
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                MauDon mauDon = mauDons.get(i);
                Bundle b = new Bundle();
                b.putSerializable("MauDon",mauDon);
                Intent intent = new Intent(MainActivity4.this, MainActivity3.class);
                intent.putExtra("data",b);
                startActivity(intent);
            }
        });
        backm4 = findViewById(R.id.backm4);
        backm4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
    private void search(String s){
        mauDons.clear();
        s=s.toUpperCase();

        for (MauDon item : list) {
            if (item.getTieuDeMD().toUpperCase().contains(s)) {

                mauDons.add(item);
            }
        }
       mauDonAdapter = new MauDonAdapter(this,0,mauDons);
        listView.setAdapter(mauDonAdapter);
    }
    /*private void search1(String s){
        cauHois.clear();
        s=s.toUpperCase();

        for (CauHoi item : listch) {
            if (item.getCauhoi().toUpperCase().contains(s)) {

                cauHois.add(item);
            }
        }
        cauHoiAdapter = new CauHoiAdapter(this,0,cauHois);
        lvch.setAdapter(cauHoiAdapter);
    }*/
    @Override
    public void batDau() {
        Toast.makeText(this,"đang lấy về",Toast.LENGTH_LONG).show();
    }

    @Override
    public void ketThuc(String data) {
        try {
            list.clear();

            JSONArray jsonArray = new JSONArray(data);
            for (int i = 0;i< jsonArray.length();i++){
                JSONObject o = jsonArray.getJSONObject(i);
                list.add(new MauDon(o));
                mauDons.add(new MauDon(o));
            }
            mauDonAdapter = new MauDonAdapter(this,0,list);
            listView.setAdapter(mauDonAdapter);
        }catch (JSONException e){

        }
    }

    @Override
    public void biLoi() {
        Toast.makeText(this,"loi",Toast.LENGTH_LONG).show();
    }
  /*  @Override
    public void batDau1() {

    }

    @Override
    public void ketThuc1(String data) {
        try {
            listch.clear();
            JSONArray jsonArray = new JSONArray(data);
            for (int i = 0;i< jsonArray.length();i++){
                JSONObject o = jsonArray.getJSONObject(i);
                listch.add(new CauHoi(o));
                cauHois.add(new CauHoi(o));
            }
            cauHoiAdapter = new CauHoiAdapter(this,0,listch);
            lvch.setAdapter(cauHoiAdapter);
        }catch (JSONException e){

        }
    }

    @Override
    public void biLoi1() {

    }*/
}