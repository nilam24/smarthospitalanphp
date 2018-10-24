package com.sourcecode.smarthospital;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.sourcecode.smarthospital.pojohspital.PatResponse;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Admin on 10/6/2018.
 */

public class LoginPatient extends AppCompatActivity {

    TextView textName1, textPass1;
    EditText editName1, editPass1;
    Button btnLogin, btnRegister;
    String editUser;
    String editPassword;
    ApiInterface apiInterface;
    PatResponse patientPojo;
    List<PatResponse> patientPojoList;
    String patname;
    String patemail;
    String patpass;

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

        ActionBar actionBar=getSupportActionBar();
        actionBar.setSubtitle(R.string.pattitle);

        patientPojo = new PatResponse();
        patientPojoList = new ArrayList<>();
        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                editUser = editName1.getText().toString().trim();
                editPassword = editPass1.getText().toString().trim();

                Log.e("edit==..", "" + editUser + editPassword);
                Log.e("loginPat..", "" + patname + patpass);

                Call<List<PatResponse>>call=apiInterface.doLoginPat();
                call.enqueue(new Callback<List<PatResponse>>() {
                    @Override
                    public void onResponse(Call<List<PatResponse>> call, Response<List<PatResponse>> response) {

                        patientPojoList=response.body();
                        for(int i=0;i<patientPojoList.size();i++)
                        {
                            patname=patientPojoList.get(i).getPatFirstName();
                            patpass=patientPojoList.get(i).getPatPass();

                            if ((editUser.equals(patname)) && (editPassword.equals(patpass))) {

                                // SharedPrefManager.savePatName(patname);

                                Toast.makeText(LoginPatient.this, "login success:-)", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(LoginPatient.this, PatListActivity.class);
                                intent.putExtra("patname",patname);
                                startActivity(intent);
                            } else {
                                editName1.setHint("invalid user name");
                                editPass1.setHint("invalid password");
                                Toast.makeText(LoginPatient.this, "login failed try again", Toast.LENGTH_LONG).show();
                            }
                            Log.e("patname  "+patname,"  "+patpass);
                        }
                    }

                    @Override
                    public void onFailure(Call<List<PatResponse>> call, Throwable t) {

                        t.printStackTrace();
                        editName1.setHint("invalid user name");
                        editPass1.setHint("invalid password");
                    }
                });

                //condition check for login details
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(LoginPatient.this, RegistrationUserActivity.class);
                startActivity(intent1);
            }
        });

    }

}
