package com.sourcecode.smarthospital;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.sourcecode.smarthospital.pojohspital.DocPojo;
import com.sourcecode.smarthospital.pojohspital.PatResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Admin on 10/6/2018.
 */

public class DetailDocActivity extends AppCompatActivity {

    RecyclerView recyclerView1,recyclerView2;
    TextView textpersonal,textpatient,emptytext;
    Adapter2 adapter2;
    Adapter adapter;
    ApiInterface ap1,ap2;
    DocPojo docPojo;
    PatResponse pat;
    List<DocPojo>list1;
    List<PatResponse>list2;
    String nm,ps;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_detail_layout);

        recyclerView1=(RecyclerView)findViewById(R.id.recycler1);
        recyclerView2=(RecyclerView)findViewById(R.id.recycler2);
        emptytext=(TextView)findViewById(R.id.textView);
        textpersonal=(TextView)findViewById(R.id.text1);
        textpatient=(TextView)findViewById(R.id.text2);
        ap1=ApiClient.getApiClient().create(ApiInterface.class);
        ap2=ApiClient.getApiClient().create(ApiInterface.class);
        docPojo=new DocPojo();
        pat=new PatResponse();
        list1=new ArrayList<>();
        list2=new ArrayList<>();

        //LinearLayoutManager layoutManager=new LinearLayoutManager(DetailDocActivity.this,LinearLayoutManager.VERTICAL,false);
        recyclerView1.setLayoutManager(new LinearLayoutManager(DetailDocActivity.this,LinearLayoutManager.VERTICAL,false));
        Call<List<DocPojo>> call=ap2.getDocDetail();
        call.enqueue(new Callback<List<DocPojo>>() {
            @Override
            public void onResponse(Call<List<DocPojo>> call, Response<List<DocPojo>> response) {
                list1=response.body();
                adapter2=new Adapter2(DetailDocActivity.this,list1);
                recyclerView1.setAdapter(adapter2);
                adapter2.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<List<DocPojo>> call, Throwable t) {
                t.printStackTrace();

            }
        });
//        Call<DocPojo>call=ap1.getDocDetail();
//        call.enqueue(new Callback<DocPojo>() {
//            @Override
//            public void onResponse(Call<DocPojo> call, Response<DocPojo> response) {
//                docPojo=response.body();
//                list1.add(docPojo);
//                Log.e("docpojo===",""+docPojo);
//                adapter2=new Adapter2(DetailDocActivity.this,list1);
//                recyclerView1.setAdapter(adapter2);
//                adapter2.notifyDataSetChanged();
//
//            }
//
//            @Override
//            public void onFailure(Call<DocPojo> call, Throwable t) {
//
//                emptytext.setVisibility(View.VISIBLE);
//                emptytext.setText("failure");
//            }
//        });


      //  adapter2=new Adapter2(DetailDocActivity.this,new ArrayList<DocPojo>());

       // recyclerView1.setAdapter(adapter2);

        textpatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recyclerView2.setVisibility(View.VISIBLE);
                recyclerView2.setLayoutManager(new LinearLayoutManager(DetailDocActivity.this,LinearLayoutManager.VERTICAL,false));
                 Call<List<PatResponse>>listCall=ap2.getPatResponse();
                 listCall.enqueue(new Callback<List<PatResponse>>() {
                     @Override
                     public void onResponse(Call<List<PatResponse>> call, Response<List<PatResponse>> response) {
                         list2=response.body();
                         adapter=new Adapter(list2);
                         recyclerView2.setAdapter(adapter);
                         adapter.notifyDataSetChanged();
                     }

                     @Override
                     public void onFailure(Call<List<PatResponse>> call, Throwable t) {

                         t.printStackTrace();
                     }
                 });




//                Call<PatientPojo>callpat=ap2.getPatDetailData();
//                callpat.enqueue(new Callback<PatientPojo>() {
//                    @Override
//                    public void onResponse(Call<PatientPojo> call, Response<PatientPojo> response) {
//                        patientPojo=response.body();
//                        list2.add(patientPojo);
//                       // adapter=new Adapter(DetailDocActivity.this,list2);
//                      //  recyclerView2.setAdapter(adapter);
//                      //  adapter.notifyDataSetChanged();
//                    }
//
//                    @Override
//                    public void onFailure(Call<PatientPojo> call, Throwable t) {
//                        emptytext.setVisibility(View.VISIBLE);
//                        emptytext.setText("failure");
//                    }
//                });

              //  adapter=new Adapter(DetailDocActivity.this,new ArrayList<PatientPojo>());
              //  recyclerView2.setAdapter(adapter);
            }
        });


    }
}
