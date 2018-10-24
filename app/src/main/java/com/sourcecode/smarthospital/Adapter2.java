package com.sourcecode.smarthospital;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sourcecode.smarthospital.pojohspital.DocPojo;

import java.util.List;

public class Adapter2 extends RecyclerView.Adapter<displayViewHolder>{

    List<DocPojo>pojoList;
    DocPojo docPojo;

    public Adapter2(Context context){

        super();

    }
    public Adapter2(Context context, List<DocPojo>pojoList)
    {
        super();
        this.pojoList=pojoList;


    }

    @NonNull
    @Override
    public displayViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_layout,parent,false);

        displayViewHolder viewHolder=new displayViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull displayViewHolder holder, int position) {

        docPojo=new DocPojo();
        docPojo=pojoList.get(position);
        int id=docPojo.getDocId();
        String nm=docPojo.getDocFirstName();
        holder.displaytext1.setText(nm);
        String lstnm=docPojo.getDocLastName();
        holder.displaytext2.setText(lstnm);
        String contact=docPojo.getDocContact();
        holder.displaytext3.setText(contact);
        String email=docPojo.getDocEmail();
        holder.displaytext4.setText(email);
        String ps=docPojo.getDocPass();
        holder.displaytext5.setText(ps);
        String city=docPojo.getDocCity();
        holder.displaytext6.setText(city);
        String st=docPojo.getDocState();
        holder.displaytext7.setText(st);
        String contry=docPojo.getDocCountry();
        holder.displaytext8.setText(contry);
       // holder.displaytext9.setText("Patient detail");
     //   holder.displaytext9.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //fetch from database allocation..
//            }
//        });




    }

    @Override
    public int getItemCount() {
        return pojoList.size();
    }
}

class displayViewHolder extends RecyclerView.ViewHolder{

    TextView displaytext1, displaytext2, displaytext3, displaytext4, displaytext5, displaytext6,displaytext7,displaytext8,displaytext9;
    public displayViewHolder(View itemView) {
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
      // displaytext9=(TextView)itemView.findViewById(R.id.textItem6Allocated);

    }


}