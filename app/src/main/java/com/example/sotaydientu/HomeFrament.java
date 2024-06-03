package com.example.sotaydientu;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class HomeFrament extends Fragment implements/* LayPhoTo,*/ LayNoiDung {
    private ViewPager viewPager;
    private CircleIndicator circleIndicator;
    private PhotoAdapter photoAdapter;
    private View view;
    private List<Photo> list;
    private GioiThieu gt;
    private TextView tieude,noidung;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frament_home,container,false);
        viewPager = view.findViewById(R.id.view_pager);
        circleIndicator = view.findViewById(R.id.circle_i);
        //list = new ArrayList<>();
        tieude = view.findViewById(R.id.TieuDe);
        noidung = view.findViewById(R.id.GioiThieu);
        noidung.setMovementMethod(new ScrollingMovementMethod());

        photoAdapter = new PhotoAdapter(view.getContext(),getListPhoto());
        viewPager.setAdapter(photoAdapter);
        circleIndicator.setViewPager(viewPager);
        photoAdapter.registerDataSetObserver(circleIndicator.getDataSetObserver());
        //new APILayPhoto(this).execute();
        new APILayNoiDung(this).execute();
        return view;
    }
    private List<Photo> getListPhoto(){
         list = new ArrayList<>();
         list.add(new Photo(R.drawable.anh1));
         list.add(new Photo(R.drawable.anh2));
         list.add(new Photo(R.drawable.anh3));
         return list;
    }

 /*   @Override
    public void batDau() {
        Toast.makeText(view.getContext(),"đang lấy về",Toast.LENGTH_LONG).show();
    }

    @Override
    public void ketThuc(String data) {
        try {
            list.clear();
            JSONArray array = new JSONArray(data);
            for (int i=0;i<array.length();i++){
                JSONObject o = array.getJSONObject(i);
                list.add(new Photo(o));
            }
            photoAdapter = new PhotoAdapter(view.getContext(),list);
            viewPager.setAdapter(photoAdapter);
            circleIndicator.setViewPager(viewPager);
            photoAdapter.registerDataSetObserver(circleIndicator.getDataSetObserver());
        }catch (JSONException e) {

        }
    }

    @Override
    public void biLoi() {
        Toast.makeText(view.getContext(),"loi",Toast.LENGTH_LONG).show();
    } */

    @Override
    public void batDau1() {

    }

    @Override
    public void ketThuc1(String data) {
        try {
            JSONArray array = new JSONArray(data);
            for (int i=0;i<array.length();i++) {
                JSONObject o = array.getJSONObject(i);
                gt = new GioiThieu(o);
                tieude.setText(gt.getTieude());
                noidung.setText(gt.getNoidung());
            }

        }catch (JSONException e){

        }
    }

    @Override
    public void biLoi1() {

    }
}
