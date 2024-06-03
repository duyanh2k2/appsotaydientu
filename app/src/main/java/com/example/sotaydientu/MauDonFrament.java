package com.example.sotaydientu;

import static android.app.Activity.RESULT_OK;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MauDonFrament extends Fragment implements LayMauDon {
    private View view;
    private ListView LVMauDon;
    private MauDonAdapter mauDonAdapter;
    private ArrayList<MauDon> list;
    private FloatingActionButton add;
    public static final String UPDATE="update";
    public static final String INSERT="insert";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frament_maudon,container,false);
        LVMauDon=view.findViewById(R.id.LVMauDon);
        add = view.findViewById(R.id.add);
        list = new ArrayList<>();
        new APILayMauDon(this).execute();
        LVMauDon.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                MauDon mauDon = list.get(i);
                Bundle b = new Bundle();
                b.putSerializable("MauDon",mauDon);
                Intent intent = new Intent(view.getContext(), MainActivity3.class);
                intent.putExtra("data",b);
                startActivity(intent);
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MainActivity5.class);
                intent.setAction(INSERT);
                AResult.launch(intent);
            }
        });
        LVMauDon.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                registerForContextMenu(LVMauDon);
                return false;
            }
        });

        return view;
    }
    ActivityResultLauncher<Intent> AResult= registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    new APILayMauDon(MauDonFrament.this).execute();
                }
            });
    @Override
    public void batDau() {
        Toast.makeText(view.getContext(),"đang lấy về",Toast.LENGTH_LONG).show();
    }

    @Override
    public void ketThuc(String data) {
        try {
            list.clear();
            JSONArray jsonArray = new JSONArray(data);
            for (int i = 0;i< jsonArray.length();i++){
                JSONObject o = jsonArray.getJSONObject(i);
                list.add(new MauDon(o));
            }
        /*    Collections.sort(list, new Comparator<MauDon>() {
                @Override
                public int compare(MauDon mauDon, MauDon t1) {
                    return mauDon.getTieuDeMD().compareTo(t1.getTieuDeMD());
                }
            });*/
            mauDonAdapter = new MauDonAdapter(view.getContext(),0,list);
            LVMauDon.setAdapter(mauDonAdapter);
        }catch (JSONException e){

        }
    }
    @Override
    public void biLoi() {
        Toast.makeText(view.getContext(),"loi",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onCreateContextMenu(@NonNull ContextMenu menu, @NonNull View v, @Nullable ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if(v.getId()==R.id.LVMauDon){
            getActivity().getMenuInflater().inflate(R.menu.menu_md,menu);
        }
    }
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo acmi=(AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int ps=acmi.position;
        MauDon mauDon = mauDonAdapter.getItem(ps);
        if(item.getItemId()==R.id.sua){
            Intent intent=new Intent(view.getContext(),MainActivity5.class);
            Bundle bundle=new Bundle();
            bundle.putSerializable("mauDon",mauDon);
            intent.putExtras(bundle);
            intent.setAction(UPDATE);
            UResult.launch(intent);
        }
        if (item.getItemId()==R.id.xoa){
                AlertDialog.Builder delDialog= new AlertDialog.Builder(view.getContext());
                delDialog.setTitle("Bạn muốn xóa mẫu đơn: "+ mauDon.getTieuDeMD());
                delDialog.setCancelable(true);
                delDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(view.getContext(),"You choose cancel button",Toast.LENGTH_LONG).show();
                        dialogInterface.cancel();
                    }
                });
                delDialog.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        new deleteMD(mauDon.getTieuDeMD()).execute();
                        dialogInterface.dismiss();
                        new APILayMauDon(MauDonFrament.this).execute();
                    }
                });
                AlertDialog alertDialog=delDialog.create();
                alertDialog.show();
        }
        return true;
    }
    ActivityResultLauncher<Intent> UResult= registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                        new APILayMauDon(MauDonFrament.this).execute();

                }
            });


}
