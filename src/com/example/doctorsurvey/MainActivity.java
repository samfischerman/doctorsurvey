package com.example.doctorsurvey;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	Survey s1;
	
	Spinner sp1;
	Spinner sp2;
	
	String mTracking;
	String mObserver;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		sp1 = (Spinner) findViewById(R.id.spnTracking);
		mTracking = sp1.getSelectedItem().toString();
		
		sp2 = (Spinner) findViewById(R.id.spnObserver);
		mObserver = sp2.getSelectedItem().toString();
	
	    Button BeginSurvey = (Button) findViewById(R.id.btnBeginSurvey);
	    BeginSurvey.setOnClickListener(new View.OnClickListener() {
	        public void onClick(View view) {
	        	
	        	//ArrayList<Survey> questions = new ArrayList<Survey>();
	        	
	        	//s1 = new Survey(mTracking, mObserver);
	        	
	        	/*Intent i = new Intent(this, SurveyView.class);
	        	i.putExtra("Survey", obj);
	        	startActivity(i);
	        	Toast.makeText(getBaseContext(),  "You have selected item : " + mTracking, 
                    Toast.LENGTH_SHORT).show(); */   
	        	
	        	Intent i = new Intent(getApplicationContext(), SurveyView.class);
	        	i.putExtra("tracking",  mTracking);
	        	i.putExtra("observer", mObserver);
	        	startActivity(i);
	        }
	        
	    });
	
	}

}
