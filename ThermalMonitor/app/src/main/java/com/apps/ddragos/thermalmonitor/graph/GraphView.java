package com.apps.ddragos.thermalmonitor.graph;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.preference.PreferenceManager;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.HorizontalScrollView;

import com.apps.ddragos.thermalmonitor.MC1X.MC1XData;
import com.apps.ddragos.thermalmonitor.R;

import java.util.HashMap;
import java.util.Map;

public class GraphView extends View {

    Paint axisPaint;
    Paint graphPaint;
    Paint textPaint;
    Paint gridPaint;
    Graph graph;

    int frequency = 2;
    float scale = 1f;
    int yOffset = 30;
    int startTime = 0;
    int endTime = 300;
    float currentTime = 0;
    float scaler;
    static final int ST_DPI = 445;
    Context context;
    DisplayMetrics metrics;

    HashMap<String,Graph> graphMap;

    public GraphView(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public GraphView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    public GraphView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init();
    }


    private void initDummyGraph() {
        int dTime = startTime - endTime;
        float unitSize = getWidth() / (dTime*frequency);
        int color = 0x000000;

        graph = new Graph(color,scale,unitSize,getHeight(),0,yOffset);
        graph.generateSin((float) (-4 * Math.PI), (float) (4 * Math.PI), 0.1f);

    }
    private void init() {
        initPaint();
        metrics = new DisplayMetrics();

    }

    private void initGraphs() {
        int dTime = endTime - startTime;
        float unitSize = (float)getWidth() / (dTime*frequency);
        int height = getHeight();
        int color = 0x000000;
        graphMap = new HashMap<>();

        graphMap.put("dhwFlow", new Graph(color, scale, unitSize, height, 0, yOffset));
        graphMap.put("extTemp", new Graph(color, scale, unitSize, height, 0, yOffset));
        graphMap.put("chSetTemp", new Graph(color, scale, unitSize, height, 0, yOffset));
        graphMap.put("chFlowTemp", new Graph(color, scale, unitSize, height, 0, yOffset));
        graphMap.put("chReturnTemp", new Graph(color, scale, unitSize, height, 0, yOffset));
        graphMap.put("dhwSetTemp", new Graph(color, scale, unitSize, height, 0, yOffset));
        graphMap.put("dhwTemp", new Graph(color, scale, unitSize, height, 0, yOffset));

        graphMap.put("tankS1Temp", new Graph(color, scale, unitSize, height, 0, yOffset));
        graphMap.put("tankS2Temp", new Graph(color, scale, unitSize, height, 0, yOffset));
        graphMap.put("exhaustTemp", new Graph(color, scale, unitSize, height, 0, yOffset));
        graphMap.put("fanPwm", new Graph(color, scale / 10, unitSize, height, 0, yOffset));
        graphMap.put("fanRpm", new Graph(color, scale / 10, unitSize, height, 0, yOffset));
        graphMap.put("chPressure", new Graph(color, scale, unitSize, height, 0, yOffset));
        graphMap.put("ionVoltage", new Graph(color, scale * 10, unitSize, height, 0, yOffset));

        setColors();
        setGraphsPreferences(PreferenceManager.getDefaultSharedPreferences(getContext()));

        for (HashMap.Entry<String,Graph> graph : graphMap.entrySet()) {
            graph.getValue().getPaint().setStrokeWidth(5*scaler);
        }
    }

    private void drawAxis(Canvas canvas) {
        int totalUnits = (endTime-startTime)/10 + 1;
        float unit = (float)getWidth()/(totalUnits - 1);

        for(int i=1; i<totalUnits; i++) {
            canvas.drawLine(i * unit, getHeight() - yOffset + 20*scaler, i * unit, getHeight() - yOffset, axisPaint);
            canvas.drawText(String.valueOf(i*10),i*unit + 5, getHeight() - yOffset + 25,textPaint);

            //grid x
            canvas.drawLine(i*unit, getHeight() - yOffset, i*unit, 0, gridPaint);
        }
        canvas.drawLine(0, getHeight() - yOffset, getWidth(), getHeight() - yOffset, axisPaint);

        int yUnits = YView.yUnits;
        unit = (getHeight() - yOffset)/(yUnits - 1);
        for(int i=0; i<yUnits; i++) {
            canvas.drawLine(0, getHeight() - (yOffset + i * unit), getWidth(), getHeight() - (yOffset + i * unit), gridPaint);
        }

    }

