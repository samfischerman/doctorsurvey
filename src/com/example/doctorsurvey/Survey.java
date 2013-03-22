package com.example.doctorsurvey;

import java.util.ArrayList;

import android.text.format.Time;

public class Survey 
{
	
	String sTracking;
	String sObserver;
	
	ArrayList<String> Activities = new ArrayList<String>();
	
	public Survey() 
    {
		
    }

    public Survey(String Tracking, String Observer) 
    {
    
    	sTracking = Tracking;
    	sObserver = Observer;
    	
    }
    
    public String getTracking()
    {
    	
    	return sTracking;
    	
    }
    
    public String getObserver()
    {
    	
    	return sObserver;
    	
    }
    
    public void addActivity(Time starttime, String location, String activity, Time endtime)
    {
    	//Activities.add();
    }
    
}