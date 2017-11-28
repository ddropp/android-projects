package com.example.evenimentemondene;

import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Fragment;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class FragmentA extends Fragment implements OnItemClickListener,
		EventsParser {

	View view;
	ListView eventsList;
	Event[] events;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		view = inflater.inflate(R.layout.events_fragment_a, container, false);

		eventsList = (ListView) view.findViewById(R.id.listview);
		eventsList.setOnItemClickListener(this);

		try {
			
			// https://dl.dropboxusercontent.com/s/iabyf97gvb8cu1a/events.json

			ConnectivityManager connMgr = (ConnectivityManager) getActivity()
					.getSystemService(Context.CONNECTIVITY_SERVICE);
			NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

			if (networkInfo != null && networkInfo.isConnected()) {

				URL url = new URL(
						"http://students.info.uaic.ro/~radu.topor/evenimente_mondene/events");
				new Downloader(this).execute(url);
			} else
				Toast.makeText(
						getActivity(),
						"No Internet connection. Please connect to the internet first.",
						Toast.LENGTH_LONG).show();

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return view;
	}

	public void parseNetworkResponse(String response) {

		try {

			JSONArray jsonEvents = new JSONArray(response);

			events = new Event[jsonEvents.length()];

			for (int i = 0; i < jsonEvents.length(); i++) {
				events[i] = parseJsonEvent(jsonEvents.getJSONObject(i));
			}

			eventsList.setAdapter(new EventAdapter(getActivity(), events));

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Override
	public Event parseJsonEvent(JSONObject jsonEvent) {
		// TODO Auto-generated method stub
		
		try {
			Event event = new Event();
			event.setTitle(jsonEvent.getString("title"));
			event.setId(jsonEvent.getInt("id"));
			event.setDescription(jsonEvent.getString(
					"description"));
			event.setThumbImageUrl(jsonEvent.getString("thumbImageUrl"));
			
			return event;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		EventsActivity activity = (EventsActivity) getActivity();
		activity.showEventDetails(events[arg2].getId());
	}

	

}
