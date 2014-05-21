package com.parse.starter;

import com.parse.GetCallback;
import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import android.app.Application;

public class ParseApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();

		// Add your initialization code here
		Parse.initialize(this, "e3iYHXy6fGSvD2zLSfFiRW9svLO00zxbSxbTxASO",
				"wEThjMVaviI7XQC6Mpc6Rkl9ljkndPU9MxXBKsxu");

		ParseObject listing = new ParseObject("Listing");
		listing.put("appartment", "room 111");
		listing.saveInBackground();

		ParseQuery<ParseObject> query = ParseQuery.getQuery("Listing");
		query.getInBackground("2jNULR1bR4", new GetCallback<ParseObject>() {
			public void done(ParseObject object, ParseException e) {
				if (e == null) {
					System.out.println(object.getString("appartment"));
				} else {
					// something went wrong
				}
			}
		});
		

		ParseUser.enableAutomaticUser();
		ParseACL defaultACL = new ParseACL();

		// If you would like all objects to be private by default, remove this
		// line.
		defaultACL.setPublicReadAccess(true);

		ParseACL.setDefaultACL(defaultACL, true);
	}

}
