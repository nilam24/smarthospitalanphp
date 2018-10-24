package com.sourcecode.smarthospital.pojohspital;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DevicePojo {

    @SerializedName("admin_email")
    @Expose
    private String adminEmail;
    @SerializedName("token")
    @Expose
    private String token;

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public DevicePojo() {
    }

    public DevicePojo(String adminEmail, String token) {
        this.adminEmail = adminEmail;
        this.token = token;
    }
}