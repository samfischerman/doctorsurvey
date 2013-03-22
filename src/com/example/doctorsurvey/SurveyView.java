/*package com.example.doctorsurvey;

import com.example.doctorsurvey.R;
import android.app.Activity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;
import android.view.View;
import android.content.Intent;

public class Survey extends Activity  
{
	
	String sTracking;
	String sObserver;
	
	//ArrayList<String> questions = new ArrayList<String>();

    public Survey(String tracking, String observer) 
    {
    
    	sTracking = tracking;
    	sObserver = observer;
    	
    }
    
    public void getSurvey()
    {
    	
    	System.out.println("Tracking: " + sTracking);
    	System.out.println("Observing: " + sObserver);
    	
    }
    
    /** Called when the activity is first created. 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.survey);
    }
    
}*/

package com.example.doctorsurvey;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;
import android.text.format.Time;
import android.view.View;
import android.content.Intent;

public class SurveyView extends Activity  
{	
	String svTracking;
	String svObserver;
	String svLocation;
	String svEvent;
	
	Spinner spActivity;
	Spinner spEvent;
	String act;
	
	TextView tvTracking;
	TextView tvObserver;
	TextView tvStartTime;
	TextView tvEndtime;
	TextView tvActivity;
	TextView tvLocation;
	
	EditText mEdit;
	
	Time ST  = new Time(Time.getCurrentTimezone());
	Time ET  = new Time(Time.getCurrentTimezone());
	
	ArrayList<ActivityEntry> aL = new ArrayList<ActivityEntry>();
	
	ActivityEntry a1;
	
	int index;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.survey);
        
        mEdit = (EditText) findViewById(R.id.etLocation);
        spEvent = (Spinner) findViewById(R.id.spnAct);
        
        tvStartTime =(TextView)findViewById(R.id.tvStartTime); 
        tvEndtime =(TextView)findViewById(R.id.tvEndTime); 
        
        tvActivity =(TextView)findViewById(R.id.tvActivity); 
        tvLocation = (TextView)findViewById(R.id.tvLocation);

        Button next = (Button) findViewById(R.id.back);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
            }

        });
        
        Bundle extras = getIntent().getExtras();
        if(extras !=null) {
        	
        	svTracking = extras.getString("tracking");
        	svObserver = extras.getString("observer");
        	
        }
        
        spActivity = (Spinner) findViewById(R.id.spnAllActivities);
		ArrayAdapter<ActivityEntry> adapter = new ArrayAdapter<ActivityEntry>(this,
				android.R.layout.simple_spinner_item, aL);
		spActivity.setAdapter(adapter);
        
        //final Time starttime = new Time(Time.getCurrentTimezone());
        //final Time endtime = new Time(Time.getCurrentTimezone());
		
        final Button startActivity = (Button) findViewById(R.id.btnStartActivity);
        final Button freezeActivity = (Button) findViewById(R.id.btnFreezeActivity);
        
        startActivity.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            	
            	//starttime.setToNow();
            	ST.setToNow();
            	
            	startActivity.setEnabled(false);
            	freezeActivity.setEnabled(true);
            }

        });
        
        freezeActivity.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            	
            	//endtime.setToNow();
            	ET.setToNow();
            	
            	act = spEvent.getSelectedItem().toString();
            	
            	svLocation = mEdit.getText().toString();
            	
            	aL.add(new ActivityEntry(svLocation, act, ST.format("%k:%M:%S"), ET.format("%k:%M:%S")));
            	
            	tvStartTime.setText(aL.get(aL.size()-1).getStarttimeS());
            	tvEndtime.setText(aL.get(aL.size()-1).getEndTimeS());
            	
            	tvActivity.setText(aL.get(aL.size()-1).getEvent());
            	tvLocation.setText(aL.get(aL.size()-1).getLocation());
            	
            	//(a1);
            	
            	startActivity.setEnabled(true);
            	freezeActivity.setEnabled(false);
            }

        });
        
        spActivity.setOnItemSelectedListener(new OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) 
            {
            	/*tvStartTime.setText(this.getStarttime().format("%k:%M:%S"));
            	tvEndtime.setText(a1.getEndTime().format("%k:%M:%S"));
            	
            	tvActivity.setText(a1.getEvent());
            	tvLocation.setText(a1.getLocation());*/
            	index = spActivity.getSelectedItemPosition();
            	a1 = aL.get(index);
            	Toast.makeText(getBaseContext(),  "You have selected item : " + a1.toString(), 
                            Toast.LENGTH_SHORT).show();
            }
 
            public void onNothingSelected(AdapterView<?> arg0) {}
        });
        
        
        
    }
      
}