package com.sourcecode.smarthospital.pojohspital;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DocPojo {

    @SerializedName("doc_Id")
    @Expose
    private int docId;
    @SerializedName("doc_firstName")
    @Expose
    private String docFirstName;
    @SerializedName("doc_lastName")
    @Expose
    private String docLastName;
    @SerializedName("doc_contact")
    @Expose
    private String docContact;
    @SerializedName("doc_email")
    @Expose
    private String docEmail;
    @SerializedName("doc_pass")
    @Expose
    private String docPass;
    @SerializedName("doc_conf_pass")
    @Expose
    private String docConfPass;
    @SerializedName("doc_city")
    @Expose
    private String docCity;
    @SerializedName("doc_state")
    @Expose
    private String docState;
    @SerializedName("doc_pin")
    @Expose
    private String docPin;
    @SerializedName("doc_country")
    @Expose
    private String docCountry;

    public DocPojo(){}



    public int getDocId() {
        return docId;
    }

    public void setDocId(int docId) {
        this.docId = docId;
    }

    public String getDocFirstName() {
        return docFirstName;
    }

    public void setDocFirstName(String docFirstName) {
        this.docFirstName = docFirstName;
    }

    public String getDocLastName() {
        return docLastName;
    }

    public void setDocLastName(String docLastName) {
        this.docLastName = docLastName;
    }

    public String getDocContact() {
        return docContact;
    }

    public void setDocContact(String docContact) {
        this.docContact = docContact;
    }

    public String getDocEmail() {
        return docEmail;
    }

    public void setDocEmail(String docEmail) {
        this.docEmail = docEmail;
    }

    public String getDocPass() {
        return docPass;
    }

    public void setDocPass(String docPass) {
        this.docPass = docPass;
    }

    public String getDocConfPass() {
        return docConfPass;
    }

    public void setDocConfPass(String docConfPass) {
        this.docConfPass = docConfPass;
    }

    public String getDocCity() {
        return docCity;
    }

    public void setDocCity(String docCity) {
        this.docCity = docCity;
    }

    public String getDocState() {
        return docState;
    }

    public void setDocState(String docState) {
        this.docState = docState;
    }

    public String getDocPin() {
        return docPin;
    }

    public void setDocPin(String docPin) {
        this.docPin = docPin;
    }

    public String getDocCountry() {
        return docCountry;
    }

    public void setDocCountry(String docCountry) {
        this.docCountry = docCountry;
    }

    @Override
    public String toString() {
        return "DocPojo{" +
                "docId='" + docId + '\'' +
                ", docFirstName='" + docFirstName + '\'' +
                ", docLastName='" + docLastName + '\'' +
                ", docContact='" + docContact + '\'' +
                ", docEmail='" + docEmail + '\'' +
                ", docPass='" + docPass + '\'' +
                ", docConfPass='" + docConfPass + '\'' +
                ", docCity='" + docCity + '\'' +
                ", docState='" + docState + '\'' +
                ", docPin='" + docPin + '\'' +
                ", docCountry='" + docCountry + '\'' +
                '}';
    }
}
