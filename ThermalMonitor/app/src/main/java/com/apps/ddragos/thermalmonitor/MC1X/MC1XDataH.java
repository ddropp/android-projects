package com.apps.ddragos.thermalmonitor.MC1X;


@SuppressWarnings("ALL")
public class MC1XDataH {

    public static final int VAL_NONE = 100;
    public static final String VAL_NONE_STR = "100";

    /// momentul de timp la care sunt esantionate datele
    double m_time;
    // ID message
    /// model the monitorized boiler
    int m_boilerModel;
    /// revision
    int m_revision;
    //NM message
    /// number of messages succesfuly received
    int m_numberOfMessages;
    // request message
    // request DHW[/CH]: anti-block circulation ???
    int m_requestSource_DHW_AntiblocCirculation;
    /// request source DHW comfort
    int m_requestSource_DHW_InstantComfort;
    /// request source CH : user/normal heating
    int m_requestSource_CH_UserNormalHeating;
    /// request source CH : anti-freeze heating
    int m_requestSource_CH_AntifreezeHeating;
    /// request DHW tank with 1/2 sensors: user/normal heating
    int m_requestSource_DHW_Tank1NormalHeating;
    /// request DHW tank with 1/2 sensors: anti-legionella heating
    int m_requestSource_DHW_Tank1Antilegionela;
    /// request DHW tank with 0 sensors: user/normal heating
    int m_requestSource_DHW_Tank0NormalHeating;
    /// DHW instant user: burning/circulation-only request (circulation only when below DHW min-power)
    int m_requestSource_DHW_InstantUser;
    /// burn request source none
    int m_requestSource_None;
    /// request instal
    // 0x00 - none
    // 0x01 - DHW
    // 0x02 - CH
    int m_requestInstal;
    /// burn request ModSetTemp valoare intreaga codata hex ascii
    int m_requestModSetTemp;
    //system major status
    ////////////////////////////////////////////////////////////////
    /// system major status operation mode
    ///		0x00 - Initial
    ///		0x01 - Standby
    ///		0x02 - Failure
    ///		0x03 - User
    int m_sysMjStatus_OperationMode;
    ////////////////////////////////////////////////////////////////
    /// system major status state, relative state at operation mode
    ///		0x00 - Initial
    ///		0x11 - Wait
    ///		0x20 - Prepurge
    ///		0x21 - Interpurge
    ///		0x22 - Ignition
    ///		0x23 - Burning
    ///		0x24 - Extinction
    ///		0x25 - Postpurge
    ///		0x30 - Circulation
    ///		0x40 - Error
    int m_sysMjStatus_State;
    /// system major status errors
    int m_sysMjStatus_CriticalError;
    int m_sysMjStatus_NormalError;
    int m_sysMjStatus_InfoError;
    //execution elements
    /// execution elements, exist cmd for gas valve; 1 - cmd exist, 0 - cmd not exist
    int m_execElementsCtrl_GasValve;
    /// execution elements, exist cmd for igniter; 1 - cmd exist, 0 - cmd not exist
    int m_execElementsCtrl_Igniter;
    /// execution elements, exist cmd for fan; 1 - cmd exist, 0 - cmd not exist
    int m_execElementsCtrl_Fan;
    /// execution elements, exist cmd for three way valve; 1 - cmd exist, 0 - cmd not exist
    int m_execElementsCtrl_ThreeWayValve;
    /// execution elements, exist cmd for pump; 1 - cmd exist, 0 - cmd not exist
    int m_execElementsCtrl_Pump;
    /// execution elements, exist cmd for boiler pump; 1 - cmd exist, 0 - cmd not exist
    int m_execElementsCtrl_TankPump;
    /// execution elements, gas valve state; 1 - ON, 0 - OFF
    int m_execElementsStatus_GasValve;
    /// execution elements, flame state; 1 - ON, 0 - OFF
    int m_execElementsStatus_Flame;
    /// execution elements, fan state; 1 - ON, 0 - OFF
    int m_execElementsStatus_Fan;
    /// execution elements, three way valve state; 1 - ON, 0 - OFF
    int m_execElementsStatus_ThreeWayValve;
    /// execution elements, pump state; 1 - ON, 0 - OFF
    int m_execElementsStatus_Pump;
    /// execution elements, tank pump state; 1 - ON, 0 - OFF
    int m_execElementsStatus_TankPump;

