package com.parse.starter;

import android.app.Application;
import android.net.ParseException;
import android.widget.*;

import com.parse.GetCallback;
import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;



public class ParseApplication extends Application {

	private EditText apartmentNumber;
	private Button apartmentNumberConfirm;
	
	
	
	@Override
	public void onCreate() {
		super.onCreate();

		// Add your initialization code here
		Parse.initialize(this, "e3iYHXy6fGSvD2zLSfFiRW9svLO00zxbSxbTxASO",
				"wEThjMVaviI7XQC6Mpc6Rkl9ljkndPU9MxXBKsxu");

	
		ParseUser.enableAutomaticUser();
		ParseACL defaultACL = new ParseACL();

		// If you would like all objects to be private by default, remove this
		// line.
		defaultACL.setPublicReadAccess(true);

		ParseACL.setDefaultACL(defaultACL, true);
	}


}
