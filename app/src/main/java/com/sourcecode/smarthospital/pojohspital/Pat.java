package com.sourcecode.smarthospital.pojohspital;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Pat  {


    @SerializedName("PatResponse")
    @Expose
    List<PatResponse>patResponseList;


    public Pat(){}

    public Pat(List<PatResponse> patResponseList) {
        this.patResponseList = patResponseList;
    }

    public List<PatResponse> getPatResponseList() {
        return patResponseList;
    }

    public void setPatResponseList(List<PatResponse> patResponseList) {
        this.patResponseList = patResponseList;
    }
}
