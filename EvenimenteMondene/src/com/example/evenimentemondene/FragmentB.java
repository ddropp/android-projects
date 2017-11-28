package com.example.evenimentemondene;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.json.JSONException;
import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;

public class FragmentB extends Fragment implements EventsParser, OnClickListener {

	private RequestQueue mRequestQueue;
	private ImageLoader mImageLoader;
	Event event;
	View view;
	TextView tvTitle, tvDescription, tvDate, tvTime, tvCity;
	NetworkImageView nivEvent;
	Button btLocation;

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		view = inflater.inflate(R.layout.events_fragment_b, container, false);

		mRequestQueue = Volley.newRequestQueue(getActivity());
		mImageLoader = new ImageLoader(mRequestQueue,
				new ImageLoader.ImageCache() {
					private final LruCache<String, Bitmap> mCache = new LruCache<String, Bitmap>(
							50);

					public void putBitmap(String url, Bitmap bitmap) {
						mCache.put(url, bitmap);
					}

					public Bitmap getBitmap(String url) {
						return mCache.get(url);
					}
				});

		tvTitle = (TextView) view.findViewById(R.id.tvEventTitle);
		tvDate = (TextView) view.findViewById(R.id.tvDate);
		tvTime = (TextView) view.findViewById(R.id.tvTime);
		tvCity = (TextView) view.findViewById(R.id.tvCity);
		tvDescription = (TextView) view.findViewById(R.id.tvDescription);
		nivEvent = (NetworkImageView) view.findViewById(R.id.ivEventImage);

		btLocation = (Button) view.findViewById(R.id.btLocation);
		btLocation.setOnClickListener(this);
		
		return view;
	}

	public void setContent(int id) {

		Integer iid = Integer.valueOf(id);
		try {
			// http://bucium.mobiletouch.ro:6161/api/IasiEvent
			// https://dl.dropboxusercontent.com/s/iabyf97gvb8cu1a/events.json
/*
			ConnectivityManager connMgr = (ConnectivityManager) getActivity()
					.getSystemService(Context.CONNECTIVITY_SERVICE);
			NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

			if (networkInfo != null && networkInfo.isConnected()) {

	*/			URL url = new URL(
						"http://students.info.uaic.ro/~radu.topor/evenimente_mondene/details/"
								+ iid.toString());
				new Downloader(this).execute(url);
			//}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@SuppressLint("SimpleDateFormat")
	public void parseNetworkResponse(String response) {

		try {
			JSONObject jsonEvent = new JSONObject(response);
			
			event = parseJsonEvent(jsonEvent);
				
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	@SuppressLint("SimpleDateFormat")
	@Override
	public Event parseJsonEvent(JSONObject jsonEvent) {
		// TODO Auto-generated method stub
		Event event = new Event();

		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formatT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		
		try {
			calendar.setTime(formatT.parse(jsonEvent.getString("startingDate")));

			event.setDate(calendar);
			event.setId(jsonEvent.getInt("id"));
			event.setTitle(jsonEvent.getString("title"));
			event.setDescription(jsonEvent.getString("description"));
			event.setImageUrl(jsonEvent.getString("imageUrl"));
			event.setLocation(jsonEvent.getString("location"));
			event.setLatitude(jsonEvent.getDouble("latitude"));
			event.setLongitude(jsonEvent.getDouble("longitude"));
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		tvTitle.setText(event.getTitle());
		tvDescription.setText(event.getDescription());

		SimpleDateFormat format = new SimpleDateFormat("HH:mm");
		tvTime.setText("Ora : " + format.format(calendar.getTime()));
		SimpleDateFormat formatt = new SimpleDateFormat("dd.MM.yyyy");
		tvDate.setText("Data : " + formatt.format(calendar.getTime()));
		tvCity.setText("Locatie : " + event.getLocation());
		
		nivEvent.setImageUrl(event.getImageUrl(), mImageLoader);

		
		return event;
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Bundle bundle = new Bundle();
		
		if (event!=null) {
			bundle.putDouble("latitude", event.getLatitude());
			bundle.putDouble("longitude", event.getLongitude());
			
			Intent intent = new Intent(getActivity(),MapsActivity.class);
			intent.putExtras(bundle);
			
			startActivity(intent);
		}
		else
			Toast.makeText(getActivity(), "Location not available",Toast.LENGTH_SHORT).show();
	}

	

}
