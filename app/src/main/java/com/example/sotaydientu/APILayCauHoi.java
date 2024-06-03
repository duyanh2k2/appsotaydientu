package com.example.sotaydientu;

import android.os.AsyncTask;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class APILayCauHoi extends AsyncTask<Void,Void,Void> {
    String data;
    LayCauHoi layCauHoi;

    public APILayCauHoi(LayCauHoi layCauHoi) {
        this.layCauHoi = layCauHoi;
        this.layCauHoi.batDau1();
    }

    @Override
    protected Void doInBackground(Void... voids) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url("https://duyanh2002.000webhostapp.com/LayCauHoi.php").build();
        data=null;
        try {
            Response response = client.newCall(request).execute();
            ResponseBody body = response.body();
            data= body.string();
        }catch (IOException e){
            data=null;
        }
        return null;
    }
    @Override
    protected void onPostExecute(Void unused) {
        if(data==null){
            this.layCauHoi.biLoi1();
        }
        else {
            this.layCauHoi.ketThuc1(data);
        }
    }
}
