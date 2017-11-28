package com.example.evenimentemondene;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;

public class EventAdapter extends ArrayAdapter<Event> {

	private LayoutInflater layoutInflater;
	private RequestQueue mRequestQueue;
	private ImageLoader mImageLoader;

	public EventAdapter(Context context, Event[] events) {
		super(context, -1, events);

		layoutInflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		mRequestQueue = Volley.newRequestQueue(context);
		mImageLoader = new ImageLoader(mRequestQueue,
				new ImageLoader.ImageCache() {
					private final LruCache<String, Bitmap> mCache = new LruCache<String, Bitmap>(50);

					public void putBitmap(String url, Bitmap bitmap) {
						mCache.put(url, bitmap);
					}

					public Bitmap getBitmap(String url) {
						return mCache.get(url);
					}
				});

	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		Event thisEvent = getItem(position);

		View thisView;

		if (convertView != null)
			thisView = convertView;
		else
			thisView = layoutInflater.inflate(R.layout.event_item, null);

		TextView title = (TextView) thisView.findViewById(R.id.tvEventTitle);
		TextView tvDescription = (TextView) thisView
				.findViewById(R.id.tvDescription);
		NetworkImageView nivEventImage = (NetworkImageView) thisView
				.findViewById(R.id.ivEventImage);

		title.setText(thisEvent.getTitle().toString());
		tvDescription.setText(thisEvent.getDescription().toString());

		if (nivEventImage != null)
			nivEventImage.setImageUrl(thisEvent.getThumbImageUrl(),
					mImageLoader);

		return thisView;
	}
}
