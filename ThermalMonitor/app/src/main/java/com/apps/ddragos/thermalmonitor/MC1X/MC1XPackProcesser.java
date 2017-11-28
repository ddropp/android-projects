package com.apps.ddragos.thermalmonitor.MC1X;

import android.os.Handler;

import static com.apps.ddragos.thermalmonitor.constants.ConstsBTConnection.PACK_DATA_RDY;
import static com.apps.ddragos.thermalmonitor.constants.ConstsMC1XPack.PACKTYPE_CHRONO_SETTINGS;
import static com.apps.ddragos.thermalmonitor.constants.ConstsMC1XPack.PACKTYPE_CH_ENABLE_INPUTS;
import static com.apps.ddragos.thermalmonitor.constants.ConstsMC1XPack.PACKTYPE_EEPROM_ADDRESS;
import static com.apps.ddragos.thermalmonitor.constants.ConstsMC1XPack.PACKTYPE_EEPROM_VALUE;
import static com.apps.ddragos.thermalmonitor.constants.ConstsMC1XPack.PACKTYPE_EXEC_ELEMENTS;
import static com.apps.ddragos.thermalmonitor.constants.ConstsMC1XPack.PACKTYPE_ME;
import static com.apps.ddragos.thermalmonitor.constants.ConstsMC1XPack.PACKTYPE_MODULATION_CMD;
import static com.apps.ddragos.thermalmonitor.constants.ConstsMC1XPack.PACKTYPE_MODULATION_FEEDBACK;
import static com.apps.ddragos.thermalmonitor.constants.ConstsMC1XPack.PACKTYPE_MOTANC15ID;
import static com.apps.ddragos.thermalmonitor.constants.ConstsMC1XPack.PACKTYPE_NR_MESSAGES;
import static com.apps.ddragos.thermalmonitor.constants.ConstsMC1XPack.PACKTYPE_REQUEST;
import static com.apps.ddragos.thermalmonitor.constants.ConstsMC1XPack.PACKTYPE_SENSOR_VALUES;
import static com.apps.ddragos.thermalmonitor.constants.ConstsMC1XPack.PACKTYPE_SYS_STATUS;
import static com.apps.ddragos.thermalmonitor.constants.ConstsMC1XPack.PACKTYPE_SYS_TIME;
import static com.apps.ddragos.thermalmonitor.constants.ConstsMC1XPack.PACKTYPE_USER_SETTINGS;
import static com.apps.ddragos.thermalmonitor.constants.ConstsMC1XPack.buildPackType;
import static com.apps.ddragos.thermalmonitor.utils.HexUtil.CharToHex;

public class MC1XPackProcesser {

    private MC1XData data;
    private Handler handler;
    private boolean mFirstPack = true;

    public MC1XPackProcesser(MC1XData mc1XData, Handler handler) {
        this.data = mc1XData;
        this.handler =  handler;
    }

    int getPackValue(char[] packData, int packLen)
    {
        int value = 0;

        for (int i=3 ; (packData[i]!='#') && (i < packLen) ; i++ )
        {
            value = (value<<4) | CharToHex(packData[i]);
        }
        return value;
    }

    // calculul valorii dintr-un pachet
    int getPackValue(char[] packData, int start, int packLen)
    {
        int value = 0;
        int i;

        for( i = 3+start ; (packData[i]!='#') && (i < packLen) ; i++ )
        {
            value = (value<<4) | CharToHex(packData[i]);
        }
        return value;
    }

