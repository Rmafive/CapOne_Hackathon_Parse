package com.parse.starter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.parse.ParseAnalytics;

public class HomeScreenActivity extends Activity {
	
	private static final String LOG_TAG = "HomeScreenActivity";

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.homescreen);

        
		ParseAnalytics.trackAppOpened(getIntent());

	}
	
	public void userSignUp(View view) {
		Intent i = new Intent(HomeScreenActivity.this, SignUpActivity.class);
		startActivity(i);
	}
	
	public void userLogIn(View view) {
		Intent i = new Intent(HomeScreenActivity.this, LogInActivity.class);
		startActivity(i);			
	}
	
	
}
