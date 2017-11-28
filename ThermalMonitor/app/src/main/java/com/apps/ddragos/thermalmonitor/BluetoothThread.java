package com.apps.ddragos.thermalmonitor;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.os.Handler;
import android.widget.Toast;

import com.apps.ddragos.thermalmonitor.constants.ConstsBTConnection;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.apps.ddragos.thermalmonitor.constants.ConstsBTConnection.*;

public class BluetoothThread extends Thread {
    private final BluetoothSocket mmSocket;
    private final BluetoothDevice mmDevice;
    private Handler handler;
    private Context context;
    private InputStream inputStream = null;
    private OutputStream outputStream = null;
    private StreamParser streamParser = null;
    private Thread streamParserThread = null;
    private static final UUID MY_UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
    private ExecutorService executor;

    public BluetoothThread(Context context, BluetoothDevice device, Handler handler) {
        BluetoothSocket tmp = null;
        this.mmDevice = device;
        this.handler = handler;
        this.context = context;

        try {
            tmp = device.createRfcommSocketToServiceRecord(MY_UUID);
        }
        catch (IOException e) { }

        mmSocket = tmp;
    }

    @Override
    public void run() {
        try {
            mmSocket.connect();
        } catch (IOException connectException) {
            try {
                mmSocket.close();
            } catch (IOException closeException) {}
            handler.post(new Runnable() {
                @Override
                public void run() {
                Toast.makeText(context,"Could not connect",Toast.LENGTH_SHORT).show();
                }
            });
            return;
        }

        executor = Executors.newFixedThreadPool(1);
        manageConnectedSocket(mmSocket);
    }

    private void manageConnectedSocket(final BluetoothSocket mmSocket) {

        handler.obtainMessage(CONNECTED,mmDevice).sendToTarget();

        try {
            inputStream = mmSocket.getInputStream();
            outputStream = mmSocket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

        streamParser = new StreamParser(handler);
        int bytesRead;
        while (mmSocket.isConnected()) {
            try {
                byte[] buffer = new byte[16];
                bytesRead = inputStream.read(buffer);

                final int finalBytesRead = bytesRead;
                startParserThread(finalBytesRead, buffer);

                //send raw message to UI thread
                handler.obtainMessage(MESSAGE_RECEIVED,finalBytesRead,-1,buffer).sendToTarget();
               // Log.i(ConstsBTConnection.BT_MSG_TAG,new String(buffer,0,bytesRead));

            } catch (IOException e) {
                e.printStackTrace();
                handler.obtainMessage(DISCONNECTED,mmDevice).sendToTarget();
                try {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(context, "Disconnected from " + mmDevice.getName(), Toast.LENGTH_SHORT).show();
                        }
                    });
                    mmSocket.close();
                    outputStream.close();
                    inputStream.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }

    }

    private void startParserThread(final int finalBytesRead,final byte[] finalBuffer) {
        if (streamParserThread != null && streamParserThread.isAlive()) {
            try {
                streamParserThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
       /* streamParserThread = new Thread(new Runnable() {
            @Override
            public void run() {
                streamParser.parseMessage(finalBuffer, finalBytesRead);
            }
        });
        streamParserThread.start();*/

        executor.execute(new Runnable() {
            @Override
            public void run() {
                streamParser.parseMessage(finalBuffer, finalBytesRead);
            }
        });
    }


    public void write(byte[] bytes) {
        try {
            outputStream.write(bytes);
        } catch (IOException e) { }
    }

    public void cancel() {
        try {
            mmSocket.close();

        } catch (IOException e) { }
    }


}
