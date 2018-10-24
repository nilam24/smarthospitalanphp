package com.sourcecode.smarthospital.pojohspital;

import java.util.List;

/**
 * Created by Admin on 10/6/2018.
 */

public class HsPojo {

    int hs_id;
    String hs_name;

    List<DocPojo>docPojoList;
    List<PatResponse>patientPojoList;

    public HsPojo() {
    }



    public int getHs_id() {
        return hs_id;
    }

    public void setHs_id(int hs_id) {
        this.hs_id = hs_id;
    }

    public String getHs_name() {
        return hs_name;
    }

    public void setHs_name(String hs_name) {
        this.hs_name = hs_name;
    }





    public List<DocPojo> getDocPojoList() {
        return docPojoList;
    }

    public void setDocPojoList(List<DocPojo> docPojoList) {
        this.docPojoList = docPojoList;
    }

    public List<PatResponse> getPatientPojoList() {
        return patientPojoList;
    }

    public void setPatientPojoList(List<PatResponse> patientPojoList) {
        this.patientPojoList = patientPojoList;
    }



}
