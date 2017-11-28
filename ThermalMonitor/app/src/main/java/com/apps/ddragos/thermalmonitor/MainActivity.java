package com.apps.ddragos.thermalmonitor;


import android.app.FragmentTransaction;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.apps.ddragos.thermalmonitor.MC1X.MC1XData;
import com.apps.ddragos.thermalmonitor.MC1X.MC1XPackProcesser;
import com.apps.ddragos.thermalmonitor.fragments.SlidingTabsFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Timer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.apps.ddragos.thermalmonitor.constants.ConstsBTConnection.BT_MSG_TAG;
import static com.apps.ddragos.thermalmonitor.constants.ConstsBTConnection.CONNECTED;
import static com.apps.ddragos.thermalmonitor.constants.ConstsBTConnection.DISCONNECTED;
import static com.apps.ddragos.thermalmonitor.constants.ConstsBTConnection.MESSAGE_RECEIVED;
import static com.apps.ddragos.thermalmonitor.constants.ConstsBTConnection.PACK_DATA_RDY;
import static com.apps.ddragos.thermalmonitor.constants.ConstsBTConnection.QUEUE_DATA_RDY;
import static com.apps.ddragos.thermalmonitor.constants.ConstsBTConnection.REQUEST_PREFS;
import static com.apps.ddragos.thermalmonitor.constants.ConstsBTConnection.REQUEST_ENABLE_BT;
import static com.apps.ddragos.thermalmonitor.constants.ConstsBTConnection.PREFS_CHANGED;

public class MainActivity extends FragmentActivity {


    private BluetoothThread btThread;
    private Handler handler;
    private Timer timer;
    private ExecutorService executor;
    private MC1XData mc1XData;
    private MC1XPackProcesser packProcesser;
    private boolean timerStarted = false;