    private void initPaint() {
        DisplayMetrics metrics = new DisplayMetrics();
        ((Activity)context).getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int screenDensity = metrics.densityDpi;
        scaler = (float)screenDensity/ST_DPI;

        axisPaint = new Paint();
        axisPaint.setStyle(Paint.Style.STROKE);
        axisPaint.setStrokeWidth(3);
        axisPaint.setColor(Color.BLACK);

        graphPaint = new Paint();
        graphPaint.setStyle(Paint.Style.STROKE);
        graphPaint.setStrokeWidth(6*scaler);
        graphPaint.setColor(Color.BLUE);
        graphPaint.setAntiAlias(true);

        textPaint = new Paint();
        textPaint.setTextSize(28*scaler);
        textPaint.setColor(Color.BLACK);
        textPaint.setStyle(Paint.Style.FILL);

        gridPaint = new Paint();
        gridPaint.setColor(Color.LTGRAY);
        gridPaint.setStyle(Paint.Style.STROKE);

    }

    @Override
    public void onDraw(Canvas canvas) {

        if (!this.isInEditMode()) {
            drawAxis(canvas);
            if (graphMap == null)
                initGraphs();
            else
            {
                Graph graph;
                float yLabel = 15f;
                float xLabel = 15f;
                float stepLabel = 25f*scaler;

                graph = graphMap.get("dhwFlow");
                if (graph.getPath() != null && graph.isVisible()) {
                    canvas.drawPath(graph.getPath(), graph.getPaint());
                    textPaint.setColor(graph.getColor());
                    yLabel += stepLabel;
                    canvas.drawText("DHW Flow(L/min) x " + graph.getYScale(), xLabel, yLabel,textPaint);
                }
                graph = graphMap.get("chFlowTemp");
                if (graph.getPath() != null && graph.isVisible()) {
                    canvas.drawPath(graph.getPath(), graph.getPaint());
                    textPaint.setColor(graph.getColor());
                    yLabel += stepLabel;
                    canvas.drawText("CH Flow Temperature(C) x " + graph.getYScale(), xLabel, yLabel,textPaint);
                }
                graph = graphMap.get("chReturnTemp");
                if (graph.getPath() != null && graph.isVisible()) {
                    canvas.drawPath(graph.getPath(), graph.getPaint());
                    textPaint.setColor(graph.getColor());
                    yLabel += stepLabel;
                    canvas.drawText("CH Return Temperature(C) x " + graph.getYScale(), xLabel, yLabel,textPaint);
                }
                graph = graphMap.get("tankS1Temp");
                if (graph.getPath() != null && graph.isVisible()) {
                    canvas.drawPath(graph.getPath(), graph.getPaint());
                    textPaint.setColor(graph.getColor());
                    yLabel += stepLabel;
                    canvas.drawText("Tank S1 Temperature(C) x " + graph.getYScale(), xLabel, yLabel,textPaint);
                }
                graph = graphMap.get("tankS2Temp");
                if (graph.getPath() != null && graph.isVisible()) {
                    canvas.drawPath(graph.getPath(), graph.getPaint());
                    textPaint.setColor(graph.getColor());
                    yLabel += stepLabel;
                    canvas.drawText("Tank S2 Temperature(C) x " + graph.getYScale(), xLabel, yLabel,textPaint);
                }
                graph = graphMap.get("chPressure");
                if (graph.getPath() != null && graph.isVisible()) {
                    canvas.drawPath(graph.getPath(), graph.getPaint());
                    textPaint.setColor(graph.getColor());
                    yLabel += stepLabel;
                    canvas.drawText("CH Pressure(bar) x " + graph.getYScale(), xLabel, yLabel,textPaint);
                }
                graph = graphMap.get("dhwTemp");
                if (graph.getPath() != null && graph.isVisible()) {
                    canvas.drawPath(graph.getPath(), graph.getPaint());
                    textPaint.setColor(graph.getColor());
                    yLabel += stepLabel;
                    canvas.drawText("DHW Temperature(C) x " + graph.getYScale(), xLabel, yLabel,textPaint);
                }
                graph = graphMap.get("exhaustTemp");
                if (graph.getPath() != null && graph.isVisible()) {
                    canvas.drawPath(graph.getPath(), graph.getPaint());
                    textPaint.setColor(graph.getColor());
                    yLabel += stepLabel;
                    canvas.drawText("Exhaust Temperature(C) x " + graph.getYScale(), xLabel, yLabel,textPaint);
                }
                graph = graphMap.get("fanPwm");
                if (graph.getPath() != null && graph.isVisible()) {
                    canvas.drawPath(graph.getPath(), graph.getPaint());
                    textPaint.setColor(graph.getColor());
                    yLabel += stepLabel;
                    canvas.drawText("Fan PWM x " + graph.getYScale(), xLabel, yLabel, textPaint);
                }
                graph = graphMap.get("fanRpm");
                if (graph.getPath() != null && graph.isVisible()) {
                    canvas.drawPath(graph.getPath(), graph.getPaint());
                    textPaint.setColor(graph.getColor());
                    yLabel += stepLabel;
                    canvas.drawText("Fan RPM x " + graph.getYScale(), xLabel, yLabel,textPaint);
                }
                graph = graphMap.get("ionVoltage");
                if (graph.getPath() != null && graph.isVisible()) {
                    canvas.drawPath(graph.getPath(), graph.getPaint());
                    textPaint.setColor(graph.getColor());
                    yLabel += stepLabel;
                    canvas.drawText("Ionization Voltage(VDC) x " + graph.getYScale(), xLabel, yLabel,textPaint);
                }
                graph = graphMap.get("dhwSetTemp");
                if (graph.getPath() != null && graph.isVisible()) {
                    canvas.drawPath(graph.getPath(), graph.getPaint());
                    textPaint.setColor(graph.getColor());
                    yLabel += stepLabel;
                    canvas.drawText("DHW Set Temperature(C) x " + graph.getYScale(), xLabel, yLabel,textPaint);
                }
                graph = graphMap.get("chSetTemp");
                if (graph.getPath() != null && graph.isVisible()) {
                    canvas.drawPath(graph.getPath(), graph.getPaint());
                    textPaint.setColor(graph.getColor());
                    yLabel += stepLabel;
                    canvas.drawText("CH Set Temperature(C) x " + graph.getYScale(), xLabel, yLabel,textPaint);
                }

                textPaint.setColor(Color.BLACK);
            }

        }

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        int width = 3000;
        int height = MeasureSpec.getSize(heightMeasureSpec);

        WindowManager wm = (WindowManager) this.getContext().getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        display.getMetrics(metrics);

        setMeasuredDimension(2 * metrics.widthPixels, height);
    }

