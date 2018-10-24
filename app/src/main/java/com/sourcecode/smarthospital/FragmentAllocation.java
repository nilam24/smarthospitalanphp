package com.sourcecode.smarthospital;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;

public class FragmentAllocation extends Fragment {


    Spinner spinnerPat,spinnerDoc;
    Button btnsave;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View rootView=inflater.inflate(R.layout.allocation_layout_fragment,container,false);

        spinnerDoc=(Spinner)rootView.findViewById(R.id.spinner2);
        spinnerPat=(Spinner)rootView.findViewById(R.id.spinner1);
        btnsave=(Button)rootView.findViewById(R.id.btnclick);






        return rootView;
    }
}
