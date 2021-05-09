package com.example.swgtask_2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class eventlistadapter extends BaseAdapter {
    private ArrayList<Event> Events;
    Context ctx;
    public eventlistadapter(ArrayList<Event> Events, Context ctx) {
        this.Events = Events;
        this.ctx = ctx;
    }
    @Override
    public int getCount(){
        return Events.size();
    }

    @Override
    public Object getItem(int position) {
        return Events.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View listview = convertView;

        if(listview==null){
            LayoutInflater inflater = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            listview = inflater.inflate(R.layout.eventlistview,null);
        }

        TextView eventname = (TextView)listview.findViewById(R.id.eventname);
        TextView eventtime = (TextView)listview.findViewById(R.id.eventtime);
        TextView eventtarget = (TextView)listview.findViewById(R.id.eventtarget);
        TextView description = (TextView)listview.findViewById(R.id.eventdescription);

        final int n = Events.size();

        eventname.setText(Events.get(n-1-position).getEventName().toString());
        eventtime.setText(Events.get(n-1-position).getTime().toString());
        eventtarget.setText(Events.get(n-1-position).getTargetaudience().toString());
        description.setText(Events.get(n-1-position).getDescription().toString());

        return listview;
    }
}
