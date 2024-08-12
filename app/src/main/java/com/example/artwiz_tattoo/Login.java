package com.example.artwiz_tattoo;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.artwiz_tattoo.databinding.ActivityLoginBinding;

public class Login extends AppCompatActivity {


    DatabaseHelper myDb;
    EditText editUsername, editPassword;
    Button  btnLogin,register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        editUsername = findViewById(R.id.username);
        editPassword = findViewById(R.id.password);
        btnLogin = findViewById(R.id.loginButton);
        register = findViewById(R.id.btn2);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password = editPassword.getText().toString();

                Cursor res = myDb.getData(password);
                if (res.getCount() == 0) {
                    // No such user
                    Toast.makeText(Login.this, "Login failed", Toast.LENGTH_SHORT).show();
                } else {
                    // User found
                    StringBuffer buffer = new StringBuffer();
                    while (res.moveToNext()) {
                        buffer.append("ID: ").append(res.getString(0)).append("\n");
                        buffer.append("Username: ").append(res.getString(1)).append("\n");
                        buffer.append("Email: ").append(res.getString(2)).append("\n");
                        buffer.append("Gender: ").append(res.getString(3)).append("\n");
                    }
                    Toast.makeText(Login.this, "Tattoo Booked", Toast.LENGTH_LONG).show();
                }
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Register.class);
                startActivity(intent);
            }
        });


    }
}