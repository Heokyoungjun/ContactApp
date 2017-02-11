package com.compapp.app.contactapp.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.compapp.app.contactapp.R;

public class MypageActivity extends AppCompatActivity implements View.OnClickListener{
    Button btMyAlbum, btSchedule, btGoogle, btNaver, btUpdate, btUnresist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);

        btMyAlbum = (Button) findViewById(R.id.btMyAlbum);
        btSchedule = (Button) findViewById(R.id.btSchedule);
        btGoogle = (Button) findViewById(R.id.btGoogle);
        btNaver = (Button) findViewById(R.id.btNaver);
        btUpdate = (Button) findViewById(R.id.btUpdate);
        btUnresist = (Button) findViewById(R.id.btUnresist);

        btMyAlbum.setOnClickListener(this);
        btSchedule.setOnClickListener(this);
        btGoogle.setOnClickListener(this);
        btNaver.setOnClickListener(this);
        btUpdate.setOnClickListener(this);
        btUnresist.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btMyAlbum:
                break;
            case R.id.btSchedule:
                break;
            case R.id.btGoogle:
                break;
            case R.id.btNaver:
                break;
            case R.id.btUpdate:
                Toast.makeText(MypageActivity.this,"Go to Detail",Toast.LENGTH_SHORT);
                startActivity(new Intent(MypageActivity.this, DetailActivity.class));
                break;
            case R.id.btUnresist:
                break;
        }
    }
}