    public void updateGraphs(MC1XData mc1XData) {
        graphMap.get("dhwFlow").addPoint(new PointF(currentTime, (float) mc1XData.GetQValFlowDHW()));
        graphMap.get("extTemp").addPoint(new PointF(currentTime, (float) mc1XData.GetQValTemperatureExterior()));
        graphMap.get("chFlowTemp").addPoint(new PointF(currentTime, (float) mc1XData.GetQValTemperatureCHFlow()));
        graphMap.get("chReturnTemp").addPoint(new PointF(currentTime, (float) mc1XData.GetQValTemperatureCHRetur()));
        graphMap.get("dhwTemp").addPoint(new PointF(currentTime, (float) mc1XData.GetQValTemperatureDHW()));
        graphMap.get("tankS1Temp").addPoint(new PointF(currentTime, (float) mc1XData.GetQValTemperatureWaterTankS1()));
        graphMap.get("tankS2Temp").addPoint(new PointF(currentTime, (float) mc1XData.GetQValTemperatureWaterTankS2()));
        graphMap.get("exhaustTemp").addPoint(new PointF(currentTime, (float) mc1XData.GetQValTemperatureExhaust()));
        graphMap.get("fanPwm").addPoint(new PointF(currentTime, (float) mc1XData.GetMCFanSetPwm()));
        graphMap.get("fanRpm").addPoint(new PointF(currentTime, (float) mc1XData.GetMFFanSpeed()));
        graphMap.get("chPressure").addPoint(new PointF(currentTime, (float) mc1XData.GetQValPresureCH()));
        graphMap.get("ionVoltage").addPoint(new PointF(currentTime, (float) mc1XData.GetMFFlameIonisationVoltage()));

        if( mc1XData.GetRequestInstal() == 0 ) // nu exista cerere
        {
            graphMap.get("chSetTemp").addPoint(new PointF(currentTime, (float) mc1XData.GetUserSettingsTemperatureCHSet()));
            graphMap.get("dhwSetTemp").addPoint(new PointF(currentTime, (float) mc1XData.GetUserSettingsTemperatureDHWSet()));
        }
        if( mc1XData.GetRequestInstal() == 1 ) // cerere pentru instalatia de ACM
        {
            graphMap.get("chSetTemp").addPoint(new PointF(currentTime, (float) mc1XData.GetUserSettingsTemperatureCHSet()));
            graphMap.get("dhwSetTemp").addPoint(new PointF(currentTime, (float) mc1XData.GetRequestModSetTemp()));
        }
        if( mc1XData.GetRequestInstal() == 2 ) // cerere pentru instalatia de AT, incalzire
        {
            graphMap.get("chSetTemp").addPoint(new PointF(currentTime, (float) mc1XData.GetRequestModSetTemp()));
            graphMap.get("dhwSetTemp").addPoint(new PointF(currentTime, (float) mc1XData.GetUserSettingsTemperatureDHWSet()));
        }

        currentTime += 1/frequency;
        invalidate();
    }

