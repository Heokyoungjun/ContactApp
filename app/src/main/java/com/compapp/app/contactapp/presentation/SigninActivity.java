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
                String id = etID.getText().toString();
                String pw = etPW.getText().toString();
                bean.setId(id);
                bean.setPw(pw);

                MemberBean resultBean = service.findOne(bean);

                if (!resultBean.getId().equals("fail") && pw.equals(resultBean.getPw())) {
                    Toast.makeText(SigninActivity.this,"SECCESS",Toast.LENGTH_LONG);
                    startActivity(new Intent(SigninActivity.this, DetailActivity.class));
                } else {
                    Toast.makeText(SigninActivity.this,"Fail",Toast.LENGTH_LONG);
                    startActivity(new Intent(SigninActivity.this, SigninActivity.class));
                }
                break;
            case R.id.btCancel:
                break;
        }
    }
}
