package com.parse.starter;

import com.parse.LogInCallback;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LogInActivity extends Activity{

	private EditText username;
	private EditText password;

	

	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		ParseAnalytics.trackAppOpened(getIntent());
	}
	
	public void logInConfirm(View view) {
		
	
		username = (EditText) findViewById(R.id.username);
		password = (EditText) findViewById(R.id.password);
		
		


		String u = username.getText().toString();
		String p = password.getText().toString();
		
		


		
		
		ParseUser.logInInBackground(u, p, new LogInCallback(){

			@Override
			public void done(ParseUser user, ParseException e) {
			    if (user != null) {
			    	Intent i = new Intent(LogInActivity.this, NewsFeedActivity.class);
					startActivity(i);
			      } 
			    else {
			    	Log.d("LOG IN", "LOG IN FAILED");
			      }
			}
			
		});
	}
		
		//user.setUsername(u);

	}
	
	

