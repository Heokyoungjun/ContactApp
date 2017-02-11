package com.compapp.app.contactapp.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.compapp.app.contactapp.R;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener{
    Button btUpdate,btList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        btUpdate = (Button) findViewById(R.id.btUpdate);
        btList = (Button) findViewById(R.id.btList);

        btUpdate.setOnClickListener(this);
        btList.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btUpdate:
                Toast.makeText(DetailActivity.this,"Go to Update",Toast.LENGTH_SHORT);
                Intent intent = new Intent(DetailActivity.this,UpdateActivity.class);
                intent.putExtra("id","hong");
                startActivity(intent);
                break;
            case R.id.btList:
                Toast.makeText(DetailActivity.this,"Go to List",Toast.LENGTH_SHORT);
                startActivity(new Intent(DetailActivity.this,ListActivity.class));
                break;
        }
    }
}
