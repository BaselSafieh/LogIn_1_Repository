package com.example.basel.login_1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

import java.util.ArrayList;

public class AClasses extends Activity {

    Button B_AddClass, B_Back;
    TextView TV_Temp;
    ListView LV_Classes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aclasses);

        B_AddClass = (Button) findViewById(R.id.B_AddClass);
        B_Back = (Button) findViewById(R.id.B_Back);
        //TV_Temp = (TextView) findViewById(R.id.TV_Temp);
        LV_Classes = (ListView) findViewById(R.id.LV_Classes);

        final ArrayList<ClassObject> list = new ArrayList<ClassObject>();
        final ClassesAdapter adapter = new ClassesAdapter(AClasses.this, list);
        LV_Classes.setAdapter(adapter);

        if (B_Back == null)
            Toast.makeText(AClasses.this, "NULL", Toast.LENGTH_LONG).show();

        B_AddClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AClasses.this, AAddClass.class));
            }
        });

        B_Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AClasses.this, ADashboard.class));
            }
        });

        //Populate the items
        Backendless.Persistence.of(ClassObject.class).find(new AsyncCallback<BackendlessCollection<ClassObject>>() {
            @Override
            public void handleResponse(BackendlessCollection<ClassObject> foundContacts) {
                for(int i=0; i < foundContacts.getData().size(); i++){
                    list.add(foundContacts.getData().get(i));
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void handleFault(BackendlessFault fault) {
                // an error has occurred, the error code can be retrieved with fault.getCode()
            }
        });


    }
}
