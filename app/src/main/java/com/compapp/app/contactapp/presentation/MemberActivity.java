package com.compapp.app.contactapp.presentation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.compapp.app.contactapp.R;
import com.compapp.app.contactapp.domain.MemberBean;
import com.compapp.app.contactapp.service.MemberService;
import com.compapp.app.contactapp.service.MemberServiceImpl;

public class MemberActivity extends AppCompatActivity implements View.OnClickListener{
    Button btAdd,btFindById,btFindByName,btAllList,btUpdate,btDelete;
    MemberService service;
    MemberBean bean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meber);
        btAdd= (Button) findViewById(R.id.btAdd);
        btFindById= (Button) findViewById(R.id.btFindById);
        btFindByName= (Button) findViewById(R.id.btFindByName);
        btAllList= (Button) findViewById(R.id.btAllList);
        btUpdate= (Button) findViewById(R.id.btUpdate);
        btDelete= (Button) findViewById(R.id.btDelete);
        service = new MemberServiceImpl();
        bean = new MemberBean();

        btAdd.setOnClickListener(this);
        btFindById.setOnClickListener(this);
        btFindByName.setOnClickListener(this);
        btAllList.setOnClickListener(this);
        btUpdate.setOnClickListener(this);
        btDelete.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btAdd:
                service.add(bean);
                break;
            case R.id.btFindById:
                service.findOne(bean);
                break;
            case R.id.btFindByName:
                service.findSome("");
                break;
            case R.id.btAllList:
                service.list();
                break;
            case R.id.btUpdate:
                service.upd(bean);
                break;
            case R.id.btDelete:
                service.del(bean);
                break;
        }
    }
}
