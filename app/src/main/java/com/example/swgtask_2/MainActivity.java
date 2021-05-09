package com.example.swgtask_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private Button ViewEvents;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button =(Button)findViewById(R.id.RegisterEvent);
        ViewEvents =(Button)findViewById(R.id.ViewEvent);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegisteractivity();
            }
        });
        ViewEvents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openevents();
            }
        });
    }
    public void openRegisteractivity(){
        Intent intent = new Intent(this,AddEvent.class);
        startActivity(intent);
    }
    public void openevents(){
        Intent intent = new Intent(this,ViewEvents.class);
        startActivity(intent);
    }


}