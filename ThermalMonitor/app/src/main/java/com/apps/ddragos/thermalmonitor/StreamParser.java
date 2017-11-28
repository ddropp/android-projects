package com.apps.ddragos.thermalmonitor;

import android.os.Handler;
import android.util.Log;

import com.apps.ddragos.thermalmonitor.constants.ConstsBTConnection;
import com.apps.ddragos.thermalmonitor.utils.CRC;

import java.util.LinkedList;
import java.util.Queue;

public class StreamParser {

    private StringBuilder currentSeq = null;
    private StringBuilder crc = null;
    private boolean seqStarted = false;
    private boolean crcStarted = false;
    private boolean firstID = false;

    private Handler handler = null;

    public static Queue<String> queue = null;
    public static final Object lock = new Object();

    public StreamParser(Handler handler) {
        this.handler = handler;
    }


    public synchronized void parseMessage(byte[] buffer, int bytesRead) {
        String sequence = new String(buffer,0,bytesRead);

        for (int i = 0; i < sequence.length(); i++) {
            char c = sequence.charAt(i);

            switch (c) {
                case '>':
                    seqStarted = true;
                    currentSeq = new StringBuilder();
                    currentSeq.append('>');
                    break;
                case '<':
                    if (currentSeq != null && currentSeq.length() >= 3) {
                        crcStarted = false;

                        if (currentSeq.substring(1,3).equals("ID")) {
                            if (!firstID) {
                                firstID = true;
                                if (queue == null)
                                    queue = new LinkedList<>();
                            }
                        }

                        //crc check + insertion in queue
                        if (firstID) {
                            if (checkCRC(currentSeq,crc)) {
                                synchronized (lock) {
                                    queue.add(currentSeq.toString());
                                    handler.obtainMessage(ConstsBTConnection.QUEUE_DATA_RDY, null).sendToTarget();
                                    Log.i("word", currentSeq.toString());
                                }
                            }
                        }

                    }
                    break;
                case '#':
                    if (seqStarted) {
                        seqStarted = false;
                        crcStarted =  true;
                        currentSeq.append('#');
                        crc = new StringBuilder();
                    }

                    break;
                default: break;
            }

            if (isAlphaNumeric(c))
            {
                if (seqStarted)
                    currentSeq.append(c);
                else if (crcStarted)
                    crc.append(c);
            }
        }

    }

    private boolean checkCRC(StringBuilder currentSeq, StringBuilder crc) {
        try {
            int computedCRC = new CRC().crcFromString(currentSeq.toString());
            int receivedCRC = Integer.parseInt(crc.toString(),16);
            Log.i("myCRC",Integer.toHexString(computedCRC) + " : " + Integer.toHexString(receivedCRC));

            if ((computedCRC ^ receivedCRC) == 0)
                return true;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            Log.d("CRC INT", crc.toString());
        }

        return false;
    }

    private boolean isAlphaNumeric(char c) {
        char ch = Character.toLowerCase(c);
        return (ch >= 'a' && ch <= 'z') || Character.isDigit(ch);
    }

}
