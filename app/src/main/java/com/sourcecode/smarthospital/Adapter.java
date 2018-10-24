package com.sourcecode.smarthospital;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sourcecode.smarthospital.pojohspital.AllocationPojo;
import com.sourcecode.smarthospital.pojohspital.Pat;
import com.sourcecode.smarthospital.pojohspital.PatResponse;


import java.util.List;

public class Adapter extends RecyclerView.Adapter<displayView>{

    Pat patientPojo;
    PatResponse res;
    List<Pat> patientPojoList;
    List<PatResponse>responseList;
    String docName;
    String patName;
    List<AllocationPojo>list;
    AllocationPojo pojo;

    public Adapter(List<PatResponse>responseList)
    {
        this.responseList=responseList;
        Log.e("responselist ","adapter  "+responseList);

    }
    public Adapter(Context context,List<Pat>patientPojoList){
       this.patientPojoList=patientPojoList;
        Log.e("patdetailaaa ","adapter  "+patientPojoList);

    }

    public Adapter(Context context ,String docName)
    {

        this.docName=docName;

        Log.e("namelist "+list,"adapter  "+patName);
    }

    @NonNull
    @Override
    public displayView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View root= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_layout,parent,false);


        return new displayView(root);
    }

    @Override
    public void onBindViewHolder(@NonNull displayView holder, int position) {
        patientPojo=new Pat();
        Log.e("namedoc ","adapter bind view "+patName);

        res=new PatResponse();
       // res=responseList.get(position);

       // allocationPojo.getDocFirstName();
        String doc=docName;

        res=responseList.get(position);

        Log.e(res+" patdetail ","holder  ");
        String nm=res.getPatFirstName();
        if(nm!=null) {
            holder.displaytext1.setText(nm);
        }
        String lstnm=res.getPatLastName();
        if(lstnm!=null) {
            holder.displaytext2.setText(lstnm);
        }

        String contact=res.getPatContact();
        if(contact!=null) {
            holder.displaytext3.setText(contact);
        }
        String email=res.getPatEmail();
        if(email!=null) {
            holder.displaytext4.setText(email);
        }
        String ps=res.getPatPass();
        if(ps!=null) {
            holder.displaytext5.setText(ps);
        }
        String city=res.getPatCity();
        if(city!=null) {
            holder.displaytext6.setText(city);
        }
        String st=res.getPatState();
        if(st!=null) {
            holder.displaytext7.setText(st);
        }
        String contry=res.getPatCountry();
        if(contry!=null) {
            holder.displaytext8.setText(contry);
        }
        if(docName!=null) {
            holder.displaytext9.setText(doc);
        }
        else if (docName==null){
            holder.displaytext9.setText("doctor not alloted");
        }
        else {
            holder.displaytext9.setText("doctor not alloted");
        }

    }

    @Override
    public int getItemCount() {
        return responseList.size();
    }
}

class displayView extends RecyclerView.ViewHolder{


    TextView displaytext1, displaytext2, displaytext3, displaytext4, displaytext5, displaytext6,displaytext7,displaytext8,displaytext9;


    public displayView(View itemView) {
        super(itemView);

        displaytext1=(TextView)itemView.findViewById(R.id.textItem1Name);
        displaytext2=(TextView)itemView.findViewById(R.id.textItem2LastNM);
        displaytext3=(TextView)itemView.findViewById(R.id.textItem3Contact);
        displaytext4=(TextView)itemView.findViewById(R.id.textItem4Email);
        displaytext4=(TextView)itemView.findViewById(R.id.textItem5Pass);
        displaytext5=(TextView)itemView.findViewById(R.id.textItem6City);
        displaytext6=(TextView)itemView.findViewById(R.id.textItem7State);
        displaytext7=(TextView)itemView.findViewById(R.id.textItem8Pin);
        displaytext8=(TextView)itemView.findViewById(R.id.textItem9Country);
        displaytext9=(TextView)itemView.findViewById(R.id.textItem6Allocated);

    }
}
