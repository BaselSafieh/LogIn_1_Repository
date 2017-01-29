package com.example.basel.login_1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.BackendlessCallback;


public class ASignUp extends Activity {

    EditText ET_Email, ET_Password;
    Button B_Submit;
    Spinner S_Role;

    static final String appVersion = "v1";
    static final String APP_ID = "4C698B7C-14B4-333A-FF28-AEC7D1B0D200";
    static final String AUTH_SECRET = "A9B868D1-6B60-2933-FF38-90C567054B00";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asign_up);

        ET_Email = (EditText) findViewById(R.id.ET_Email);
        ET_Password = (EditText) findViewById(R.id.ET_Password);
        B_Submit = (Button) findViewById(R.id.B_Submit);
        S_Role = (Spinner) findViewById(R.id.S_Role);

        Backendless.initApp(this, APP_ID, AUTH_SECRET, appVersion);

        B_Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BackendlessUser user = new BackendlessUser();
                user.setEmail(ET_Email.getText().toString());
                user.setPassword(ET_Password.getText().toString());
                user.setProperty("Role", S_Role.getSelectedItem().toString());
                Backendless.UserService.register( user, new BackendlessCallback<BackendlessUser>()
                {
                    @Override
                    public void handleResponse( BackendlessUser backendlessUser )
                    {
                        Toast.makeText(ASignUp.this, backendlessUser.getEmail() + " successfully registered", Toast.LENGTH_LONG).show();

                    }
                } );
            }
        });

    }
}
