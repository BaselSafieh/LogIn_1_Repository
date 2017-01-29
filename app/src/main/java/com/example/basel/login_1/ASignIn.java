package com.example.basel.login_1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;


public class ASignIn extends Activity {

    EditText ET_Username, ET_Password;
    Button B_LogIn;

    static final String appVersion = "v1";
    static final String APP_ID = "4C698B7C-14B4-333A-FF28-AEC7D1B0D200";
    static final String AUTH_SECRET = "A9B868D1-6B60-2933-FF38-90C567054B00";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asign_in);

        ET_Username = (EditText) findViewById(R.id.ET_Username);
        ET_Password = (EditText) findViewById(R.id.ET_Password);
        B_LogIn = (Button) findViewById(R.id.B_LogIn);

        Backendless.initApp(this, APP_ID, AUTH_SECRET, appVersion);

        B_LogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Backendless.UserService.login(ET_Username.getText().toString(), ET_Password.getText().toString(), new AsyncCallback<BackendlessUser>() {
                    public void handleResponse(BackendlessUser user) {
                        Toast.makeText(ASignIn.this, "Success" + user.getProperty("Role"), Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(ASignIn.this, ADashboard.class);
                        intent.putExtra("ROLE", user.getProperty("Role").toString());
                        startActivity(intent);
                    }

                    public void handleFault(BackendlessFault fault) {
                        Toast.makeText(ASignIn.this, "Failed, Error: " + fault.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}
