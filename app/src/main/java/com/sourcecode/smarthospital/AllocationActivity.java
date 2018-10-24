package com.sourcecode.smarthospital;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.sourcecode.smarthospital.pojohspital.AllocationPojo;
import com.sourcecode.smarthospital.pojohspital.DocPojo;
import com.sourcecode.smarthospital.pojohspital.PatResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllocationActivity extends AppCompatActivity {

    Spinner spinnerPat, spinnerDoc;
    TextView textRefreshlist;
    RecyclerView recyclerView;
    Button btnsave;
    ApiInterface ap1, ap2, ap3;
    List<DocPojo> listdoc;
    List<PatResponse> listpat;
    List<AllocationPojo>listalloccated;
    DocPojo docPojo;
    PatResponse patientPojo;
    AllocationPojo allocationPojo;
    String nmdoc, patnm;
    List<String> stringList;
    List<String> stringList2;
    AdapterAlloc adapterAlloc;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.allocation_layout_fragment);

        spinnerPat = (Spinner) findViewById(R.id.spinner1);
        spinnerDoc = (Spinner) findViewById(R.id.spinner2);
        btnsave = (Button) findViewById(R.id.btnclick);
        textRefreshlist=(TextView)findViewById(R.id.textList);
        recyclerView=(RecyclerView)findViewById(R.id.recyclerAllocDetail);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

        listdoc = new ArrayList<>();
        listpat = new ArrayList<>();
        listalloccated=new ArrayList<>();
        docPojo = new DocPojo();
        patientPojo = new PatResponse();
        allocationPojo=new AllocationPojo();

        stringList = new ArrayList<>();
        stringList2 = new ArrayList<>();

        ap1 = ApiClient.getApiClient().create(ApiInterface.class);
        ap2 = ApiClient.getApiClient().create(ApiInterface.class);
        ap3 = ApiClient.getApiClient().create(ApiInterface.class);
        Call<List<DocPojo>> calldoc = ap1.getDocData();

        calldoc.enqueue(new Callback<List<DocPojo>>() {
            @Override
            public void onResponse(Call<List<DocPojo>> call, Response<List<DocPojo>> response) {
                if(response.isSuccessful())
                {
                    listdoc=response.body();
                    int i=0;
                    for(i=0;i<listdoc.size();i++) {

                        stringList.add(listdoc.get(i).getDocFirstName());
                    }
                    ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(AllocationActivity.this, android.R.layout.simple_spinner_item, stringList);
                    dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

                    spinnerDoc.setAdapter(dataAdapter);

                }
            }

            @Override
            public void onFailure(Call<List<DocPojo>> call, Throwable t) {

                t.printStackTrace();
            }
        });

        Call<List<PatResponse>> callpat = ap2.getPatientData();

        callpat.enqueue(new Callback<List<PatResponse>>() {
            @Override
            public void onResponse(Call<List<PatResponse>> call, Response<List<PatResponse>> response) {

                if (response.isSuccessful()) {
                     listpat=response.body();
                     int i=0;
                     for(i=0;i<listpat.size();i++) {

                        //    patientPojo.getPatFirstName();
                         stringList2.add(listpat.get(i).getPatFirstName());

                     }

                         ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(AllocationActivity.this, android.R.layout.simple_spinner_dropdown_item, stringList2);
                         dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                         spinnerPat.setAdapter(dataAdapter1);


                }
                Toast.makeText(AllocationActivity.this, "records pat found" + stringList2, Toast.LENGTH_LONG).show();

            }

            @Override
            public void onFailure(Call<List<PatResponse>> call, Throwable t) {

                if (call.isCanceled()) {
                    Toast.makeText(AllocationActivity.this, "no record found", Toast.LENGTH_LONG).show();
                }

            }
        });

        spinnerDoc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
                nmdoc=adapterView.getItemAtPosition(pos).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinnerPat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                patnm=adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                saveAllocation(nmdoc, patnm);
                Toast.makeText(AllocationActivity.this,"allocated",Toast.LENGTH_LONG).show();
            }
        });

        Call<List<AllocationPojo>>callalloc=ap1.getAlloc();
        callalloc.enqueue(new Callback<List<AllocationPojo>>() {
            @Override
            public void onResponse(Call<List<AllocationPojo>> call, Response<List<AllocationPojo>> response) {
                listalloccated=response.body();
                adapterAlloc=new AdapterAlloc(AllocationActivity.this,listalloccated);
                recyclerView.setAdapter(adapterAlloc);
                adapterAlloc.notifyDataSetChanged();
            }
            @Override
            public void onFailure(Call<List<AllocationPojo>> call, Throwable t) {

            }
        });

        textRefreshlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                recyclerView.setAdapter(adapterAlloc);
                adapterAlloc.notifyDataSetChanged();
            }
        });

    }

    public int saveAllocation(String docName, String patName) {

        final int[] res = {0};
        docName=nmdoc;
        patName=patnm;
        Call<AllocationPojo> call = ap3.saveAllocation(docName, patName);
        call.enqueue(new Callback<AllocationPojo>() {
            @Override
            public void onResponse(Call<AllocationPojo> call, Response<AllocationPojo> response) {
                if (response.isSuccessful()) {
                    res[0] = response.code();
                    Toast.makeText(AllocationActivity.this, "data saved" + res, Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<AllocationPojo> call, Throwable t) {

                if (call.isCanceled()) {
                    res[0] = 0;
                    t.printStackTrace();
                }
            }
        });

        return res[0];
    }

}
