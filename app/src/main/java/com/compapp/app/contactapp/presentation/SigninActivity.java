package com.compapp.app.contactapp.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.compapp.app.contactapp.R;
import com.compapp.app.contactapp.domain.MemberBean;
import com.compapp.app.contactapp.service.MemberService;
import com.compapp.app.contactapp.service.MemberServiceImpl;

public class SigninActivity extends AppCompatActivity implements View.OnClickListener{
    EditText etID,etPW;
    Button btLogin,btCancel;
    MemberService service;
    MemberBean bean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        service = new MemberServiceImpl(this.getApplicationContext());
        bean = new MemberBean();

        etID = (EditText) findViewById(R.id.etID);
        etPW = (EditText) findViewById(R.id.etPW);
        btLogin = (Button) findViewById(R.id.btLogin);
        btCancel = (Button) findViewById(R.id.btCancel);

        btLogin.setOnClickListener(this);
        btCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btLogin:
                bean.setId(etID.getText().toString());
                bean.setPw(etPW.getText().toString());

                if(service.login(bean)) {
                    startActivity(new Intent(SigninActivity.this, ListActivity.class));
                } else {
                    Toast.makeText(SigninActivity.this,"Fail LOGIN",Toast.LENGTH_LONG).show();
                }

                break;
            case R.id.btCancel:
                break;
        }
    }
}
