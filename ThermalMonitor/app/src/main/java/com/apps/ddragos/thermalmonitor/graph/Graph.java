package com.apps.ddragos.thermalmonitor.graph;

import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.Log;

import java.util.ArrayList;

public class Graph {

    private int screenHeight;
    private ArrayList<PointF> points;
    private ArrayList<PointF> screenPoints;
    private Path path;
    private int size;
    private int maxSize;
    private float unitSize;
    private float yScale = 1f;
    private boolean visible = true;
    private int color = 0x000000;

    private float offsetX;
    private float offsetY;
    private Paint paint;

    public Graph(float unitSize) {
        points = null;
        screenPoints = null;
        path = null;

        points = new ArrayList<>();
        screenPoints = new ArrayList<>();

        this.unitSize = unitSize;
        this.offsetX = 0;
        this.offsetY = 0;
    }

    public Graph(int color, float yScale, float unitSize, int screenHeight,float offsetX, float offsetY) {
        points = null;
        screenPoints = null;
        path = null;

        this.yScale = yScale;
        this.color = color;
        this.unitSize = unitSize;
        this.screenHeight = screenHeight;
        this.offsetX = offsetX;
        this.offsetY = offsetY;

        this.paint = new Paint();
        this.paint.setColor(color);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(5);
        this.paint.setAntiAlias(true);

    }

    public Graph(ArrayList<PointF> points,float unitSize) {

        this.points = points;
        size = points.size();

        this.screenPoints = null;
        this.path = null;
        this.unitSize = unitSize;
    }

    public void addPoint(PointF point) {
        if (points == null)
            this.points = new ArrayList<>();
        points.add(point);
        addScreenPoint();
        addToPath();
//        refreshPath();
    }
    public void removePoint(int position)
    {
        points.remove(position);
    }

    private void addScreenPoint() {
        size = points.size();
        PointF point = new PointF();
        if (screenPoints == null) {
            screenPoints = new ArrayList<>();

            point.x =  offsetX + points.get(0).x*unitSize + Math.abs(points.get(0).x)*unitSize;
            point.y = -offsetY + screenHeight - points.get(0).y*unitSize*yScale;
            screenPoints.add(point);
            Log.d("Point0", point.x + " " + point.y);
        }
        else if (size > 1)
        {
            int i = size - 1;

            point.x = offsetX + screenPoints.get(i-1).x + unitSize;
            point.y = -offsetY + (float)screenHeight - points.get(i).y*unitSize*yScale;

            screenPoints.add(point);

            Log.d("Point",point.x + " " + point.y);
        }


    }

    public ArrayList<PointF> generateScreenPoints(float offsetX, float offsetY) {

        size = points.size();
        screenPoints = new ArrayList<>();

//        float difX = points.get(size - 1).x - points.get(0).x;
//        float xUnitSize = ((screenWidth*scale) / difX);

        screenPoints.set(0, new PointF());
        screenPoints.get(0).x = offsetX + points.get(0).x*unitSize + Math.abs(points.get(0).x)*unitSize;
        screenPoints.get(0).y = -offsetY + screenHeight - points.get(0).y*unitSize*yScale ;

        for (int i = 1; i < size; i++ ) {
            screenPoints.set(i, new PointF());
            screenPoints.get(i).x = offsetX + screenPoints.get(i-1).x + unitSize;
            screenPoints.get(i).y = -offsetY + screenHeight - points.get(i).y*unitSize*yScale ;

        }

        return screenPoints;
    }

    public ArrayList<PointF> generateSin(float min, float max, float unitSize) {


        size = (int)((max-min)/unitSize);
        points = new ArrayList<>();

        PointF point = new PointF(min,(float)Math.sin(min));
        points.add(point);

        for (int i=1; i<size; i++) {
            point = new PointF();
            point.x = points.get(i - 1).x + unitSize;
            point.y = (float) Math.sin(points.get(i).x);
            points.add(point);

            Log.i("Sine", "X: " + points.get(i).x + "   Y: " + points.get(i).y);
        }

        size = points.size();

        return points;
    }

    private void refreshPath() {
        path = new Path();
        path.moveTo(screenPoints.get(0).x,screenPoints.get(0).y);

        for (int i=1; i<size; i++) {
            path.lineTo(screenPoints.get(i).x, screenPoints.get(i).y);
        }
    }

    private void addToPath() {
        if (path==null) {
            path = new Path();
            path.moveTo(screenPoints.get(0).x,screenPoints.get(0).y);
        }
        else
            path.lineTo(screenPoints.get(size-1).x,screenPoints.get(size-1).y);
    }

    public Path getPath() {
        return path;
    }


    public float getYScale() {
        return yScale;
    }

    public void setYScale(float yScale) {
        this.yScale = yScale;
    }
    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
        this.paint.setColor(color);
    }

    public ArrayList getPoints() {
        return points;
    }

    public void setPoints(ArrayList points) {
        this.points = points;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public Paint getPaint() {
        return paint;
    }
}
