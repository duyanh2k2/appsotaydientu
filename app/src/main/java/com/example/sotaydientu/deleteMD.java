package com.example.sotaydientu;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;

import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class deleteMD extends AsyncTask<String,Void,String> {
    OkHttpClient okHttpClient=new OkHttpClient.Builder().build();
    String tieude;

    public deleteMD(String tieude) {
        this.tieude = tieude;

    }

    @Override
    protected java.lang.String doInBackground(String... strings) {
        RequestBody requestBody=new MultipartBody.Builder()
                .addFormDataPart("tieude",tieude)
                .setType(MultipartBody.FORM).build();
        Request request= new Request.Builder().url("https://duyanh2002.000webhostapp.com/deleteMauDon.php").post(requestBody).build();
        try {
            Response response =okHttpClient.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    protected void onPostExecute(java.lang.String s) {
        Log.d("AAA", s);
        super.onPostExecute(s);
    }
}
