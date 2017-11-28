package com.dragosi.blobs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;

public class MenuActivity extends Activity implements OnClickListener {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.menu_activity);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
	
		int id = v.getId();
		
		switch (id) {
			case R.id.button1:
				Intent i =  new Intent(getBaseContext(), GameActivity.class);
				startActivity(i);
				Log.i("start", "start pressed");
				break;
			case R.id.button2:  
				Intent iS = new Intent(getBaseContext(), ScoreActivity.class);
				startActivity(iS);
				break;
			case R.id.button3:
				finish(); break;
			default:break;
		}
	}
}
