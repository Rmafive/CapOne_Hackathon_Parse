package com.parse.starter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.parse.ParseAnalytics;

public class NewsFeedActivity extends Activity{

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.newsfeed);
		ParseAnalytics.trackAppOpened(getIntent());
	}
	
	public void toProfile(View view){
		Intent i = new Intent(NewsFeedActivity.this, ProfileActivity.class);
		startActivity(i);
	}
	
}
