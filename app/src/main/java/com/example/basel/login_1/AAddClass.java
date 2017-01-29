package com.example.basel.login_1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.backendless.Backendless;
import com.backendless.async.callback.BackendlessCallback;
import com.mbass.codegenerator.CodeGenerationService;

public class AAddClass extends Activity {

    Button B_Back, B_Confirm;
    EditText ET_Code, ET_CourseName, ET_University, ET_Students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aadd_class);

        B_Confirm = (Button) findViewById(R.id.B_Confirm);
        B_Back = (Button) findViewById(R.id.B_Back);
        ET_Code = (EditText) findViewById(R.id.ET_Code);
        ET_CourseName = (EditText) findViewById(R.id.ET_CourseName);
        ET_University = (EditText) findViewById(R.id.ET_University);
        ET_Students = (EditText) findViewById(R.id.ET_NumberOfStudents);


        CodeGenerationService codeGenerationService = CodeGenerationService.getInstance();
        codeGenerationService.getCodeAsync(new BackendlessCallback<Integer>() {
            @Override
            public void handleResponse(Integer response) {
                ET_Code.setText("" + response);
            }
        });


        B_Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AAddClass.this, AClasses.class));
            }
        });

        B_Confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Read the values and create an object on the server
                ClassObject myClass = new ClassObject(ET_CourseName.getText().toString(), Integer.parseInt(ET_Code.getText().toString()),
                        ET_University.getText().toString(), Integer.valueOf(ET_Students.getText().toString()));
                Backendless.Persistence.save( myClass, new BackendlessCallback<ClassObject>()
                {
                    @Override
                    public void handleResponse( ClassObject myClass)
                    {
                        Log.i( "Class is:", "" + myClass );
                        startActivity(new Intent(AAddClass.this, AClasses.class));
                    }
                } );

            }
        });

    }
}
