package com.apps.ddragos.thermalmonitor.utils;

public class CRC {
    private int crc;

    public CRC() {
        crc = 0xFFFF;
    }

    public CRC(int base) {
        crc = base;
    }

    private int crc16(final byte[] buffer) {

        for (int i = 0; i < buffer.length ; i++) {
            crc = ((crc  >>> 8) | (crc  << 8) )& 0xffff;
            crc ^= (buffer[i] & 0xff); //truncate sign
            crc ^= ((crc & 0xff) >> 4);
            crc ^= (crc << 12) & 0xffff;
            crc ^= ((crc & 0xFF) << 5) & 0xffff;
        }
        crc &= 0xffff;

        return crc;
    }

    public int crcFromString(String crcString) {
        byte[] buffer = crcString.getBytes();

        return crc16(buffer);
    }

    public int getCrc() {
        return crc;
    }
}