    public synchronized boolean processPack(char[] packData, int packLen) {
        int i = 0;
        int uIntValue;
        int packType = buildPackType(packData[1], packData[2]);
//        MC1XData data = callingFragment.getMc1XData();

        if (packType == PACKTYPE_MOTANC15ID) {
            uIntValue = getPackValue(packData, 5);
            data.setBoilerModel(uIntValue);

            uIntValue = getPackValue(packData, 2, 7);
            data.setRevision(uIntValue);

            if (!mFirstPack) {
                handler.obtainMessage(PACK_DATA_RDY).sendToTarget();
            } else
            {
                mFirstPack = false;
            }

            return true;
        }
        //////////////////////////////////////////////////////////////////////////
        // pachet NM - numar de mesaje receptionate cu success
        else if (packType == PACKTYPE_NR_MESSAGES) {
            uIntValue = getPackValue(packData, packLen);
            data.setNumberOfMessages(uIntValue);
            return true;
        }
        //////////////////////////////////////////////////////////////////////////
        // pachet BR - burn request data
        else if (packType == PACKTYPE_REQUEST) {
            uIntValue = getPackValue(packData, packLen);
            data.setRequest(uIntValue);
            return true;
        }
        //////////////////////////////////////////////////////////////////////////
        // pachet SS - system major status
        else if (packType == PACKTYPE_SYS_STATUS) {
            uIntValue = getPackValue(packData, packLen);
            data.setSystemMajorStatus(uIntValue);
            return true;
        }
        //////////////////////////////////////////////////////////////////////////
        // pachet EE - execution elements
        else if (packType == PACKTYPE_EXEC_ELEMENTS) {
            uIntValue = getPackValue(packData, packLen);
            data.setExecutionElements(uIntValue);
            return true;
        }
        //////////////////////////////////////////////////////////////////////////
        // pachet QV - sensors measurements: Quantities Values
        else if (packType == PACKTYPE_SENSOR_VALUES) {
            uIntValue = getPackValue(packData, packLen);
            data.setQuantiesValues(uIntValue);
            return true;
        }
        //////////////////////////////////////////////////////////////////////////
        // pachet QS - sensors measurements: Quantities Status
//		    else if (packType == PACKTYPE_SENSOR_STATUS) {
//			    uIntValue=getPackValue(packData, packLen);
//			    data.setQuantiesStatus( uIntValue );
//
//              return true;
//           }
        //////////////////////////////////////////////////////////////////////////
        // pachet CE - Central-heating Enable inputs
        else if (packType == PACKTYPE_CH_ENABLE_INPUTS) {
            uIntValue = getPackValue(packData, packLen);
            data.setCentralHeatingEnableInputs(uIntValue);
            return true;
        }
        //////////////////////////////////////////////////////////////////////////
        // pachet MC - Modulation Command[s]
        else if (packType == PACKTYPE_MODULATION_CMD) {
            uIntValue = getPackValue(packData, packLen);
            data.setModulationCommand(uIntValue);
            return true;
        }
        //////////////////////////////////////////////////////////////////////////
        // pachet MF - Modulation Feedback[s]
        else if (packType == PACKTYPE_MODULATION_FEEDBACK) {
            uIntValue = getPackValue(packData, packLen);
            data.setModulationFeedback(uIntValue);
            return true;
        }
        //////////////////////////////////////////////////////////////////////////
        // pachet US - User Settings
        else if (packType == PACKTYPE_USER_SETTINGS) {
            uIntValue = getPackValue(packData, packLen);
            data.setUserSettings(uIntValue);
            return true;
        }
        //////////////////////////////////////////////////////////////////////////
        // pachet CS - Chrono Settings
        else if (packType == PACKTYPE_CHRONO_SETTINGS) {
            uIntValue = getPackValue(packData, packLen);
            return true;
        }
        //////////////////////////////////////////////////////////////////////////
        // pachet TI - System time
        else if (packType == PACKTYPE_SYS_TIME) {
            uIntValue = getPackValue(packData, packLen);
            return true;
        }
        //////////////////////////////////////////////////////////////////////////
        // pachet ME - Message executed
        else if (packType == PACKTYPE_ME) {
            //uIntValue=getPackValue(packData, packLen);

            return true;
        } else if (packType == PACKTYPE_EEPROM_ADDRESS) {
            return true;
        } else if (packType == PACKTYPE_EEPROM_VALUE) {
            return true;
        }

        return false;
    }



}
