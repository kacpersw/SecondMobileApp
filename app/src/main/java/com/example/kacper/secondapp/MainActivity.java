package com.example.kacper.secondapp;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class MainActivity extends AppCompatActivity {
    private List<ToDo> items;
    private ListView lvItems;
    private Snackbar addMessage;
    private Intent formIntent;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        initSingletons();

        lvItems = (ListView) findViewById(R.id.lvItems);
        items = Singleton.getInstance().getToDos();
        final ToDoListAdapter toDoListAdapter = new ToDoListAdapter(this, items);
        lvItems.setAdapter(toDoListAdapter);

        formIntent = getIntent();
        if(formIntent.getBooleanExtra(NewElementToDoActivity.CAN_I_SHOW_POP_UP,false)==true){
            addMessage = Snackbar.make(findViewById(R.id.mainLayout), "You added new item to list.", Snackbar.LENGTH_LONG);
            addMessage.show();
        }

        lvItems.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> adapter, View item, int pos, long id) {
                        items.remove(pos);
                        toDoListAdapter.notifyDataSetChanged();

                        context = getApplicationContext();
                        Toast toast = Toast.makeText(context, "Item deleted", Toast.LENGTH_LONG);
                        toast.show();

                        toDoListAdapter.notifyDataSetChanged();
                        return true;
                    }
                });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(Objects.equals(item.getTitle(),"Add new to do")){
            Intent intent = new Intent(this, NewElementToDoActivity.class);
            startActivity(intent);
            return true;
            }
        return false;
    }

    public void goToAddView(View view) {
        Intent intent = new Intent(this, NewElementToDoActivity.class);
        startActivity(intent);
    }

    private void initSingletons(){
        Singleton.initInstance();
    }

}
