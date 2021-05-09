package com.example.swgtask_2;

public class Event {
    String EventId;
    String EventName;
    String Description;
    String Time;
    String Targetaudience;
    public Event(){

    }

    public Event(String eventId, String eventName, String description, String time, String targetaudience) {
        EventId = eventId;
        EventName = eventName;
        Description = description;
        Time = time;
        Targetaudience = targetaudience;
    }

    public String getEventId() {
        return EventId;
    }

    public void setEventId(String eventId) {
        EventId = eventId;
    }

    public String getEventName() {
        return EventName;
    }

    public void setEventName(String eventName) {
        EventName = eventName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getTargetaudience() {
        return Targetaudience;
    }

    public void setTargetaudience(String targetaudience) {
        Targetaudience = targetaudience;
    }
}
