package com.example.kacper.secondapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

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
    }

    public void addElementToList(View view){
        EditText type = findViewById(R.id.typeOfItem);
        String typeText = type.getText().toString();

        EditText date = findViewById(R.id.typeOfItem);
        String dateText = type.getText().toString();

        EditText hour = findViewById(R.id.typeOfItem);
        String hourText = type.getText().toString();

        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy.MM.dd");
        SimpleDateFormat formatHour = new SimpleDateFormat("HH.mm");
        SimpleDateFormat formatAllDate = new SimpleDateFormat("yyyy.MM.dd HH.mm");

        try{
            tryDate = formatDate.parse(dateText);
        }catch(Exception e){
            showMessage("Date format is invalid.");
        }

        try{
            tryHour = formatHour.parse(hourText);
        }catch(Exception e){
            showMessage("Hour format is invalid.");
        }

        try{
            Singleton.addElementToList(new ToDo(typeText, formatAllDate.parse(tryDate+ " " + tryHour)));
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

    private void showMessage(String message){
        context = getApplicationContext();
        Toast toast = Toast.makeText(context, message, Toast.LENGTH_LONG);
        toast.show();
    }

    private void initSingletons(){
        Singleton.initInstance();
    }
}
