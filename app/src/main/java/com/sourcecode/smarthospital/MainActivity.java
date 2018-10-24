package com.sourcecode.smarthospital;

import android.content.Intent;
import android.os.StrictMode;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.sourcecode.smarthospital.pojohspital.DocPojo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView textName1, textPass1;
    EditText editName1, editPass1;
    Button btnLogin, btnRegister;
    String editUser;
    String editPassword;
    DocPojo docPojo;
    ApiInterface apiInterface;
    String docname;
    String docemail;
    String docpass;
    List<DocPojo> list;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textName1 = (TextView) findViewById(R.id.textName);
        textPass1 = (TextView) findViewById(R.id.textPass);
        editName1 = (EditText) findViewById(R.id.editName);
        editPass1 = (EditText) findViewById(R.id.editPass);
        btnLogin = (Button) findViewById(R.id.loginbtn);
        btnRegister = (Button) findViewById(R.id.register1);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setSubtitle(R.string.doctitle);
         //.setTitle(R.string.doctitle);

        docPojo=new DocPojo();
        list=new ArrayList<>();
        apiInterface=ApiClient.getApiClient().create(ApiInterface.class);

               //condition check for login details

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this, RegistrationActivity.class);
                startActivity(intent1);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                editUser = editName1.getText().toString().trim();
                editPassword = editPass1.getText().toString().trim();
                Log.e("***"+docname,"***"+docpass);
                Call<List<DocPojo>>call=apiInterface.doLogin();
                call.enqueue(new Callback<List<DocPojo>>() {
                    @Override
                    public void onResponse(Call<List<DocPojo>> call, Response<List<DocPojo>> response) {

                        if(response.isSuccessful()) {
                            list = response.body();
                            for (int i = 0; i < list.size(); i++) {
                                docname=list.get(i).getDocFirstName();
                                docpass=list.get(i).getDocPass();

                                if((editUser.equals(docname))&& (editPassword.equals(docpass)))
                                {
                                    Intent intent=new Intent(MainActivity.this,DetailDocActivity.class);
                                    startActivity(intent);
                                    Toast.makeText(MainActivity.this,"Login success :-)",Toast.LENGTH_LONG).show();
                                }

                                else {

                                    editName1.setHint("invalid user name");
                                    editPass1.setHint("invalid password");
                                    Toast.makeText(MainActivity.this, "login failed try again", Toast.LENGTH_LONG).show();
                                }

                                Log.e("**"+docname,"**"+docpass);
                            }

                        }
                    }

                    @Override
                    public void onFailure(Call<List<DocPojo>> call, Throwable t) {

                        if(call.isCanceled()) {
                            t.printStackTrace();
                            editName1.setHint("invalid user name");
                            editPass1.setHint("invalid password");
                        }
                    }
                });


            }
        });

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new
                    StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

    }

}
