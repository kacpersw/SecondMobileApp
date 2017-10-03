package com.example.kacper.secondapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.EditText;

import java.util.Date;

public class NewElementToDoActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_element_to_do);

        initSingletons();
    }

    public void addElementToList(View view){
        EditText type = findViewById(R.id.typeOfItem);
        String typeText = type.getText().toString();
        Singleton.addElementToList(new ToDo(typeText, new Date()));

        Intent intent = new Intent(this, MainActivity.class);
        Snackbar addMessage = Snackbar.make(findViewById(R.id.layout), "You added new item to list.", Snackbar.LENGTH_LONG);

        addMessage.show();
        startActivity(intent);
    }

    private void initSingletons(){
        Singleton.initInstance();
    }
}
