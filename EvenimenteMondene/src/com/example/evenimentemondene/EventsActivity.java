package com.example.evenimentemondene;

import android.app.FragmentManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class EventsActivity extends FragmentActivity {

	FragmentA fragmentA;
	FragmentB fragmentB;
	FragmentManager fragmentManager;
	int currentId = 1000;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.events_activity);

		fragmentManager = getFragmentManager();

		if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
			fragmentA = (FragmentA) fragmentManager
					.findFragmentById(R.id.fragmentA);
			fragmentB = (FragmentB) fragmentManager
					.findFragmentById(R.id.fragmentB);
			fragmentB.setContent(currentId);
		} else {
			fragmentA = new FragmentA();
			fragmentManager.beginTransaction().addToBackStack("A")
					.replace(R.id.fragContainer, fragmentA).commit();
		}

	}

	public void showEventDetails(int id) {

		currentId = id;

		if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
			fragmentB = (FragmentB) fragmentManager
					.findFragmentById(R.id.fragmentB);
			fragmentB.setContent(id);

		} else {

			fragmentB = new FragmentB();

			fragmentManager.beginTransaction().addToBackStack("A")
					.replace(R.id.fragContainer, fragmentB).commit();

			fragmentB.setContent(currentId);

			/*
			 * Intent intent = new Intent(this, DetailsActivity.class);
			 * intent.putExtra("event id", id); startActivity(intent);
			 */
		}
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub

		if (fragmentB != null && fragmentB.isVisible()) {
			if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)

				fragmentManager.beginTransaction()
						.replace(R.id.fragContainer, fragmentA).commit();

			else
				super.onBackPressed();
		} else
			super.onBackPressed();

	}
}
