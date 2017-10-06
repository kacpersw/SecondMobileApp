package com.example.kacper.secondapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.text.InputFilter;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutionException;

public class NewElementToDoActivity extends Activity {

    public static final String CAN_I_SHOW_POP_UP = "com.example.kacper.secondapp.NewElementToDoActivity.CAN_I_SHOW_POP_UP";
    private Context context;
    private Date tryHour;
    Date tryDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_element_to_do);

        initSingletons();

        final EditText type = findViewById(R.id.typeOfItem);
        type.addTextChangedListener(new TextValidator(type){
            @Override
            public void validate(TextView textView, String text){
                if(type.getText().toString().length()==0){
                    type.setError("Name is empty");
                }
            }
        });

        EditText edittext = findViewById(R.id.typeOfItem);
        edittext.setFilters(new InputFilter[] {new InputFilter.AllCaps()});

        type.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    String bigLetters = type.getText().toString().toUpperCase();
                    type.setText(bigLetters);
                }
            }
        });
    }

    public void addElementToList(View view){
        EditText type = findViewById(R.id.typeOfItem);
        String typeText = type.getText().toString();

        EditText date = findViewById(R.id.dateOfItem);
        String dateText = date.getText().toString();

        EditText hour = findViewById(R.id.hourOfItem);
        String hourText = hour.getText().toString();

        int day=-1;
        int month=-1;
        int year=-1;

        int hours=-1;
        int minutes=-1;

        try{
            String[] partsOfDate = dateText.split("\\.");
            day = Integer.valueOf(partsOfDate[2]);
            month = Integer.valueOf(partsOfDate[1]);
            year = Integer.valueOf(partsOfDate[0]);
        }catch(Exception e){
            date.setError("Date format is invalid");
        }

        try{
            String[] partsOfHour = hourText.split("\\.");
            hours = Integer.valueOf(partsOfHour[0]);
            minutes = Integer.valueOf(partsOfHour[1]);
        }catch(Exception e){
            hour.setError("Hour format is invalid");
        }

        CheckBox notification = findViewById(R.id.addNotification);
        boolean addNotification = notification.isChecked();

        try{
            Singleton.addElementToList(new ToDo(typeText, new Date(year-1900,month,day,hours,minutes), addNotification));
            notificationOn("sdsd");
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra(CAN_I_SHOW_POP_UP, true);
            startActivity(intent);
        }catch(Exception e){
        }

    }

    public void backToMainBtn(){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(CAN_I_SHOW_POP_UP, false);
        startActivity(intent);
    }

    private void initSingletons(){
        Singleton.initInstance();
    }

    private void notificationOn(String text){
        NotificationCompat.Builder builder = (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                .setContentTitle("You have something to do now")
                .setContentText(text);

    }
}
