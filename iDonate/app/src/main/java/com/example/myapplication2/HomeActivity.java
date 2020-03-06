package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Locale;

public class HomeActivity extends AppCompatActivity {

    Button btnLogOut;
    FirebaseAuth mFirebaseAuth;
    private TextToSpeech textToSpeech;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        Button ReadGuidelines = findViewById(R.id.guidelines);
        final Button AddAnEvent = findViewById(R.id.AddEvent);
        Button Contact = findViewById(R.id.button);



        btnLogOut = findViewById(R.id.logout);

         btnLogOut.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 FirebaseAuth.getInstance().signOut();
                 Intent intToMain = new Intent(HomeActivity.this, MainActivity.class);
                 startActivity(intToMain);
             }
         });


        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                textToSpeech.setLanguage(Locale.US);


            }
        });

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE},
                PackageManager.PERMISSION_GRANTED);


        ReadGuidelines.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String guidelines = "Hello, In order to make donation, you should be to" +
                        ". Plan according to our dietary routine." +
                        "For Non veg," +
                        "1. Rice or bread with protein such as fish or chicken and a salad optionally" +
                        "Fruits can also be included" +
                        "2. For veg option, any type of vegetables can be cooked and donated " +
                        "but has to be steamed or cooked with less oil" +
                        "Click on the form below to fill in details" +
                        "Our team shall contact you for further information" +
                        "Thank you for your interest and god bless you"
                        ;
                Log.i("TTS", "button clicked:" + guidelines);
                int speech = textToSpeech.speak(guidelines, TextToSpeech.QUEUE_FLUSH,null);
            }
        });

        AddAnEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, Adding_an_event.class));
            }
        });





    }
}
