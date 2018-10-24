package com.sourcecode.smarthospital.pojohspital;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.sourcecode.smarthospital.AdminDetailActivity;
//import org.apache.commons.lang.builder.ToStringBuilder;

public class AdminPojo {

    @SerializedName("admin_firstName")
    @Expose
    private String adminFirstName;
    @SerializedName("admin_lastName")
    @Expose
    private String adminLastName;
    @SerializedName("admin_contact")
    @Expose
    private String adminContact;
    @SerializedName("admin_email")
    @Expose
    private String adminEmail;
    @SerializedName("admin_pass")
    @Expose
    private String adminPass;
    @SerializedName("admin_conf_pass")
    @Expose
    private String adminConfPass;
    @SerializedName("admin_city")
    @Expose
    private String adminCity;
    @SerializedName("admin_state")
    @Expose
    private String adminState;
    @SerializedName("admin_pin")
    @Expose
    private String adminPin;
    @SerializedName("admin_country")
    @Expose
    private String adminCountry;

    public AdminPojo(){}

    public String getAdminFirstName() {
        return adminFirstName;
    }

    public void setAdminFirstName(String adminFirstName) {
        this.adminFirstName = adminFirstName;
    }

    public String getAdminLastName() {
        return adminLastName;
    }

    public void setAdminLastName(String adminLastName) {
        this.adminLastName = adminLastName;
    }

    public String getAdminContact() {
        return adminContact;
    }

    public void setAdminContact(String adminContact) {
        this.adminContact = adminContact;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public String getAdminPass() {
        return adminPass;
    }

    public void setAdminPass(String adminPass) {
        this.adminPass = adminPass;
    }

    public String getAdminConfPass() {
        return adminConfPass;
    }

    public void setAdminConfPass(String adminConfPass) {
        this.adminConfPass = adminConfPass;
    }

    public String getAdminCity() {
        return adminCity;
    }

    public void setAdminCity(String adminCity) {
        this.adminCity = adminCity;
    }

    public String getAdminState() {
        return adminState;
    }

    public void setAdminState(String adminState) {
        this.adminState = adminState;
    }

    public String getAdminPin() {
        return adminPin;
    }

    public void setAdminPin(String adminPin) {
        this.adminPin = adminPin;
    }

    public String getAdminCountry() {
        return adminCountry;
    }

    public void setAdminCountry(String adminCountry) {
        this.adminCountry = adminCountry;
    }

//    @Override
//    public String toString() {
//        return new ToStringBuilder(this).append("adminFirstName", adminFirstName).append("adminLastName", adminLastName).append("adminContact", adminContact).append("adminEmail", adminEmail).append("adminPass", adminPass).append("adminConfPass", adminConfPass).append("adminCity", adminCity).append("adminState", adminState).append("adminPin", adminPin).append("adminCountry", adminCountry).toString();
//    }

}