    // QV message
    /// Temperatura masurata in vasul de acumulare – senzorul 2
    double m_qVal_TWaterTankS2;
    /// Temperatura masurata in vasul de acumulare – senzorul 1
    double m_qVal_TWaterTankS1;
    /// Temperatura masurata in exterior – atentie poate avea si valoare negativa
    double m_qVal_TExterior;
    /// Temperatura masurata a gazelor de evacuare
    double m_qVal_TExhaust;
    /// Temperatura masurata pe circuitul de termoficare - retur
    double m_qVal_TCHR;
    /// Temperatura masurata pe circuitul de termoficare - tur
    double m_qVal_TCHFlow;
    ///Temperatura masurata pe circuitul ACM
    double m_qVal_TDHW;
    /// Debitul masurat pe circuitul ACM (doar octetul low). Debit * 10, 127 = 12,7 l/min).
    // de interpretat datele ca la temperatura
    double m_qVal_FlowDHW;
    /// Presiunea masurata in circuitul de incalzire (doar octetul low) presiune * 10, (17 = 1.7 bar).
    /// atentie valoarea din partea intreaga trebuie impartita la 10 iar pertea fractionara = 0 (neglijata)
    double m_qVal_PresureCH;

    // QS message
    /// Status of temp on water tank (2nd sensor) ?
//	int m_qStatus_TWaterTankS2;
    /// Status of temp on water tank (1st sensor) ?
//	int m_qStatus_TWaterTankS1;
    /// Status of temp from exterior
//	int m_qStatus_TExterior;
    /// Status of temp on exhaust circuit
//	int m_qStatus_TExhaust;
    /// Status of temp on CH-return
//	int m_qStatus_TCHR;
    /// Status of temp on CH-turn
//	int m_qStatus_TCHFlow;
    /// Status of temp on DHW
//	int m_qStatus_TDHW;
    /// Status of water flow: not detected / detected
//	int m_qStatus_FlowDHW;
    /// Status of water pressure in CH circuit
//	int m_qStatus_PresureCH;

    // CE message
    /// Ambient thermostat - validare
    int m_cHeatingEnable_ByAmbientThermostat;
    /// Cronostat – validare (C1X/C14/C15/C17)
    int m_cHeatingEnable_ByChronostat;

    // MC message
    /// modulation commands
    //(modulare ventilator)// C1X/C14/C15/C17: Fan PWM: 0-1000
    int m_mcFanSetPwm;
    //modulare bobina vana de gaz// C11/C12/C15/C17: Gas-valve PWM: 0-1000
    int m_mcGValveSetPwm;

    // MF message
    /// modulation feedback;
    // viteza ventilator
    int m_mfFanSpeed; // C1X/C14/C15/C17: fan rotation speed:  scale x0.1 (unit=10RPM)
    double m_mfGValveVoltage; // C11/C12: gas-valve regulator voltage: scale x100 (unit=10mV)
    double m_mfFlameIonisationVoltage; // All models: burner ionisation voltage:scale x100 (unit=10mV)

    // US message
    /// user settings
    /// temperatura setata pe circuitul de termoficare
    int m_userSettings_TCHSet;
    /// temperatura setata pe circuitul de ACM
    int m_userSettings_TDHWSet;
    /// season set
    // 1 winter
    // 0 summer
    int m_userSettings_SeasonSet;
    /// functia confort activa
    int m_userSettings_ComfortActive;
    /// cronostat activa
    int m_userSettings_ChronoActive;
    /// functia vacanta activa
    int m_userSettings_VacationActive;
    /// temperatura ambientala setata
    // nefolosit momentan
    int m_userSettings_TAMBSet;
    /// coeficientul de pierdere prin pereti
    // nefolosit momentan
    double m_userSettings_CoefWallLoss;
    /// starea boilerului
    int m_userSettings_BoilerStatus;
    /// lumina LCD activa
    int m_userSettings_LightActive;


