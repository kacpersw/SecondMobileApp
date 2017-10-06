package com.example.kacper.secondapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Kacper on 05.10.2017.
 */

public class ToDoListAdapter extends BaseAdapter {

    private List<ToDo> toDos;
    private final LayoutInflater inflater;

    public ToDoListAdapter(Context context, List<ToDo> toDos){
        super();
        this.toDos = toDos;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return toDos.size();
    }

    @Override
    public Object getItem(int i) {
        return toDos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View oneToDo = inflater.inflate(R.layout.listviewadapter, viewGroup, false);

        TextView type = (TextView) oneToDo.findViewById(R.id.title);
        TextView time = (TextView) oneToDo.findViewById(R.id.time);

        ToDo todo = (ToDo) getItem(i);

        type.setText(todo.getType());
        time.setText(todo.getDate());

        return oneToDo;
    }
}
