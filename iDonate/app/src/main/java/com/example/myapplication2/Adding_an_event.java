package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Adding_an_event extends AppCompatActivity {

    EditText Name, address, Donate, date;
    Button home, submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding_an_event2);

        Name = findViewById(R.id.txtName);
        address = findViewById(R.id.Address);
        Donate = findViewById(R.id.txtDonatingItem);
        date = findViewById(R.id.txtDate);
        home = findViewById(R.id.BackToHome);
        submit = findViewById(R.id.btnConfirm);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Adding_an_event.this, HomeActivity.class));

            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Adding_an_event.this,"Submitted Successfully ",Toast.LENGTH_SHORT).show();

            }
        });
    }
}
