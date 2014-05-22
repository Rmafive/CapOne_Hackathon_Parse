package com.parse.starter;

import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends Activity{

	private EditText username;
	private EditText email;
	private EditText password;
	private EditText firstName;
	private EditText lastName;
	

	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.signup);
		ParseAnalytics.trackAppOpened(getIntent());
	}
	
	public void signUpConfirm(View view) {
		ParseUser user = new ParseUser();
		
		firstName = (EditText) findViewById(R.id.firstName);
		lastName = (EditText) findViewById(R.id.lastName);		
		username = (EditText) findViewById(R.id.username);
		email = (EditText) findViewById(R.id.email);
		password = (EditText) findViewById(R.id.password);

		String fn = firstName.getText().toString();
		String ln = lastName.getText().toString();
		String u = username.getText().toString();
		String e = email.getText().toString();
		String p = password.getText().toString();

		
		user.setUsername(u);
		user.setPassword(p);
		user.setEmail(e);
		user.put("first_name", fn);
		user.put("last_name", ln);
		
		
		user.signUpInBackground(new SignUpCallback() {

			@Override
			public void done(ParseException e) {
			    if (e == null) {
			    	Log.d("SIGN UP", "DONEEE");
			      } else {
				    	Log.d("SIGN UP", "NOT DONEEE");

			      }
			}			
		});
	}
		
		//user.setUsername(u);

	}
	
	

