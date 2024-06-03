package com.example.sotaydientu;

import org.json.JSONException;
import org.json.JSONObject;

public class GioiThieu {
    private String noidung,tieude;

    public GioiThieu(JSONObject o) throws JSONException {
        this.tieude=o.getString("tieude");
        this.noidung = o.getString("noidung");
    }

    public GioiThieu(String noidung, String tieude) {
        this.noidung = noidung;
        this.tieude = tieude;
    }

    public String getTieude() {
        return tieude;
    }

    public void setTieude(String tieude) {
        this.tieude = tieude;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }
}
