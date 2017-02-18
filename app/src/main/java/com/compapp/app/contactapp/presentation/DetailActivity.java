package com.compapp.app.contactapp.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.compapp.app.contactapp.R;
import com.compapp.app.contactapp.domain.MemberBean;
import com.compapp.app.contactapp.service.MemberService;
import com.compapp.app.contactapp.service.MemberServiceImpl;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener{
    Button btUpdate,btList;
    ImageView ivProfile;
    TextView tvID, tvName, tvEmail, tvPhone, tvAddress;

    MemberService service;
    MemberBean memberBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        service = new MemberServiceImpl(this);
        memberBean = new MemberBean();

        Intent intent = this.getIntent();
        String id = intent.getExtras().getString("id");
        memberBean.setId(id);
        memberBean = service.findOne(memberBean);

        btUpdate = (Button) findViewById(R.id.btUpdate);
        btList = (Button) findViewById(R.id.btList);

        ivProfile = (ImageView) findViewById(R.id.ivProfile);
        tvID = (TextView) findViewById(R.id.tvID);
        tvName = (TextView) findViewById(R.id.tvName);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvPhone = (TextView) findViewById(R.id.tvPhone);
        tvAddress = (TextView) findViewById(R.id.tvAddress);

        int temp = getResources().getIdentifier(this.getPackageName()+":drawable/default_image",null,null);

        ivProfile.setImageDrawable(getResources().getDrawable(temp,this.getApplicationContext().getTheme()));
        tvID.setText(memberBean.getId());
        tvName.setText(memberBean.getName());
        tvEmail.setText(memberBean.getEmail());
        tvPhone.setText(memberBean.getPhone());
        tvAddress.setText(memberBean.getAddr());

        btUpdate.setOnClickListener(this);
        btList.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btUpdate:
                Intent intent = new Intent(DetailActivity.this,UpdateActivity.class);
                intent.putExtra("id","hong");
                startActivity(intent);
                break;
            case R.id.btList:
                startActivity(new Intent(DetailActivity.this,ListActivity.class));
                break;
        }
    }
}