    /*
	*	indicatori daca o anumita valoare este sau nu valabila
	*/
    ///valoarea time are sens
    boolean m_timeAvaible;
    /// model the monitorized boiler
    boolean m_boilerModelAvaible;
    /// firmware revision
    boolean m_revisionAvaible;
    /// number of messages succesfuly received
    boolean m_numberOfMessagesAvaible;
    /// request DHW[/CH]: anti-block circulation ???
    boolean m_requestSource_DHW_AntiblocCirculationAvaible;
    /// request source DHW comfort
    boolean m_requestSource_DHW_InstantComfortAvaible;
    /// request source CH : user/normal heating
    boolean m_requestSource_CH_UserNormalHeatingAvaible;
    /// request source CH : anti-freeze heating
    boolean m_requestSource_CH_AntifreezeHeatingAvaible;
    /// request DHW tank with 1/2 sensors: user/normal heating
    boolean m_requestSource_DHW_Tank1NormalHeatingAvaible;
    /// request DHW tank with 1/2 sensors: anti-legionella heating
    boolean m_requestSource_DHW_Tank1AntilegionelaAvaible;
    /// request DHW tank with 0 sensors: user/normal heating
    boolean m_requestSource_DHW_Tank0NormalHeatingAvaible;
    /// DHW instant user: burning/circulation-only request (circulation only when below DHW min-power)
    boolean m_requestSource_DHW_InstantUserAvaible;
    /// request instal
    boolean m_requestInstalAvailable;
    /// burn request source none
    boolean m_requestSource_NoneAvaible;
    /// burn request ModSetTemp valoare intreaga codata hex ascii
    boolean m_requestModSetTempAvaible;
    /// system major status operation mode
    boolean m_sysMjStatus_OperationModeAvaible;
    /// system major status state, relative state at operation mode
    boolean m_sysMjStatus_StateAvaible;
    /// system major status error
    boolean m_sysMjStatus_CriticalErrorAvaible;
    boolean m_sysMjStatus_NormalErrorAvaible;
    boolean m_sysMjStatus_InfoErrorAvaible;
    /// execution elements, exist cmd for gas valve
    boolean m_execElementsCtrl_GasValveAvaible;
    /// execution elements, exist cmd for igniter
    boolean m_execElementsCtrl_IgniterAvaible;
    /// execution elements, exist cmd for fan
    boolean m_execElementsCtrl_FanAvaible;
    /// execution elements, exist cmd for three way valve
    boolean m_execElementsCtrl_ThreeWayValveAvaible;
    /// execution elements, exist cmd for pump
    boolean m_execElementsCtrl_PumpAvaible;
    /// execution elements, exist cmd for boiler pump
    boolean m_execElementsCtrl_TankPumpAvaible;
    /// execution elements, gas valve state
    boolean m_execElementsStatus_GasValveAvaible;
    /// execution elements, flame state
    boolean m_execElementsStatus_FlameAvaible;
    /// execution elements, fan state
    boolean m_execElementsStatus_FanAvaible;
    /// execution elements, three way valve state
    boolean m_execElementsStatus_ThreeWayValveAvaible;
    /// execution elements, pump state
    boolean m_execElementsStatus_PumpAvaible;
    /// execution elements, tank pump state
    boolean m_execElementsStatus_TankPumpAvaible;
    /// Temperatura masurata in vasul de acumulare – senzorul 2
    boolean m_qVal_TWaterTankS2Avaible;
    /// Temperatura masurata in vasul de acumulare – senzorul 1
    boolean m_qVal_TWaterTankS1Avaible;
    /// Temperatura masurata in exterior – atentie poate avea si valoare negativa
    boolean m_qVal_TExteriorAvaible;
    /// Temperatura masurata a gazelor de evacuare
    boolean m_qVal_TExhaustAvaible;
    /// Temperatura masurata pe circuitul de termoficare - retur
    boolean m_qVal_TCHRAvaible;
    /// Temperatura masurata pe circuitul de termoficare - tur
    boolean m_qVal_TCHFlowAvaible;
    ///Temperatura masurata pe circuitul ACM
    boolean m_qVal_TDHWAvaible;
    /// Debitul masurat pe circuitul ACM
    boolean m_qVal_FlowDHWAvaible;
    /// Presiunea masurata in circuitul de incalzire
    boolean m_qVal_PresureCHAvaible;
    /// Status of temp on water tank (2nd sensor) ?
//	boolean m_qStatus_TWaterTankS2Avaible;
    /// Status of temp on water tank (1st sensor) ?
//	boolean m_qStatus_TWaterTankS1Avaible;
    /// Status of temp from exterior
//	boolean m_qStatus_TExteriorAvaible;
    /// Status of temp on exhaust circuit
//	boolean m_qStatus_TExhaustAvaible;
    /// Status of temp on CH-return
//	boolean m_qStatus_TCHRAvaible;
    /// Status of temp on CH-turn
//	boolean m_qStatus_TCHFlowAvaible;
    /// Status of temp on DHW
//	boolean m_qStatus_TDHWAvaible;
    /// Status of water flow: not detected / detected
//	boolean m_qStatus_FlowDHWAvaible;
    /// Status of water pressure in CH circuit
//	boolean m_qStatus_PresureCHAvaible;
    /// Ambient thermostat - validare
    boolean m_cHeatingEnable_ByAmbientThermostatAvaible;
    /// Cronostat – validare (C1X/C14/C15/C17)
    boolean m_cHeatingEnable_ByChronostatAvaible;
    /// modulation commands
    boolean m_mcFanSetPwmAvaible;
    boolean m_mcGValveSetPwmAvaible;
    /// modulation feedback;
    boolean m_mfFanSpeedAvaible;
    boolean m_mfGValveVoltageAvaible;
    boolean m_mfFlameIonisationVoltageAvaible;
    /// temperatura setata pe circuitul de termoficare
    boolean m_userSettings_TCHSetAvaible;
    /// temperatura setata pe circuitul de ACM
    boolean m_userSettings_TDHWSetAvaible;
    /// season set
    boolean m_userSettings_SeasonSetAvaible;
    /// functia confort activa
    boolean m_userSettings_ComfortActiveAvaible;
    /// cronostat activa
    boolean m_userSettings_ChronoActiveAvaible;
    /// functia vacanta activa
    boolean m_userSettings_VacationActiveAvaible;
    /// temperatura ambientala setata
    // nefolosit momnetan
    boolean m_userSettings_TAMBSetAvaible;
    /// coeficientul de pierdere prin pereti
    // nefolosit momentan
    boolean m_userSettings_CoefWallLossAvaible;
    /// starea boilerului
    boolean m_userSettings_BoilerStatusAvaible;
    /// lumina LCD activa
    boolean m_userSettings_LightActiveAvaible;

