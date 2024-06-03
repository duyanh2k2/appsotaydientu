package com.example.sotaydientu;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class CauHoi implements Serializable {
    private String cauhoi,cauTL;

    public CauHoi(JSONObject o) throws JSONException {
        this.cauhoi=o.getString("cauhoi");
        this.cauTL = o.getString("cautl");
    }

    public CauHoi(String cauhoi) {
        this.cauhoi = cauhoi;
    }

    public String getCauhoi() {
        return cauhoi;
    }

    public void setCauhoi(String cauhoi) {
        this.cauhoi = cauhoi;
    }

    public String getCauTL() {
        return cauTL;
    }

    public void setCauTL(String cauTL) {
        this.cauTL = cauTL;
    }
}
