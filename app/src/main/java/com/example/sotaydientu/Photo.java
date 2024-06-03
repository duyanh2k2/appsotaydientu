package com.example.sotaydientu;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.jar.JarException;

public class Photo {
    private String resoureID;
    private int res;

    public Photo(int res) {
        this.res = res;
    }
    public Photo(JSONObject o) throws JSONException
    {
        resoureID = o.getString("linkAnh");
    }

    public Photo(String resoureID) {
        this.resoureID = resoureID;
    }

    public String getResoureID() {
        return resoureID;
    }

    public void setResoureID(String resoureID) {
        this.resoureID = resoureID;
    }

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }
}
