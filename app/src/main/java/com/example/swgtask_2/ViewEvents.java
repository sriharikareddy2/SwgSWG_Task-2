package com.example.swgtask_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ViewEvents extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_events);
        listView = (ListView) findViewById(R.id.events_list);
        final ArrayList<Event> list =new ArrayList<>();
        final eventlistadapter adapter = new eventlistadapter(list,this);
        listView.setAdapter(adapter);
        DatabaseReference ref= FirebaseDatabase.getInstance().getReference().child("events");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list.clear();
                for (DataSnapshot snapshots : snapshot.getChildren()){
                    Event p = new Event(snapshots.child("eventId").getValue(String.class),
                            snapshots.child("eventName").getValue(String.class),
                            snapshots.child("description").getValue(String.class),
                            snapshots.child("time").getValue(String.class),
                            snapshots.child("targetaudience").getValue(String.class));
                    list.add(p);

                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}