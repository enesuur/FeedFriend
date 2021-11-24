package com.enesuur.feedfriend;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    // This part of code for just testing,
    String def_username = "admin",def_password = "12345";
    String username,password;
    EditText txtUsername,txtPassword;
    Button btnLogin,btnSignUp;
    TextView warningMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSignUp = findViewById(R.id.btnSignUp);
        btnLogin = findViewById(R.id.btnLogin);
        warningMessage = findViewById(R.id.txtWarning);
        txtUsername = findViewById(R.id.txtUsername);
        txtPassword = findViewById(R.id.txtPassword);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MainActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                if(txtUsername.getText().toString().equals(def_username) && txtPassword.getText().toString().equals(def_password)){
                    Toast.makeText(getApplicationContext(),"You have succesffuly logged in!",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                    startActivity(intent);
                }
            }
        });




    }

}