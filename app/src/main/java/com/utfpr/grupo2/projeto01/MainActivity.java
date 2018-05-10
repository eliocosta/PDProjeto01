package com.utfpr.grupo2.projeto01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import org.json.JSONArray;
import java.util.ArrayList;

import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.text.InputType;
import android.view.View.OnClickListener;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnClickListener {

    private ListView listViewDays;
    private CheckBox checkDays;

    //UI References
    private EditText fromDate;
    private EditText toDate;

    private DatePickerDialog fromDatePickerDialog;
    private DatePickerDialog toDatePickerDialog;

    private SimpleDateFormat dateFormatter;

    TextView tvProgressLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewDays = (ListView)findViewById(R.id.listViewDays);
        listViewDays.setAdapter(new SimplesAdapter(this));

//        listViewDays.setOnItemClickListener((AdapterView.OnItemClickListener) this);

        dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.US);

        findViewsById();
        setDateTimeField();


        // set a change listener on the SeekBar
//        SeekBar seekBar = findViewById(R.id.barAulas);
//        seekBar.setOnSeekBarChangeListener(seekBarChangeListener);
//
//        int progress = seekBar.getProgress();
//        tvProgressLabel = findViewById(R.id.LabelSeekBar);

    }

    private void findViewsById() {
        fromDate = (EditText) findViewById(R.id.txtfromdate);
        fromDate.setInputType(InputType.TYPE_NULL);
//        fromDate.requestFocus();

        toDate = (EditText) findViewById(R.id.txttodate);
        toDate.setInputType(InputType.TYPE_NULL);
    }


    private void setDateTimeField() {
        fromDate.setOnClickListener(this);
        toDate.setOnClickListener(this);

        Calendar newCalendar = Calendar.getInstance();
        fromDatePickerDialog = new DatePickerDialog(this, new OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                fromDate.setText(dateFormatter.format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        toDatePickerDialog = new DatePickerDialog(this, new OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                toDate.setText(dateFormatter.format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
    }

//
//    public void saveData(View v){
//
//        ArrayList<String> list = new ArrayList<String>();
//        list.add("jose");
//        list.add("maria");
//        JSONArray jsArray = new JSONArray(list);
//
//        android.widget.Toast.makeText(this,jsArray.toString(),Toast.LENGTH_LONG).show();
//    }

    @Override
    public void onClick(View v) {
        if(v == fromDate) {
            fromDatePickerDialog.show();
        } else if(v == toDate) {
            toDatePickerDialog.show();
        }
    }

    SeekBar.OnSeekBarChangeListener seekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            // updated continuously as the user slides the thumb
            tvProgressLabel.setText("Aulas: " + progress);
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
            // called when the user first touches the SeekBar
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            // called after the user finishes moving the SeekBar
        }
    };

    public void configDate(View v){
        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.LabelSeek);

        if(linearLayout.getVisibility() == View.VISIBLE){
            linearLayout.setVisibility(View.GONE);
        }
        else{
            linearLayout.setVisibility(View.VISIBLE);
        }
    }
}
