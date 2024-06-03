package com.example.sotaydientu;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;

import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class insertMD extends AsyncTask<String,Void,String> {
    OkHttpClient okHttpClient=new OkHttpClient.Builder().build();
    String tieude,noidung,linkdon;

    public insertMD(String tieude, String noidung, String linkdon) {
        this.tieude = tieude;
        this.noidung = noidung;
        this.linkdon = linkdon;
    }

    @Override
    protected String doInBackground(String... strings) {
        RequestBody requestBody=new MultipartBody.Builder()
                .addFormDataPart("tieude",tieude)
                .addFormDataPart("noidung",noidung)
                .addFormDataPart("linkdon",linkdon)
                .setType(MultipartBody.FORM).build();
        Request request= new Request.Builder().url("https://duyanh2002.000webhostapp.com/insertMauDon.php").post(requestBody).build();
        try {
            Response response =okHttpClient.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    protected void onPostExecute(String s) {
        Log.d("AAA", s);
        super.onPostExecute(s);
    }
}
