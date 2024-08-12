package com.example.artwiz_tattoo;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class Specific_Item extends AppCompatActivity {

        TextView t1, t2, time;
        String nm, price;
        ImageView img;
        DatePicker datePicker;
        TimePicker timePicker;
        TextView showDateTimeButton;

        Button btn;

        TextView timetext;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            EdgeToEdge.enable(this);
            setContentView(R.layout.activity_specific_item);


            t1=findViewById(R.id.textnm);
            img=findViewById(R.id.img);
            t2=findViewById(R.id.price);

            time=findViewById(R.id.timetext);
            timePicker = findViewById(R.id.timePicker);
            showDateTimeButton = findViewById(R.id.showDateTimeButton);
            timetext = findViewById(R.id.tvSelectedDate);
            datePicker = findViewById(R.id.datePicker);
            btn = findViewById(R.id.submit);


            int imageResourceId = getIntent().getIntExtra("timage", 0);
            nm=getIntent().getStringExtra("tattoname"); // Use the correct key
            price=getIntent().getStringExtra("tprice");

            img.setImageResource(imageResourceId);

            t1.setText(nm);
            t2.setText(price);

            showDateTimeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Get the selected date from DatePicker
                    int day = datePicker.getDayOfMonth();
                    int month = datePicker.getMonth() + 1; // Month starts from 0
                    int year = datePicker.getYear();

                    // Get the selected time from TimePicker
                    int hour = timePicker.getCurrentHour();
                    int minute = timePicker.getCurrentMinute();

                    // Display the selected date and time in a toast message
                    String dateTime = "Date: " + day + "/" + month + "/" + year + "\nTime: " + hour + ":" + minute;
                    //Toast.makeText(Specific_Item.this, dateTime, Toast.LENGTH_SHORT).show();
                    datePicker.setVisibility(View.VISIBLE);
                    showTimePickerDialog();
                    displaydate();
                }
            });

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(),Login.class);
                    intent.putExtra("flowerName",nm);

                    startActivity(intent);
                }
            });
        }

        private void displaydate() {
            final Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                            String selectedDate = dayOfMonth + "/" + (month + 1) + "/" + year;
                            time.setText(selectedDate);
                            time.setVisibility(View.VISIBLE);
                        }
                    }, year, month, day);

            datePickerDialog.show();

            datePicker.setVisibility(View.GONE);

        }

        public void showTimePickerDialog() {
            final Calendar calendar = Calendar.getInstance();
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            int minute = calendar.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {
                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                            String selectedTime = hourOfDay + ":" + minute;
                            timetext.setText(selectedTime);
                        }
                    }, hour, minute, true);

            timePickerDialog.show();
        }


}
