package com.sourcecode.smarthospital;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    TextView docClick,patClick,adminClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        docClick=(TextView) findViewById(R.id.docLogin);
        patClick=(TextView)findViewById(R.id.loginPat);
        adminClick=(TextView)findViewById(R.id.loginAdmin);


        docClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent in=new Intent(HomeActivity.this,MainActivity.class);
                startActivity(in);

            }
        });

        patClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(HomeActivity.this,LoginPatient.class);
                startActivity(intent);
            }
        });

        adminClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent2=new Intent(HomeActivity.this,AdminActivity.class);
                startActivity(intent2);
            }
        });

    }
}
