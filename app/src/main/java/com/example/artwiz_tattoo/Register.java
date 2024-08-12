package com.example.artwiz_tattoo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.artwiz_tattoo.databinding.ActivitySignupBinding;

public class Register extends AppCompatActivity {

    DatabaseHelper myDb;
    EditText usernameEditText, emailEditText, genderEditText, passwordEditText;
    Button registerButton;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);

        usernameEditText = findViewById(R.id.username);
        emailEditText = findViewById(R.id.email);
        genderEditText = findViewById(R.id.gender);
        passwordEditText = findViewById(R.id.password);
        registerButton = findViewById(R.id.btn1);

        databaseHelper = new DatabaseHelper(this);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String gender = genderEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                boolean isInserted = myDb.insertData(username, email, gender, password);

                if (isInserted)
                    Toast.makeText(Register.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(Register.this, "Registration failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
