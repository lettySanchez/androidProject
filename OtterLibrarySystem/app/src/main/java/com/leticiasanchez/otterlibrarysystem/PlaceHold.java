package com.leticiasanchez.otterlibrarysystem;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by leticiasanchez on 12/7/15.
 */
public class PlaceHold extends Activity implements View.OnClickListener {
    // Widget GUI
    Button btnCalendar1, btnCalendar2, btnTimePicker1, btnTimePicker2;
    EditText txtDate1, txtDate2, txtTime1, txtTime2;


    // Variable for storing current date and time
    private Integer startYear, startMonth, startDay, startHour, startMinute;
    private Integer endYear, endMonth, endDay, endHour, endMinute;

    private static final String TAG = "PLACEHOLD";
    final Calendar c = Calendar.getInstance();
    final Calendar c2 = Calendar.getInstance();
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.placehold);
//        int day1 = startDay;
//        int day2 = endDay;

        btnCalendar1 = (Button) findViewById(R.id.pickdate);
        btnCalendar2 = (Button) findViewById(R.id.returndate);
        btnTimePicker1 = (Button) findViewById(R.id.pickhour_button);
        btnTimePicker2 = (Button) findViewById(R.id.returnhour_button);

        txtDate1 = (EditText) findViewById(R.id.txtDate1);
        txtDate2 = (EditText) findViewById(R.id.txtDate2);
        txtTime1 = (EditText) findViewById(R.id.txtTime1);
        txtTime2 = (EditText) findViewById(R.id.txtTime2);

        View pickDateButton = findViewById(R.id.pickdate);
        pickDateButton.setOnClickListener(this);

        View returnDateButton = findViewById(R.id.returndate);
        returnDateButton.setOnClickListener(this);

        View pickHourButton = findViewById(R.id.pickhour_button);
        pickHourButton.setOnClickListener(this);

        View returnHourButton = findViewById(R.id.returnhour_button);
        returnHourButton.setOnClickListener(this);

        View submitButton = findViewById(R.id.submit_button);
        submitButton.setOnClickListener(this);

//        btnCalendar.setOnClickListener(this);
//        btnTimePicker.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        EditText bookTitle;
        TextView tv1;
        String inputBookTitle;
        String day1 = "", returnDate = "";
        int valueDay1 = 0;
        int valueDay2 = 0;

        bookTitle = (EditText) findViewById(R.id.boooktitle_edittxt);
        inputBookTitle = bookTitle.getText().toString();


        //************ PICK DATE****************
        if (v == btnCalendar1) {

            // Process to get Current Date

            startYear = c.get(Calendar.YEAR);
            startMonth = c.get(Calendar.MONTH);
            startDay = c.get(Calendar.DAY_OF_MONTH);


            // Launch Date Picker Dialog
            DatePickerDialog dpd = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {
                            // Display Selected date in textbox
                            txtDate1.setText(dayOfMonth + "-"
                                    + (monthOfYear + 1) + "-" + year);
                            startDay = dayOfMonth;

                        }
                    }, startYear, startMonth, startDay);
            dpd.show();

//            startDay = dpd.getDatePicker().getDayOfMonth();
//            startMonth =dpd.getDatePicker().getMonth();
//            startYear = dpd.getDatePicker().getYear();
            Log.d("INNER1", startDay.toString());

            c.set(startYear, startMonth, startDay);
            valueDay1 = startDay;
//           day1 = txtDate1.getText().toString();
//            valueDay1 = Integer.parseInt(day1);

        }
        //************ RETURN DATE****************
        else if (v == btnCalendar2) {
            // Process to get Current Date

            endYear = c2.get(Calendar.YEAR);
            endMonth = c2.get(Calendar.MONTH);
            endDay = c2.get(Calendar.DAY_OF_MONTH);


            // Launch Date Picker Dialog
            DatePickerDialog dpd = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {
                            // Display Selected date in textbox
                            txtDate2.setText(dayOfMonth + "-"
                                    + (monthOfYear + 1) + "-" + year);
                            endDay = dayOfMonth;

                        }
                    }, endYear, endMonth, endDay);
            dpd.show();
//            endDay = dpd.getDatePicker().getDayOfMonth();
//            endMonth =dpd.getDatePicker().getMonth();
//            endYear = dpd.getDatePicker().getYear();
            c2.set(endYear, endMonth, endDay);
            Log.d("INNER2", endDay.toString());
            valueDay2 = endDay;
//            returnDate = txtDate2.getText().toString();
//            valueDay2 = Integer.parseInt(returnDate);
        }
        //************ PICKHOUR_BUTTON ****************
        else if (v == btnTimePicker1) {

            // Process to get Current Time
//            Calendar c = Calendar.getInstance();
//            startHour = c.get(Calendar.HOUR_OF_DAY);
//            startMinute = c.get(Calendar.MINUTE);

            // Launch Time Picker Dialog
            TimePickerDialog tpd = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {
                            // Display Selected time in textbox
                            txtTime1.setText(hourOfDay + ":" + minute);
                        }
                    }, startHour, startMinute, false);
            tpd.show();
        }
        //************ RETUNRHOUT_BUTTON ****************
        else if (v == btnTimePicker2) {

            // Process to get Current Time
//            Calendar c = Calendar.getInstance();
//            endHour = c.get(Calendar.HOUR_OF_DAY);
//            endMinute = c.get(Calendar.MINUTE);

            // Launch Time Picker Dialog
            TimePickerDialog tpd = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {
                            // Display Selected time in textbox
                            txtTime2.setText(hourOfDay + ":" + minute);
                        }
                    }, endHour, endMinute, false);
            tpd.show();
        }

        ////************ SUBMIT BUTTON ****************
        else if (v.getId() == R.id.submit_button) {


//            endDay =  c2.get(Calendar.DATE)  ;
//            startDay = c.get(Calendar.DATE);
            Log.d("DAY: " , endDay.toString());
            Log.d("DAY: " , startDay.toString());
            if (endDay - startDay >= 7) {
                Toast toast = Toast.makeText(getBaseContext(),"Can not reserve for more than 7 days", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();

            } else {
                Intent i = new Intent(this, LogIn.class);
                startActivity(i);

            }
        }
        //*********************
//        Log.d(TAG, "day1" + valueDay1);
//        Log.d(TAG, "returnday " + valueDay2);
//        if(startYear == endYear &&startMonth == endMonth){
//            Log.d(TAG, "sameYear& MOnth - ");
//
//
//        }

    }

}

