package com.example.sotaydientu;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MauDonAdapter extends ArrayAdapter<MauDon>   {
    private Context ct;
    private ArrayList<MauDon> arrCH;

    public MauDonAdapter(@NonNull Context context, int resource, @NonNull ArrayList<MauDon> objects) {
        super(context, resource, objects);
        this.ct=context;
        this.arrCH= objects;
    }
    public void sxMD(ArrayList<MauDon> ls){
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView==null){
            LayoutInflater layoutInflater=(LayoutInflater)ct.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=layoutInflater.inflate(R.layout.item_maudon,null);
        }
        if(arrCH.size()>0){
            MauDon mauDon = this.arrCH.get(position);
            ImageView imageView = convertView.findViewById(R.id.anh);
            TextView txtMauDon=convertView.findViewById(R.id.txtmaudon);
            txtMauDon.setText(mauDon.getTieuDeMD());
        }
        return convertView;
    }



}