    //UI
    private Spinner spinner;
    private TextView statusTv;
    private Button devicesBtn;
    private Button disconnectBtn;
    private Button connectBtn;
    private PowerManager.WakeLock mWakeLock;
    private SlidingTabsFragment fragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {

            fragment = new SlidingTabsFragment();
//            fragment.setRetainInstance(true);
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.tabs_fragment, fragment)
                    .commit();
        }

        handler = new BTHandler(Looper.myLooper());
        setupUI();

        PreferenceManager.setDefaultValues(this, R.xml.preferences, false);

        //keep screen on
        final PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
        this.mWakeLock = pm.newWakeLock(PowerManager.SCREEN_DIM_WAKE_LOCK, "My Tag");
        this.mWakeLock.acquire();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (fragment == null)
        {
            fragment = new SlidingTabsFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.tabs_fragment, fragment)
                    .commit();
        }

    }

    private void setupUI() {
        spinner = (Spinner) findViewById(R.id.spinner);
        statusTv = (TextView) findViewById(R.id.statusTv);
        devicesBtn = (Button) findViewById(R.id.devicesBtn);
        disconnectBtn = (Button) findViewById(R.id.disconnectBtn);
        connectBtn = (Button) findViewById(R.id.connectBtn);

        setListeners();
    }

    private void setListeners() {
        devicesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("", "CONNECT");
                refreshDeviceList();
            }
        });

        disconnectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btThread != null && btThread.isAlive()) {
                    btThread.cancel();
//                    v.setEnabled(false);
                    statusTv.setVisibility(View.GONE);

                    disconnectBtn.setEnabled(false);
                    connectBtn.setEnabled(true);
                }
            }
        });
    }

    private void refreshDeviceList() {
        ArrayAdapter<String> mArrayAdapter = new ArrayAdapter<>(this, R.layout.device_item);
        final BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        if (mBluetoothAdapter == null) {
            Toast.makeText(this, "Bluetooth is not supported on this device.", Toast.LENGTH_LONG).show();
        } else {

            try {
                if (!mBluetoothAdapter.isEnabled()) {
                    Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    startActivityForResult(intent, REQUEST_ENABLE_BT);
                }

                final List<BluetoothDevice> pairedDevices = new ArrayList<>(mBluetoothAdapter.getBondedDevices());

                if (pairedDevices.size() > 0) {

                    for (BluetoothDevice device : pairedDevices) {
                        mArrayAdapter.add(device.getName() + "\n" + device.getAddress());
                    }

                    spinner.setAdapter(mArrayAdapter);
                    spinner.setVisibility(View.VISIBLE);

                    connectBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mBluetoothAdapter.cancelDiscovery();
                            if (btThread == null || !btThread.isAlive()) {
                                int position = spinner.getSelectedItemPosition();
                                btThread = new BluetoothThread(getApplicationContext(), pairedDevices.get(position), handler);
                                btThread.start();
                            } else
                                Toast.makeText(getApplicationContext(), "Already connected", Toast.LENGTH_SHORT).show();
                        }
                    });
                } else
                    spinner.setVisibility(View.GONE);

            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

            switch (requestCode) {
                case REQUEST_ENABLE_BT:
                    if (resultCode == RESULT_OK) {
                        Log.i(BT_MSG_TAG, "Bluetooth enabled!");
                        refreshDeviceList();
                    }
                    break;
                case REQUEST_PREFS:
                    if (resultCode == PREFS_CHANGED) {
                        if (fragment != null) {
                            fragment.updatePreferences();
                        }
                    }
                    break;
            }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Log.d("Settings", "Pressed!");

            Intent intent = new Intent(this,SettingsFragment.class);
            startActivityForResult(intent, REQUEST_PREFS);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private class BTHandler extends Handler {

        public BTHandler(Looper looper) {
            super(looper);
        }

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case CONNECTED:
                    BluetoothDevice device = (BluetoothDevice) msg.obj;
                    Toast.makeText(getApplicationContext(), "Connected to " + device.getName(), Toast.LENGTH_SHORT).show();
                    statusTv.setText("Connected to " + device.getName());
                    statusTv.setVisibility(View.VISIBLE);

                    if (mc1XData == null)
                        mc1XData = new MC1XData();
                    if (packProcesser == null)
                        packProcesser = new MC1XPackProcesser(mc1XData,handler);

                    disconnectBtn.setEnabled(true);
                    connectBtn.setEnabled(false);
                    executor = Executors.newFixedThreadPool(1);
                    break;
                case MESSAGE_RECEIVED:
                    break;
                case DISCONNECTED:
                    disconnectBtn.setEnabled(false);
                    connectBtn.setEnabled(true);
                    Toast.makeText(getApplicationContext(), "Disconnected from " + ((BluetoothDevice) msg.obj).getName(), Toast.LENGTH_SHORT).show();
                    statusTv.setVisibility(View.GONE);

                    /*if (timerStarted) {
                        timer.cancel();
                        timerStarted = false;
                        timerBtn.setEnabled(false);
                        timerBtn.setText("Timer");
                    }*/
                    break;
                case QUEUE_DATA_RDY:

                    Queue<String> queue = StreamParser.queue;
                    String data = null;

                    synchronized (StreamParser.lock) {
                        try {
                            data = queue.remove();
                        } catch (NoSuchElementException ex) {
                            Log.i("Queue", "Empty Queue");
                        }
                    }

                    final String fData = data;
                    if (data != null) {
                        executor.execute(new Runnable() {
                            @Override
                            public void run() {
                                Log.d("PPROCESSING","Processer thread");
                                packProcesser.processPack(fData.toCharArray(), fData.length());
                            }
                        });
                       /* new Thread(new Runnable() {
                            @Override
                            public void run() {

                            }
                        }).start();*/
                    }

                    break;
                case PACK_DATA_RDY:
                    if (fragment != null) {
                        fragment.updateFragments(mc1XData);
                    }
                    break;
                default:
                    break;
            }
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (btThread != null)
            btThread.cancel();
        this.mWakeLock.release();
    }

    @Override
    protected void onStop() {
        super.onStop();
//        if (btThread != null)
//            btThread.cancel();
    }

    @Override
    protected void onPause() {
        super.onPause();
//        if (btThread != null)
//            btThread.cancel();
    }

}
