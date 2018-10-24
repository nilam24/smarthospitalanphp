package com.sourcecode.smarthospital.pojohspital;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PatResponse {

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

    public PatResponse() {
    }

    public PatResponse(String patFirstName, String patLastName, String patContact, String patEmail, String patPass, String patCity, String patState, String patPin, String patCountry) {
        this.patFirstName = patFirstName;
        this.patLastName = patLastName;
        this.patContact = patContact;
        this.patEmail = patEmail;
        this.patPass = patPass;
        this.patCity = patCity;
        this.patState = patState;
        this.patPin = patPin;
        this.patCountry = patCountry;
    }

    public PatResponse(String patFirstName, String patPass) {
        this.patFirstName = patFirstName;
        this.patPass = patPass;
    }


    public String getPatFirstName() {
        return patFirstName;
    }

    public void setPatFirstName(String patFirstName) {
        this.patFirstName = patFirstName;
    }

    public String getPatLastName() {
        return patLastName;
    }

    public void setPatLastName(String patLastName) {
        this.patLastName = patLastName;
    }

    public String getPatContact() {
        return patContact;
    }

    public void setPatContact(String patContact) {
        this.patContact = patContact;
    }

    public String getPatEmail() {
        return patEmail;
    }

    public void setPatEmail(String patEmail) {
        this.patEmail = patEmail;
    }

    public String getPatPass() {
        return patPass;
    }

    public void setPatPass(String patPass) {
        this.patPass = patPass;
    }

    public String getPatCity() {
        return patCity;
    }

    public void setPatCity(String patCity) {
        this.patCity = patCity;
    }

    public String getPatState() {
        return patState;
    }

    public void setPatState(String patState) {
        this.patState = patState;
    }

    public String getPatPin() {
        return patPin;
    }

    public void setPatPin(String patPin) {
        this.patPin = patPin;
    }

    public String getPatCountry() {
        return patCountry;
    }

    public void setPatCountry(String patCountry) {
        this.patCountry = patCountry;
    }

    @Override
    public String toString() {
        return "PatResponse{" +
                "patFirstName='" + patFirstName + '\'' +
                ", patLastName='" + patLastName + '\'' +
                ", patContact='" + patContact + '\'' +
                ", patEmail='" + patEmail + '\'' +
                ", patPass='" + patPass + '\'' +
                ", patCity='" + patCity + '\'' +
                ", patState='" + patState + '\'' +
                ", patPin='" + patPin + '\'' +
                ", patCountry='" + patCountry + '\'' +
                '}';
    }
}
