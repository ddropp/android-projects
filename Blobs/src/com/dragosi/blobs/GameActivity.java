package com.dragosi.blobs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

public class GameActivity extends Activity {

	GameSurface surface;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		
		surface = new GameSurface(this);	
		setContentView(surface);
		
	}

	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		
		if (surface.alertDialog != null)
			surface.alertDialog.dismiss();
		
		getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);	
		finish();
	}
	

	public void registerScore(String name, long score) {
		
		try {
		
			File d = new File(Environment.getExternalStorageDirectory().getPath(),"/Blobs");
			
			if (!d.isDirectory())
				d.mkdir();
			File file = new File(Environment.getExternalStorageDirectory().getPath()+"/Blobs","scores.json");
			
			if (!file.exists())
				file.createNewFile();
			FileReader fileReader = new FileReader(file);
			BufferedReader br = new BufferedReader(fileReader);
			StringBuilder sb = new StringBuilder();
			String s;
			
			while ((s = br.readLine())!=null) {
				sb.append(s);
			}
			br.close();
			fileReader.close();
			
			FileWriter fileWriter = new FileWriter(file,false);
			JSONArray array;
			
			try {
				array = new JSONArray(sb.toString());
			} catch (Exception e) {
				array = new JSONArray();
				e.printStackTrace();
			}
		
			JSONObject object = new JSONObject();
			object.put("Name", name);
			object.put("Score", score);
			
			array.put(object);
			fileWriter.write(array.toString());
			
			fileWriter.close();
			
		} catch (IOException | JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}




}
