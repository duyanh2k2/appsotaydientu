package com.example.sotaydientu;

import android.os.AsyncTask;

import org.json.JSONException;

import java.io.IOException;
import java.util.jar.JarException;

import okhttp3.OkHttp;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class APILayPhoto extends AsyncTask<Void,Void,Void> {
    String data;
    LayPhoTo layPhoTo;

    public APILayPhoto(LayPhoTo layPhoTo) {
        this.layPhoTo = layPhoTo;
        this.layPhoTo.batDau();
    }



    @Override
    protected Void doInBackground(Void... voids) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url("https://duyanh2002.000webhostapp.com/LayPhoto.php").build();
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
            this.layPhoTo.biLoi();
        }
        else {
            this.layPhoTo.ketThuc(data);
        }
    }
}
