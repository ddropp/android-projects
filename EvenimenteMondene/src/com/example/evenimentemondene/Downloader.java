package com.example.evenimentemondene;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import android.os.AsyncTask;

public class Downloader extends AsyncTask<URL, Integer, String> {

	EventsParser parser;

	public Downloader(EventsParser parser) {
		this.parser = parser;
	}

	@Override
	protected String doInBackground(URL... urls) {
		// TODO Auto-generated method stub
		try {

			URLConnection openedConnection = urls[0].openConnection();

			InputStream inputStream = openedConnection.getInputStream();
			InputStreamReader inputReader = new InputStreamReader(inputStream);
			BufferedReader bufferedReader = new BufferedReader(inputReader);

			String line;
			StringBuilder sb = new StringBuilder();
			while ((line = bufferedReader.readLine()) != null) {
				sb.append(line);
			}

			return sb.toString();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	protected void onPostExecute(String result) {
		// TODO Auto-generated method stub
		parser.parseNetworkResponse(result);
	}

	@Override
	protected void onProgressUpdate(Integer... values) {
		// TODO Auto-generated method stub
		// pb_download.setProgress(values[0]);
	}

}
