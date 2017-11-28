package com.apps.ddragos.thermalmonitor.constants;

@SuppressWarnings("ALL")
public class ConstsMC1XPack {

    public static int buildPackType(char x, char y) {
        return ((x << 8) | y);
    }

// id centrala
    public static final int PACKTYPE_MOTANC13ID           = buildPackType('I','D');
    public static final int PACKTYPE_MOTANC15ID		      = buildPackType('I','D');
    public static final int PACKTYPE_MOTANC11NID		  = buildPackType('I','D');
/// numar de mesaje receptionate cu success
    public static final int PACKTYPE_NR_MESSAGES		  = buildPackType('N', 'M');
/// request data
    public static final int PACKTYPE_REQUEST			  = buildPackType('R', 'Q');
/// system major status
    public static final int PACKTYPE_SYS_STATUS		      = buildPackType('S', 'S');
/// execution elements
    public static final int PACKTYPE_EXEC_ELEMENTS        = buildPackType('E', 'E');
/// sensors measurements: Quantities Values
    public static final int PACKTYPE_SENSOR_VALUES        = buildPackType('Q', 'V');
/// sensors measurements: Quantities Status
//    public static int PACKTYPE_SENSOR_STATUS		      = buildPackType('Q', 'S');
/// Central-heating Enable inputs
    public static final int PACKTYPE_CH_ENABLE_INPUTS     = buildPackType('C', 'E');
/// Modulation Command[s]
    public static final int PACKTYPE_MODULATION_CMD		  = buildPackType('M', 'C');
/// Modulation Feedback[s]
    public static final int PACKTYPE_MODULATION_FEEDBACK = buildPackType('M', 'F');
/// User Settings
    public static final int PACKTYPE_USER_SETTINGS		  = buildPackType('U', 'S');
/// Chrono Settings
    public static final int PACKTYPE_CHRONO_SETTINGS	  = buildPackType('C', 'S');
/// System time
    public static final int PACKTYPE_SYS_TIME	    	  = buildPackType('T', 'I');
/// Message executed
    public static final int PACKTYPE_ME					  = buildPackType('M', 'E');
/// EEPROM ADDRESS
    public static final int PACKTYPE_EEPROM_ADDRESS		  = buildPackType('E', 'A');
/// EEPROM value
    public static final int PACKTYPE_EEPROM_VALUE	      = buildPackType('E', 'V');


}
