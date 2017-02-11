package com.compapp.app.contactapp.presentation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

import com.compapp.app.contactapp.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ScheduleActivity extends AppCompatActivity implements View.OnClickListener{
    RadioButton rbCalender, rbClock;
    CalendarView cvSet;
    TimePicker tpSet;
    Button btSet;
    TextView tvToday, tvYear, tvMonth, tvDate, tvHour, tvMinute;
    String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        rbCalender = (RadioButton) findViewById(R.id.rbCalender);
        rbClock = (RadioButton) findViewById(R.id.rbClock);
        cvSet = (CalendarView) findViewById(R.id.cvSet);
        tpSet = (TimePicker) findViewById(R.id.tpSet);
        btSet = (Button) findViewById(R.id.btSet);
        tvToday = (TextView) findViewById(R.id.tvToday);
        tvYear = (TextView) findViewById(R.id.tvYear);
        tvMonth = (TextView) findViewById(R.id.tvMonth);
        tvDate = (TextView) findViewById(R.id.tvDate);
        tvHour = (TextView) findViewById(R.id.tvHour);
        tvMinute = (TextView) findViewById(R.id.tvMinute);
        tvToday.setText("TODAY : "+new SimpleDateFormat("yyyy-MM-dd").format(new Date()));

        cvSet.setVisibility(View.VISIBLE);
        tpSet.setVisibility(View.INVISIBLE);

        rbCalender.setOnClickListener(this);
        rbClock.setOnClickListener(this);
        btSet.setOnClickListener(this);
        date = null;

        cvSet.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                date = year + "-" + (month + 1) + "-" + dayOfMonth;
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rbCalender:
                cvSet.setVisibility(View.VISIBLE);
                tpSet.setVisibility(View.INVISIBLE);
                break;
            case R.id.rbClock:
                cvSet.setVisibility(View.INVISIBLE);
                tpSet.setVisibility(View.VISIBLE);
                break;
            case R.id.btSet:
                String[] arr = date.split("-");
                tvYear.setText(arr[0]);
                tvMonth.setText(arr[1]);
                tvDate.setText(arr[2]);
                tvHour.setText(Integer.toString(tpSet.getHour()));
                tvMinute.setText(Integer.toString(tpSet.getMinute()));
                break;
        }
    }
}
