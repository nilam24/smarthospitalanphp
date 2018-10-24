package com.sourcecode.smarthospital.pojohspital;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PatientPojoTest {

    @SerializedName("PatientPojoresponse")
    @Expose
    private List<PatientPojoResponse> response = null;

    public List<PatientPojoResponse> getResponse()
    {
        return response;
    }

    public void setResponse(List<PatientPojoResponse> response)
    {
        this.response = response;
    }

//    public PatientPojoTest withResponse(List<Response> response) {
//        this.response = response;
//        return this;
//    }

}