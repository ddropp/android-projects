package com.dragosi.blobs;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Vibrator;
import android.support.v4.view.MotionEventCompat;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.WindowManager;
import android.widget.EditText;

public class GameSurface extends SurfaceView implements SurfaceHolder.Callback, SensorEventListener 
{

	private Context context;
	private Boolean firstTouch = false;
	private SurfaceHolder mySurfaceHolder;
	private Paint p;
	private Paint textP;
	private int greenIntensity = 5;

	private SensorManager manager;
	private Sensor sensor;
	private Timer t;
	private MyThread paintThread = null;

	private long score = 0;
	private ArrayList<Blob> blobs;
	private Blob playerBlob;
	private int genTime = 600;
	private int level = 0;
	private Vibrator v;
	private float offsetX = 1;
	private float offsetY = 1;
	int dA,dB;

	public AlertDialog alertDialog = null;

	public GameSurface(Context context) {
		super(context);
		this.context = context;

		mySurfaceHolder = getHolder();
		mySurfaceHolder.addCallback(this);

		manager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
		sensor = manager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		v = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
		
		p = new Paint();
		p.setFlags(Paint.ANTI_ALIAS_FLAG);

		textP = new Paint();
		textP.setTextAlign(Paint.Align.CENTER);
		textP.setTextSkewX((float) -0.1);
		textP.setAntiAlias(true);

	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		playerBlob = new Blob(100, 100,30);		
		blobs = new ArrayList<Blob>();

		paintThread = new MyThread(this,mySurfaceHolder);
		paintThread.isRunning = true;
		paintThread.start();

		manager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_FASTEST);

