//package com.leticiasanchez.otterlibrarysystem;
//
//import android.app.Activity;
//import android.app.Dialog;
//import android.app.TimePickerDialog;
//import android.os.Bundle;
//import android.view.Gravity;
//import android.view.View;
//import android.widget.Button;
//import android.widget.TextView;
//import android.widget.TimePicker;
//import android.widget.Toast;
//
//import java.util.Calendar;
//
///**
// * Created by leticiasanchez on 12/12/15.
// */
//public class PickTimeHours extends Activity implements View.OnClickListener{
//
//    /*private TimePicker timePicker;
//    private int hour, minute;
//    private TextView textViewTime;
//    private Calendar selectedDate;*/
//
//    static final int TIME_DIALOG_ID = 999;
//    private TextView textViewTime;
//    private TimePicker timePicker;
//    private Button button;
//    private int hour;
//    private int minute;
//
//
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.picktimehours);
//
//        setCurrentTimeOnView();
//        addButtonListener();
//
//        View okButton = findViewById(R.id.ok_button);
//        okButton.setOnClickListener(this);
//
//        View pickHourButton = findViewById(R.id.pickhour);
//        pickHourButton.setOnClickListener(this);
//
//
//    }
//    //Display current time
//    public void setCurrentTimeOnView(){
//
//        textViewTime = (TextView) findViewById(R.id.displayDate);
//        timePicker = (TimePicker)findViewById(R.id.timePicker);
//
//        final Calendar c = Calendar.getInstance();
//        hour = c.get(Calendar.HOUR_OF_DAY);
//        minute = c.get(Calendar.MINUTE);
//
//        //set current time into textview
//        textViewTime.setText(new StringBuilder().append(padding_str(hour)).append(":").append(padding_str(minute)));
//        //set current time into timepicker
//        timePicker.setCurrentHour(hour);
//        timePicker.setCurrentMinute(minute);
//    }
//    public void addButtonListener(){
//        Button pickTimeButton  = (Button)findViewById(R.id.pickhour);
//        //Button returnTimeButton = (Button)findViewById(R.id.returnhour);
//        pickTimeButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                showDialog(TIME_DIALOG_ID);
//                Toast toast = Toast.makeText(getBaseContext()," PIckup hour", Toast.LENGTH_LONG);
//                toast.setGravity(Gravity.CENTER, 0, 0);
//                toast.show();
//            }
//        });
////        returnTimeButton.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                showDialog(TIME_DIALOG_ID);
////            }
////        });
//
//    }
//    @Override
//    protected Dialog onCreateDialog(int id) {
//        switch (id) {
//            case TIME_DIALOG_ID:
//                // set time picker as current time
//                return new TimePickerDialog(this, timePickerListener, hour, minute,false);
//        }
//        return null;
//    }
//
//    private TimePickerDialog.OnTimeSetListener timePickerListener =  new TimePickerDialog.OnTimeSetListener() {
//        public void onTimeSet(TimePicker view, int selectedHour, int selectedMinute) {
//
//            hour = selectedHour;
//            minute = selectedMinute;
//            // set current time into textview
//            textViewTime.setText(new StringBuilder().append(padding_str(hour)).append(":").append(padding_str(minute)));
//            // set current time into timepicker
//            timePicker.setCurrentHour(hour);
//            timePicker.setCurrentMinute(minute);
//
//        }
//    };
//
//    private static String padding_str(int c) {
//        if (c >= 10)
//        return String.valueOf(c);
//        else
//        return "0" + String.valueOf(c);
//    }
//
//
//    @Override
//    public void onClick(View view) {
//
//    }
////        View pickHourButton = findViewById(R.id.pickhour);
////        pickHourButton.setOnClickListener(this);
////
////        View returnHourButton = findViewById(R.id.returnhour);
////        returnHourButton.setOnClickListener(this);
////
//////        View pickHourButton = findViewById(R.id.pickhour);
//////        pickHourButton.setOnClickListener(this);
//////
//////        View returnHourButton = findViewById(R.id.returnhour);
//////        returnHourButton.setOnClickListener(this);
////
////        timePicker = (TimePicker)findViewById(R.id.timePicker);
////
//////        Button pickTimeButton = (Button)findViewById(R.id.pickhour);
//////        Button returnTimeButton = (Button)findViewById(R.id.returnhour);
////        Button pickTimeButton  = (Button)findViewById(R.id.pickhour);
////        Button returnTimeButton = (Button)findViewById(R.id.returnhour);
////        pickTimeButton.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                showDialog(TIME_DIALOG_ID);
////            }
////        });
////        returnTimeButton.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                showDialog(TIME_DIALOG_ID);
////            }
////        });
////
////    }
////    //Display current time
////    public void setCurrentTimeOnView(){
////
////        textViewTime = (TextView) findViewById(R.id.displayDate);
////        timePicker = (TimePicker)findViewById(R.id.timePicker);
////
////        final Calendar c = Calendar.getInstance();
//////        hour = c.get(Calendar.HOUR_OF_DAY);
//////        minute = c.get(Calendar.MINUTE);
////
////        //set current time into textview
////        textViewTime.setText(new StringBuilder().append(padding_str(hour)).append(":").append(padding_str(minute)));
////        //set current time into timepicker
////        timePicker.setCurrentHour(hour);
////        timePicker.setCurrentMinute(minute);
////    }
////
//////    public void addButtonListener(){
//////        Button pickTimeButton  = (Button)findViewById(R.id.pickhour);
//////        Button returnTimeButton = (Button)findViewById(R.id.returnhour);
//////        pickTimeButton.setOnClickListener(new View.OnClickListener() {
//////            @Override
//////            public void onClick(View view) {
//////                showDialog(TIME_DIALOG_ID);
//////            }
//////        });
//////        returnTimeButton.setOnClickListener(new View.OnClickListener() {
//////            @Override
//////            public void onClick(View view) {
//////                showDialog(TIME_DIALOG_ID);
//////            }
//////        });
//////
//////    }
////    private static String padding_str(int c) {
////        if (c >= 10) {
////            return String.valueOf(c);
////        }
////        else{
////            return "0" + String.valueOf(c);
////        }
////    }
////
////    @Override
////    protected Dialog onCreateDialog(int id) {
////        switch (id) {
////            case TIME_DIALOG_ID:
////                // set time picker as current time
////                return new TimePickerDialog(this, timePickerListener, hour, minute,false);
////        }
////        return null;
////    }
////
////    private TimePickerDialog.OnTimeSetListener timePickerListener =  new TimePickerDialog.OnTimeSetListener() {
////        public void onTimeSet(TimePicker view, int selectedHour, int selectedMinute) {
////            selectedDate = Calendar.getInstance();
////            hour = selectedHour;
////            minute = selectedMinute;
////            //set current time into textview
////            textViewTime.setText(new StringBuilder().append(padding_str(hour)).append(":").append(padding_str(minute)));
////
////            //set current time into picker
////            timePicker.setCurrentHour(hour);
////            timePicker.setCurrentMinute(minute);
////            selectedDate.set(hour, minute);
////            //timePicker.setOnTimeChangedListener(selectedDate.getTimeInMillis());
////        }
////    };
////
////    @Override
////    public void onClick(View v) {
////
////        if(v.getId() == R.id.ok_button){
////
////            Intent i = new Intent(this, PlaceHold.class);
////            startActivity(i);
////        }
////
////    }
//}
