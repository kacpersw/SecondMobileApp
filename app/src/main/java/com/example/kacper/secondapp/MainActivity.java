package com.example.kacper.secondapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;


public class MainActivity extends Activity {
    private ArrayList<String> items;
    private ArrayAdapter<String> itemsAdapter;
    private ListView lvItems;
    private Snackbar addMessage;
    private Intent formIntent;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvItems = findViewById(R.id.lvItems);
        items = new ArrayList<String>();
        itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        lvItems.setAdapter(itemsAdapter);

        formIntent = getIntent();
        if(formIntent.getBooleanExtra(NewElementToDoActivity.CAN_I_SHOW_POP_UP,false)==true){
            addMessage = Snackbar.make(findViewById(R.id.mainLayout), "You added new item to list.", Snackbar.LENGTH_LONG);
            addMessage.show();
        }


        initSingletons();
        addElementsToList();
        setupListViewListener();
    }

    private void setupListViewListener() {
        lvItems.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> adapter, View item, int pos, long id) {
                        items.remove(pos);
                        Singleton.removeElementFromList(pos);

                        context = getApplicationContext();
                        Toast toast = Toast.makeText(context, "Item deleted", Toast.LENGTH_LONG);
                        toast.show();

                        itemsAdapter.notifyDataSetChanged();
                        return true;
                    }
                });
    }

    public void goToAddView(View view) {
        Intent intent = new Intent(this, NewElementToDoActivity.class);
        startActivity(intent);
    }

    private void addElementsToList(){
        for(ToDo x : Singleton.list){
            items.add(x.toString());
        }
    }

    private void initSingletons(){
        Singleton.initInstance();
    }

}
