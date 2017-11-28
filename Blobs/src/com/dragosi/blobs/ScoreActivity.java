package com.dragosi.blobs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ScoreActivity extends ListActivity {

	ArrayList<Score> scores;
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_layout);

		getScores();
		
		MyAdapter adapter = new MyAdapter(this, scores); 
		setListAdapter(adapter); 
	}

	
	
	private void getScores() {
		File file = new File(Environment.getExternalStorageDirectory().getPath()+"/Blobs","scores.json");
		scores = new ArrayList<Score>();
		
		try {
			FileReader fileReader = new FileReader(file);
			
			BufferedReader br = new BufferedReader(fileReader);
			StringBuilder sb = new StringBuilder();
			String s;
			JSONArray array;
			
			while ((s = br.readLine())!=null) {
				sb.append(s);
			}
			br.close();
			fileReader.close();
			
			array = new JSONArray(sb.toString());
		
			for (int i=0; i<array.length(); i++) {
				
				JSONObject object = (JSONObject) array.get(i);
				Score score = new Score(object.getString("Name"),object.getLong("Score"));
				
				scores.add(score);
			}
			
			
			Collections.sort(scores, new Comparator<Score>() {
			    public int compare(Score a,Score b) {
			        return (int)(b.score-a.score);
			    }
			   
			});
			
		} catch (IOException | JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	class MyAdapter extends ArrayAdapter<Score> {

		LayoutInflater layoutInflater;
		public MyAdapter(Context context, ArrayList<Score> scores) {
			super(context, -1, scores);

			layoutInflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		}
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			Score thisScore = getItem(position);

			View thisView;

			if (convertView != null)
				thisView = convertView;
			else
				thisView = layoutInflater.inflate(R.layout.list_item, null);

			TextView name = (TextView) thisView.findViewById(R.id.tvA);
			TextView score = (TextView) thisView
					.findViewById(R.id.tvB);

			name.setText(thisScore.name);
			score.setText(""+thisScore.score);

			return thisView;
		}

	}
	
	class Score {
		public String name;
		public long score;
		
		public Score(String name, long score) {
			this.name = name;
			this.score = score;
		}
	}

}
