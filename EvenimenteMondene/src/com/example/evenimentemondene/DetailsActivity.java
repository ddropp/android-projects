package com.example.evenimentemondene;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class DetailsActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		if (getResources().getConfiguration().orientation
	                == Configuration.ORIENTATION_LANDSCAPE) {
	         
	            finish();
	            return;
	        }
		setContentView(R.layout.details_activity);

		FragmentB fragmentB = (FragmentB) getFragmentManager()
				.findFragmentById(R.id.fragmentB);
		if (fragmentB != null)
			fragmentB.setContent(getIntent().getIntExtra("event id", 1000));

	}

}
