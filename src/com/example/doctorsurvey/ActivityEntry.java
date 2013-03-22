package com.example.doctorsurvey;

import java.util.ArrayList;

import android.text.format.Time;

public class ActivityEntry 
{
	
	String aLocation;
	String aEvent;
	
	String StartTime;
	String EndTime;
	
	//Time aStartTime;
	//Time aEndTime;
	
	//ArrayList<String> Activities = new ArrayList<String>();

    /*public ActivityEntry(String location, String event, Time starttime, Time endtime) 
    {
    
    	aLocation = location;
    	aEvent = event;
    	aStartTime = starttime;
    	aEndTime = endtime;
    }*/
    
    public ActivityEntry(String location, String event, String starttime, String endtime) 
    {
    
    	aLocation = location;
    	aEvent = event;
    	StartTime = starttime;
    	EndTime = endtime;
    }
    
    public String getLocation()
    {
    	
    	return aLocation;
    	
    }
    
    public String getEvent()
    {
    	
    	return aEvent;
    	
    }
    
    /*public Time getStarttimeT()
    {
    	return aStartTime;
    }
    
    public Time getEndTimeT()
    {
    	return aEndTime;
    }*/
    
    public String getStarttimeS()
    {
    	return StartTime;
    }
    
    public String getEndTimeS()
    {
    	return EndTime;
    }   
    
    public void addActivity(Time starttime, String location, String activity, Time endtime)
    {
    	//Activities.add();
    }
    
    @Override
    public String toString() {
        return this.StartTime + " -" + this.EndTime + " -- " + this.aEvent + " - " + this.aLocation + "";
    }
    
}