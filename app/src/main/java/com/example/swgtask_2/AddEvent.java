package com.example.swgtask_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddEvent extends AppCompatActivity {
    EditText editTextEvent;
    EditText editTextdescription;
    EditText editTexttime;
    EditText editTexttarget;
    EditText editTextpassword;
    Button buttonAdd;
    DatabaseReference databaseEvents;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);
        databaseEvents = FirebaseDatabase.getInstance().getReference("events");
        editTextEvent = (EditText)findViewById(R.id.editTextEventName);
        editTextdescription=(EditText)findViewById(R.id.editTextDescription);
        editTexttime=(EditText)findViewById(R.id.editTexttime);
        editTexttarget=(EditText)findViewById(R.id.editTexttargetaudience);
        editTextpassword=(EditText)findViewById(R.id.editTextpassword);
        buttonAdd=(Button)findViewById(R.id.Register);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addEvent();
            }
        });
    }
    public void addEvent() {
        String event = editTextEvent.getText().toString().trim();
        String description = editTextdescription.getText().toString().trim();
        String time = editTexttime.getText().toString().trim();
        String target = editTexttarget.getText().toString().trim();
        String Password = editTextpassword.getText().toString().trim();
        if (!((TextUtils.isEmpty(event)) || (TextUtils.isEmpty(description)) || (TextUtils.isEmpty(time)) || (TextUtils.isEmpty(target)))) {
            if(Password.equals("TeamSwg"))
            {
                String id=databaseEvents.push().getKey();
                Event events= new Event(id,event,description,time,target);
                databaseEvents.child(id).setValue(events);
                Toast.makeText(this,"Event Added Succesfully!",Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(this, "Incorrect Password!",Toast.LENGTH_LONG).show();
            }

        }else
        {
            Toast.makeText(this, "Please fill all the fields!",Toast.LENGTH_LONG).show();
        }
    }
}