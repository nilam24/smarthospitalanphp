package com.sourcecode.smarthospital;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

//import com.google.gson.Gson;
//import com.google.gson.JsonArray;
//import com.google.gson.JsonParser;
//import com.google.gson.JsonSyntaxException;
//import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.sourcecode.smarthospital.pojohspital.AllocationPojo;
import com.sourcecode.smarthospital.pojohspital.Pat;
import com.sourcecode.smarthospital.pojohspital.PatResponse;


import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PatListActivity extends AppCompatActivity {

    Pat p;
    PatResponse patResponse;
    TextView empty;
    TextView alloc;
    RecyclerView recyclerView3;
    Adapter adapterpat;
    ApiInterface apiInterface;
    List<Pat> list;
    List<AllocationPojo>listalloc;
    AllocationPojo allocationPojo;
    Pat pojo;
    String nm,ps;
    String patFirstName,docname;

    List<PatResponse> r;
    List<PatResponse>newpatlist;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pat_detail_layout);


        empty=(TextView)findViewById(R.id.textempty);
        alloc=(TextView)findViewById(R.id.textViewalloc);
        recyclerView3=(RecyclerView)findViewById(R.id.recyclerpat);

        recyclerView3.setLayoutManager(new LinearLayoutManager(PatListActivity.this, LinearLayoutManager.VERTICAL, false));


        pojo=new Pat();
        list=new ArrayList<>();
        listalloc=new ArrayList<>();
        allocationPojo=new AllocationPojo();
        r=new ArrayList<>();
        newpatlist=new ArrayList<>();

        Intent intent=getIntent();
        if(intent!=null) {
            patFirstName = intent.getStringExtra("patname");
        }


        apiInterface=ApiClient.getApiClient().create(ApiInterface.class);
        Call<List<PatResponse>> call=apiInterface.getPatResponse();
        call.enqueue(new Callback<List<PatResponse>>() {
            @Override
            public void onResponse(Call<List<PatResponse>> call, Response<List<PatResponse>> response) {
                r=response.body();
                for(int i=0;i<r.size();i++) {
                    String pnm=r.get(i).getPatFirstName();
                    if(patFirstName.equals(pnm))
                    {
                      String fnm=r.get(i).getPatFirstName();
                        String lnm=r.get(i).getPatLastName();
                        String pcontact=r.get(i).getPatContact();
                        String pemail=r.get(i).getPatEmail();
                        String ppass=r.get(i).getPatPass();
                        String pcity=r.get(i).getPatCity();
                        String pstate=r.get(i).getPatState();
                        String ppin=r.get(i).getPatPin();
                        String pcountry=r.get(i).getPatCountry();
                        PatResponse p=new PatResponse(fnm,lnm,pcontact,pemail,ppass,pcity,pstate,ppin,pcountry);
                        newpatlist.add(p);
                        adapterpat=new Adapter(newpatlist);
                        recyclerView3.setAdapter(adapterpat);
                        Log.e("**00","**0011"+newpatlist);

                    }
                }

                Log.e("**00","**00"+r);
            }


            @Override
            public void onFailure(Call<List<PatResponse>> call, Throwable t) {

                t.printStackTrace();
            }
        });

     final Call<List<AllocationPojo>>listCall=apiInterface.getAlloc();
     listCall.enqueue(new Callback<List<AllocationPojo>>() {
         @Override
         public void onResponse(Call<List<AllocationPojo>> call, Response<List<AllocationPojo>> response) {
            listalloc=response.body();
            for(int i=0;i<listalloc.size();i++) {
                String patname = listalloc.get(i).getPatFirstName();
                //patFirstName=SharedPrefManager.getmInstance(getApplicationContext()).getPatName();

                if ((patFirstName != null) && (patname.equals(patFirstName))) {
                     docname = listalloc.get(i).getDocFirstName();
                     Log.e("", "match found " + docname);
                    if (patFirstName != null) {
                        alloc.setText(docname);
                    }
                    else {
                        alloc.setText("not alloted");
                    }

                }

            }
         }

         @Override
         public void onFailure(Call<List<AllocationPojo>> call, Throwable t) {

         }
     });
    }

//    private List<PatResponse> getList2(String jsonarray, Type listType2) {
//
//        if(isValid(jsonarray)){
//            return  null;
//
//        }
//
//        Log.e("","+++       "+new Gson().fromJson(jsonarray,listType2));
//        return new Gson().fromJson(jsonarray,listType2);
//    }
//
//    private List<Pat> getList(String jsonString, Type listType) {
//
//        if(!isValid(jsonString)){
//            return null;
//
//        }
//        return new Gson().fromJson(jsonString,listType);
//
//    }
//
//    private boolean isValid(String jsonString) {
//
//        try{
//
//            new JsonParser().parse(jsonString);
//            return true;
//        }
//        catch (JsonSyntaxException e){
//            e.getMessage();
//            return false;
//
//        }
//    }
}
