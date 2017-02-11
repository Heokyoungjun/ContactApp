package com.compapp.app.contactapp.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.compapp.app.contactapp.R;

public class SigninActivity extends AppCompatActivity implements View.OnClickListener{
    EditText etID,etPW;
    Button btLogin,btCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
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
                Toast.makeText(SigninActivity.this,"Go to Detail",Toast.LENGTH_SHORT);
                startActivity(new Intent(SigninActivity.this, DetailActivity.class));
                break;
            case R.id.btCancel:
                break;
        }
    }
}
