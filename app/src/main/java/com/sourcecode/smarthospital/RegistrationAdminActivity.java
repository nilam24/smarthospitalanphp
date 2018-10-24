package com.sourcecode.smarthospital;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.sourcecode.smarthospital.pojohspital.AdminPojo;

import java.sql.SQLException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistrationAdminActivity extends AppCompatActivity {

    Button register;
    TextView textFirstNm,textLastNm,textNumber,textEmailId,textCity,textStat,textPin,textContry,textPas,textConfpas;
    EditText editFirstNm,editLastNm,editNumber,editEmail,editCity,editState,editPincode,editCountry,editPas,editConfpas;

    String nm;
    String lastName;
    String adminContact;
    String adminEmail;
    String adminPass;
    String adminConf;
    String adminCity;
    String adminState;
    String adminPin;
    String adminCountry;
    ApiInterface api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        getIntent();
        register=(Button)findViewById(R.id.regbtn);
        textFirstNm=(TextView)findViewById(R.id.textFirst);
        textLastNm=(TextView)findViewById(R.id.textLastName);
        textNumber=(TextView)findViewById(R.id.textContact);
        textEmailId=(TextView)findViewById(R.id.textEmail);
        textCity=(TextView)findViewById(R.id.textCity);
        textStat=(TextView)findViewById(R.id.textState);
        textPin=(TextView)findViewById(R.id.textPinCode);
        textContry=(TextView)findViewById(R.id.textCountry);
        textPas=(TextView)findViewById(R.id.textPass3);
        textConfpas=(TextView)findViewById(R.id.textPassConf);

        editFirstNm=(EditText)findViewById(R.id.editFirst1);
        editLastNm=(EditText)findViewById(R.id.editLastName1);
        editNumber=(EditText)findViewById(R.id.editContact1);
        editEmail=(EditText)findViewById(R.id.editEmailId1);
        editCity=(EditText)findViewById(R.id.editCity1);
        editState=(EditText)findViewById(R.id.editState1);
        editPincode=(EditText)findViewById(R.id.editPinCode1);
        editCountry=(EditText)findViewById(R.id.editCountry1);
        editPas=(EditText)findViewById(R.id.editPass2);
        editConfpas=(EditText)findViewById(R.id.editPassConf);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //validation check for edit field
                String adminId;
                nm=editFirstNm.getText().toString().trim();
                lastName=editLastNm.getText().toString().trim();
                adminContact=editNumber.getText().toString().trim();
                adminEmail=editEmail.getText().toString().trim();
                adminPass=editPas.getText().toString().trim();
                adminConf=editConfpas.getText().toString().trim();
                adminCity=editCity.getText().toString().trim();
                adminState=editState.getText().toString().trim();
                adminPin=editPincode.getText().toString().trim();
                adminCountry=editCountry.getText().toString().trim();

                try
                {

                   if (nm.length()==0) {
                        editFirstNm.setHint("enter name");
                       Toast.makeText(RegistrationAdminActivity.this, ""+nm, Toast.LENGTH_SHORT).show();
                    }
                    if (lastName.length()==0) {
                        editLastNm.setHint("enter last name");
                    }
                    if (adminContact.length()== 0) {
                        editNumber.setHint("enter contact number");
                    }

                    if(adminEmail.length()==0)
                    { editEmail.setHint("enter email address");

                    }
                    if(adminPass.length()==0)
                    {
                        editPas.setHint("enter password");
                    }
                    if(adminConf.length()==0)
                    {
                        editConfpas.setHint("enter confirm pas field");

                    }
                    if(!adminConf.equals(adminPass))
                    {
                        editConfpas.setHint(" confirm password is not matching with password");
                    }

                    if(adminCity.length()==0)
                    {
                        editCity.setHint("please enter city name");
                    }
                    if(adminState.length()==0)
                    {
                        editState.setHint("please enter state");
                    }
                    if(adminPin.length()==0)
                    {
                        editPincode.setHint("please enter pincode");
                    }
                    if(adminCountry.length()==0)
                    {
                        editCountry.setHint("please enter country name");
                    }


                    else if((nm.length()!=0) && (lastName.length()!=0) && (adminContact.length()!=0) && (adminEmail.length()!=0) &&(adminPass.length()!=0)  && (adminConf.length()!=0)&& (adminCity.length()!=0) && (adminState.length()!=0) &&(adminPin.length()!=0) &&(adminCountry.length()!=0)) {

                        Toast.makeText(RegistrationAdminActivity.this,lastName+","+nm,Toast.LENGTH_LONG).show();
                        insertAdminnDetail(nm,lastName,adminContact,adminEmail,adminPass,adminConf,adminCity,adminState,adminPin,adminCountry);
                    }

               }
                catch (NullPointerException e)
                {
                    e.getMessage();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        });

    }
   public void insertAdminnDetail( String nm,String lastName,String adminContact,String adminEmail,String adminPass,String adminConf,String adminCity,String adminState,String adminPin,String adminCountry) throws SQLException {

        final int[] res = new int[1];
       Call<AdminPojo>pojoCall=api.insertAdminnDetail(nm,lastName,adminContact,adminEmail,adminPass,adminConf,adminCity,adminState,adminPin,adminCountry);

       pojoCall.enqueue(new Callback<AdminPojo>() {
           @Override
           public void onResponse(Call<AdminPojo> call, Response<AdminPojo> response) {

               if(response.isSuccessful()) {
                   res[0] = response.code();
                   Toast.makeText(RegistrationAdminActivity.this,"data registered",Toast.LENGTH_LONG).show();
                   Intent intent = new Intent(RegistrationAdminActivity.this, AdminActivity.class);
                   startActivity(intent);
               }
           }

           @Override
           public void onFailure(Call<AdminPojo> call, Throwable t) {

               if(call.isCanceled()){
                   res[0]=0;
                   Log.e("res","on failure"+t.getMessage());
               }
           }
       });


    }
}