/*//        Days d = Days.daysBetween(startDay, endDay);
//        int days = d.getDays();
//        long diff = endD.getTime() – cal.getTime();//in Milli seconds
//        int numOfDays = diff/(1000*60*60*24);

        //long diff = btnCalendar2.getDrawingTime() - btnCalendar1.getDrawingTime();
//        long diff = btnTimePicker1.getDrawingTime() - btnCalendar2.getDrawingTime();
//        int numOfDays = (int) (diff/(1000*60*60*24));
//        String number = Integer.toString(numOfDays);
//
        long diff = txtDate2.getDrawingTime() - txtDate2.getDrawingTime();
        int numOfDays = (int) (diff/(1000*60*60*24));
        String number = Integer.toString(numOfDays);

        Log.d(TAG, "NmberofDays - " + number);
//        if(startMonth == endMonth){
//            if(numOfDays > 7){
//
//            }
//        }
//        int days = daysBetween(startDay, endMonth).getDays();
        if(startYear == endYear && startMonth == endMonth){
            if(diff >= 7){
                Log.d(TAG, "NUmberofDays****** - " + number);
                AlertDialog alertDialog = new AlertDialog.Builder(this).create();
                alertDialog.setTitle("");
                alertDialog.setMessage("Books can't be reserved!");
                alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
// here you can add functions
                        //go back to main function

                    }
                });
                //alertDialog.setIcon(R.drawable.icon);
                alertDialog.show();
            }
        }*/

//    private CalendarView calendarView;
//    private int yr, mon, dy;
//    private Calendar selectedDate;
//
//    Button button_stpd;
//    static final int DIALOG_ID = 0;
//    int hour, minute;
//    TextView textViewTime;
//    TimePicker timePicker;
//
//    public static final int TIME_DIALOG_ID = 999;
//
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.placehold);
//
////        setCurrentTimeOnView();
////        addButtonListener();
//
//        //dateView = (TextView) findViewById(R.id.pickdate)
//        View pickDateButton = findViewById(R.id.pickdate);
//        pickDateButton.setOnClickListener(this);
//
//        View returnDateButton = findViewById(R.id.returndate);
//        returnDateButton.setOnClickListener(this);
//
//        View pickHourButton = findViewById(R.id.pickhour_button);
//        pickHourButton.setOnClickListener(this);
//
//        setContentView(R.layout.placehold);
//
//        Calendar c = Calendar.getInstance();
//        yr = c.get(Calendar.YEAR);
//        mon = c.get(Calendar.MONTH);
//        dy = c.get(Calendar.DAY_OF_MONTH);
////        final int hour = c.get(Calendar.HOUR_OF_DAY);
////        final int minute = c.get(Calendar.MINUTE);
//
//        Button datePickerButton = (Button) findViewById(R.id.pickdate);
//        Button dateReturnButton = (Button)findViewById(R.id.returndate);
////        Button pickTimeButton = (Button)findViewById(R.id.pickhour);
////        Button returnTimeButton = (Button)findViewById(R.id.returnhour);
//        //returndate
//        calendarView = (CalendarView) findViewById(R.id.calendar_view);
//
//
//        datePickerButton.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                new DatePickerDialog(PlaceHold.this, dateListener, yr, mon, dy).show();
//            }
//        });
//        dateReturnButton.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//                new DatePickerDialog(PlaceHold.this, dateListener, yr, mon, dy).show();
//            }
//        });
//
//
//        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
//            @Override
//            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
//                Toast.makeText(getApplicationContext(), "Selecteddate is" + (month + 1) + " - " + dayOfMonth + " - " +
//                        year, Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
//            @Override
//            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
//                Toast.makeText(getApplicationContext(), "Selected date is " + (month + 1) + "-" + dayOfMonth + "-" +
//                        year, Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//
//    public void showTimePickerDialog(){
//        button_stpd = (Button)findViewById(R.id.pickhour_button);
//        button_stpd.setOnClickListener(
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        showDialog(DIALOG_ID);
//                    }
//                }
//        );
//    }
//
//
//    private DatePickerDialog.OnDateSetListener dateListener = new DatePickerDialog.OnDateSetListener() {
//
//                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth){
//                    selectedDate=Calendar.getInstance();
//                    yr=year;
//                    mon=monthOfYear;
//                    dy=dayOfMonth;
//                    selectedDate.set(yr, mon, dy);
//                    calendarView.setDate(selectedDate.getTimeInMillis());
//                }
//            };
//
//    @Override
//    public void onClick(View view) {
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
//        Button pickTimeButton  = (Button)findViewById(R.id.pickhour_button);
//        //Button returnTimeButton = (Button)findViewById(R.id.returnhour);
//        pickTimeButton.setOnClickListener(new View.OnClickListener() {
//
//
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
//            return String.valueOf(c);
//        else
//            return "0" + String.valueOf(c);
//    }
//
//
//

