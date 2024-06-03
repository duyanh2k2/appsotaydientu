package com.example.sotaydientu;

import android.os.AsyncTask;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class APILayNoiDung extends AsyncTask<Void,Void,Void> {
    String data;
    LayNoiDung layNoiDung;

    public APILayNoiDung(LayNoiDung layNoiDung) {
        this.layNoiDung = layNoiDung;
        this.layNoiDung.batDau1();
    }

    @Override
    protected Void doInBackground(Void... voids) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url("https://duyanh2002.000webhostapp.com/LayGioiThieu.php").build();
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
            this.layNoiDung.biLoi1();
        }
        else {
            this.layNoiDung.ketThuc1(data);
        }
    }
}
