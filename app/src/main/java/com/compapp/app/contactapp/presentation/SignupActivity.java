package com.compapp.app.contactapp.presentation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.compapp.app.contactapp.R;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener{
    EditText etID,etPW,etName,etPhone,etAddr;
    Button btSubmit,btCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        etID = (EditText) findViewById(R.id.etID);
        etPW = (EditText) findViewById(R.id.etPW);
        etName = (EditText) findViewById(R.id.etName);
        etPhone = (EditText) findViewById(R.id.etPhone);
        etAddr = (EditText) findViewById(R.id.etAddr);
        btSubmit = (Button) findViewById(R.id.btSubmit);
        btCancel = (Button) findViewById(R.id.btCancel);

        btSubmit.setOnClickListener(this);
        btCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btSubmit:
                break;
            case R.id.btCancel:
                break;
        }
    }
}
