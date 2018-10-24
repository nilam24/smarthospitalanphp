package com.sourcecode.smarthospital.pojohspital;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
//import org.apache.commons.lang.builder.ToStringBuilder;

public class SensorDataPojo {

    @SerializedName("pat_firstName_fileName")
    @Expose
    private String pat_firstName_fileName;
    @SerializedName("doc_firstName")
    @Expose
    private String docFirstName;
    @SerializedName("doc_contact")
    @Expose
    private String docContact;
    @SerializedName("pat_contact")
    @Expose
    private String patContact;
    @SerializedName("sensor_Id")
    @Expose
    private String sensorId;
    @SerializedName("w_pressure")
    @Expose
    private String wPressure;
    @SerializedName("heart_beat")
    @Expose
    private String heartBeat;
    @SerializedName("temp")
    @Expose
    private String temp;


    public String getWPressure() {
        return wPressure;
    }

    public void setWPressure(String wPressure) {
        this.wPressure = wPressure;
    }

    public String getHeartBeat() {
        return heartBeat;
    }

    public void setHeartBeat(String heartBeat) {
        this.heartBeat = heartBeat;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getPat_firstName_fileName() {
        return pat_firstName_fileName;
    }

    public void setPat_firstName_fileName(String pat_firstName_fileName) {
        this.pat_firstName_fileName = pat_firstName_fileName;
    }

    public String getDocFirstName() {
        return docFirstName;
    }

    public void setDocFirstName(String docFirstName) {
        this.docFirstName = docFirstName;
    }

    public String getDocContact() {
        return docContact;
    }

    public void setDocContact(String docContact) {
        this.docContact = docContact;
    }

    public String getPatContact() {
        return patContact;
    }

    public void setPatContact(String patContact) {
        this.patContact = patContact;
    }

    public String getSensorId() {
        return sensorId;
    }

    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }
//    @Override
//    public String toString() {
//        return new ToStringBuilder(this).append("fileNamePatId", fileNamePatId).append("sensId", sensId).append("wPressure", wPressure).append("heartBeat", heartBeat).append("temp", temp).toString();
//    }

}