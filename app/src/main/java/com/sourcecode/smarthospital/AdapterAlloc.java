package com.sourcecode.smarthospital;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sourcecode.smarthospital.pojohspital.AllocationPojo;

import java.util.List;

public class AdapterAlloc extends RecyclerView.Adapter<detailViewHolder> {

    List<AllocationPojo>detaillist;
    AllocationPojo allocationPojo;

    public AdapterAlloc(){

    }
    public AdapterAlloc(Context context, List<AllocationPojo>detaillist){

        this.detaillist=detaillist;
    }
    @NonNull
    @Override
    public detailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View inflater=LayoutInflater.from(parent.getContext()).inflate(R.layout.alloted_list_item_layout,parent,false);

        return new detailViewHolder(inflater);
    }

    @Override
    public void onBindViewHolder(@NonNull detailViewHolder holder, int position) {

        allocationPojo=new AllocationPojo();
        allocationPojo=detaillist.get(position);

        String pat=allocationPojo.getPatFirstName();
        if(pat!=null){
            holder.textpat.setText(pat);
        }
        String doc=allocationPojo.getDocFirstName();
        if(doc!=null){
            holder.textdoc.setText(doc);
        }
    }

    @Override
    public int getItemCount() {
        return detaillist.size();
    }
}

  class detailViewHolder extends RecyclerView.ViewHolder{

    TextView textpat,textdoc;

     public detailViewHolder(View itemView) {
         super(itemView);
         textpat=(TextView)itemView.findViewById(R.id.textViewallocpat);
         textdoc=(TextView)itemView.findViewById(R.id.textViewallocdoc);
     }
 }
