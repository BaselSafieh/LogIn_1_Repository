package com.example.basel.login_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Basel on 1/26/2017.
 */

public class ClassesAdapter extends ArrayAdapter<ClassObject> {
    private final Context context;
    private final ArrayList<ClassObject> classes;
    public ClassesAdapter(Context context, ArrayList<ClassObject> classes){
        super(context, -1, classes);
        this.context = context;
        this.classes = classes;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_row, parent, false);

        TextView TV_Class = (TextView) rowView.findViewById(R.id.TV_Class);
        TextView TV_Code = (TextView) rowView.findViewById(R.id.TV_Code);

        TV_Class.setText(classes.get(position).getName().toString());
        TV_Code.setText("" + classes.get(position).getCode());

        return rowView;
    }
}
