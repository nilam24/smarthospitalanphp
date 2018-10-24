package com.sourcecode.smarthospital.pojohspital;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class AllocationPojo {


    @SerializedName("allocation_Id")
    @Expose
    private String allocationId;
    @SerializedName("doc_firstName")
    @Expose
    private String docFirstName;
    @SerializedName("pat_firstName")
    @Expose
    private String patFirstName;


    public AllocationPojo(){}



    public String getAllocationId() {
        return allocationId;
    }

    public void setAllocationId(String allocationId) {
        this.allocationId = allocationId;
    }

    public String getDocFirstName() {
        return docFirstName;
    }

    public void setDocFirstName(String docFirstName) {
        this.docFirstName = docFirstName;
    }

    public String getPatFirstName() {
        return patFirstName;
    }

    public void setPatFirstName(String patFirstName) {
        this.patFirstName = patFirstName;
    }





}
