package com.example.sotaydientu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CauHoiAdapter extends ArrayAdapter<CauHoi> {
    private Context ct;
    private ArrayList<CauHoi> arrCH;
    public CauHoiAdapter(@NonNull Context context, int resource, @NonNull List<CauHoi> objects) {
        super(context, resource, objects);
        this.ct=context;
        this.arrCH= new ArrayList<>(objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView==null){
            LayoutInflater layoutInflater=(LayoutInflater)ct.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=layoutInflater.inflate(R.layout.item_cauhoi,null);
        }
        if(arrCH.size()>0){
            CauHoi cauHoi = this.arrCH.get(position);
            TextView txtcauhoi = convertView.findViewById(R.id.txtcauhoi);
            txtcauhoi.setText(cauHoi.getCauhoi());
        }
        return convertView;
    }
}