		t = new Timer();
		t.schedule(new TimerTask() {
			public void run() {
				timerJob();
			}
		}, 1500,genTime);
	}

	public void timerJob() {	
		generateBlob();
		score += new Random().nextInt(10);
		
		if (level<331)
			level++;

		switch (level) {

		case 40: genTime = 450; rescheduleTimer(); break;
		case 80: genTime = 350; rescheduleTimer(); break;	
		case 140: genTime = 260; rescheduleTimer();	break;
		case 230: genTime = 190; rescheduleTimer();	break;	
		case 330: genTime = 150; rescheduleTimer(); break;
		default: break;
		}
	}
	
	public void rescheduleTimer() {
		
	    Log.i("Gen_TIME", ""+genTime); 
		t.cancel();
		t = new Timer();
		t.schedule(new TimerTask() {
			public void run() {
				timerJob();
			}
		}, 0, genTime); 	
	}
	
	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO Auto-generated method stub
		playerBlob.x = getWidth()/2;
		playerBlob.y = getHeight()/2;

		Log.i("Dimensions", ""+getWidth()+" "+getHeight());
		
		offsetX = getWidth()/(float)320;
		offsetY = getHeight()/(float)480;

		playerBlob.r *= (int)offsetX;
		dA = Math.round(offsetY+0.45f);
		dB = 2*Math.round(offsetY+0.45f);
		Log.i("D", ""+dA+" "+dB);
		textP.setTextSize(32*offsetX);
	}


	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		
		manager.unregisterListener(this);
		stopTasks();
		
		blobs.clear();
		blobs = null;		
		score = 0;
		greenIntensity = 0;
	}
	
	private void stopTasks() {
		
		if (t!=null) {
			t.cancel();
		}
		t = null;

		paintThread.isRunning = false;
		boolean retry = true;
		while(retry){
			try {
				paintThread.join();
				retry = false;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void draw(Canvas canvas) {
		// TODO Auto-generated method stub

		canvas.drawColor(Color.parseColor("#ECC8A3"));

		textP.setColor(Color.parseColor("#D6AD99"));		
		canvas.drawText(String.valueOf(score), getWidth()/2, 30*offsetY, textP);

		if (greenIntensity > 210) {
			p.setColor(Color.RED);
			p.setStyle(Style.STROKE);
			p.setStrokeWidth(2);
			canvas.drawCircle(playerBlob.x, playerBlob.y, playerBlob.r+2, p);
			p.setStyle(Style.FILL);
		}

		p.setColor(Color.rgb(255, greenIntensity, 30));
		canvas.drawCircle(playerBlob.x, playerBlob.y, playerBlob.r, p);



		synchronized(blobs) {
			if (!blobs.isEmpty())
				for (Blob blob : blobs) {
					if (blob.color == 1)
						p.setColor(Color.parseColor("#FF9900"));
					else
						p.setColor(Color.parseColor("#FF1919"));

					canvas.drawCircle(blob.x, blob.y, blob.r, p);
				}
		}

	}

	public void update() {

		for (int i=0; i<blobs.size(); i++) {
			Blob blob = blobs.get(i);

			if (blob.x < 0 || blob.x > getWidth() ||
					blob.y < 0 || blob.y > getHeight()) {

				blobs.remove(i);

			} else {
				
				switch (blob.dir) {

				case 0: blob.x+=dA; blob.y-=dA; break;
				case 1: blob.y+=dB; blob.x-=dA; break;
				case 2: blob.x-=dA; blob.y-=dA; break;
				case 3: blob.y-=dB; blob.x-=dA; break;
				}
				
				checkCollision(blob, i);

			}
		}

	}

	public void checkCollision(Blob blob,int pos) {
		
		int dX = playerBlob.x - blob.x;
		int dY = playerBlob.y - blob.y;
		int distanceSquared = dX * dX + dY * dY;

		boolean collision = distanceSquared < (playerBlob.r + blob.r) * (playerBlob.r + blob.r);

		if (collision) {

			blobs.remove(pos);

			if (blob.color == 1)
			{
				v.vibrate(80);
				score -= greenIntensity/5;
				if (greenIntensity<240) {
					greenIntensity+=30;					
					if (score < 0 || greenIntensity > 240)
						onGameLost();
				}
			} else {
				
				//v.vibrate(200);
				if (greenIntensity > 30)
					greenIntensity -= 30;
				score += new Random().nextInt(30);
			}
		}
	}

	private void onGameLost() {
		// TODO Auto-generated method stub
	
		final AlertDialog.Builder alert = new AlertDialog.Builder(context);
		
		alert.setTitle("Game over!")
		     .setMessage("You scored " + score + " points!\n   Enter your name:");
		
		
		((Activity)context).runOnUiThread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				stopTasks();
				
				final EditText name = new EditText(context);
				alert.setView(name)
					 .setPositiveButton("OK", new DialogInterface.OnClickListener() {
	
							public void onClick(DialogInterface dialog, int which) {
										
								String nameTag = name.getText().toString();
								alertDialog.dismiss();	
								
								((GameActivity)context).registerScore(nameTag,score);
								((Activity)context).finish();
							}
						});
				alertDialog = alert.create();
				alertDialog.show();	
			}
		});
	}


	@Override
	public boolean onTouchEvent(MotionEvent event){ 

		int action = MotionEventCompat.getActionMasked(event);
		float mX, mY;

		mX = event.getX();
		mY = event.getY();


		switch(action) {
		case (MotionEvent.ACTION_DOWN) :

			if (mX > playerBlob.x-playerBlob.r && mX < playerBlob.x+playerBlob.r &&
					mY > playerBlob.y-playerBlob.r && mY < playerBlob.y+playerBlob.r) 
			{
				firstTouch = true;
			}

		return true;
		case (MotionEvent.ACTION_MOVE) :
			if (firstTouch)
				if (mX-playerBlob.r > 0 && mX+playerBlob.r < getWidth() &&
						mY-playerBlob.r > 0 && mY+playerBlob.r < getHeight())
				{
					playerBlob.x = (int) mX;
					playerBlob.y = (int) mY;
				} else 
				{
					playerBlob.x = (int) mX - 1;
					playerBlob.y = (int) mY - 1;
				}

		return true;
		case (MotionEvent.ACTION_UP) :
			firstTouch = false;
		return true;
		case (MotionEvent.ACTION_CANCEL) :
			return true;
		case (MotionEvent.ACTION_OUTSIDE) :
			return true;      
		default : 
			return super.onTouchEvent(event);
		}      
	}

	public void generateBlob() {
		Random r = new Random();
		int from = r.nextInt(4);
		int x,y;
		Blob b = null;

		switch (from) {
		case 0:  x = 0; y = r.nextInt(getHeight()); 
				 b = new Blob(x,y);
				 b.dir = 0;  break;
		case 1:  x = r.nextInt(getWidth()); y = 0; 
				 b = new Blob(x,y);
				 b.dir = 1; break;
		case 2:  x = getWidth(); y = r.nextInt(getHeight()); 
				 b = new Blob(x,y);
				 b.dir = 2; break;
		case 3:  x = r.nextInt(getWidth()); y = getHeight(); 
				 b = new Blob(x,y);
				 b.dir = 3; break;
		}
		b.r *= (int)offsetX;
		if (r.nextInt(6) == 5)
			b.color = 2;

		synchronized(blobs) {
			blobs.add(b);
		}
	}

	@Override
	public void onSensorChanged(SensorEvent event) {
		// TODO Auto-generated method stub

		final float alpha = 1.0f;
		float gravity[] = {0,0};
		float acceleration[] = new float[2];;

		gravity[0] = alpha * gravity[0] + (1 - alpha) * event.values[0];
		gravity[1] = alpha * gravity[1] + (1 - alpha) * event.values[1];

		acceleration[0] = event.values[0] - gravity[0];
		acceleration[1] = event.values[1] - gravity[1];


		int newX = (int) (playerBlob.x - (int)(acceleration[0]*offsetX));
		int newY = (int) (playerBlob.y + (int)(acceleration[1]*offsetY));

		if (newX-playerBlob.r >= 0 && newX+playerBlob.r <= getWidth() &&
				newY-playerBlob.r >= 0	&& newY+playerBlob.r <= getHeight())
		{
			playerBlob.x = newX;
			playerBlob.y = newY;
		}

	}
	
	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub

	}

}
