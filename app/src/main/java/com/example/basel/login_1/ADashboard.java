package com.example.basel.login_1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class ADashboard extends Activity {

    TextView TV_Role;
    Button B_Classes, B_Students, B_Records, B_Options;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adashboard);

        TV_Role = (TextView) findViewById(R.id.TV_Role);
        B_Classes = (Button) findViewById(R.id.B_Classes);
        B_Students = (Button) findViewById(R.id.B_Students);
        B_Records = (Button) findViewById(R.id.B_Records);
        B_Options = (Button) findViewById(R.id.B_Options);

        String role = getIntent().getCharSequenceExtra("ROLE").toString();
        TV_Role.setText("ROLE: " + role);

        B_Classes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ADashboard.this, AClasses.class));
            }
        });
    }
}
