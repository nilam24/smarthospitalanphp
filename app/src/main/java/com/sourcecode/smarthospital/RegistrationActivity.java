package com.sourcecode.smarthospital;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

//import com.sourcecode.smarthospital.utils.DaoUtils;


import com.sourcecode.smarthospital.pojohspital.DocPojo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistrationActivity extends AppCompatActivity {

    Button register;
    TextView textFirstNm, textLastNm, textNumber, textEmailId, textCity, textStat, textPin, textContry, textPas, textConfpas;
    EditText editFirstNm, editLastNm, editNumber, editEmail, editCity, editState, editPincode, editCountry, editPas, editConfpas;

    DocPojo docPojo;
    List<DocPojo> docPojoList;
    ApiInterface ap;

    String nm;
    String lastName;
    String docContact;
    String docEmail;
    String docPass;
    String docConf;
    String docCity;
    String docState;
    String docPin;
    String docCountry;
    int res;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        getIntent();
        register = (Button) findViewById(R.id.regbtn);
        textFirstNm = (TextView) findViewById(R.id.textFirst);
        textLastNm = (TextView) findViewById(R.id.textLastName);
        textNumber = (TextView) findViewById(R.id.textContact);
        textEmailId = (TextView) findViewById(R.id.textEmail);
        textCity = (TextView) findViewById(R.id.textCity);
        textStat = (TextView) findViewById(R.id.textState);
        textPin = (TextView) findViewById(R.id.textPinCode);
        textContry = (TextView) findViewById(R.id.textCountry);
        textPas = (TextView) findViewById(R.id.textPass3);
        textConfpas = (TextView) findViewById(R.id.textPassConf);

        editFirstNm = (EditText) findViewById(R.id.editFirst1);
        editLastNm = (EditText) findViewById(R.id.editLastName1);
        editNumber = (EditText) findViewById(R.id.editContact1);
        editEmail = (EditText) findViewById(R.id.editEmailId1);
        editCity = (EditText) findViewById(R.id.editCity1);
        editState = (EditText) findViewById(R.id.editState1);
        editPincode = (EditText) findViewById(R.id.editPinCode1);
        editCountry = (EditText) findViewById(R.id.editCountry1);
        editPas = (EditText) findViewById(R.id.editPass2);
        editConfpas = (EditText) findViewById(R.id.editPassConf);
        docPojo = new DocPojo();
        docPojoList = new ArrayList<>();
        ap = ApiClient.getApiClient().create(ApiInterface.class);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                nm = editFirstNm.getText().toString().trim();
                lastName = editLastNm.getText().toString().trim();
                docContact = editNumber.getText().toString().trim();
                docEmail = editEmail.getText().toString().trim();
                docPass = editPas.getText().toString().trim();
                docConf = editConfpas.getText().toString().trim();
                docCity = editCity.getText().toString().trim();
                docState = editState.getText().toString().trim();
                docPin = editPincode.getText().toString().trim();
                docCountry = editCountry.getText().toString().trim();


                try {

                    if (nm.length() == 0) {
                        editFirstNm.setHint("enter name");
                        Toast.makeText(RegistrationActivity.this, "" + nm, Toast.LENGTH_SHORT).show();
                    }
                    if (lastName.length() == 0) {
                        editLastNm.setHint("enter last name");
                    }
                    if (docContact.length() == 0) {
                        editNumber.setHint("enter contact number");
                    }

                    if (docEmail.length() == 0) {
                        editEmail.setHint("enter email address");

                    }
                    if (docPass.length() == 0) {
                        editPas.setHint("enter password");
                    }
                    if (docConf.length() == 0) {
                        editConfpas.setHint("enter confirm pas field");

                    }
                    if (!docConf.equals(docPass)) {
                        editConfpas.setHint(" confirm password is not matching with password");
                    }

                    if (docCity.length() == 0) {
                        editCity.setHint("please enter city name");
                    }
                    if (docState.length() == 0) {
                        editState.setHint("please enter state");
                    }
                    if (docPin.length() == 0) {
                        editPincode.setHint("please enter pincode");
                    }
                    if (docCountry.length() == 0) {
                        editCountry.setHint("please enter country name");
                    } else if ((nm.length() != 0) && (lastName.length() != 0) && (docContact.length() != 0) && (docEmail.length() != 0) && (docPass.length() != 0) && (docConf.length() != 0)&&(docConf.equals(docPass)) && (docCity.length() != 0) && (docState.length() != 0) && (docPin.length() != 0) && (docCountry.length() != 0)) {

                        Toast.makeText(RegistrationActivity.this, lastName + "," + nm, Toast.LENGTH_LONG).show();

                        insertUser(nm, lastName, docContact, docEmail, docPass, docConf, docCity, docState, docPin, docCountry);
                    }

                } catch (NullPointerException e) {
                    e.getMessage();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        });

    }

    public int insertUser(String nm, String lastName, String docContact, String docEmail, String docPass, String docConf, String docCity, String docState, String docPin, String docCountry) throws SQLException {

        final int[] res = new int[1];

        Call<DocPojo> call = ap.insertUser(nm, lastName, docContact, docEmail, docPass, docConf, docCity, docState, docPin, docCountry);

        call.enqueue(new Callback<DocPojo>() {
            @Override
            public void onResponse(Call<DocPojo> call, Response<DocPojo> response) {

                if (response.isSuccessful()) {

                    response.body();
                    int code = response.code();
                    res[0] = code;
                    Log.e("" + code, "return " + res[0]);

                    Intent in=new Intent(RegistrationActivity.this,MainActivity.class);
                    startActivity(in);
                }
            }

            @Override
            public void onFailure(Call<DocPojo> call, Throwable t) {

                res[0] = 0;
                if(call.isCanceled()){

                    Log.e("ffff " + res[0], "request aborted" + t.getMessage());
                }
                else {
                    Log.e("ffff " + res[0], "unable to submit" );
                }
                t.printStackTrace();

            }
        });


        return res[0];
    }
}