    public void setGraphsPreferences(SharedPreferences preferences) {
        setGraphsColors(preferences);
        setGraphsScale(preferences);
        setGraphsVisibility(preferences);
    }

    public void setColors() {
        graphMap.get("dhwFlow").setColor(Color.BLUE);
        graphMap.get("extTemp").setColor(Color.CYAN);
        graphMap.get("chFlowTemp").setColor(Color.GREEN);
        graphMap.get("chReturnTemp").setColor(Color.MAGENTA);
        graphMap.get("dhwTemp").setColor(Color.RED);
        graphMap.get("tankS1Temp").setColor(Color.YELLOW);
        graphMap.get("tankS2Temp").setColor(Color.BLACK);
        graphMap.get("exhaustTemp").setColor(Color.DKGRAY);
        graphMap.get("fanPwm").setColor(Color.BLACK);
        graphMap.get("fanRpm").setColor(Color.BLACK);
        graphMap.get("chPressure").setColor(Color.GREEN);
        graphMap.get("ionVoltage").setColor(Color.YELLOW);
        graphMap.get("chSetTemp").setColor(Color.RED);
        graphMap.get("dhwSetTemp").setColor(Color.MAGENTA);
    }


    private void setGraphsColors(SharedPreferences preferences) {
        Resources resources = getResources();
        String defaultColor = "0000FF";
        try {

            String currentPref = preferences.getString(resources.getString(R.string.pref_key_dhwFlow_color),defaultColor);
            int alpha = 0xFF<<24;
            int currentColor = Integer.parseInt(currentPref,16) | alpha;
            graphMap.get("dhwFlow").setColor(currentColor);
            currentPref = preferences.getString(resources.getString(R.string.pref_key_extTemp_color), defaultColor);
            currentColor = Integer.parseInt(currentPref,16) | alpha;
            graphMap.get("extTemp").setColor(currentColor);
            currentPref = preferences.getString(resources.getString(R.string.pref_key_chFlowTemp_color), defaultColor);
            currentColor = Integer.parseInt(currentPref,16) | alpha;
            graphMap.get("chFlowTemp").setColor(currentColor);
            currentPref = preferences.getString(resources.getString(R.string.pref_key_chReturnTemp_color), defaultColor);
            currentColor = Integer.parseInt(currentPref,16) | alpha;
            graphMap.get("chReturnTemp").setColor(currentColor);
            currentPref = preferences.getString(resources.getString(R.string.pref_key_dhwTemp_color), defaultColor);
            currentColor = Integer.parseInt(currentPref,16) | alpha;
            graphMap.get("dhwTemp").setColor(currentColor);
            currentPref = preferences.getString(resources.getString(R.string.pref_key_tankS1Temp_color), defaultColor);
            currentColor = Integer.parseInt(currentPref,16) | alpha;
            graphMap.get("tankS1Temp").setColor(currentColor);
            currentPref = preferences.getString(resources.getString(R.string.pref_key_tankS2Temp_color), defaultColor);
            currentColor = Integer.parseInt(currentPref,16) | alpha;
            graphMap.get("tankS2Temp").setColor(currentColor);
            currentPref = preferences.getString(resources.getString(R.string.pref_key_exhaustTemp_color), defaultColor);
            currentColor = Integer.parseInt(currentPref,16) | alpha;
            graphMap.get("exhaustTemp").setColor(currentColor);
            currentPref = preferences.getString(resources.getString(R.string.pref_key_fanPwm_color), defaultColor);
            currentColor = Integer.parseInt(currentPref,16) | alpha;
            graphMap.get("fanPwm").setColor(currentColor);
            currentPref = preferences.getString(resources.getString(R.string.pref_key_fanRpm_color), defaultColor);
            currentColor = Integer.parseInt(currentPref,16) | alpha;
            graphMap.get("fanRpm").setColor(currentColor);
            currentPref = preferences.getString(resources.getString(R.string.pref_key_chPressure_color), defaultColor);
            currentColor = Integer.parseInt(currentPref,16) | alpha;
            graphMap.get("chPressure").setColor(currentColor);
            currentPref = preferences.getString(resources.getString(R.string.pref_key_ionVoltage_color), defaultColor);
            currentColor = Integer.parseInt(currentPref,16) | alpha;
            graphMap.get("ionVoltage").setColor(currentColor);
            currentPref = preferences.getString(resources.getString(R.string.pref_key_chSetTemp_color), defaultColor);
            currentColor = Integer.parseInt(currentPref,16) | alpha;
            graphMap.get("chSetTemp").setColor(currentColor);
            currentPref = preferences.getString(resources.getString(R.string.pref_key_dhwSetTemp_color), defaultColor);
            currentColor = Integer.parseInt(currentPref,16) | alpha;
            graphMap.get("dhwSetTemp").setColor(currentColor);
        } catch (NumberFormatException | Resources.NotFoundException e) {
            e.printStackTrace();
        }
    }

