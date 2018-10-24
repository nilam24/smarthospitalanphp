package com.sourcecode.smarthospital.pojohspital;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PatientPojoResponse {

    @SerializedName("pat_firstName")
    @Expose
    private String patFirstName;
    @SerializedName("pat_lastName")
    @Expose
    private String patLastName;
    @SerializedName("pat_contact")
    @Expose
    private String patContact;
    @SerializedName("pat_email")
    @Expose
    private String patEmail;
    @SerializedName("pat_pass")
    @Expose
    private String patPass;
    @SerializedName("pat_city")
    @Expose
    private String patCity;
    @SerializedName("pat_state")
    @Expose
    private String patState;
    @SerializedName("pat_pin")
    @Expose
    private String patPin;
    @SerializedName("pat_country")
    @Expose
    private String patCountry;

    public String getPatFirstName() {
        return patFirstName;
    }

    public void setPatFirstName(String patFirstName) {
        this.patFirstName = patFirstName;
    }

//    public Response withPatFirstName(String patFirstName) {
//        this.patFirstName = patFirstName;
//        return this;
//    }

    public String getPatLastName() {
        return patLastName;
    }

    public void setPatLastName(String patLastName) {
        this.patLastName = patLastName;
    }

//    public Response withPatLastName(String patLastName) {
//        this.patLastName = patLastName;
//        return this;
//    }

    public String getPatContact() {
        return patContact;
    }

    public void setPatContact(String patContact) {
        this.patContact = patContact;
    }

//    public Response withPatContact(String patContact) {
//        this.patContact = patContact;
//        return this;
//    }

    public String getPatEmail() {
        return patEmail;
    }

    public void setPatEmail(String patEmail) {
        this.patEmail = patEmail;
    }

//    public Response withPatEmail(String patEmail) {
//        this.patEmail = patEmail;
//        return this;
//    }

    public String getPatPass() {
        return patPass;
    }

    public void setPatPass(String patPass) {
        this.patPass = patPass;
    }

//    public Response withPatPass(String patPass) {
//        this.patPass = patPass;
//        return this;
//    }

    public String getPatCity() {
        return patCity;
    }

    public void setPatCity(String patCity) {
        this.patCity = patCity;
    }

//    public Response withPatCity(String patCity) {
//        this.patCity = patCity;
//        return this;
//    }

    public String getPatState() {
        return patState;
    }

    public void setPatState(String patState) {
        this.patState = patState;
    }

//    public Response withPatState(String patState) {
//        this.patState = patState;
//        return this;
//    }

    public String getPatPin() {
        return patPin;
    }

    public void setPatPin(String patPin) {
        this.patPin = patPin;
    }

//    public Response withPatPin(String patPin) {
//        this.patPin = patPin;
//        return this;
//    }

    public String getPatCountry() {
        return patCountry;
    }

    public void setPatCountry(String patCountry) {
        this.patCountry = patCountry;
    }

//    public Response withPatCountry(String patCountry) {
//        this.patCountry = patCountry;
//        return this;
//    }

}