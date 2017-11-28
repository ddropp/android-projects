package com.dragosi.blobs;

public class Blob {
	
		public int x,y;
		public int dir;
		public int speed = 2;
		public int color;
		int r=10;

		public Blob(int x, int y) {

			this.color = 1;
			this.x = x;
			this.y = y;
		}
		
		public Blob(int x, int y, int r) {

			this.color = 1;
			this.x = x;
			this.y = y;
			this.r = r;
		}

}