    /// valoare dummy folosita in cazul in care functia getMember(@param value) nu are ce returna
    double m_dummyValue;


    public double GetTimeValue(){ return m_time; };
    /// functia returneaza modelul boilerului
    public int GetBoilerModel() { return m_boilerModel;};
    /// functia returneaza revizia
    public int GetReveision() { return m_revision; };
    /// returneaza numarul de mesaje
    public int GetNumberOfMessages(){ return m_numberOfMessages; };
    /// return request source DHW[/CH]: anti-block circulation
    public int GetRequestSourceDHWAntiblocCirculation() { return m_requestSource_DHW_AntiblocCirculation; };
    /// return request source DHW instant comfort
    public int GetRequestSourceDHWInstantComfort() { return m_requestSource_DHW_InstantComfort; };
    /// return request source CH : user/normal heating
    public int GetRequestSourceCHUserNormalHeating() { return m_requestSource_CH_UserNormalHeating; };
    /// return request source CH : anti-freeze heating
    public int GetRequestSourceCHAntifreezeHeating() { return m_requestSource_CH_AntifreezeHeating; };
    /// return request source DHW tank with 1/2 sensors: user/normal heating
    public int GetRequestSourceDHWTank1NormalHeating() { return m_requestSource_DHW_Tank1NormalHeating; };
    /// return request source DHW tank with 1/2 sensors: anti-legionella heating
    public int GetRequestSourceDHWTank1Antilegionela() { return m_requestSource_DHW_Tank1Antilegionela; };
    /// return request source DHW tank with 0 sensors: user/normal heating
    public int GetRequestSourceDHWTank0NormalHeating() { return m_requestSource_DHW_Tank0NormalHeating; };
    /// return request source DHW instant user: burning/circulation-only request (circulation only when below DHW min-power)
    public int GetRequestSourceDHWInstantUser() { return m_requestSource_DHW_InstantUser; };
    /// return request source none
    public int GetRequestSourceNone() { return m_requestSource_None; };
    /// request instal
    /// 0x00 - none
    /// 0x01 - DHW
    /// 0x02 - CH
    public int GetRequestInstal() { return m_requestInstal; };
    /// burn request ModSetTemp valoare intreaga codata hex ascii
    public int GetRequestModSetTemp() { return m_requestModSetTemp; };
    /// system major status operation mode
    public int GetSysMajorStatusOperationMode() { return m_sysMjStatus_OperationMode; };
    /// system major status state
    public int GetSysMajorStatusState(){ return m_sysMjStatus_State; };
    /// system major status errors
    public int GetSysMajorStatusCriticalError(){ return m_sysMjStatus_CriticalError; };
    public int GetSysMajorStatusNormalError(){ return m_sysMjStatus_NormalError; };
    public int GetSysMajorStatusInfoError(){ return m_sysMjStatus_InfoError; };
    /// starea elementelor de executie
    /// returneaza starea pompei boiler-ului
    public int GetExecElementsStatusTankPump() { return m_execElementsStatus_TankPump; };
    /// returneaza starea pompei
    public int GetExecElementsStatusPump() { return m_execElementsStatus_Pump; };
    /// returneaza starea vanei cu trei cai
    public int GetExecElementsStatusThreeWayValve() { return m_execElementsStatus_ThreeWayValve; };
    /// returneaza starea ventilatorului
    public int GetExecElementsStatusFan() { return m_execElementsStatus_Fan; };
    /// returneaza starea flacarii
    public int GetExecElementsStatusFlame() { return m_execElementsStatus_Flame; };
    /// returneaza starea vanei de gaz
    public int GetExecElementsStatusGasValve() { return m_execElementsStatus_GasValve; };
    /// starea comenzilor de executie
    /// returneaza starea comenzii pompei boilerului
    public int GetExecElementsCtrlTankPump() { return m_execElementsCtrl_TankPump; };
    /// returneaza starea comenzii pompei
    public int GetExecElementsCtrlPump() { return m_execElementsCtrl_Pump; };
    /// returneaza starea comenzii vanei cu trei cai
    public int GetExecElementsCtrlThreeWayValve() { return m_execElementsCtrl_ThreeWayValve; };
    /// returneaza starea comenzii ventilatorului
    public int GetExecElementsCtrlFan() { return m_execElementsCtrl_Fan; };
    /// returneaza starea comenzii circuitului de ignitie
    public int GetExecElementsCtrlFlame() { return m_execElementsCtrl_Igniter; };
    /// returneaza starea comenzii vanei de gaz
    public int GetExecElementsCtrlGasValve() { return m_execElementsCtrl_GasValve; };
    /// returneaza Temperatura masurata in vasul de acumulare – senzorul 2
    public double GetQValTemperatureWaterTankS2() { return m_qVal_TWaterTankS2; };
    /// returneaza Temperatura masurata in vasul de acumulare – senzorul 1
    public double GetQValTemperatureWaterTankS1() { return m_qVal_TWaterTankS1; };
    /// returneaza Temperatura masurata in exterior – atentie poate avea si valoare negativa
    public double GetQValTemperatureExterior() { return  m_qVal_TExterior; };
    /// returneaza Temperatura masurata a gazelor de evacuare
    public double GetQValTemperatureExhaust() { return m_qVal_TExhaust; };
    /// returneaza Temperatura masurata pe circuitul de termoficare - retur
    public double GetQValTemperatureCHRetur() { return m_qVal_TCHR; };
    /// returneaza Temperatura masurata pe circuitul de termoficare - tur
    public double GetQValTemperatureCHFlow() { return m_qVal_TCHFlow; };
    /// returneaza Temperatura masurata pe circuitul ACM
    public double GetQValTemperatureDHW() { return m_qVal_TDHW; };
    /// returneaza Debitul masurat pe circuitul ACM (doar octetul low). Debit * 10, 127 = 12,7 l/min).
    public double GetQValFlowDHW() { return m_qVal_FlowDHW; };
    /// returneaza Presiunea masurata in circuitul de incalzire (doar octetul low) presiune * 10, (17 = 1.7 bar).
    public double GetQValPresureCH() { return m_qVal_PresureCH; };
    /// return the Status of temp on water tank (2nd sensor) ?
//	int GetQStatusTemperatureWaterTankS2() { return m_qStatus_TWaterTankS2; };
    /// return the Status of temp on water tank (1st sensor) ?
//	int GetQStatusTemperatureWaterTankS1() { return m_qStatus_TWaterTankS1; };
    /// return the Status of temp from exterior
//	int GetQStatusTemperatureExterior() { return m_qStatus_TExterior; };
    /// return the Status of temp on exhaust circuit
//	int GetQStatusTemperatureExhaust() { return m_qStatus_TExhaust; };
    /// return the Status of temp on CH-return
//	int GetQStatusTemperatureCHRetur() { return m_qStatus_TCHR; };
    /// return the Status of temp on CH-turn
//	int GetQStatusTemperatureCHFlow() { return m_qStatus_TCHFlow; };
    /// return the Status of temp on DHW
//	int GetQStatusTemperatureDHW() { return m_qStatus_TDHW; };
    /// return the Status of water flow: not detected / detected
//	int GetQStatusFlowDHW() { return m_qStatus_FlowDHW; };
    /// return the Status of water pressure in CH circuit
//	int GetQStatusPresureCH() { return m_qStatus_PresureCH; };
    /// sursa de validare pentru a porni incalzirea
    public int GetCentralHeatingEnableInputsByAmbientTermostat(){ return m_cHeatingEnable_ByAmbientThermostat; };
    public int GetCentralHeatingEnableInputsByAmbientcronostat(){ return m_cHeatingEnable_ByChronostat; };
    /// returneaza comanda de modulare
    public int GetMCFanSetPwm(){ return m_mcFanSetPwm; };
    public int GetMCGValveSetPwm(){ return m_mcGValveSetPwm; };
    /// returneaza feadback-ul de modulare
    public int GetMFFanSpeed(){ return m_mfFanSpeed; };
    public double GetMFGValveVoltaged(){ return m_mfGValveVoltage; };
    public double GetMFFlameIonisationVoltage(){ return m_mfFlameIonisationVoltage; };
    /// temperatura setata pe circuitul de termoficare
    public int GetUserSettingsTemperatureCHSet() { return m_userSettings_TCHSet; };
    /// temperatura setata pe circuitul de ACM
    public int GetUserSettingsTemperatureDHWSet() { return m_userSettings_TDHWSet; };
    /// season set: 1 winter; 0 summer
    public int GetUserSettingsSeasonset() { return m_userSettings_SeasonSet; };
    /// functia confort activa
    public int GetUserSettingsComfortActive() { return m_userSettings_ComfortActive; };
    /// cronostat activa
    public int GetUserSettingsChronoActive() { return m_userSettings_ChronoActive; };
    /// functia vacanta activa
    public int GetUserSettingsVacationActive() { return m_userSettings_VacationActive; };
    /// temperatura ambientala setata, nefolosit momnetan
    public int GetUserSettingsTemperatureAmbientSet() { return m_userSettings_TAMBSet; };
    /// coeficientul de pierdere prin pereti, nefolosit momentan
    public double GetUserSettingsCoefWallLoss() { return m_userSettings_CoefWallLoss; };
    /// starea boilerului
    public int GetUserSettingsBoilerStatus() { return m_userSettings_BoilerStatus; };
    /// lumina LCD activa
    public int GetUserSettingsLightActive() { return m_userSettings_LightActive; };

