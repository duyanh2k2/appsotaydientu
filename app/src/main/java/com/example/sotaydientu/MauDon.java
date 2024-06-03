package com.example.sotaydientu;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class MauDon implements Serializable {
    private String TieuDeMD;
    private String NdMD;
    private String linkMD;
    private String idMD;
    public MauDon(JSONObject o) throws JSONException {
        this.idMD = o.getString("id");
        this.TieuDeMD=o.getString("tieudeMD");
        this.NdMD=o.getString("ndMD");
        this.linkMD=o.getString("linkMD");
    }

    public String getIdMD() {
        return idMD;
    }

    public void setIdMD(String idMD) {
        this.idMD = idMD;
    }

    public String getTieuDeMD() {
        return TieuDeMD;
    }

    public void setTieuDeMD(String tieuDeMD) {
        TieuDeMD = tieuDeMD;
    }

    public String getNdMD() {
        return NdMD;
    }

    public void setNdMD(String ndMD) {
        NdMD = ndMD;
    }

    public String getLinkMD() {
        return linkMD;
    }

    public void setLinkMD(String linkMD) {
        this.linkMD = linkMD;
    }

}
