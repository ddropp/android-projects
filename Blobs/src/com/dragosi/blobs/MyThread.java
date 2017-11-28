package com.dragosi.blobs;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class MyThread extends Thread implements Runnable {
	
	private GameSurface mySurface;
	private SurfaceHolder mySurfaceHolder;
	
	public boolean isRunning = false;
	final private int fps = 60;
	
	public MyThread(GameSurface mySurface,SurfaceHolder mySurfaceHolder) {
		super();	
		
		this.mySurface = mySurface;
		this.mySurfaceHolder = mySurfaceHolder;
	}
	

	@Override
	public void run() {
		Canvas c = null;

		while (isRunning) {
			if(mySurfaceHolder.getSurface().isValid()) {

				long timeStart = System.currentTimeMillis(); 

				try { 
					c = mySurfaceHolder.lockCanvas(null);                                 
					synchronized(mySurfaceHolder) {

						mySurface.draw(c);
						mySurface.update();
					}
				} finally {
					if (c!=null)
						mySurfaceHolder.unlockCanvasAndPost(c);                      
				}

				long timeEnd = System.currentTimeMillis();                               
				long frameTime = timeEnd-timeStart;                                     
				long sleepTime = (int) ((1000/fps)-frameTime);                            

				if (sleepTime>0){                                                   
					try {
						Thread.sleep(sleepTime);                                 
					} catch (InterruptedException e) {}                             
				}                                              
			}

		}
	}


}

	
	
	