    /// este modelul boilerului disponibil
    public boolean IsBoilerModelAvaible() { return m_boilerModelAvaible;	}
    /// este revizia disponibila
    public  boolean IsRevisionAvaible() { return m_revisionAvaible; };
    /// este numarul de mesaje disponibil
    public boolean IsNumberOfMessagesAvaible(){ return m_numberOfMessagesAvaible; };
    /// este request source DHW[/CH]: anti-block circulation disponibil
    public  boolean IsRequestSourceDHWAntiblocCirculationAvaible() { return m_requestSource_DHW_AntiblocCirculationAvaible; };
    /// este request source DHW instant comfort disponibil
    public boolean IsRequestSourceDHWInstantComfortAvaible() { return m_requestSource_DHW_InstantComfortAvaible; };
    /// este request source CH : user/normal heating disponibil
    public boolean IsRequestSourceCHUserNormalHeatingAvaible() { return m_requestSource_CH_UserNormalHeatingAvaible; };
    /// este request source CH : anti-freeze heating disponibil
    public boolean IsRequestSourceCHAntifreezeHeatingAvaible() { return m_requestSource_CH_AntifreezeHeatingAvaible; };
    /// este request source DHW tank with 1/2 sensors: user/normal heating disponibil
    public boolean IsRequestSourceDHWTank1NormalHeatingAvaible() { return m_requestSource_DHW_Tank1NormalHeatingAvaible; };
    /// este request source DHW tank with 1/2 sensors: anti-legionella heating disponibil
    public boolean IsRequestSourceDHWTank1AntilegionelaAvaible() { return m_requestSource_DHW_Tank1AntilegionelaAvaible; };
    /// este request source DHW tank with 0 sensors: user/normal heating disponibil
    public boolean IsRequestSourceDHWTank0NormalHeatingAvaible() { return m_requestSource_DHW_Tank0NormalHeatingAvaible; };
    /// este request source DHW instant user: burning/circulation-only request (circulation only when below DHW min-power) disponibil
    public boolean IsRequestSourceDHWInstantUserAvaible() { return m_requestSource_DHW_InstantUserAvaible; };
    /// este instal disponibil
    public boolean IsRequestInstalAvaible() { return m_requestInstalAvailable; };
    /// este request source none disponibil
    public boolean IsRequestSourceNoneAvaible() { return m_requestSource_NoneAvaible; };
    /// este request ModSetTemp valoare intreaga codata hex ascii disponibila
    public boolean IsRequestModSetTempAvaible() { return m_requestModSetTempAvaible; };
    /// este system major status operation mode disponibil
    public boolean IsSysMajorStatusOperationModeAvaible() { return m_sysMjStatus_OperationModeAvaible; };
    /// este system major status state disponibil
    public boolean IsSysMajorStatusStateAvaible(){ return m_sysMjStatus_StateAvaible; };
    /// este system major status errors disponibil
    public boolean IsSysMajorStatusCriticalErrorAvaible(){ return m_sysMjStatus_CriticalErrorAvaible; };
    public boolean IsSysMajorStatusNormalErrorAvaible(){ return m_sysMjStatus_NormalErrorAvaible; };
    public boolean IsSysMajorStatusInfoErrorAvaible(){ return m_sysMjStatus_InfoErrorAvaible; };
    /// este starea pompei boiler-ului disponibila
    public boolean IsExecElementsStatusTankPumpAvaible() { return m_execElementsStatus_TankPumpAvaible; };
    /// este starea pompei disponibil disponibila
    public boolean IsExecElementsStatusPumpAvaible() { return m_execElementsStatus_PumpAvaible; };
    /// este starea vanei cu trei cai disponibila
    public boolean IsExecElementsStatusThreeWayValveAvaible() { return m_execElementsStatus_ThreeWayValveAvaible; };
    /// este starea ventilatorului disponibila
    public boolean IsExecElementsStatusFanAvaible() { return m_execElementsStatus_FanAvaible; };
    /// este starea flacarii disponibila
    public boolean IsExecElementsStatusFlameAvaible() { return m_execElementsStatus_FlameAvaible; };
    /// este starea vanei de gaz disponibila
    public boolean IsExecElementsStatusGasValveAvaible() { return m_execElementsStatus_GasValveAvaible; };
    /// este starea comenzii pompei boilerului disponibila
    public boolean IsExecElementsCtrlTankPumpAvaible() { return m_execElementsCtrl_TankPumpAvaible; };
    /// este starea comenzii pompei disponibila
    public boolean IsExecElementsCtrlPumpAvaible() { return m_execElementsCtrl_PumpAvaible; };
    /// este starea comenzii vanei cu trei cai disponibila
    public boolean IsExecElementsCtrlThreeWayValveAvaible() { return m_execElementsCtrl_ThreeWayValveAvaible; };
    /// este starea comenzii ventilatorului disponibila
    public boolean IsExecElementsCtrlFanAvaible() { return m_execElementsCtrl_FanAvaible; };
    /// este starea comenzii circuitului de ignitie disponibila
    public boolean IsExecElementsCtrlFlameAvaible() { return m_execElementsCtrl_IgniterAvaible; };
    /// este starea comenzii vanei de gaz disponibila
    public boolean IsExecElementsCtrlGasValveAvaible() { return m_execElementsCtrl_GasValveAvaible; };
    /// este Temperatura masurata in vasul de acumulare – senzorul 2 disponibila
    public boolean IsQValTemperatureWaterTankS2Avaible() { return m_qVal_TWaterTankS2Avaible; };
    /// este Temperatura masurata in vasul de acumulare – senzorul 1 disponibila
    public boolean IsQValTemperatureWaterTankS1Avaible() { return m_qVal_TWaterTankS1Avaible; };
    /// este Temperatura masurata in exterior – atentie poate avea si valoare negativa disponibila
    public boolean IsQValTemperatureExteriorAvaible() { return  m_qVal_TExteriorAvaible; };
    /// returneaza Temperatura masurata a gazelor de evacuare disponibila
    public boolean IsQValTemperatureExhaustAvaible() { return m_qVal_TExhaustAvaible; };
    /// este Temperatura masurata pe circuitul de termoficare - retur disponibila
    public boolean IsQValTemperatureCHReturAvaible() { return m_qVal_TCHRAvaible; };
    /// este Temperatura masurata pe circuitul de termoficare - tur disponibila
    public boolean IsQValTemperatureCHFlowAvaible() { return m_qVal_TCHFlowAvaible; };
    /// este Temperatura masurata pe circuitul ACM disponibila
    public boolean IsQValTemperatureDHWAvaible() { return m_qVal_TDHWAvaible; };
    /// este Debitul masurat pe circuitul ACM disponibila
//	boolean IsQValFlowDHWAvaible() { return m_qVal_FlowDHWAvaible; };
    /// este Presiunea masurata in circuitul de incalzire disponibila
//	boolean IsQValPresureCHAvaible() { return m_qVal_PresureCHAvaible; };
    /// este Status of temp on water tank (2nd sensor) disponibil
//	boolean IsQStatusTemperatureWaterTankS2Avaible() { return m_qStatus_TWaterTankS2Avaible; };
    /// este Status of temp on water tank (1st sensor) disponibil
//	boolean IsQStatusTemperatureWaterTankS1Avaible() { return m_qStatus_TWaterTankS1Avaible; };
    /// este Status of temp from exterior disponibil
//	boolean IsQStatusTemperatureExteriorAvaible() { return m_qStatus_TExteriorAvaible; };
    /// este Status of temp on exhaust circuit disponibil
//	boolean IsQStatusTemperatureExhaustAvaible() { return m_qStatus_TExhaustAvaible; };
    /// este Status of temp on CH-return disponibil
//	boolean IsQStatusTemperatureCHReturAvaible() { return m_qStatus_TCHRAvaible; };
    /// este Status of temp on CH-turn disponibil
//	boolean IsQStatusTemperatureCHFlowAvaible() { return m_qStatus_TCHFlowAvaible; };
    /// este Status of temp on DHW disponibil
//	boolean IsQStatusTemperatureDHWAvaible() { return m_qStatus_TDHWAvaible; };
    /// este Status of water flow disponibil
//	boolean IsQStatusFlowDHWAvaible() { return m_qStatus_FlowDHWAvaible; };
    /// este Status of water pressure in CH circuit disponibil
//	boolean IsQStatusPresureCHAvaible() { return m_qStatus_PresureCHAvaible; };
    /// este sursa de validare pentru a porni incalzirea disponibila
    public boolean IsCHEnableInByAmbientTermostatAvaible(){ return m_cHeatingEnable_ByAmbientThermostatAvaible; };
    public boolean IsCHEnableInByAmbientCronostatAvaible(){ return m_cHeatingEnable_ByChronostatAvaible; };
    /// este comanda de modulare disponibila
    public boolean IsMCFanSetPwmAvaible(){ return m_mcFanSetPwmAvaible; };
    public boolean IsMCGValveSetPwmAvaible(){ return m_mcGValveSetPwmAvaible; };
    /// este feadback-ul de modulare disponibil
    public boolean IsMFFanSpeedAvaible(){ return m_mfFanSpeedAvaible; };
    public boolean IsMFGValveVoltageAvaible(){ return m_mfGValveVoltageAvaible; };
    public boolean IsMFFlameIonisationVoltageAvaible(){ return m_mfFlameIonisationVoltageAvaible; };
    /// este temperatura setata pe circuitul de termoficare disponibila
    public boolean IsUserSettingsTemperatureCHSetAvaible() { return m_userSettings_TCHSetAvaible; };
    /// este temperatura setata pe circuitul de ACM disponibila
    public boolean IsUserSettingsTemperatureDHWSetAvaible() { return m_userSettings_TDHWSetAvaible; };
    /// este season set disponibil
    public boolean IsUserSettingsSeasonsetAvaible() { return m_userSettings_SeasonSetAvaible; };
    /// este functia confort activa disponibila
    public boolean IsUserSettingsComfortActiveAvaible() { return m_userSettings_ComfortActiveAvaible; };
    /// este cronostat activ disponibil
    public boolean IsUserSettingsChronoActiveAvaible() { return m_userSettings_ChronoActiveAvaible; };
    /// este functia vacanta activa disponibila
    public boolean IsUserSettingsVacationActiveAvaible() { return m_userSettings_VacationActiveAvaible; };
    /// este temperatura ambientala setata, disponibila
    public boolean IsUserSettingsTemperatureAmbientSetAvaible() { return m_userSettings_TAMBSetAvaible; };
    /// este coeficientul de pierdere prin pereti,  disponibil
    public boolean IsUserSettingsCoefWallLossAvaible() { return m_userSettings_CoefWallLossAvaible; };
    /// este starea boilerului disponibila
    public boolean IsUserSettingsBoilerStatusAvaible() { return m_userSettings_BoilerStatusAvaible; };
    /// este lumina LCD activa disponibila
    public boolean IsUserSettingsLightActiveAvaible() { return m_userSettings_LightActiveAvaible; };
    /// este eeprom address disponibila

}
