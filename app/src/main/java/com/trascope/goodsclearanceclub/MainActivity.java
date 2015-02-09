package com.trascope.goodsclearanceclub;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    GCCFunctionClass gccFunctionClass;
    EditText email, password;
    Button login;
    int userID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gccFunctionClass = new GCCFunctionClass();

        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login_btn);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userID = gccFunctionClass.MemberLogin(email.toString(), password.toString());

                if (userID > 0) {

                    Intent loginIntent = new Intent(MainActivity.this, Membership.class);
                    loginIntent.putExtra("userID", userID);
                    startActivity(loginIntent);
                } else {

                    Toast.makeText(getApplicationContext(), "Sorry you were unable to login, kindly try again!", Toast.LENGTH_LONG).show();
                }

            }
        });
    }

}