    private void setGraphsScale(SharedPreferences preferences) {
        Resources resources = getResources();
        String defaultScale = "1";
//        try {
            String currentScale = preferences.getString(resources.getString(R.string.pref_key_dhwFlow_scale), defaultScale);
            graphMap.get("dhwFlow").setYScale(Float.parseFloat(currentScale));
            currentScale = preferences.getString(resources.getString(R.string.pref_key_extTemp_scale), defaultScale);
            graphMap.get("extTemp").setYScale(Float.parseFloat(currentScale));
            currentScale = preferences.getString(resources.getString(R.string.pref_key_chFlowTemp_scale), defaultScale);
            graphMap.get("chFlowTemp").setYScale(Float.parseFloat(currentScale));
            currentScale = preferences.getString(resources.getString(R.string.pref_key_chReturnTemp_scale), defaultScale);
            graphMap.get("chReturnTemp").setYScale(Float.parseFloat(currentScale));
            currentScale = preferences.getString(resources.getString(R.string.pref_key_dhwTemp_scale), defaultScale);
            graphMap.get("dhwTemp").setYScale(Float.parseFloat(currentScale));
            currentScale = preferences.getString(resources.getString(R.string.pref_key_tankS1Temp_scale), defaultScale);
            graphMap.get("tankS1Temp").setYScale(Float.parseFloat(currentScale));
            currentScale = preferences.getString(resources.getString(R.string.pref_key_tankS2Temp_scale), defaultScale);
            graphMap.get("tankS2Temp").setYScale(Float.parseFloat(currentScale));
            currentScale = preferences.getString(resources.getString(R.string.pref_key_exhaustTemp_scale), defaultScale);
            graphMap.get("exhaustTemp").setYScale(Float.parseFloat(currentScale));
            currentScale = preferences.getString(resources.getString(R.string.pref_key_fanPwm_scale), defaultScale);
            graphMap.get("fanPwm").setYScale(Float.parseFloat(currentScale));
            currentScale = preferences.getString(resources.getString(R.string.pref_key_fanRpm_scale), defaultScale);
            graphMap.get("fanRpm").setYScale(Float.parseFloat(currentScale));
            currentScale = preferences.getString(resources.getString(R.string.pref_key_chPressure_scale), defaultScale);
            graphMap.get("chPressure").setYScale(Float.parseFloat(currentScale));
            currentScale = preferences.getString(resources.getString(R.string.pref_key_ionVoltage_scale), defaultScale);
            graphMap.get("ionVoltage").setYScale(Float.parseFloat(currentScale));
            currentScale = preferences.getString(resources.getString(R.string.pref_key_chSetTemp_scale), defaultScale);
            graphMap.get("chSetTemp").setYScale(Float.parseFloat(currentScale));
            currentScale = preferences.getString(resources.getString(R.string.pref_key_dhwSetTemp_scale), defaultScale);
            graphMap.get("dhwSetTemp").setYScale(Float.parseFloat(currentScale));
      /*  } catch (Resources.NotFoundException | NumberFormatException e) {
            e.printStackTrace();
        }*/
    }

