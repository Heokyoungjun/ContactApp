package com.compapp.app.contactapp.presentation;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.compapp.app.contactapp.R;
import com.compapp.app.contactapp.domain.MemberBean;
import com.compapp.app.contactapp.service.MemberService;
import com.compapp.app.contactapp.service.MemberServiceImpl;
import com.compapp.app.contactapp.util.MemberAdapter;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    MemberService service;
    ListView lvMemberList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        service = new MemberServiceImpl(this.getApplicationContext());

        lvMemberList = (ListView) findViewById(R.id.lvMemberList);
        ArrayList<MemberBean> list = service.list();
        lvMemberList.setAdapter(new MemberAdapter(list, this));

        lvMemberList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int i, long l) {
                Object oj = lvMemberList.getItemAtPosition(i);
                MemberBean memberBean = (MemberBean) oj;

                Intent intent = new Intent(ListActivity.this, DetailActivity.class);
                intent.putExtra("id", memberBean.getId());

                startActivity(intent);
            }
        });

        lvMemberList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int i, long l) {
                Object oj = lvMemberList.getItemAtPosition(i);
                final MemberBean memberBean = (MemberBean) oj;
                new AlertDialog.Builder (ListActivity.this)
                        .setTitle("Realy Del")
                        .setMessage("Are you Realy Delete")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                service.del(memberBean);
                                startActivity(new Intent(ListActivity.this, ListActivity.class));
                            }
                        })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }).show();

                return true;
            }
        });
    }
}
