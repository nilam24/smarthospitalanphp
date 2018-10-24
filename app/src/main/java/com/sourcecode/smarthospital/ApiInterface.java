package com.sourcecode.smarthospital;


import com.google.gson.JsonArray;

import com.google.gson.JsonElement;
import com.sourcecode.smarthospital.pojohspital.AdminPojo;
import com.sourcecode.smarthospital.pojohspital.AllocationPojo;
import com.sourcecode.smarthospital.pojohspital.DevicePojo;
import com.sourcecode.smarthospital.pojohspital.DocPojo;
import com.sourcecode.smarthospital.pojohspital.Pat;
import com.sourcecode.smarthospital.pojohspital.PatResponse;
import com.sourcecode.smarthospital.pojohspital.SensorDataPojo;

import org.json.JSONObject;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {


    @GET("test2.php")  //okok admin login
    Call<List<AdminPojo>> getAdminList();


    @GET("testdoc.php")  //ok doc login
    Call<List<DocPojo>> doLogin();

    @GET("loginpat.php") //okok pat login
    Call<List<PatResponse>> doLoginPat();

    @GET("testsensor1.php")
    Call<List<SensorDataPojo>> getSensorData();


    @GET("allocdoc.php")  //ok
    Call<List<DocPojo>> getDocData();


    @GET("testdetailpat.php")
    Call<JsonArray> getArray();

    @GET("testdetailpat.php") //ok
    Call<List<PatResponse>> getPatResponse();//   @Query("pat_firstName") String pat_firstName,
                                           //@Query("pat_pass") String pat_pass);

    @GET("allocpat.php")  //ok
    Call<List<PatResponse>> getPatientData();

    @GET("admindetail.php")  //ok
    Call<List<AdminPojo>> getAdminData();

    @GET("docdetail.php")   //ok
    Call<List<DocPojo>> getDocDetail();

    @GET("testdetailpat.php")
    Call<List<Pat>>  getPatResponseList();

    @GET("testallocation.php")
    Call<List<AllocationPojo>> getAlloc();


    @FormUrlEncoded
    @POST("docregister.php")
    Call<DocPojo> insertUser(@Field("doc_firstName") String doc_firstName,
                             @Field("doc_lastName") String doc_lastName,
                             @Field("doc_contact") String doc_contact,
                             @Field("doc_email") String doc_email,
                             @Field("doc_pass") String doc_pass,
                             @Field("doc_conf_pass") String doc_conf_pass,
                             @Field("doc_city") String doc_city,
                             @Field("doc_state") String doc_state,
                             @Field("doc_pin") String doc_pin,
                             @Field("doc_country") String doc_country);


    @FormUrlEncoded
    @POST("patregister.php")
    Call<PatResponse> insertPatDetail(@Field("pat_firstName") String pat_firstName,
                                      @Field("pat_lastName") String pat_lastName,
                                      @Field("pat_contact") String pat_contact,
                                      @Field("pat_email") String pat_email,
                                      @Field("pat_pass") String pat_pass,
                                      @Field("pat_conf_pass") String pat_conf_pass,
                                      @Field("pat_city") String pat_city,
                                      @Field("pat_state") String pat_state,
                                      @Field("pat_pin") String pat_pin,
                                      @Field("pat_country") String pat_country);


    @FormUrlEncoded
    @POST("adminregister.php")
    Call<AdminPojo> insertAdminnDetail(@Field("admin_firstName") String admin_firstName,
                                       @Field("admin_lastName") String admin_lastName,
                                       @Field("admin_contact") String admin_contact,
                                       @Field("admin_email") String admin_email,
                                       @Field("admin_pass") String admin_pass,
                                       @Field("admin_conf_pass") String admin_conf_pass,
                                       @Field("admin_city") String admin_city,
                                       @Field("admin_state") String admin_state,
                                       @Field("admin_pin") String admin_pin,
                                       @Field("admin_country") String admin_country);


    //pat_firstName_fileName`,'doc_firstName','doc_contact','pat_contact',`w_pressure`, `heart_beat`, `temp`
    @FormUrlEncoded
    @POST("sensordatainsert.php")
    Call<SensorDataPojo> insertSensorData(@Field("pat_firstName_fileName") String file_name,
                                          @Field("doc_firstName")String doc_firstName,
                                          @Field("doc_contact")String doc_contact,
                                          @Field("pat_contact")String pat_contact,
                                          @Field("w_pressure") String w_pressure,
                                          @Field("heart_beat") String heart_beat,
                                          @Field("temp") String temp);

    @FormUrlEncoded
    @POST("allocation.php")

    Call<AllocationPojo> saveAllocation(@Field("doc_firstName")String doc_firstName,
                           @Field("pat_firstName")String pat_firstName);

    @FormUrlEncoded
    @POST("testdevice1.php")
    Call<DevicePojo> sendRegistration(@Field("admin_email")String admin_email,
                                              @Field("token")String token);


//    @POST("docregister.php")
//    @FormUrlEncoded
//    Call<DocPojo> savePost(@Body DocPojo docPojo);
}
