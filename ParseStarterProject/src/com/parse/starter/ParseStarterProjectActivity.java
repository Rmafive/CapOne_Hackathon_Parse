package com.parse.starter;

import android.content.Intent;
import java.lang.*;

import android.util.Log;
import android.view.View;
import android.widget.*;
import android.content.*;
import android.app.Activity;
import android.net.ParseException;
import android.os.Bundle;
import android.widget.Toast;

import com.parse.GetCallback;
import com.parse.ParseAnalytics;
import com.parse.ParseObject;
import com.parse.ParseQuery;

public class ParseStarterProjectActivity extends Activity {

	private static final String LOG_TAG = "ParseStarterProjectActivity";
	private EditText apartmentNumber;
	private CheckBox utilities;
	private String NUM = null;
	private ParseObject listing;

	/** Called when the activity is first created. */
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		ParseAnalytics.trackAppOpened(getIntent());
		listing = new ParseObject("Listing");
	}


	public void apartmentNumberConfirmClicked(View view)
	{
		apartmentNumber = (EditText) findViewById(R.id.apartmentNumber);
		utilities = (CheckBox) findViewById(R.id.utilities);


		String aptNum = apartmentNumber.getText().toString();
		boolean util;
		if(!utilities.isChecked()){
			util = false;
		}
		else{
			util = true;
		}

		Log.d(LOG_TAG, "aptNum:" + aptNum);

		//ParseObject listing = new ParseObject("Listing");

		listing.put("apartment", aptNum);
		listing.put("utilities", util);
		listing.saveInBackground();

		/*
		Context context = getApplicationContext();
		CharSequence text = "End";
		int duration = Toast.LENGTH_LONG;
		Toast toast = Toast.makeText(context, text, duration);
		toast.show();

		*/

		/*
		ParseQuery<ParseObject> query = ParseQuery.getQuery("Listing");
		query.getInBackground("2jNULR1bR4", new GetCallback<ParseObject>() {

			@Override
			public void done(ParseObject object, com.parse.ParseException e) {
				if (e == null) {
					System.out.println(object.getString("appartment"));
				} else {
				}
			}

		});
		*/
	}
	/*
	public void utilitiesClicked()
	{
		utilities = (CheckBox) findViewById(R.id.apartmentNumber);
		if(NUM == null)
		{
			Context context = getApplicationContext();
			CharSequence text = "Enter a Apartment Number first.";
			int duration = Toast.LENGTH_LONG;
			Toast toast = Toast.makeText(context, text, duration);
			toast.show();
		}
		else
		{
			listing.put("utilities", utilities.isChecked());
			listing.saveInBackground();
		}


	}

	public void confirmOptionsClicked()
	{
		utilitiesClicked();
	}

	*/
}