    private void setGraphsVisibility(SharedPreferences preferences) {
        Resources resources = getResources();
        boolean currentBool = preferences.getBoolean(resources.getString(R.string.pref_key_dhwFlow_vis), true);
        graphMap.get("dhwFlow").setVisible(currentBool);
        currentBool = preferences.getBoolean(resources.getString(R.string.pref_key_extTemp_vis), true);
        graphMap.get("extTemp").setVisible(currentBool);
        currentBool = preferences.getBoolean(resources.getString(R.string.pref_key_chFlowTemp_vis), true);
        graphMap.get("chFlowTemp").setVisible(currentBool);
        currentBool = preferences.getBoolean(resources.getString(R.string.pref_key_chReturnTemp_vis), true);
        graphMap.get("chReturnTemp").setVisible(currentBool);
        currentBool = preferences.getBoolean(resources.getString(R.string.pref_key_dhwTemp_vis), true);
        graphMap.get("dhwTemp").setVisible(currentBool);
        currentBool = preferences.getBoolean(resources.getString(R.string.pref_key_tankS1Temp_vis), true);
        graphMap.get("tankS1Temp").setVisible(currentBool);
        currentBool = preferences.getBoolean(resources.getString(R.string.pref_key_tankS2Temp_vis), true);
        graphMap.get("tankS2Temp").setVisible(currentBool);
        currentBool = preferences.getBoolean(resources.getString(R.string.pref_key_exhaustTemp_vis), true);
        graphMap.get("exhaustTemp").setVisible(currentBool);
        currentBool = preferences.getBoolean(resources.getString(R.string.pref_key_fanPwm_vis), true);
        graphMap.get("fanPwm").setVisible(currentBool);
        currentBool = preferences.getBoolean(resources.getString(R.string.pref_key_fanRpm_vis), true);
        graphMap.get("fanRpm").setVisible(currentBool);
        currentBool = preferences.getBoolean(resources.getString(R.string.pref_key_chPressure_vis), true);
        graphMap.get("chPressure").setVisible(currentBool);
        currentBool = preferences.getBoolean(resources.getString(R.string.pref_key_ionVoltage_vis), true);
        graphMap.get("ionVoltage").setVisible(currentBool);
        currentBool = preferences.getBoolean(resources.getString(R.string.pref_key_chSetTemp_vis), true);
        graphMap.get("chSetTemp").setVisible(currentBool);
        currentBool = preferences.getBoolean(resources.getString(R.string.pref_key_dhwSetTemp_vis), true);
        graphMap.get("dhwSetTemp").setVisible(currentBool);
    }



/*  private Path getGraphPath() {
        	Path sinPath = new Path();


            float xScreen, yScreen;


            float xUnitSize = (float) (getWidth()/ (4*Math.PI));
            float yUnitSize = getHeight()/2 ;

            xScreen = xValues[0]*xUnitSize + Math.abs(xValues[0])*xUnitSize;
            yScreen = getHeight()/2 - sinValues[0]*xUnitSize ;

            sinPath.moveTo(xScreen, yScreen);

            for (int i = 1; i < size; i++ ) {

            	xValues[i] = (float) (xValues[i-1]+0.1);
            	sinValues[i] = (float) Math.sin(xValues[i]);


            	xScreen = xValues[i]*xUnitSize + Math.abs(xValues[0])*xUnitSize;
                yScreen = getHeight()/2 - sinValues[i]*xUnitSize ;

                System.out.println("x: " + xValues[i]+ "   y:" + sinValues[i] +
                					"   screenX: " + xScreen + "  screenY: " + yScreen);
                sinPath.lineTo(xScreen, yScreen);

            }

            return sinPath;
		}
*/

}
