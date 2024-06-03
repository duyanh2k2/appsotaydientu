package com.example.sotaydientu;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class CauHoiFrament extends Fragment implements LayCauHoi{

    private View view;
    private ListView LVcauhoi;
    private CauHoiAdapter cauHoiAdapter;
    private ArrayList<CauHoi> list;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.frament_cauhoi,container,false);
        LVcauhoi=view.findViewById(R.id.LVcauhoi);
        init();

        new APILayCauHoi(this).execute();
        LVcauhoi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                CauHoi cauHoi = list.get(i);
                Bundle bundle = new Bundle();
                bundle.putSerializable("cauhoi",cauHoi);
                Intent intent = new Intent(view.getContext(), MainActivity2.class);
                intent.putExtra("data",bundle);
                startActivity(intent);
            }
        });
        return view;
    }
    private void init(){
        list = new ArrayList<>();


    }

    @Override
    public void batDau1() {

    }

    @Override
    public void ketThuc1(String data) {
        try {
            list.clear();
            JSONArray jsonArray = new JSONArray(data);
            for (int i = 0;i< jsonArray.length();i++){
                JSONObject o = jsonArray.getJSONObject(i);
                list.add(new CauHoi(o));
            }
            cauHoiAdapter = new CauHoiAdapter(view.getContext(),0,list);
            LVcauhoi.setAdapter(cauHoiAdapter);
        }catch (JSONException e){

        }
    }

    @Override
    public void biLoi1() {

    }
}
