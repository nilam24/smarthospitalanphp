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

import com.sourcecode.smarthospital.pojohspital.PatResponse;

import java.sql.SQLException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//import com.sourcecode.smarthospital.utils.DaoUtils;

public class RegistrationUserActivity extends AppCompatActivity {

    Button register;
    TextView textFirstNm,textLastNm,textNumber,textEmailId,textCity,textStat,textPin,textContry,textPas,textConfpas;
    EditText editFirstNm,editLastNm,editNumber,editEmail,editCity,editState,editPincode,editCountry,editPas,editConfpas;

    ApiInterface apiInterface;
    String nm;
    String lastName;
    String patContact;
    String patEmail;
    String patPass;
    String patConf;
    String patCity;
    String patState;
    String patPin;
    String patCountry;

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


        apiInterface=ApiClient.getApiClient().create(ApiInterface.class);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //validation check for edit field
                String patId;
                nm=editFirstNm.getText().toString().trim();
                lastName=editLastNm.getText().toString().trim();
                patContact=editNumber.getText().toString().trim();
                patEmail=editEmail.getText().toString().trim();
                patPass=editPas.getText().toString().trim();
                patConf=editConfpas.getText().toString().trim();
                patCity=editCity.getText().toString().trim();
                patState=editState.getText().toString().trim();
                patPin=editPincode.getText().toString().trim();
                patCountry=editCountry.getText().toString().trim();


                try
                {

                   if (nm.length()==0) {
                        editFirstNm.setHint("enter name");
                       Toast.makeText(RegistrationUserActivity.this, ""+nm, Toast.LENGTH_SHORT).show();
                    }
                    if (lastName.length()==0) {
                        editLastNm.setHint("enter last name");
                    }
                    if (patContact.length()== 0) {
                        editNumber.setHint("enter contact number");
                    }

                    if(patEmail.length()==0)
                    { editEmail.setHint("enter email address");

                    }
                    if(patPass.length()==0)
                    {
                        editPas.setHint("enter password");
                    }
                    if(patConf.length()==0)
                    {
                        editConfpas.setHint("enter confirm pas field");

                    }
                    if(!patConf.equals(patPass))
                    {
                        editConfpas.setHint(" confirm password is not matching with password");
                    }

                    if(patCity.length()==0)
                    {
                        editCity.setHint("please enter city name");
                    }
                    if(patState.length()==0)
                    {
                        editState.setHint("please enter state");
                    }
                    if(patPin.length()==0)
                    {
                        editPincode.setHint("please enter pincode");
                    }
                    if(patCountry.length()==0)
                    {
                        editCountry.setHint("please enter country name");
                    }


                    else if((nm.length()!=0) && (lastName.length()!=0) && (patContact.length()!=0) && (patEmail.length()!=0) &&(patPass.length()!=0)  && (patConf.length()!=0)&& (patConf.equals(patPass)) &&(patCity.length()!=0) && (patState.length()!=0) &&(patPin.length()!=0) &&(patCountry.length()!=0)) {

                        Toast.makeText(RegistrationUserActivity.this,lastName+","+nm,Toast.LENGTH_LONG).show();
                        insertPatDetail(nm,lastName,patContact,patEmail,patPass,patConf,patCity,patState,patPin,patCountry);
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
   public int insertPatDetail( String nm,String lastName,String docContact,String docEmail,String docPass,String docConf,String docCity,String docState,String docPin,String docCountry) throws SQLException {


       final int[] res = {0};
       Call<PatResponse>callPat=apiInterface.insertPatDetail(nm,lastName,patContact,patEmail,patPass,patConf,patCity,patState,patPin,patCountry);
       callPat.enqueue(new Callback<PatResponse>() {
           @Override
           public void onResponse(Call<PatResponse> call, Response<PatResponse> response) {
               if(response.isSuccessful())
               {

                   res[0] =response.code();
                   Toast.makeText(RegistrationUserActivity.this,"registered successfully",Toast.LENGTH_LONG).show();
                   Intent intent=new Intent(RegistrationUserActivity.this,LoginPatient.class);
                   startActivity(intent);
               }
           }

           @Override
           public void onFailure(Call<PatResponse> call, Throwable t) {

               if(call.isCanceled())
               {
                   res[0]=0;
                   Log.e("res","on failure"+t.getMessage());
               }
           }
       });

        return res[0];
    }
}
