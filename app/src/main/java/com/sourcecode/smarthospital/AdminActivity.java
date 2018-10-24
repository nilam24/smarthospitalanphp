package com.sourcecode.smarthospital;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.sourcecode.smarthospital.pojohspital.AdminPojo;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Admin on 10/6/2018.
 */

public class AdminActivity extends AppCompatActivity {

    TextView textName1, textPass1;
    EditText editName1, editPass1;
    Button btnLogin, btnRegister;
    List<AdminPojo> adminPojoList;
    AdminPojo adminPojo;
    ApiInterface ap;
    String name;
    String pass;
    String email;
    String editNM;
    String editPs;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_laout);

        textName1 = (TextView) findViewById(R.id.textPName);
        textPass1 = (TextView) findViewById(R.id.textPPass);
        editName1 = (EditText) findViewById(R.id.editPName);
        editPass1 = (EditText) findViewById(R.id.editPPass);
        btnLogin = (Button) findViewById(R.id.loginbtn1);
        btnRegister = (Button) findViewById(R.id.register11);

        btnRegister.setVisibility(View.GONE);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setSubtitle(R.string.title);

        Log.e("edit==", "" + editNM + " " + editPs);
        adminPojoList = new ArrayList<>();
        adminPojo = new AdminPojo();

        ap = ApiClient.getApiClient().create(ApiInterface.class);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editNM = editName1.getText().toString().trim();
                editPs = editPass1.getText().toString().trim();

                Log.e("", "" + name + " " + pass);
                Log.e("editbtn", "" + editNM + " " + editPs);

                Call<List<AdminPojo>>call=ap.getAdminList();
                call.enqueue(new Callback<List<AdminPojo>>() {
                    @Override
                    public void onResponse(Call<List<AdminPojo>> call, Response<List<AdminPojo>> response) {
                        if(response.isSuccessful()){

                            adminPojoList=response.body();
                            Log.e("**11","**11"+adminPojoList);
                            int i=0;
                            for(i=0;i<adminPojoList.size();i++) {
                                name=adminPojoList.get(i).getAdminFirstName();
                                pass=adminPojoList.get(i).getAdminPass();
                                email=adminPojoList.get(i).getAdminEmail();
//                                if(email!=null) {
//                                    SharedPrefManager.saveEmail(email);
//                                }

                                if ((editNM.equals(name)) && (editPs.equals(pass))) {
                                    Log.e("", "" + name + " " + pass);

                                    Toast.makeText(AdminActivity.this, "login success"+email, Toast.LENGTH_LONG).show();
                                    Intent intent = new Intent(AdminActivity.this, AdminDetailActivity.class);
                                    intent.putExtra("admin_email",email);
                                    startActivity(intent);
                                } else {
                                    Toast.makeText(AdminActivity.this, "login failed try again", Toast.LENGTH_LONG).show();
                                }
                            }


                        }
                    }

                    @Override
                    public void onFailure(Call<List<AdminPojo>> call, Throwable t) {

                        t.printStackTrace();
                        Toast.makeText(AdminActivity.this, "login failed try again", Toast.LENGTH_LONG).show();
                    }
                });
                //editPass1.setText(pass);

            }
        });




        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new
                    StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
    }

}


