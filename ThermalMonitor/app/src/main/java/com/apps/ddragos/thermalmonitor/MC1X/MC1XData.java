package com.apps.ddragos.thermalmonitor.MC1X;

@SuppressWarnings("ALL")
public class MC1XData extends MC1XDataH {

    public MC1XData() {
        init();
    }

    //constructor de copiere
    public MC1XData(MC1XData mData) {
        m_time = mData.m_time;

        m_boilerModel = mData.m_boilerModel;
        m_revision = mData.m_revision;
        m_numberOfMessages = mData.m_numberOfMessages;
        m_requestSource_DHW_AntiblocCirculation = mData.m_requestSource_DHW_AntiblocCirculation;
        m_requestSource_DHW_InstantComfort = mData.m_requestSource_DHW_InstantComfort;
        m_requestSource_CH_UserNormalHeating = mData.m_requestSource_CH_UserNormalHeating;
        m_requestSource_CH_AntifreezeHeating = mData.m_requestSource_CH_AntifreezeHeating;
        m_requestSource_DHW_Tank1NormalHeating = mData.m_requestSource_DHW_Tank1NormalHeating;
        m_requestSource_DHW_Tank1Antilegionela = mData.m_requestSource_DHW_Tank1Antilegionela;
        m_requestSource_DHW_Tank0NormalHeating = mData.m_requestSource_DHW_Tank0NormalHeating;
        m_requestSource_DHW_InstantUser = mData.m_requestSource_DHW_InstantUser;
        m_requestInstal = mData.m_requestInstal;
        m_requestSource_None = mData.m_requestSource_None;
        m_requestModSetTemp = mData.m_requestModSetTemp;
        m_sysMjStatus_OperationMode = mData.m_sysMjStatus_OperationMode;
        m_sysMjStatus_State = mData.m_sysMjStatus_State;
        m_sysMjStatus_CriticalError = mData.m_sysMjStatus_CriticalError;
        m_sysMjStatus_NormalError = mData.m_sysMjStatus_NormalError;
        m_sysMjStatus_InfoError = mData.m_sysMjStatus_InfoError;
        m_execElementsCtrl_GasValve = mData.m_execElementsCtrl_GasValve;
        m_execElementsCtrl_Igniter = mData.m_execElementsCtrl_Igniter;
        m_execElementsCtrl_Fan = mData.m_execElementsCtrl_Fan;
        m_execElementsCtrl_ThreeWayValve = mData.m_execElementsCtrl_ThreeWayValve;
        m_execElementsCtrl_Pump = mData.m_execElementsCtrl_Pump;
        m_execElementsCtrl_TankPump = mData.m_execElementsCtrl_TankPump;
        m_execElementsStatus_GasValve = mData.m_execElementsStatus_GasValve;
        m_execElementsStatus_Flame = mData.m_execElementsStatus_Flame;
        m_execElementsStatus_Fan = mData.m_execElementsStatus_Fan;
        m_execElementsStatus_ThreeWayValve = mData.m_execElementsStatus_ThreeWayValve;
        m_execElementsStatus_Pump = mData.m_execElementsStatus_Pump;
        m_execElementsStatus_TankPump = mData.m_execElementsStatus_TankPump;
        m_qVal_TWaterTankS2 = mData.m_qVal_TWaterTankS2;
        m_qVal_TWaterTankS1 = mData.m_qVal_TWaterTankS1;
        m_qVal_TExterior = mData.m_qVal_TExterior;
        m_qVal_TExhaust = mData.m_qVal_TExhaust;
        m_qVal_TCHR = mData.m_qVal_TCHR;
        m_qVal_TCHFlow = mData.m_qVal_TCHFlow;
        m_qVal_TDHW = mData.m_qVal_TDHW;
        m_qVal_FlowDHW = mData.m_qVal_FlowDHW;
        m_qVal_PresureCH = mData.m_qVal_PresureCH;
//	m_qStatus_TWaterTankS2 = data.m_qStatus_TWaterTankS2;
//	m_qStatus_TWaterTankS1 = data.m_qStatus_TWaterTankS1;
//	m_qStatus_TExterior = data.m_qStatus_TExterior;
//	m_qStatus_TExhaust = data.m_qStatus_TExhaust;
//	m_qStatus_TCHR = data.m_qStatus_TCHR;
//	m_qStatus_TCHFlow = data.m_qStatus_TCHFlow;
//	m_qStatus_TDHW = data.m_qStatus_TDHW;
//	m_qStatus_FlowDHW = data.m_qStatus_FlowDHW;
//	m_qStatus_PresureCH = data.m_qStatus_PresureCH;
        m_cHeatingEnable_ByAmbientThermostat = mData.m_cHeatingEnable_ByAmbientThermostat;
        m_cHeatingEnable_ByChronostat = mData.m_cHeatingEnable_ByChronostat;
        m_mcFanSetPwm = mData.m_mcFanSetPwm;
        m_mcGValveSetPwm = mData.m_mcGValveSetPwm;
        m_mfFanSpeed = mData.m_mfFanSpeed;
        m_mfGValveVoltage = mData.m_mfGValveVoltage;
        m_mfFlameIonisationVoltage = mData.m_mfFlameIonisationVoltage;
        m_userSettings_TCHSet = mData.m_userSettings_TCHSet;
        m_userSettings_TDHWSet = mData.m_userSettings_TDHWSet;
        m_userSettings_SeasonSet = mData.m_userSettings_SeasonSet;
        m_userSettings_ComfortActive = mData.m_userSettings_ComfortActive;
        m_userSettings_ChronoActive = mData.m_userSettings_ChronoActive;
        m_userSettings_VacationActive = mData.m_userSettings_VacationActive;
        m_userSettings_TAMBSet = mData.m_userSettings_TAMBSet;
        m_userSettings_CoefWallLoss = mData.m_userSettings_CoefWallLoss;
        m_userSettings_BoilerStatus = mData.m_userSettings_BoilerStatus;
        m_userSettings_LightActive = mData.m_userSettings_LightActive;

        m_timeAvaible = mData.m_timeAvaible;
        m_boilerModelAvaible = mData.m_boilerModelAvaible;
        m_revisionAvaible = mData.m_revisionAvaible;
        m_numberOfMessagesAvaible = mData.m_numberOfMessagesAvaible;
        m_requestSource_DHW_AntiblocCirculationAvaible = mData.m_requestSource_DHW_AntiblocCirculationAvaible;
        m_requestSource_DHW_InstantComfortAvaible = mData.m_requestSource_DHW_InstantComfortAvaible;
        m_requestSource_CH_UserNormalHeatingAvaible = mData.m_requestSource_CH_UserNormalHeatingAvaible;
        m_requestSource_CH_AntifreezeHeatingAvaible = mData.m_requestSource_CH_AntifreezeHeatingAvaible;
        m_requestSource_DHW_Tank1NormalHeatingAvaible = mData.m_requestSource_DHW_Tank1NormalHeatingAvaible;
        m_requestSource_DHW_Tank1AntilegionelaAvaible = mData.m_requestSource_DHW_Tank1AntilegionelaAvaible;
        m_requestSource_DHW_Tank0NormalHeatingAvaible = mData.m_requestSource_DHW_Tank0NormalHeatingAvaible;
        m_requestSource_DHW_InstantUserAvaible = mData.m_requestSource_DHW_InstantUserAvaible;
        m_requestInstalAvailable = mData.m_requestInstalAvailable;
        m_requestSource_NoneAvaible = mData.m_requestSource_NoneAvaible;
        m_requestModSetTempAvaible = mData.m_requestModSetTempAvaible;
        m_sysMjStatus_OperationModeAvaible = mData.m_sysMjStatus_OperationModeAvaible;
        m_sysMjStatus_StateAvaible = mData.m_sysMjStatus_StateAvaible;
        m_sysMjStatus_CriticalErrorAvaible = mData.m_sysMjStatus_CriticalErrorAvaible;
        m_sysMjStatus_NormalErrorAvaible = mData.m_sysMjStatus_NormalErrorAvaible;
        m_sysMjStatus_InfoErrorAvaible = mData.m_sysMjStatus_InfoErrorAvaible;
        m_execElementsCtrl_GasValveAvaible = mData.m_execElementsCtrl_GasValveAvaible;
        m_execElementsCtrl_IgniterAvaible = mData.m_execElementsCtrl_IgniterAvaible;
        m_execElementsCtrl_FanAvaible = mData.m_execElementsCtrl_FanAvaible;
        m_execElementsCtrl_ThreeWayValveAvaible = mData.m_execElementsCtrl_ThreeWayValveAvaible;
        m_execElementsCtrl_PumpAvaible = mData.m_execElementsCtrl_PumpAvaible;
        m_execElementsCtrl_TankPumpAvaible = mData.m_execElementsCtrl_TankPumpAvaible;
        m_execElementsCtrl_TankPumpAvaible = mData.m_execElementsCtrl_TankPumpAvaible;
        m_execElementsStatus_GasValveAvaible = mData.m_execElementsStatus_GasValveAvaible;
        m_execElementsStatus_FlameAvaible = mData.m_execElementsStatus_FlameAvaible;
        m_execElementsStatus_FanAvaible = mData.m_execElementsStatus_FanAvaible;
        m_execElementsStatus_ThreeWayValveAvaible = mData.m_execElementsStatus_ThreeWayValveAvaible;
        m_execElementsStatus_PumpAvaible = mData.m_execElementsStatus_PumpAvaible;
        m_execElementsStatus_TankPumpAvaible = mData.m_execElementsStatus_TankPumpAvaible;
        m_qVal_TWaterTankS2Avaible = mData.m_qVal_TWaterTankS2Avaible;
        m_qVal_TWaterTankS1Avaible = mData.m_qVal_TWaterTankS1Avaible;
        m_qVal_TExteriorAvaible = mData.m_qVal_TExteriorAvaible;
        m_qVal_TExhaustAvaible = mData.m_qVal_TExhaustAvaible;
        m_qVal_TCHRAvaible = mData.m_qVal_TCHRAvaible;
        m_qVal_TCHFlowAvaible = mData.m_qVal_TCHFlowAvaible;
        m_qVal_TDHWAvaible = mData.m_qVal_TDHWAvaible;
        m_qVal_FlowDHWAvaible = mData.m_qVal_FlowDHWAvaible;
        m_qVal_PresureCHAvaible = mData.m_qVal_PresureCHAvaible;
//	m_qStatus_TWaterTankS2Avaible = data.m_qStatus_TWaterTankS2Avaible;
//	m_qStatus_TWaterTankS1Avaible = data.m_qStatus_TWaterTankS1Avaible;
//	m_qStatus_TExteriorAvaible = data.m_qStatus_TExteriorAvaible;
//	m_qStatus_TExhaustAvaible = data.m_qStatus_TExhaustAvaible;
//	m_qStatus_TCHRAvaible = data.m_qStatus_TCHRAvaible;
//	m_qStatus_TCHFlowAvaible = data.m_qStatus_TCHFlowAvaible;
//	m_qStatus_TDHWAvaible = data.m_qStatus_TDHWAvaible;
//	m_qStatus_FlowDHWAvaible = data.m_qStatus_FlowDHWAvaible;
//	m_qStatus_PresureCHAvaible = data.m_qStatus_PresureCHAvaible;
        m_cHeatingEnable_ByAmbientThermostatAvaible = mData.m_cHeatingEnable_ByAmbientThermostatAvaible;
        m_cHeatingEnable_ByChronostatAvaible = mData.m_cHeatingEnable_ByChronostatAvaible;
        m_mcFanSetPwmAvaible = mData.m_mcFanSetPwmAvaible;
        m_mcGValveSetPwmAvaible = mData.m_mcGValveSetPwmAvaible;
        m_mfFanSpeedAvaible = mData.m_mfFanSpeedAvaible;
        m_mfGValveVoltageAvaible = mData.m_mfGValveVoltageAvaible;
        m_mfFlameIonisationVoltageAvaible = mData.m_mfFlameIonisationVoltageAvaible;
        m_userSettings_TCHSetAvaible = mData.m_userSettings_TCHSetAvaible;
        m_userSettings_TDHWSetAvaible = mData.m_userSettings_TDHWSetAvaible;
        m_userSettings_SeasonSetAvaible = mData.m_userSettings_SeasonSetAvaible;
        m_userSettings_ComfortActiveAvaible = mData.m_userSettings_ComfortActiveAvaible;
        m_userSettings_ChronoActiveAvaible = mData.m_userSettings_ChronoActiveAvaible;
        m_userSettings_VacationActiveAvaible = mData.m_userSettings_VacationActiveAvaible;
        m_userSettings_TAMBSetAvaible = mData.m_userSettings_TAMBSetAvaible;
        m_userSettings_CoefWallLossAvaible = mData.m_userSettings_CoefWallLossAvaible;
        m_userSettings_BoilerStatusAvaible = mData.m_userSettings_BoilerStatusAvaible;
        m_userSettings_LightActiveAvaible = mData.m_userSettings_LightActiveAvaible;


        m_dummyValue=mData.m_dummyValue;
    }

    void init()
    {
        m_time = VAL_NONE;

        m_boilerModel = VAL_NONE;
        m_revision = VAL_NONE;
        m_numberOfMessages = VAL_NONE;

        m_requestSource_DHW_AntiblocCirculation = VAL_NONE;
        m_requestSource_DHW_InstantComfort = VAL_NONE;
        m_requestSource_CH_UserNormalHeating = VAL_NONE;
        m_requestSource_CH_AntifreezeHeating = VAL_NONE;
        m_requestSource_DHW_Tank1NormalHeating = VAL_NONE;
        m_requestSource_DHW_Tank1Antilegionela = VAL_NONE;
        m_requestSource_DHW_Tank0NormalHeating = VAL_NONE;
        m_requestSource_DHW_InstantUser = VAL_NONE;
        m_requestInstal = VAL_NONE;
        m_requestSource_None = VAL_NONE;
        m_requestModSetTemp = VAL_NONE;
        m_sysMjStatus_OperationMode = VAL_NONE;
        m_sysMjStatus_State = VAL_NONE;
        m_sysMjStatus_CriticalError = VAL_NONE;
        m_sysMjStatus_NormalError = VAL_NONE;
        m_sysMjStatus_InfoError = VAL_NONE;
        m_execElementsCtrl_GasValve = VAL_NONE;
        m_execElementsCtrl_Igniter = VAL_NONE;
        m_execElementsCtrl_Fan = VAL_NONE;
        m_execElementsCtrl_ThreeWayValve = VAL_NONE;
        m_execElementsCtrl_Pump = VAL_NONE;
        m_execElementsCtrl_TankPump = VAL_NONE;
        m_execElementsStatus_GasValve = VAL_NONE;
        m_execElementsStatus_Flame = VAL_NONE;
        m_execElementsStatus_Fan = VAL_NONE;
        m_execElementsStatus_ThreeWayValve = VAL_NONE;
        m_execElementsStatus_Pump = VAL_NONE;
        m_execElementsStatus_TankPump = VAL_NONE;
        m_qVal_TWaterTankS2 = VAL_NONE;
        m_qVal_TWaterTankS1 = VAL_NONE;
        m_qVal_TExterior = VAL_NONE;
        m_qVal_TExhaust = VAL_NONE;
        m_qVal_TCHR = VAL_NONE;
        m_qVal_TCHFlow = VAL_NONE;
        m_qVal_TDHW = VAL_NONE;
        m_qVal_FlowDHW = VAL_NONE;
        m_qVal_PresureCH = VAL_NONE;
//	m_qStatus_TWaterTankS2 = VAL_NONE;
//	m_qStatus_TWaterTankS1 = VAL_NONE;
//	m_qStatus_TExterior = VAL_NONE;
//	m_qStatus_TExhaust = VAL_NONE;
//	m_qStatus_TCHR = VAL_NONE;
//	m_qStatus_TCHFlow = VAL_NONE;
//	m_qStatus_TDHW = VAL_NONE;
//	m_qStatus_FlowDHW = VAL_NONE;
//	m_qStatus_PresureCH = VAL_NONE;
        m_cHeatingEnable_ByAmbientThermostat = VAL_NONE;
        m_cHeatingEnable_ByChronostat = VAL_NONE;
        m_mcFanSetPwm = VAL_NONE;
        m_mcGValveSetPwm = VAL_NONE;
        m_mfFanSpeed = VAL_NONE;
        m_mfGValveVoltage = VAL_NONE;
        m_mfFlameIonisationVoltage = VAL_NONE;
        m_userSettings_TCHSet = VAL_NONE;
        m_userSettings_TDHWSet = VAL_NONE;
        m_userSettings_SeasonSet = VAL_NONE;
        m_userSettings_ComfortActive = VAL_NONE;
        m_userSettings_ChronoActive = VAL_NONE;
        m_userSettings_VacationActive = VAL_NONE;
        m_userSettings_TAMBSet = VAL_NONE;
        m_userSettings_CoefWallLoss = VAL_NONE;
        m_userSettings_BoilerStatus = VAL_NONE;
        m_userSettings_LightActive = VAL_NONE;

        m_timeAvaible = false;

        m_boilerModelAvaible = false;
        m_revisionAvaible = false;
        m_numberOfMessagesAvaible = false;
        m_requestSource_DHW_AntiblocCirculationAvaible = false;
        m_requestSource_DHW_InstantComfortAvaible = false;
        m_requestSource_CH_UserNormalHeatingAvaible = false;
        m_requestSource_CH_AntifreezeHeatingAvaible = false;
        m_requestSource_DHW_Tank1NormalHeatingAvaible = false;
        m_requestSource_DHW_Tank1AntilegionelaAvaible = false;
        m_requestSource_DHW_Tank0NormalHeatingAvaible = false;
        m_requestSource_DHW_InstantUserAvaible = false;
        m_requestInstalAvailable = false;
        m_requestSource_NoneAvaible = false;
        m_requestModSetTempAvaible = false;
        m_sysMjStatus_OperationModeAvaible = false;
        m_sysMjStatus_StateAvaible = false;
        m_sysMjStatus_CriticalErrorAvaible = false;
        m_sysMjStatus_NormalErrorAvaible = false;
        m_sysMjStatus_InfoErrorAvaible = false;
        m_execElementsCtrl_GasValveAvaible = false;
        m_execElementsCtrl_IgniterAvaible = false;
        m_execElementsCtrl_FanAvaible = false;
        m_execElementsCtrl_ThreeWayValveAvaible = false;
        m_execElementsCtrl_PumpAvaible = false;
        m_execElementsCtrl_TankPumpAvaible = false;
        m_execElementsCtrl_TankPumpAvaible = false;
        m_execElementsStatus_GasValveAvaible = false;
        m_execElementsStatus_FlameAvaible = false;
        m_execElementsStatus_FanAvaible = false;
        m_execElementsStatus_ThreeWayValveAvaible = false;
        m_execElementsStatus_PumpAvaible = false;
        m_execElementsStatus_TankPumpAvaible = false;
        m_qVal_TWaterTankS2Avaible = false;
        m_qVal_TWaterTankS1Avaible = false;
        m_qVal_TExteriorAvaible = false;
        m_qVal_TExhaustAvaible = false;
        m_qVal_TCHRAvaible = false;
        m_qVal_TCHFlowAvaible = false;
        m_qVal_TDHWAvaible = false;
        m_qVal_FlowDHWAvaible = false;
        m_qVal_PresureCHAvaible = false;
//	m_qStatus_TWaterTankS2Avaible = false;
//	m_qStatus_TWaterTankS1Avaible = false;
//	m_qStatus_TExteriorAvaible = false;
//	m_qStatus_TExhaustAvaible = false;
//	m_qStatus_TCHRAvaible = false;
//	m_qStatus_TCHFlowAvaible = false;
//	m_qStatus_TDHWAvaible = false;
//	m_qStatus_FlowDHWAvaible = false;
//	m_qStatus_PresureCHAvaible = false;
        m_cHeatingEnable_ByAmbientThermostatAvaible = false;
        m_cHeatingEnable_ByChronostatAvaible = false;
        m_mcFanSetPwmAvaible = false;
        m_mcGValveSetPwmAvaible = false;
        m_mfFanSpeedAvaible = false;
        m_mfGValveVoltageAvaible = false;
        m_mfFlameIonisationVoltageAvaible = false;
        m_userSettings_TCHSetAvaible = false;
        m_userSettings_TDHWSetAvaible = false;
        m_userSettings_SeasonSetAvaible = false;
        m_userSettings_ComfortActiveAvaible = false;
        m_userSettings_ChronoActiveAvaible = false;
        m_userSettings_VacationActiveAvaible = false;
        m_userSettings_TAMBSetAvaible = false;
        m_userSettings_CoefWallLossAvaible = false;
        m_userSettings_BoilerStatusAvaible = false;
        m_userSettings_LightActiveAvaible = false;

        m_dummyValue = VAL_NONE;
    }


    /*! \brief
*	functia care seteaza valoarea de time
*/
    void setTimeValue(double t)
    {
        m_time = t;
        m_timeAvaible = true;
    }

    /*! \brief
    *	seteaza modelul boilerului
    */
    void setBoilerModel(int value )
    {
        m_boilerModel = value;
        m_boilerModelAvaible = true;
    }

    /*! \brief
    *	seteaza revizia
    */
    void setRevision( int value )
    {
        m_revision = value;
        m_revisionAvaible = true;
    }

    /*! \brief
    *	seteaza numarul de mesaje receptionate
    */
    void setNumberOfMessages(int value )
    {
        m_numberOfMessages = value;
        m_numberOfMessagesAvaible = true;
    }

    /*! \brief
    *	seteaza sursele de ardere
    */
    void setRequest(int value )
    {
        int index = ( value >> 8 ) & 0x000000FF;
        int val = value & 0x000000FF;

        switch( index )
        {
            case 0://request source

                break;
            case 1:
                m_requestSource_None = 0&0x000000FF;
                m_requestSource_DHW_AntiblocCirculation =  val & 0x00000001;
                m_requestSource_DHW_InstantComfort = ( val >> 1 ) & 0x00000001;
                m_requestSource_CH_UserNormalHeating = ( val >> 2 ) & 0x00000001;
                m_requestSource_CH_AntifreezeHeating = ( val >> 3 ) & 0x00000001;
                m_requestSource_DHW_Tank1NormalHeating = ( val >> 4 ) & 0x00000001;
                m_requestSource_DHW_Tank1Antilegionela = ( val >> 5 ) & 0x00000001;
                m_requestSource_DHW_Tank0NormalHeating = ( val >> 6 ) & 0x00000001;
                m_requestSource_DHW_InstantUser = ( val >> 7 ) & 0x00000001;
                m_requestSource_NoneAvaible = true;
                m_requestSource_DHW_AntiblocCirculationAvaible = true;
                m_requestSource_DHW_InstantComfortAvaible = true;
                m_requestSource_CH_UserNormalHeatingAvaible = true;
                m_requestSource_CH_AntifreezeHeatingAvaible = true;
                m_requestSource_DHW_Tank1NormalHeatingAvaible = true;
                m_requestSource_DHW_Tank1AntilegionelaAvaible = true;
                m_requestSource_DHW_Tank0NormalHeatingAvaible = true;
                m_requestSource_DHW_InstantUserAvaible = true;
                break;
            case 2://request type
                m_requestInstal = val;
                m_requestInstalAvailable = true;
                break;
            case 3://REQUEST_ModSetTemp_B
                m_requestModSetTemp = val;
                m_requestModSetTempAvaible = true;
                break;
            default:
               break;
        }
    }

    /*! \brief
    *	set system major status
    */
    void setSystemMajorStatus(int value )
    {
        int index = ( value >> 8 ) & 0x000000FF;
        int val = value & 0x000000FF;

        switch( index )
        {
            case 0:
                m_sysMjStatus_OperationMode = val;
                m_sysMjStatus_OperationModeAvaible = true;
                break;
            case 1:
                m_sysMjStatus_State = val;
                m_sysMjStatus_StateAvaible = true;
                break;
            case 2:
                m_sysMjStatus_CriticalError = val;
                m_sysMjStatus_CriticalErrorAvaible = true;
                break;
            case 3:
                m_sysMjStatus_NormalError = val;
                m_sysMjStatus_NormalErrorAvaible = true;
                break;
            case 4:
                m_sysMjStatus_InfoError = val;
                m_sysMjStatus_InfoErrorAvaible = true;
                break;
            default:
                break;
        }
    }

    /*! \brief
    *	set execution elements
    */
    void setExecutionElements( int value )
    {
         int control = ( value >> 8 ) & 0x000000FF;
         int state = value & 0x000000FF;

        /// Pompa de apa boiler extern
        m_execElementsStatus_TankPump = state & 0x00000001;
        m_execElementsStatus_TankPumpAvaible =  true;
        m_execElementsCtrl_TankPump = control & 0x00000001;
        m_execElementsCtrl_TankPumpAvaible = true;
        ///Pompa de apa principala
        m_execElementsStatus_Pump = ( state >> 1 ) & 0x00000001;
        m_execElementsStatus_PumpAvaible = true;
        m_execElementsCtrl_Pump = ( control >> 1 ) & 0x00000001;
        m_execElementsCtrl_PumpAvaible = true;
        ///Vana cu trei cai
        m_execElementsStatus_ThreeWayValve = ( state >> 2 ) & 0x00000001;
        m_execElementsStatus_ThreeWayValveAvaible = true;
        m_execElementsCtrl_ThreeWayValve = ( control >> 2 ) & 0x00000001;
        m_execElementsCtrl_ThreeWayValveAvaible = true;
        ///Ventilator
        m_execElementsStatus_Fan = ( state >> 3 ) & 0x00000001;
        m_execElementsStatus_FanAvaible = true;
        m_execElementsCtrl_Fan = ( control >> 3 ) & 0x00000001;
        m_execElementsCtrl_FanAvaible = true;
        /// Prezenta flacara 2 biti !
        m_execElementsStatus_Flame = ( state >> 4 ) & 0x00000003;
        m_execElementsStatus_FlameAvaible = true;
        m_execElementsCtrl_Igniter = ( control >> 4 ) & 0x00000003;
        m_execElementsCtrl_IgniterAvaible = true;
        /// Vana de gaz 2 biti (cu aceeasi informatie) !
        m_execElementsStatus_GasValve = ( state >> 6 ) & 0x00000003;
        m_execElementsStatus_GasValveAvaible = true;
        m_execElementsCtrl_GasValve = ( control >> 6 ) & 0x00000003;
        m_execElementsCtrl_GasValveAvaible = true;
    }

    /*! \brief
    *	QV (sensors measurements: Quantities Values)
    */
    void setQuantiesValues(  int value )
    {
        int index = 0;
        int semn = 0;
        double val = 0.0;
        int valInt = 0x00000000;

        index = ( value >> 12 ) & 0x0000000F;
        semn = ( value >> 11 ) & 0x00000001;

        if( semn != 0)
        {
            valInt = ( value & 0x00000FFF ) | 0xFFFFF800;
        }
        else
        {
            valInt = ( value & 0x00000FFF ) & 0x000007FF;
        }
        val =  valInt / 10.0;
        switch( index )
        {
            case 0:// Presiunea masurata in circuitul de incalzire (doar octetul low) presiune * 10, (17 = 1.7 bar).
                m_qVal_PresureCH = val;
                m_qVal_PresureCHAvaible = true;
                break;
            case 1:// Debitul masurat pe circuitul ACM (doar octetul low). Debit * 10, 127 = 12,7 l/min).
                m_qVal_FlowDHW = val;
                m_qVal_FlowDHWAvaible = true;
                break;
            case 2:// Temperatura masurata pe circuitul ACM
                m_qVal_TDHW = val;
                m_qVal_TDHWAvaible = true;
                break;
            case 3:// Temperatura masurata pe circuitul de termoficare - tur
                m_qVal_TCHFlow = val;
                m_qVal_TCHFlowAvaible = true;
                break;
            case 4:// Temperatura masurata pe circuitul de termoficare - retur
                m_qVal_TCHR = val;
                m_qVal_TCHRAvaible = true;
                break;
            case 5:// Temperatura masurata a gazelor de evacuare
                m_qVal_TExhaust = val;
                m_qVal_TExhaustAvaible = true;
                break;
            case 6:// Temperatura masurata in exterio - atentie poate avea si valoare negativa
                m_qVal_TExterior = val;
                m_qVal_TExteriorAvaible = true;
                break;
            case 7:// Temperatura masurata in tancul de apa - senzorul 1
                m_qVal_TWaterTankS1 = val;
                m_qVal_TWaterTankS1Avaible = true;
                break;
            case 8:// Temperatura masurata in tancul de apa  - senzorul 2
                m_qVal_TWaterTankS2 = val;
                m_qVal_TWaterTankS2Avaible = true;
                break;
            default:
              //  AfxMessageBox("Unknown index of Quantities Values Vector" );
        }
    }

/*! \brief
*	QS (sensors measurements: Quantities Status)
*
void setQuantiesStatus(  int value )
{
	//Nota: Cu exceptia starii debitului, pentru celelalte stari interpretarea este urmatoarea:
	//1-starea este anormala/eronata , 0-starea este normala
	m_qStatus_TWaterTankS2 = value & 0x00000001;
	m_qStatus_TWaterTankS2Avaible = true;
	m_qStatus_TWaterTankS1 = ( value >> 1 ) & 0x00000001;
	m_qStatus_TWaterTankS1 = true;
	m_qStatus_TExterior = ( value >> 2 ) & 0x00000001;
	m_qStatus_TExteriorAvaible = true;
	m_qStatus_TExhaust = ( value >> 3 ) & 0x00000001;
	m_qStatus_TExhaustAvaible = true;
	m_qStatus_TCHR = ( value >> 4 ) & 0x00000001;
	m_qStatus_TCHRAvaible = true;
	m_qStatus_TCHFlow = ( value >> 5 ) & 0x00000001;
	m_qStatus_TCHFlowAvaible = true;
	m_qStatus_TDHW = ( value >> 6 ) & 0x00000001;
	m_qStatus_TDHWAvaible = true;
	m_qStatus_FlowDHW = ( value >> 7 ) & 0x00000001;
	m_qStatus_FlowDHWAvaible = true;
	m_qStatus_PresureCH = ( value >> 8 ) & 0x00000001;
	m_qStatus_PresureCHAvaible = true;
}/**/

    /*! \brief
    *	CE (Central-heating Enable inputs)
    *
    */
    void setCentralHeatingEnableInputs(  int value )
    {
        m_cHeatingEnable_ByAmbientThermostat = ( value >> 8 ) & 0x00000001;
        m_cHeatingEnable_ByAmbientThermostatAvaible = true;
        m_cHeatingEnable_ByChronostat = value & 0x00000001;
        m_cHeatingEnable_ByChronostatAvaible = true;
    }

    /*! \brief
    *	MC (Modulation Command[s])
    *
    */
    void setModulationCommand(  int value )
    {
        int index = 0;
        int val = 0;

        index = ( value >> 12 ) & 0x0000000F;
        val =  ( value & 0x00000FFF );
        switch( index )
        {
            case 0:
                m_mcFanSetPwm = val;
                m_mcFanSetPwmAvaible = true;
                break;
            case 1:
                m_mcGValveSetPwm = val;
                m_mcGValveSetPwmAvaible = true;
                break;
        }
    }

    /*! \brief
    *	MF (Modulation Feedback[s])
    *
    */
    void setModulationFeedback(int value)
    {
        int index = 0;
        int val = 0;

        index = ( value >> 12 ) & 0x0000000F;
        val =  ( value & 0x00000FFF );
        switch( index )
        {
            case 0:
                m_mfFanSpeed = val;
                m_mfFanSpeedAvaible = true;
                break;
            case 1:
                m_mfGValveVoltage = val / 100.0;
                m_mfGValveVoltageAvaible = true;
                break;
            case 2:
                m_mfFlameIonisationVoltage = val / 100.0;
                m_mfFlameIonisationVoltageAvaible = true;
                break;
        }
    }

    /*! \brief
    *	Mesajul de stare US
    *
    */
    void setUserSettings(  int value )
    {
         int index = 0;
         int data = 0;

        index = ( value >> 8 ) & 0x000000FF;
        data =  value & 0x000000FF;
        switch ( index )
        {
            case 0: // temperatura setata pe circuitul de termoficare
                m_userSettings_TCHSet = data;
                m_userSettings_TCHSetAvaible = true;
                break;
            case 1: // temperatura setata pe circuitul de ACM
                m_userSettings_TDHWSet = data;
                m_userSettings_TDHWSetAvaible = true;
                break;
            case 2: // season set: 1 winter; 0 summer
                m_userSettings_SeasonSet = data;
                m_userSettings_SeasonSetAvaible = true;
                break;
            case 3: // functia confort activa
                m_userSettings_ComfortActive = data;
                m_userSettings_ComfortActiveAvaible = true;
                break;
            case 4:	// cronostat activa
                m_userSettings_ChronoActive = data;
                m_userSettings_ChronoActiveAvaible = true;
                break;
            case 5: // functia vacanta activa
                m_userSettings_VacationActive = data;
                m_userSettings_VacationActiveAvaible = true;
                break;
            case 6: // starea boilerului
                m_userSettings_BoilerStatus = data;
                m_userSettings_BoilerStatusAvaible = true;
                break;
            case 7: // lumina LCD activa
                m_userSettings_LightActive = data;
                m_userSettings_LightActiveAvaible = true;
                break;
            case 8:	// temperatura ambientala setata nefolosit momentan
                m_userSettings_TAMBSet = data;
                m_userSettings_TAMBSetAvaible = true;
                break;
            case 9:	// coeficientul de pierdere prin pereti nefolosit momentan
                m_userSettings_CoefWallLoss = data / 10.0;
                m_userSettings_CoefWallLossAvaible = true;
                break;
        }
    }


    double getDataByTag(String dataName)
    {
/*00*/	if( dataName.equals("TIME"))
        return (double)m_time;
/*01*/	else if( dataName.equals("tDHWSET") )
        return (double)m_userSettings_TDHWSet;
/*02*/	else if( dataName.equals("tDHW") )
        return (double)m_qVal_TDHW;
/*03*/	else if( dataName.equals("tCHSET") )
        return (double)m_userSettings_TCHSet;
/*04*/	else if( dataName.equals("tCHFLOW") )
        return (double)m_qVal_TCHFlow;
/*05*/	else if( dataName.equals("tCHR") )
        return (double)m_qVal_TCHR;
/*06*/	else if( dataName.equals("tEXHAUST") )
        return (double)m_qVal_TExhaust;
/*07*/	else if( dataName.equals("tEXT") )
        return (double)m_qVal_TExterior;
/*08*/	else if( dataName.equals("tTANK") )
        return (double)m_qVal_TWaterTankS1;
/*09*/	else if( dataName.equals("DHWFLOW") )
        return (double)m_qVal_FlowDHW;
/*10*/	else if( dataName.equals("PRESURECH") )
        return (double)m_qVal_PresureCH;
/*11*/	else if( dataName.equals("FANsetPWM") )
        return (double)m_mcFanSetPwm;
/*12*/	else if( dataName.equals("FANSPEED") )
        return (double)m_mfFanSpeed;
/*13*/	else if( dataName.equals("IONISATION") )
        return (double)m_mfFlameIonisationVoltage;
/*14*/	else if( dataName.equals("OPMODE") )
        return (double)m_sysMjStatus_OperationMode;
/*15*/	else if( dataName.equals("STATUS") )
        return (double)m_sysMjStatus_State;
/*16*/	else if( dataName.equals("SEASON") )
        return (double)m_userSettings_SeasonSet;
/*17*/	else if( dataName.equals("cERR") )
        return (double)m_sysMjStatus_CriticalError;
/*18*/	else if( dataName.equals("nERR") )
        return (double)m_sysMjStatus_NormalError;
/*19*/	else if( dataName.equals("iERR") )
        return (double)m_sysMjStatus_InfoError;
/*20*/	else if( dataName.equals("egVALVE") )
        return (double)m_execElementsStatus_GasValve;
/*21*/	else if( dataName.equals("eFLAME") )
        return (double)m_execElementsStatus_Flame;
/*22*/	else if( dataName.equals("eFAN") )
        return (double)m_execElementsStatus_Fan;
/*23*/	else if( dataName.equals("e3VALVE") )
        return (double)m_execElementsStatus_ThreeWayValve;
/*24*/	else if( dataName.equals("ePUMP") )
        return (double)m_execElementsStatus_Pump;
/*25*/	else if( dataName.equals("eTPUMP") )
        return (double)m_execElementsStatus_TankPump;
/*26*/	else if( dataName.equals("usCOMF") )
        return (double)m_userSettings_ComfortActive;
/*27*/	else if( dataName.equals("usCRONO") )
        return (double)m_userSettings_ChronoActive;
/*28*/	else if( dataName.equals("usVACATION") )
        return (double)m_userSettings_VacationActive;
/*29*/	else if( dataName.equals("enByAMBT") )
        return (double)m_cHeatingEnable_ByAmbientThermostat;
/*30*/	else if( dataName.equals("enByCRONO") )
        return (double)m_cHeatingEnable_ByChronostat;
/*31*/	else if( dataName.equals("rANTIBLOC") )
        return (double)m_requestSource_DHW_AntiblocCirculation;
/*32*/	else if( dataName.equals("rDHWCOMF") )
        return (double)m_requestSource_DHW_InstantComfort;
/*33*/	else if( dataName.equals("rCHHEAT") )
        return (double)m_requestSource_CH_UserNormalHeating;
/*34*/	else if( dataName.equals("rCHAFREEZE") )
        return (double)m_requestSource_CH_AntifreezeHeating;
/*35*/	else if( dataName.equals("rT1HEAT") )
        return (double)m_requestSource_DHW_Tank1NormalHeating;
/*36*/	else if( dataName.equals("rT1ALEG") )
        return (double)m_requestSource_DHW_Tank1Antilegionela;
/*37*/	else if( dataName.equals("rT0HEAT") )
        return (double)m_requestSource_DHW_Tank0NormalHeating;
/*38*/	else if( dataName.equals("rDHWUSER") )
        return (double)m_requestSource_DHW_InstantUser;
/*39*/	else if( dataName.equals("rINSTAL") )
        return (double)m_requestInstal;
    else
        return m_dummyValue;
    }


    /*!	\brief
*	implementare operator - (folosit la calcularea diferentei dintre doua esantioane)
*/
    MC1XData difference(MC1XData data)
    {
        MC1XData result = new MC1XData();

        result.m_time = m_time - data.m_time;
        result.m_boilerModel = m_boilerModel - data.m_boilerModel;
        result.m_revision = m_revision - data.m_revision;
        result.m_numberOfMessages = m_numberOfMessages - data.m_numberOfMessages;
        result.m_requestSource_DHW_AntiblocCirculation = m_requestSource_DHW_AntiblocCirculation - data.m_requestSource_DHW_AntiblocCirculation;
        result.m_requestSource_DHW_InstantComfort = m_requestSource_DHW_InstantComfort - data.m_requestSource_DHW_InstantComfort;
        result.m_requestSource_CH_UserNormalHeating = m_requestSource_CH_UserNormalHeating - data.m_requestSource_CH_UserNormalHeating;
        result.m_requestSource_CH_AntifreezeHeating = m_requestSource_CH_AntifreezeHeating - data.m_requestSource_CH_AntifreezeHeating;
        result.m_requestSource_DHW_Tank1NormalHeating = m_requestSource_DHW_Tank1NormalHeating - data.m_requestSource_DHW_Tank1NormalHeating;
        result.m_requestSource_DHW_Tank1Antilegionela = m_requestSource_DHW_Tank1Antilegionela - data.m_requestSource_DHW_Tank1Antilegionela;
        result.m_requestSource_DHW_Tank0NormalHeating = m_requestSource_DHW_Tank0NormalHeating - data.m_requestSource_DHW_Tank0NormalHeating;
        result.m_requestSource_DHW_InstantUser = m_requestSource_DHW_InstantUser - data.m_requestSource_DHW_InstantUser;
        result.m_requestInstal = m_requestInstal - data.m_requestInstal;
        result.m_requestSource_None = m_requestSource_None - data.m_requestSource_None;
        result.m_requestModSetTemp = m_requestModSetTemp - data.m_requestModSetTemp;
        result.m_sysMjStatus_OperationMode = m_sysMjStatus_OperationMode - data.m_sysMjStatus_OperationMode;
        result.m_sysMjStatus_State = m_sysMjStatus_State - data.m_sysMjStatus_State;
        result.m_sysMjStatus_CriticalError = m_sysMjStatus_CriticalError - data.m_sysMjStatus_CriticalError;
        result.m_sysMjStatus_NormalError = m_sysMjStatus_NormalError - data.m_sysMjStatus_NormalError;
        result.m_sysMjStatus_InfoError = m_sysMjStatus_InfoError - data.m_sysMjStatus_InfoError;
        result.m_execElementsCtrl_GasValve = m_execElementsCtrl_GasValve - data.m_execElementsCtrl_GasValve;
        result.m_execElementsCtrl_Igniter = m_execElementsCtrl_Igniter - data.m_execElementsCtrl_Igniter;
        result.m_execElementsCtrl_Fan = m_execElementsCtrl_Fan - data.m_execElementsCtrl_Fan;
        result.m_execElementsCtrl_ThreeWayValve = m_execElementsCtrl_ThreeWayValve - data.m_execElementsCtrl_ThreeWayValve;
        result.m_execElementsCtrl_Pump = m_execElementsCtrl_Pump - data.m_execElementsCtrl_Pump;
        result.m_execElementsCtrl_TankPump = m_execElementsCtrl_TankPump - data.m_execElementsCtrl_TankPump;
        result.m_execElementsStatus_GasValve = m_execElementsStatus_GasValve - data.m_execElementsStatus_GasValve;
        result.m_execElementsStatus_Flame = m_execElementsStatus_Flame - data.m_execElementsStatus_Flame;
        result.m_execElementsStatus_Fan = m_execElementsStatus_Fan - data.m_execElementsStatus_Fan;
        result.m_execElementsStatus_ThreeWayValve = m_execElementsStatus_ThreeWayValve - data.m_execElementsStatus_ThreeWayValve;
        result.m_execElementsStatus_Pump = m_execElementsStatus_Pump - data.m_execElementsStatus_Pump;
        result.m_execElementsStatus_TankPump = m_execElementsStatus_TankPump - data.m_execElementsStatus_TankPump;
        result.m_qVal_TWaterTankS2 = m_qVal_TWaterTankS2 - data.m_qVal_TWaterTankS2;
        result.m_qVal_TWaterTankS1 = m_qVal_TWaterTankS1 - data.m_qVal_TWaterTankS1;
        result.m_qVal_TExterior = m_qVal_TExterior - data.m_qVal_TExterior;
        result.m_qVal_TExhaust = m_qVal_TExhaust - data.m_qVal_TExhaust;
        result.m_qVal_TCHR = m_qVal_TCHR - data.m_qVal_TCHR;
        result.m_qVal_TCHFlow = m_qVal_TCHFlow - data.m_qVal_TCHFlow;
        result.m_qVal_TDHW = m_qVal_TDHW - data.m_qVal_TDHW;
        result.m_qVal_FlowDHW = m_qVal_FlowDHW - data.m_qVal_FlowDHW;
        result.m_qVal_PresureCH = m_qVal_PresureCH - data.m_qVal_PresureCH;
//	result.m_qStatus_TWaterTankS2 = m_qStatus_TWaterTankS2 - data.m_qStatus_TWaterTankS2;
//	result.m_qStatus_TWaterTankS1 = m_qStatus_TWaterTankS1 - data.m_qStatus_TWaterTankS1;
//	result.m_qStatus_TExterior = m_qStatus_TExterior - data.m_qStatus_TExterior;
//	result.m_qStatus_TExhaust = m_qStatus_TExhaust - data.m_qStatus_TExhaust;
//	result.m_qStatus_TCHR = m_qStatus_TCHR - data.m_qStatus_TCHR;
//	result.m_qStatus_TCHFlow = m_qStatus_TCHFlow - data.m_qStatus_TCHFlow;
//	result.m_qStatus_TDHW = m_qStatus_TDHW - data.m_qStatus_TDHW;
//	result.m_qStatus_FlowDHW = m_qStatus_FlowDHW - data.m_qStatus_FlowDHW;
//	result.m_qStatus_PresureCH = m_qStatus_PresureCH - data.m_qStatus_PresureCH;
        result.m_cHeatingEnable_ByAmbientThermostat = m_cHeatingEnable_ByAmbientThermostat - data.m_cHeatingEnable_ByAmbientThermostat;
        result.m_cHeatingEnable_ByChronostat = m_cHeatingEnable_ByChronostat - data.m_cHeatingEnable_ByChronostat;
        result.m_mcFanSetPwm = m_mcFanSetPwm - data.m_mcFanSetPwm;
        result.m_mcGValveSetPwm = m_mcGValveSetPwm - data.m_mcGValveSetPwm;
        result.m_mfFanSpeed = m_mfFanSpeed - data.m_mfFanSpeed;
        result.m_mfGValveVoltage = m_mfGValveVoltage - data.m_mfGValveVoltage;
        result.m_mfFlameIonisationVoltage = m_mfFlameIonisationVoltage - data.m_mfFlameIonisationVoltage;
        result.m_userSettings_TCHSet = m_userSettings_TCHSet - data.m_userSettings_TCHSet;
        result.m_userSettings_TDHWSet = m_userSettings_TDHWSet - data.m_userSettings_TDHWSet;
        result.m_userSettings_SeasonSet = m_userSettings_SeasonSet - data.m_userSettings_SeasonSet;
        result.m_userSettings_ComfortActive = m_userSettings_ComfortActive - data.m_userSettings_ComfortActive;
        result.m_userSettings_ChronoActive = m_userSettings_ChronoActive - data.m_userSettings_ChronoActive;
        result.m_userSettings_VacationActive = m_userSettings_VacationActive - data.m_userSettings_VacationActive;
        result.m_userSettings_TAMBSet = m_userSettings_TAMBSet - data.m_userSettings_TAMBSet;
        result.m_userSettings_CoefWallLoss = m_userSettings_CoefWallLoss - data.m_userSettings_CoefWallLoss;
        result.m_userSettings_BoilerStatus = m_userSettings_BoilerStatus - data.m_userSettings_BoilerStatus;
        result.m_userSettings_LightActive = m_userSettings_LightActive - data.m_userSettings_LightActive;


        result.m_timeAvaible = m_timeAvaible ^ data.m_timeAvaible;
        result.m_boilerModelAvaible = m_boilerModelAvaible ^ data.m_boilerModelAvaible;
        result.m_revisionAvaible = m_revisionAvaible ^ data.m_revisionAvaible;
        result.m_numberOfMessagesAvaible = m_numberOfMessagesAvaible ^ data.m_numberOfMessagesAvaible;
        result.m_requestSource_DHW_AntiblocCirculationAvaible = m_requestSource_DHW_AntiblocCirculationAvaible ^ data.m_requestSource_DHW_AntiblocCirculationAvaible;
        result.m_requestSource_DHW_InstantComfortAvaible = m_requestSource_DHW_InstantComfortAvaible ^ data.m_requestSource_DHW_InstantComfortAvaible;
        result.m_requestSource_CH_UserNormalHeatingAvaible = m_requestSource_CH_UserNormalHeatingAvaible ^ data.m_requestSource_CH_UserNormalHeatingAvaible;
        result.m_requestSource_CH_AntifreezeHeatingAvaible = m_requestSource_CH_AntifreezeHeatingAvaible ^ data.m_requestSource_CH_AntifreezeHeatingAvaible;
        result.m_requestSource_DHW_Tank1NormalHeatingAvaible = m_requestSource_DHW_Tank1NormalHeatingAvaible ^ data.m_requestSource_DHW_Tank1NormalHeatingAvaible;
        result.m_requestSource_DHW_Tank1AntilegionelaAvaible = m_requestSource_DHW_Tank1AntilegionelaAvaible ^ data.m_requestSource_DHW_Tank1AntilegionelaAvaible;
        result.m_requestSource_DHW_Tank0NormalHeatingAvaible = m_requestSource_DHW_Tank0NormalHeatingAvaible ^ data.m_requestSource_DHW_Tank0NormalHeatingAvaible;
        result.m_requestSource_DHW_InstantUserAvaible = m_requestSource_DHW_InstantUserAvaible ^ data.m_requestSource_DHW_InstantUserAvaible;
        result.m_requestInstalAvailable = m_requestInstalAvailable ^ data.m_requestInstalAvailable;
        result.m_requestSource_NoneAvaible = m_requestSource_NoneAvaible ^ data.m_requestSource_NoneAvaible;
        result.m_requestModSetTempAvaible = m_requestModSetTempAvaible ^ data.m_requestModSetTempAvaible;
        result.m_sysMjStatus_OperationModeAvaible = m_sysMjStatus_OperationModeAvaible ^ data.m_sysMjStatus_OperationModeAvaible;
        result.m_sysMjStatus_StateAvaible = m_sysMjStatus_StateAvaible ^ data.m_sysMjStatus_StateAvaible;
        result.m_sysMjStatus_CriticalErrorAvaible = m_sysMjStatus_CriticalErrorAvaible ^ data.m_sysMjStatus_CriticalErrorAvaible;
        result.m_sysMjStatus_NormalErrorAvaible = m_sysMjStatus_NormalErrorAvaible ^ data.m_sysMjStatus_NormalErrorAvaible;
        result.m_sysMjStatus_InfoErrorAvaible = m_sysMjStatus_InfoErrorAvaible ^ data.m_sysMjStatus_InfoErrorAvaible;
        result.m_execElementsCtrl_GasValveAvaible = m_execElementsCtrl_GasValveAvaible ^ data.m_execElementsCtrl_GasValveAvaible;
        result.m_execElementsCtrl_IgniterAvaible = m_execElementsCtrl_IgniterAvaible ^ data.m_execElementsCtrl_IgniterAvaible;
        result.m_execElementsCtrl_FanAvaible = m_execElementsCtrl_FanAvaible ^ data.m_execElementsCtrl_FanAvaible;
        result.m_execElementsCtrl_ThreeWayValveAvaible = m_execElementsCtrl_ThreeWayValveAvaible ^ data.m_execElementsCtrl_ThreeWayValveAvaible;
        result.m_execElementsCtrl_PumpAvaible = m_execElementsCtrl_PumpAvaible ^ data.m_execElementsCtrl_PumpAvaible;
        result.m_execElementsCtrl_TankPumpAvaible = m_execElementsCtrl_TankPumpAvaible ^ data.m_execElementsCtrl_TankPumpAvaible;
        result.m_execElementsCtrl_TankPumpAvaible = m_execElementsCtrl_TankPumpAvaible ^ data.m_execElementsCtrl_TankPumpAvaible;
        result.m_execElementsStatus_GasValveAvaible = m_execElementsStatus_GasValveAvaible ^ data.m_execElementsStatus_GasValveAvaible;
        result.m_execElementsStatus_FlameAvaible = m_execElementsStatus_FlameAvaible ^ data.m_execElementsStatus_FlameAvaible;
        result.m_execElementsStatus_FanAvaible = m_execElementsStatus_FanAvaible ^ data.m_execElementsStatus_FanAvaible;
        result.m_execElementsStatus_ThreeWayValveAvaible = m_execElementsStatus_ThreeWayValveAvaible ^ data.m_execElementsStatus_ThreeWayValveAvaible;
        result.m_execElementsStatus_PumpAvaible = m_execElementsStatus_PumpAvaible ^ data.m_execElementsStatus_PumpAvaible;
        result.m_execElementsStatus_TankPumpAvaible = m_execElementsStatus_TankPumpAvaible ^ data.m_execElementsStatus_TankPumpAvaible;
        result.m_qVal_TWaterTankS2Avaible = m_qVal_TWaterTankS2Avaible ^ data.m_qVal_TWaterTankS2Avaible;
        result.m_qVal_TWaterTankS1Avaible = m_qVal_TWaterTankS1Avaible ^ data.m_qVal_TWaterTankS1Avaible;
        result.m_qVal_TExteriorAvaible = m_qVal_TExteriorAvaible ^ data.m_qVal_TExteriorAvaible;
        result.m_qVal_TExhaustAvaible = m_qVal_TExhaustAvaible ^ data.m_qVal_TExhaustAvaible;
        result.m_qVal_TCHRAvaible = m_qVal_TCHRAvaible ^ data.m_qVal_TCHRAvaible;
        result.m_qVal_TCHFlowAvaible = m_qVal_TCHFlowAvaible ^ data.m_qVal_TCHFlowAvaible;
        result.m_qVal_TDHWAvaible = m_qVal_TDHWAvaible ^ data.m_qVal_TDHWAvaible;
        result.m_qVal_FlowDHWAvaible = m_qVal_FlowDHWAvaible ^ data.m_qVal_FlowDHWAvaible;
        result.m_qVal_PresureCHAvaible = m_qVal_PresureCHAvaible ^ data.m_qVal_PresureCHAvaible;
//	result.m_qStatus_TWaterTankS2Avaible = m_qStatus_TWaterTankS2Avaible - data.m_qStatus_TWaterTankS2Avaible;
//	result.m_qStatus_TWaterTankS1Avaible = m_qStatus_TWaterTankS1Avaible - data.m_qStatus_TWaterTankS1Avaible;
//	result.m_qStatus_TExteriorAvaible = m_qStatus_TExteriorAvaible - data.m_qStatus_TExteriorAvaible;
//	result.m_qStatus_TExhaustAvaible = m_qStatus_TExhaustAvaible - data.m_qStatus_TExhaustAvaible;
//	result.m_qStatus_TCHRAvaible = m_qStatus_TCHRAvaible - data.m_qStatus_TCHRAvaible;
//	result.m_qStatus_TCHFlowAvaible = m_qStatus_TCHFlowAvaible - data.m_qStatus_TCHFlowAvaible;
//	result.m_qStatus_TDHWAvaible = m_qStatus_TDHWAvaible - data.m_qStatus_TDHWAvaible;
//	result.m_qStatus_FlowDHWAvaible = m_qStatus_FlowDHWAvaible - data.m_qStatus_FlowDHWAvaible;
//	result.m_qStatus_PresureCHAvaible = m_qStatus_PresureCHAvaible - data.m_qStatus_PresureCHAvaible;
        result.m_cHeatingEnable_ByAmbientThermostatAvaible = m_cHeatingEnable_ByAmbientThermostatAvaible ^ data.m_cHeatingEnable_ByAmbientThermostatAvaible;
        result.m_cHeatingEnable_ByChronostatAvaible = m_cHeatingEnable_ByChronostatAvaible ^ data.m_cHeatingEnable_ByChronostatAvaible;
        result.m_mcFanSetPwmAvaible = m_mcFanSetPwmAvaible ^ data.m_mcFanSetPwmAvaible;
        result.m_mcGValveSetPwmAvaible = m_mcGValveSetPwmAvaible ^ data.m_mcGValveSetPwmAvaible;
        result.m_mfFanSpeedAvaible = m_mfFanSpeedAvaible ^ data.m_mfFanSpeedAvaible;
        result.m_mfGValveVoltageAvaible = m_mfGValveVoltageAvaible ^ data.m_mfGValveVoltageAvaible;
        result.m_mfFlameIonisationVoltageAvaible = m_mfFlameIonisationVoltageAvaible ^ data.m_mfFlameIonisationVoltageAvaible;
        result.m_userSettings_TCHSetAvaible = m_userSettings_TCHSetAvaible ^ data.m_userSettings_TCHSetAvaible;
        result.m_userSettings_TDHWSetAvaible = m_userSettings_TDHWSetAvaible ^ data.m_userSettings_TDHWSetAvaible;
        result.m_userSettings_SeasonSetAvaible = m_userSettings_SeasonSetAvaible ^ data.m_userSettings_SeasonSetAvaible;
        result.m_userSettings_ComfortActiveAvaible = m_userSettings_ComfortActiveAvaible ^ data.m_userSettings_ComfortActiveAvaible;
        result.m_userSettings_ChronoActiveAvaible = m_userSettings_ChronoActiveAvaible ^ data.m_userSettings_ChronoActiveAvaible;
        result.m_userSettings_VacationActiveAvaible = m_userSettings_VacationActiveAvaible ^ data.m_userSettings_VacationActiveAvaible;
        result.m_userSettings_TAMBSetAvaible = m_userSettings_TAMBSetAvaible ^ data.m_userSettings_TAMBSetAvaible;
        result.m_userSettings_CoefWallLossAvaible = m_userSettings_CoefWallLossAvaible ^ data.m_userSettings_CoefWallLossAvaible;
        result.m_userSettings_BoilerStatusAvaible = m_userSettings_BoilerStatusAvaible ^ data.m_userSettings_BoilerStatusAvaible;
        result.m_userSettings_LightActiveAvaible = m_userSettings_LightActiveAvaible ^ data.m_userSettings_LightActiveAvaible;

        result.m_dummyValue = m_dummyValue - data.m_dummyValue;

        return result;
    }

    /*!	\brief
    *	implementare operator < (folosit la calcularea minimului dintre doua esantioane)
    */
    MC1XData minimum(MC1XData data)
    {
        MC1XData result = new MC1XData();

        result.m_time = (m_time < data.m_time)? m_time : data.m_time;
        result.m_boilerModel = (m_boilerModel < data.m_boilerModel)? m_boilerModel : data.m_boilerModel;
        result.m_revision = (m_revision < data.m_revision)? m_revision : data.m_revision;
        result.m_numberOfMessages = (m_numberOfMessages < data.m_numberOfMessages)? m_numberOfMessages : data.m_numberOfMessages;
        result.m_requestSource_DHW_AntiblocCirculation = (m_requestSource_DHW_AntiblocCirculation < data.m_requestSource_DHW_AntiblocCirculation)? m_requestSource_DHW_AntiblocCirculation : data.m_requestSource_DHW_AntiblocCirculation;
        result.m_requestSource_DHW_InstantComfort = (m_requestSource_DHW_InstantComfort < data.m_requestSource_DHW_InstantComfort)? m_requestSource_DHW_InstantComfort : data.m_requestSource_DHW_InstantComfort;
        result.m_requestSource_CH_UserNormalHeating = (m_requestSource_CH_UserNormalHeating < data.m_requestSource_CH_UserNormalHeating)? m_requestSource_CH_UserNormalHeating : data.m_requestSource_CH_UserNormalHeating;
        result.m_requestSource_CH_AntifreezeHeating = (m_requestSource_CH_AntifreezeHeating < data.m_requestSource_CH_AntifreezeHeating)? m_requestSource_CH_AntifreezeHeating : data.m_requestSource_CH_AntifreezeHeating;
        result.m_requestSource_DHW_Tank1NormalHeating = (m_requestSource_DHW_Tank1NormalHeating < data.m_requestSource_DHW_Tank1NormalHeating)? m_requestSource_DHW_Tank1NormalHeating : data.m_requestSource_DHW_Tank1NormalHeating;
        result.m_requestSource_DHW_Tank1Antilegionela = (m_requestSource_DHW_Tank1Antilegionela < data.m_requestSource_DHW_Tank1Antilegionela)? m_requestSource_DHW_Tank1Antilegionela : data.m_requestSource_DHW_Tank1Antilegionela;
        result.m_requestSource_DHW_Tank0NormalHeating = (m_requestSource_DHW_Tank0NormalHeating < data.m_requestSource_DHW_Tank0NormalHeating)? m_requestSource_DHW_Tank0NormalHeating : data.m_requestSource_DHW_Tank0NormalHeating;
        result.m_requestSource_DHW_InstantUser = (m_requestSource_DHW_InstantUser < data.m_requestSource_DHW_InstantUser)? m_requestSource_DHW_InstantUser : data.m_requestSource_DHW_InstantUser;
        result.m_requestInstal = (m_requestInstal < data.m_requestInstal)? m_requestInstal : data.m_requestInstal;
        result.m_requestSource_None = (m_requestSource_None < data.m_requestSource_None)? m_requestSource_None : data.m_requestSource_None;
        result.m_requestModSetTemp = (m_requestModSetTemp < data.m_requestModSetTemp)? m_requestModSetTemp : data.m_requestModSetTemp;
        result.m_sysMjStatus_OperationMode = (m_sysMjStatus_OperationMode < data.m_sysMjStatus_OperationMode)? m_sysMjStatus_OperationMode : data.m_sysMjStatus_OperationMode;
        result.m_sysMjStatus_State = (m_sysMjStatus_State < data.m_sysMjStatus_State)? m_sysMjStatus_State : data.m_sysMjStatus_State;
        result.m_sysMjStatus_CriticalError = (m_sysMjStatus_CriticalError < data.m_sysMjStatus_CriticalError)? m_sysMjStatus_CriticalError : data.m_sysMjStatus_CriticalError;
        result.m_sysMjStatus_NormalError = (m_sysMjStatus_NormalError < data.m_sysMjStatus_NormalError)? m_sysMjStatus_NormalError : data.m_sysMjStatus_NormalError;
        result.m_sysMjStatus_InfoError = (m_sysMjStatus_InfoError < data.m_sysMjStatus_InfoError)? m_sysMjStatus_InfoError : data.m_sysMjStatus_InfoError;
        result.m_execElementsCtrl_GasValve = (m_execElementsCtrl_GasValve < data.m_execElementsCtrl_GasValve)? m_execElementsCtrl_GasValve : data.m_execElementsCtrl_GasValve;
        result.m_execElementsCtrl_Igniter = (m_execElementsCtrl_Igniter < data.m_execElementsCtrl_Igniter)? m_execElementsCtrl_Igniter : data.m_execElementsCtrl_Igniter;
        result.m_execElementsCtrl_Fan = (m_execElementsCtrl_Fan < data.m_execElementsCtrl_Fan)? m_execElementsCtrl_Fan : data.m_execElementsCtrl_Fan;
        result.m_execElementsCtrl_ThreeWayValve = (m_execElementsCtrl_ThreeWayValve < data.m_execElementsCtrl_ThreeWayValve)? m_execElementsCtrl_ThreeWayValve : data.m_execElementsCtrl_ThreeWayValve;
        result.m_execElementsCtrl_Pump = (m_execElementsCtrl_Pump < data.m_execElementsCtrl_Pump)? m_execElementsCtrl_Pump : data.m_execElementsCtrl_Pump;
        result.m_execElementsCtrl_TankPump = (m_execElementsCtrl_TankPump < data.m_execElementsCtrl_TankPump)? m_execElementsCtrl_TankPump : data.m_execElementsCtrl_TankPump;
        result.m_execElementsStatus_GasValve = (m_execElementsStatus_GasValve < data.m_execElementsStatus_GasValve)? m_execElementsStatus_GasValve : data.m_execElementsStatus_GasValve;
        result.m_execElementsStatus_Flame = (m_execElementsStatus_Flame < data.m_execElementsStatus_Flame)? m_execElementsStatus_Flame : data.m_execElementsStatus_Flame;
        result.m_execElementsStatus_Fan = (m_execElementsStatus_Fan < data.m_execElementsStatus_Fan)? m_execElementsStatus_Fan : data.m_execElementsStatus_Fan;
        result.m_execElementsStatus_ThreeWayValve = (m_execElementsStatus_ThreeWayValve < data.m_execElementsStatus_ThreeWayValve)? m_execElementsStatus_ThreeWayValve : data.m_execElementsStatus_ThreeWayValve;
        result.m_execElementsStatus_Pump = (m_execElementsStatus_Pump < data.m_execElementsStatus_Pump)? m_execElementsStatus_Pump : data.m_execElementsStatus_Pump;
        result.m_execElementsStatus_TankPump = (m_execElementsStatus_TankPump < data.m_execElementsStatus_TankPump)? m_execElementsStatus_TankPump : data.m_execElementsStatus_TankPump;
        result.m_qVal_TWaterTankS2 = (m_qVal_TWaterTankS2 < data.m_qVal_TWaterTankS2)? m_qVal_TWaterTankS2 : data.m_qVal_TWaterTankS2;
        result.m_qVal_TWaterTankS1 = (m_qVal_TWaterTankS1 < data.m_qVal_TWaterTankS1)? m_qVal_TWaterTankS1 : data.m_qVal_TWaterTankS1;
        result.m_qVal_TExterior = (m_qVal_TExterior < data.m_qVal_TExterior)? m_qVal_TExterior : data.m_qVal_TExterior;
        result.m_qVal_TExhaust = (m_qVal_TExhaust < data.m_qVal_TExhaust)? m_qVal_TExhaust : data.m_qVal_TExhaust;
        result.m_qVal_TCHR = (m_qVal_TCHR < data.m_qVal_TCHR)? m_qVal_TCHR : data.m_qVal_TCHR;
        result.m_qVal_TCHFlow = (m_qVal_TCHFlow < data.m_qVal_TCHFlow)? m_qVal_TCHFlow : data.m_qVal_TCHFlow;
        result.m_qVal_TDHW = (m_qVal_TDHW < data.m_qVal_TDHW)? m_qVal_TDHW : data.m_qVal_TDHW;
        result.m_qVal_FlowDHW = (m_qVal_FlowDHW < data.m_qVal_FlowDHW)? m_qVal_FlowDHW : data.m_qVal_FlowDHW;
        result.m_qVal_PresureCH = (m_qVal_PresureCH < data.m_qVal_PresureCH)? m_qVal_PresureCH : data.m_qVal_PresureCH;
        //	result.m_qStatus_TWaterTankS2 = m_qStatus_TWaterTankS2 - data.m_qStatus_TWaterTankS2;
        //	result.m_qStatus_TWaterTankS1 = m_qStatus_TWaterTankS1 - data.m_qStatus_TWaterTankS1;
        //	result.m_qStatus_TExterior = m_qStatus_TExterior - data.m_qStatus_TExterior;
        //	result.m_qStatus_TExhaust = m_qStatus_TExhaust - data.m_qStatus_TExhaust;
        //	result.m_qStatus_TCHR = m_qStatus_TCHR - data.m_qStatus_TCHR;
        //	result.m_qStatus_TCHFlow = m_qStatus_TCHFlow - data.m_qStatus_TCHFlow;
        //	result.m_qStatus_TDHW = m_qStatus_TDHW - data.m_qStatus_TDHW;
        //	result.m_qStatus_FlowDHW = m_qStatus_FlowDHW - data.m_qStatus_FlowDHW;
        //	result.m_qStatus_PresureCH = m_qStatus_PresureCH - data.m_qStatus_PresureCH;
        result.m_cHeatingEnable_ByAmbientThermostat = (m_cHeatingEnable_ByAmbientThermostat < data.m_cHeatingEnable_ByAmbientThermostat)? m_cHeatingEnable_ByAmbientThermostat : data.m_cHeatingEnable_ByAmbientThermostat;
        result.m_cHeatingEnable_ByChronostat = (m_cHeatingEnable_ByChronostat < data.m_cHeatingEnable_ByChronostat)? m_cHeatingEnable_ByChronostat : data.m_cHeatingEnable_ByChronostat;
        result.m_mcFanSetPwm = (m_mcFanSetPwm < data.m_mcFanSetPwm)? m_mcFanSetPwm : data.m_mcFanSetPwm;
        result.m_mcGValveSetPwm = (m_mcGValveSetPwm < data.m_mcGValveSetPwm)? m_mcGValveSetPwm : data.m_mcGValveSetPwm;
        result.m_mfFanSpeed = (m_mfFanSpeed < data.m_mfFanSpeed)? m_mfFanSpeed : data.m_mfFanSpeed;
        result.m_mfGValveVoltage = (m_mfGValveVoltage < data.m_mfGValveVoltage)? m_mfGValveVoltage : data.m_mfGValveVoltage;
        result.m_mfFlameIonisationVoltage = (m_mfFlameIonisationVoltage < data.m_mfFlameIonisationVoltage)? m_mfFlameIonisationVoltage : data.m_mfFlameIonisationVoltage;
        result.m_userSettings_TCHSet = (m_userSettings_TCHSet < data.m_userSettings_TCHSet)? m_userSettings_TCHSet : data.m_userSettings_TCHSet;
        result.m_userSettings_TDHWSet = (m_userSettings_TDHWSet < data.m_userSettings_TDHWSet)? m_userSettings_TDHWSet : data.m_userSettings_TDHWSet;
        result.m_userSettings_SeasonSet = (m_userSettings_SeasonSet < data.m_userSettings_SeasonSet)? m_userSettings_SeasonSet : data.m_userSettings_SeasonSet;
        result.m_userSettings_ComfortActive = (m_userSettings_ComfortActive < data.m_userSettings_ComfortActive)? m_userSettings_ComfortActive : data.m_userSettings_ComfortActive;
        result.m_userSettings_ChronoActive = (m_userSettings_ChronoActive < data.m_userSettings_ChronoActive)? m_userSettings_ChronoActive : data.m_userSettings_ChronoActive;
        result.m_userSettings_VacationActive = (m_userSettings_VacationActive < data.m_userSettings_VacationActive)? m_userSettings_VacationActive : data.m_userSettings_VacationActive;
        result.m_userSettings_TAMBSet = (m_userSettings_TAMBSet < data.m_userSettings_TAMBSet)? m_userSettings_TAMBSet : data.m_userSettings_TAMBSet;
        result.m_userSettings_CoefWallLoss = (m_userSettings_CoefWallLoss < data.m_userSettings_CoefWallLoss)? m_userSettings_CoefWallLoss : data.m_userSettings_CoefWallLoss;
        result.m_userSettings_BoilerStatus = (m_userSettings_BoilerStatus < data.m_userSettings_BoilerStatus)? m_userSettings_BoilerStatus : data.m_userSettings_BoilerStatus;
        result.m_userSettings_LightActive = (m_userSettings_LightActive < data.m_userSettings_LightActive)? m_userSettings_LightActive : data.m_userSettings_LightActive;

        result.m_timeAvaible = (result.m_time != VAL_NONE)? true:false;
        result.m_boilerModelAvaible = (result.m_boilerModel != VAL_NONE)? true:false;
        result.m_revisionAvaible = (result.m_revision != VAL_NONE)? true:false;
        result.m_numberOfMessagesAvaible = (result.m_numberOfMessages != VAL_NONE)? true:false;
        result.m_requestSource_DHW_AntiblocCirculationAvaible = (result.m_requestSource_DHW_AntiblocCirculation != VAL_NONE)? true:false;
        result.m_requestSource_DHW_InstantComfortAvaible = (result.m_requestSource_DHW_InstantComfort != VAL_NONE)? true:false;
        result.m_requestSource_CH_UserNormalHeatingAvaible = (result.m_requestSource_CH_UserNormalHeating != VAL_NONE)? true:false;
        result.m_requestSource_CH_AntifreezeHeatingAvaible = (result.m_requestSource_CH_AntifreezeHeating != VAL_NONE)? true:false;
        result.m_requestSource_DHW_Tank1NormalHeatingAvaible = (result.m_requestSource_DHW_Tank1NormalHeating != VAL_NONE)? true:false;
        result.m_requestSource_DHW_Tank1AntilegionelaAvaible = (result.m_requestSource_DHW_Tank1Antilegionela != VAL_NONE)? true:false;
        result.m_requestSource_DHW_Tank0NormalHeatingAvaible = (result.m_requestSource_DHW_Tank0NormalHeating != VAL_NONE)? true:false;
        result.m_requestSource_DHW_InstantUserAvaible = (result.m_requestSource_DHW_InstantUser != VAL_NONE)? true:false;
        result.m_requestInstalAvailable = (result.m_requestInstal != VAL_NONE)? true:false;
        result.m_requestSource_NoneAvaible = (result.m_requestSource_None != VAL_NONE)? true:false;
        result.m_requestModSetTempAvaible = (result.m_requestModSetTemp != VAL_NONE)? true:false;
        result.m_sysMjStatus_OperationModeAvaible = (result.m_sysMjStatus_OperationMode != VAL_NONE)? true:false;
        result.m_sysMjStatus_StateAvaible = (result.m_sysMjStatus_State != VAL_NONE)? true:false;
        result.m_sysMjStatus_CriticalErrorAvaible = (result.m_sysMjStatus_CriticalError != VAL_NONE)? true:false;
        result.m_sysMjStatus_NormalErrorAvaible = (result.m_sysMjStatus_NormalError != VAL_NONE)? true:false;
        result.m_sysMjStatus_InfoErrorAvaible = (result.m_sysMjStatus_InfoError != VAL_NONE)? true:false;
        result.m_execElementsCtrl_GasValveAvaible = (result.m_execElementsCtrl_GasValve != VAL_NONE)? true:false;
        result.m_execElementsCtrl_IgniterAvaible = (result.m_execElementsCtrl_Igniter != VAL_NONE)? true:false;
        result.m_execElementsCtrl_FanAvaible = (result.m_execElementsCtrl_Fan != VAL_NONE)? true:false;
        result.m_execElementsCtrl_ThreeWayValveAvaible = (result.m_execElementsCtrl_ThreeWayValve != VAL_NONE)? true:false;
        result.m_execElementsCtrl_PumpAvaible = (result.m_execElementsCtrl_Pump != VAL_NONE)? true:false;
        result.m_execElementsCtrl_TankPumpAvaible = (result.m_execElementsCtrl_TankPump != VAL_NONE)? true:false;
        result.m_execElementsStatus_GasValveAvaible = (result.m_execElementsStatus_GasValve != VAL_NONE)? true:false;
        result.m_execElementsStatus_FlameAvaible = (result.m_execElementsStatus_Flame != VAL_NONE)? true:false;
        result.m_execElementsStatus_FanAvaible = (result.m_execElementsStatus_Fan != VAL_NONE)? true:false;
        result.m_execElementsStatus_ThreeWayValveAvaible = (result.m_execElementsStatus_ThreeWayValve != VAL_NONE)? true:false;
        result.m_execElementsStatus_PumpAvaible = (result.m_execElementsStatus_Pump != VAL_NONE)? true:false;
        result.m_execElementsStatus_TankPumpAvaible = (result.m_execElementsStatus_TankPump != VAL_NONE)? true:false;
        result.m_qVal_TWaterTankS2Avaible = (result.m_qVal_TWaterTankS2 != VAL_NONE)? true:false;
        result.m_qVal_TWaterTankS1Avaible = (result.m_qVal_TWaterTankS1 != VAL_NONE)? true:false;
        result.m_qVal_TExteriorAvaible = (result.m_qVal_TExterior != VAL_NONE)? true:false;
        result.m_qVal_TExhaustAvaible = (result.m_qVal_TExhaust != VAL_NONE)? true:false;
        result.m_qVal_TCHRAvaible = (result.m_qVal_TCHR != VAL_NONE)? true:false;
        result.m_qVal_TCHFlowAvaible = (result.m_qVal_TCHFlow != VAL_NONE)? true:false;
        result.m_qVal_TDHWAvaible = (result.m_qVal_TDHW != VAL_NONE)? true:false;
        result.m_qVal_FlowDHWAvaible = (result.m_qVal_FlowDHW != VAL_NONE)? true:false;
        result.m_qVal_PresureCHAvaible = (result.m_qVal_PresureCH != VAL_NONE)? true:false;
        //	result.m_qStatus_TWaterTankS2Avaible = m_qStatus_TWaterTankS2Avaible - data.m_qStatus_TWaterTankS2Avaible;
        //	result.m_qStatus_TWaterTankS1Avaible = m_qStatus_TWaterTankS1Avaible - data.m_qStatus_TWaterTankS1Avaible;
        //	result.m_qStatus_TExteriorAvaible = m_qStatus_TExteriorAvaible - data.m_qStatus_TExteriorAvaible;
        //	result.m_qStatus_TExhaustAvaible = m_qStatus_TExhaustAvaible - data.m_qStatus_TExhaustAvaible;
        //	result.m_qStatus_TCHRAvaible = m_qStatus_TCHRAvaible - data.m_qStatus_TCHRAvaible;
        //	result.m_qStatus_TCHFlowAvaible = m_qStatus_TCHFlowAvaible - data.m_qStatus_TCHFlowAvaible;
        //	result.m_qStatus_TDHWAvaible = m_qStatus_TDHWAvaible - data.m_qStatus_TDHWAvaible;
        //	result.m_qStatus_FlowDHWAvaible = m_qStatus_FlowDHWAvaible - data.m_qStatus_FlowDHWAvaible;
        //	result.m_qStatus_PresureCHAvaible = m_qStatus_PresureCHAvaible - data.m_qStatus_PresureCHAvaible;
        result.m_cHeatingEnable_ByAmbientThermostatAvaible = (result.m_cHeatingEnable_ByAmbientThermostat != VAL_NONE)? true:false;
        result.m_cHeatingEnable_ByChronostatAvaible = (result.m_cHeatingEnable_ByChronostat != VAL_NONE)? true:false;
        result.m_mcFanSetPwmAvaible = (result.m_mcFanSetPwm != VAL_NONE)? true:false;
        result.m_mcGValveSetPwmAvaible = (result.m_mcGValveSetPwm != VAL_NONE)? true:false;
        result.m_mfFanSpeedAvaible = (result.m_mfFanSpeed != VAL_NONE)? true:false;
        result.m_mfGValveVoltageAvaible = (result.m_mfGValveVoltage != VAL_NONE)? true:false;
        result.m_mfFlameIonisationVoltageAvaible = (result.m_mfFlameIonisationVoltage != VAL_NONE)? true:false;
        result.m_userSettings_TCHSetAvaible = (result.m_userSettings_TCHSet != VAL_NONE)? true:false;
        result.m_userSettings_TDHWSetAvaible = (result.m_userSettings_TDHWSet != VAL_NONE)? true:false;
        result.m_userSettings_SeasonSetAvaible = (result.m_userSettings_SeasonSet != VAL_NONE)? true:false;
        result.m_userSettings_ComfortActiveAvaible = (result.m_userSettings_ComfortActive != VAL_NONE)? true:false;
        result.m_userSettings_ChronoActiveAvaible = (result.m_userSettings_ChronoActive != VAL_NONE)? true:false;
        result.m_userSettings_VacationActiveAvaible = (result.m_userSettings_VacationActive != VAL_NONE)? true:false;
        result.m_userSettings_TAMBSetAvaible = (result.m_userSettings_TAMBSet != VAL_NONE)? true:false;
        result.m_userSettings_CoefWallLossAvaible = (result.m_userSettings_CoefWallLoss != VAL_NONE)? true:false;
        result.m_userSettings_BoilerStatusAvaible = (result.m_userSettings_BoilerStatus != VAL_NONE)? true:false;
        result.m_userSettings_LightActiveAvaible = (result.m_userSettings_LightActive != VAL_NONE)? true:false;


        result.m_dummyValue = (m_dummyValue < data.m_dummyValue)? m_dummyValue : data.m_dummyValue;

        return result;
    }

    /*!	\brief
    *	implementare operator > (folosit la calcularea maximului dintre doua esantioane)
    */
    MC1XData maximum(MC1XData data)
    {
        MC1XData result = new MC1XData();

        result.m_time = (m_time > data.m_time)? m_time : data.m_time;
        result.m_boilerModel = (m_boilerModel > data.m_boilerModel)? m_boilerModel : data.m_boilerModel;
        result.m_revision = (m_revision > data.m_revision)? m_revision : data.m_revision;
        result.m_numberOfMessages = (m_numberOfMessages > data.m_numberOfMessages)? m_numberOfMessages : data.m_numberOfMessages;
        result.m_requestSource_DHW_AntiblocCirculation = (m_requestSource_DHW_AntiblocCirculation > data.m_requestSource_DHW_AntiblocCirculation)? m_requestSource_DHW_AntiblocCirculation : data.m_requestSource_DHW_AntiblocCirculation;
        result.m_requestSource_DHW_InstantComfort = (m_requestSource_DHW_InstantComfort > data.m_requestSource_DHW_InstantComfort)? m_requestSource_DHW_InstantComfort : data.m_requestSource_DHW_InstantComfort;
        result.m_requestSource_CH_UserNormalHeating = (m_requestSource_CH_UserNormalHeating > data.m_requestSource_CH_UserNormalHeating)? m_requestSource_CH_UserNormalHeating : data.m_requestSource_CH_UserNormalHeating;
        result.m_requestSource_CH_AntifreezeHeating = (m_requestSource_CH_AntifreezeHeating > data.m_requestSource_CH_AntifreezeHeating)? m_requestSource_CH_AntifreezeHeating : data.m_requestSource_CH_AntifreezeHeating;
        result.m_requestSource_DHW_Tank1NormalHeating = (m_requestSource_DHW_Tank1NormalHeating > data.m_requestSource_DHW_Tank1NormalHeating)? m_requestSource_DHW_Tank1NormalHeating : data.m_requestSource_DHW_Tank1NormalHeating;
        result.m_requestSource_DHW_Tank1Antilegionela = (m_requestSource_DHW_Tank1Antilegionela > data.m_requestSource_DHW_Tank1Antilegionela)? m_requestSource_DHW_Tank1Antilegionela : data.m_requestSource_DHW_Tank1Antilegionela;
        result.m_requestSource_DHW_Tank0NormalHeating = (m_requestSource_DHW_Tank0NormalHeating > data.m_requestSource_DHW_Tank0NormalHeating)? m_requestSource_DHW_Tank0NormalHeating : data.m_requestSource_DHW_Tank0NormalHeating;
        result.m_requestSource_DHW_InstantUser = (m_requestSource_DHW_InstantUser > data.m_requestSource_DHW_InstantUser)? m_requestSource_DHW_InstantUser : data.m_requestSource_DHW_InstantUser;
        result.m_requestInstal = (m_requestInstal > data.m_requestInstal)? m_requestInstal : data.m_requestInstal;
        result.m_requestSource_None = (m_requestSource_None > data.m_requestSource_None)? m_requestSource_None : data.m_requestSource_None;
        result.m_requestModSetTemp = (m_requestModSetTemp > data.m_requestModSetTemp)? m_requestModSetTemp : data.m_requestModSetTemp;
        result.m_sysMjStatus_OperationMode = (m_sysMjStatus_OperationMode > data.m_sysMjStatus_OperationMode)? m_sysMjStatus_OperationMode : data.m_sysMjStatus_OperationMode;
        result.m_sysMjStatus_State = (m_sysMjStatus_State > data.m_sysMjStatus_State)? m_sysMjStatus_State : data.m_sysMjStatus_State;
        result.m_sysMjStatus_CriticalError = (m_sysMjStatus_CriticalError > data.m_sysMjStatus_CriticalError)? m_sysMjStatus_CriticalError : data.m_sysMjStatus_CriticalError;
        result.m_sysMjStatus_NormalError = (m_sysMjStatus_NormalError > data.m_sysMjStatus_NormalError)? m_sysMjStatus_NormalError : data.m_sysMjStatus_NormalError;
        result.m_sysMjStatus_InfoError = (m_sysMjStatus_InfoError > data.m_sysMjStatus_InfoError)? m_sysMjStatus_InfoError : data.m_sysMjStatus_InfoError;
        result.m_execElementsCtrl_GasValve = (m_execElementsCtrl_GasValve > data.m_execElementsCtrl_GasValve)? m_execElementsCtrl_GasValve : data.m_execElementsCtrl_GasValve;
        result.m_execElementsCtrl_Igniter = (m_execElementsCtrl_Igniter > data.m_execElementsCtrl_Igniter)? m_execElementsCtrl_Igniter : data.m_execElementsCtrl_Igniter;
        result.m_execElementsCtrl_Fan = (m_execElementsCtrl_Fan > data.m_execElementsCtrl_Fan)? m_execElementsCtrl_Fan : data.m_execElementsCtrl_Fan;
        result.m_execElementsCtrl_ThreeWayValve = (m_execElementsCtrl_ThreeWayValve > data.m_execElementsCtrl_ThreeWayValve)? m_execElementsCtrl_ThreeWayValve : data.m_execElementsCtrl_ThreeWayValve;
        result.m_execElementsCtrl_Pump = (m_execElementsCtrl_Pump > data.m_execElementsCtrl_Pump)? m_execElementsCtrl_Pump : data.m_execElementsCtrl_Pump;
        result.m_execElementsCtrl_TankPump = (m_execElementsCtrl_TankPump > data.m_execElementsCtrl_TankPump)? m_execElementsCtrl_TankPump : data.m_execElementsCtrl_TankPump;
        result.m_execElementsStatus_GasValve = (m_execElementsStatus_GasValve > data.m_execElementsStatus_GasValve)? m_execElementsStatus_GasValve : data.m_execElementsStatus_GasValve;
        result.m_execElementsStatus_Flame = (m_execElementsStatus_Flame > data.m_execElementsStatus_Flame)? m_execElementsStatus_Flame : data.m_execElementsStatus_Flame;
        result.m_execElementsStatus_Fan = (m_execElementsStatus_Fan > data.m_execElementsStatus_Fan)? m_execElementsStatus_Fan : data.m_execElementsStatus_Fan;
        result.m_execElementsStatus_ThreeWayValve = (m_execElementsStatus_ThreeWayValve > data.m_execElementsStatus_ThreeWayValve)? m_execElementsStatus_ThreeWayValve : data.m_execElementsStatus_ThreeWayValve;
        result.m_execElementsStatus_Pump = (m_execElementsStatus_Pump > data.m_execElementsStatus_Pump)? m_execElementsStatus_Pump : data.m_execElementsStatus_Pump;
        result.m_execElementsStatus_TankPump = (m_execElementsStatus_TankPump > data.m_execElementsStatus_TankPump)? m_execElementsStatus_TankPump : data.m_execElementsStatus_TankPump;
        result.m_qVal_TWaterTankS2 = (m_qVal_TWaterTankS2 > data.m_qVal_TWaterTankS2)? m_qVal_TWaterTankS2 : data.m_qVal_TWaterTankS2;
        result.m_qVal_TWaterTankS1 = (m_qVal_TWaterTankS1 > data.m_qVal_TWaterTankS1)? m_qVal_TWaterTankS1 : data.m_qVal_TWaterTankS1;
        result.m_qVal_TExterior = (m_qVal_TExterior > data.m_qVal_TExterior)? m_qVal_TExterior : data.m_qVal_TExterior;
        result.m_qVal_TExhaust = (m_qVal_TExhaust > data.m_qVal_TExhaust)? m_qVal_TExhaust : data.m_qVal_TExhaust;
        result.m_qVal_TCHR = (m_qVal_TCHR > data.m_qVal_TCHR)? m_qVal_TCHR : data.m_qVal_TCHR;
        result.m_qVal_TCHFlow = (m_qVal_TCHFlow > data.m_qVal_TCHFlow)? m_qVal_TCHFlow : data.m_qVal_TCHFlow;
        result.m_qVal_TDHW = (m_qVal_TDHW > data.m_qVal_TDHW)? m_qVal_TDHW : data.m_qVal_TDHW;
        result.m_qVal_FlowDHW = (m_qVal_FlowDHW > data.m_qVal_FlowDHW)? m_qVal_FlowDHW : data.m_qVal_FlowDHW;
        result.m_qVal_PresureCH = (m_qVal_PresureCH > data.m_qVal_PresureCH)? m_qVal_PresureCH : data.m_qVal_PresureCH;
        //	result.m_qStatus_TWaterTankS2 = m_qStatus_TWaterTankS2 - data.m_qStatus_TWaterTankS2;
        //	result.m_qStatus_TWaterTankS1 = m_qStatus_TWaterTankS1 - data.m_qStatus_TWaterTankS1;
        //	result.m_qStatus_TExterior = m_qStatus_TExterior - data.m_qStatus_TExterior;
        //	result.m_qStatus_TExhaust = m_qStatus_TExhaust - data.m_qStatus_TExhaust;
        //	result.m_qStatus_TCHR = m_qStatus_TCHR - data.m_qStatus_TCHR;
        //	result.m_qStatus_TCHFlow = m_qStatus_TCHFlow - data.m_qStatus_TCHFlow;
        //	result.m_qStatus_TDHW = m_qStatus_TDHW - data.m_qStatus_TDHW;
        //	result.m_qStatus_FlowDHW = m_qStatus_FlowDHW - data.m_qStatus_FlowDHW;
        //	result.m_qStatus_PresureCH = m_qStatus_PresureCH - data.m_qStatus_PresureCH;
        result.m_cHeatingEnable_ByAmbientThermostat = (m_cHeatingEnable_ByAmbientThermostat > data.m_cHeatingEnable_ByAmbientThermostat)? m_cHeatingEnable_ByAmbientThermostat : data.m_cHeatingEnable_ByAmbientThermostat;
        result.m_cHeatingEnable_ByChronostat = (m_cHeatingEnable_ByChronostat > data.m_cHeatingEnable_ByChronostat)? m_cHeatingEnable_ByChronostat : data.m_cHeatingEnable_ByChronostat;
        result.m_mcFanSetPwm = (m_mcFanSetPwm > data.m_mcFanSetPwm)? m_mcFanSetPwm : data.m_mcFanSetPwm;
        result.m_mcGValveSetPwm = (m_mcGValveSetPwm > data.m_mcGValveSetPwm)? m_mcGValveSetPwm : data.m_mcGValveSetPwm;
        result.m_mfFanSpeed = (m_mfFanSpeed > data.m_mfFanSpeed)? m_mfFanSpeed : data.m_mfFanSpeed;
        result.m_mfGValveVoltage = (m_mfGValveVoltage > data.m_mfGValveVoltage)? m_mfGValveVoltage : data.m_mfGValveVoltage;
        result.m_mfFlameIonisationVoltage = (m_mfFlameIonisationVoltage > data.m_mfFlameIonisationVoltage)? m_mfFlameIonisationVoltage : data.m_mfFlameIonisationVoltage;
        result.m_userSettings_TCHSet = (m_userSettings_TCHSet > data.m_userSettings_TCHSet)? m_userSettings_TCHSet : data.m_userSettings_TCHSet;
        result.m_userSettings_TDHWSet = (m_userSettings_TDHWSet > data.m_userSettings_TDHWSet)? m_userSettings_TDHWSet : data.m_userSettings_TDHWSet;
        result.m_userSettings_SeasonSet = (m_userSettings_SeasonSet > data.m_userSettings_SeasonSet)? m_userSettings_SeasonSet : data.m_userSettings_SeasonSet;
        result.m_userSettings_ComfortActive = (m_userSettings_ComfortActive > data.m_userSettings_ComfortActive)? m_userSettings_ComfortActive : data.m_userSettings_ComfortActive;
        result.m_userSettings_ChronoActive = (m_userSettings_ChronoActive > data.m_userSettings_ChronoActive)? m_userSettings_ChronoActive : data.m_userSettings_ChronoActive;
        result.m_userSettings_VacationActive = (m_userSettings_VacationActive > data.m_userSettings_VacationActive)? m_userSettings_VacationActive : data.m_userSettings_VacationActive;
        result.m_userSettings_TAMBSet = (m_userSettings_TAMBSet > data.m_userSettings_TAMBSet)? m_userSettings_TAMBSet : data.m_userSettings_TAMBSet;
        result.m_userSettings_CoefWallLoss = (m_userSettings_CoefWallLoss > data.m_userSettings_CoefWallLoss)? m_userSettings_CoefWallLoss : data.m_userSettings_CoefWallLoss;
        result.m_userSettings_BoilerStatus = (m_userSettings_BoilerStatus > data.m_userSettings_BoilerStatus)? m_userSettings_BoilerStatus : data.m_userSettings_BoilerStatus;
        result.m_userSettings_LightActive = (m_userSettings_LightActive > data.m_userSettings_LightActive)? m_userSettings_LightActive : data.m_userSettings_LightActive;


        result.m_timeAvaible = (result.m_time != VAL_NONE)? true:false;
        result.m_boilerModelAvaible = (result.m_boilerModel != VAL_NONE)? true:false;
        result.m_revisionAvaible = (result.m_revision != VAL_NONE)? true:false;
        result.m_numberOfMessagesAvaible = (result.m_numberOfMessages != VAL_NONE)? true:false;
        result.m_requestSource_DHW_AntiblocCirculationAvaible = (result.m_requestSource_DHW_AntiblocCirculation != VAL_NONE)? true:false;
        result.m_requestSource_DHW_InstantComfortAvaible = (result.m_requestSource_DHW_InstantComfort != VAL_NONE)? true:false;
        result.m_requestSource_CH_UserNormalHeatingAvaible = (result.m_requestSource_CH_UserNormalHeating != VAL_NONE)? true:false;
        result.m_requestSource_CH_AntifreezeHeatingAvaible = (result.m_requestSource_CH_AntifreezeHeating != VAL_NONE)? true:false;
        result.m_requestSource_DHW_Tank1NormalHeatingAvaible = (result.m_requestSource_DHW_Tank1NormalHeating != VAL_NONE)? true:false;
        result.m_requestSource_DHW_Tank1AntilegionelaAvaible = (result.m_requestSource_DHW_Tank1Antilegionela != VAL_NONE)? true:false;
        result.m_requestSource_DHW_Tank0NormalHeatingAvaible = (result.m_requestSource_DHW_Tank0NormalHeating != VAL_NONE)? true:false;
        result.m_requestSource_DHW_InstantUserAvaible = (result.m_requestSource_DHW_InstantUser != VAL_NONE)? true:false;
        result.m_requestInstalAvailable = (result.m_requestInstal != VAL_NONE)? true:false;
        result.m_requestSource_NoneAvaible = (result.m_requestSource_None != VAL_NONE)? true:false;
        result.m_requestModSetTempAvaible = (result.m_requestModSetTemp != VAL_NONE)? true:false;
        result.m_sysMjStatus_OperationModeAvaible = (result.m_sysMjStatus_OperationMode != VAL_NONE)? true:false;
        result.m_sysMjStatus_StateAvaible = (result.m_sysMjStatus_State != VAL_NONE)? true:false;
        result.m_sysMjStatus_CriticalErrorAvaible = (result.m_sysMjStatus_CriticalError != VAL_NONE)? true:false;
        result.m_sysMjStatus_NormalErrorAvaible = (result.m_sysMjStatus_NormalError != VAL_NONE)? true:false;
        result.m_sysMjStatus_InfoErrorAvaible = (result.m_sysMjStatus_InfoError != VAL_NONE)? true:false;
        result.m_execElementsCtrl_GasValveAvaible = (result.m_execElementsCtrl_GasValve != VAL_NONE)? true:false;
        result.m_execElementsCtrl_IgniterAvaible = (result.m_execElementsCtrl_Igniter != VAL_NONE)? true:false;
        result.m_execElementsCtrl_FanAvaible = (result.m_execElementsCtrl_Fan != VAL_NONE)? true:false;
        result.m_execElementsCtrl_ThreeWayValveAvaible = (result.m_execElementsCtrl_ThreeWayValve != VAL_NONE)? true:false;
        result.m_execElementsCtrl_PumpAvaible = (result.m_execElementsCtrl_Pump != VAL_NONE)? true:false;
        result.m_execElementsCtrl_TankPumpAvaible = (result.m_execElementsCtrl_TankPump != VAL_NONE)? true:false;
        result.m_execElementsStatus_GasValveAvaible = (result.m_execElementsStatus_GasValve != VAL_NONE)? true:false;
        result.m_execElementsStatus_FlameAvaible = (result.m_execElementsStatus_Flame != VAL_NONE)? true:false;
        result.m_execElementsStatus_FanAvaible = (result.m_execElementsStatus_Fan != VAL_NONE)? true:false;
        result.m_execElementsStatus_ThreeWayValveAvaible = (result.m_execElementsStatus_ThreeWayValve != VAL_NONE)? true:false;
        result.m_execElementsStatus_PumpAvaible = (result.m_execElementsStatus_Pump != VAL_NONE)? true:false;
        result.m_execElementsStatus_TankPumpAvaible = (result.m_execElementsStatus_TankPump != VAL_NONE)? true:false;
        result.m_qVal_TWaterTankS2Avaible = (result.m_qVal_TWaterTankS2 != VAL_NONE)? true:false;
        result.m_qVal_TWaterTankS1Avaible = (result.m_qVal_TWaterTankS1 != VAL_NONE)? true:false;
        result.m_qVal_TExteriorAvaible = (result.m_qVal_TExterior != VAL_NONE)? true:false;
        result.m_qVal_TExhaustAvaible = (result.m_qVal_TExhaust != VAL_NONE)? true:false;
        result.m_qVal_TCHRAvaible = (result.m_qVal_TCHR != VAL_NONE)? true:false;
        result.m_qVal_TCHFlowAvaible = (result.m_qVal_TCHFlow != VAL_NONE)? true:false;
        result.m_qVal_TDHWAvaible = (result.m_qVal_TDHW != VAL_NONE)? true:false;
        result.m_qVal_FlowDHWAvaible = (result.m_qVal_FlowDHW != VAL_NONE)? true:false;
        result.m_qVal_PresureCHAvaible = (result.m_qVal_PresureCH != VAL_NONE)? true:false;
        //	result.m_qStatus_TWaterTankS2Avaible = m_qStatus_TWaterTankS2Avaible - data.m_qStatus_TWaterTankS2Avaible;
        //	result.m_qStatus_TWaterTankS1Avaible = m_qStatus_TWaterTankS1Avaible - data.m_qStatus_TWaterTankS1Avaible;
        //	result.m_qStatus_TExteriorAvaible = m_qStatus_TExteriorAvaible - data.m_qStatus_TExteriorAvaible;
        //	result.m_qStatus_TExhaustAvaible = m_qStatus_TExhaustAvaible - data.m_qStatus_TExhaustAvaible;
        //	result.m_qStatus_TCHRAvaible = m_qStatus_TCHRAvaible - data.m_qStatus_TCHRAvaible;
        //	result.m_qStatus_TCHFlowAvaible = m_qStatus_TCHFlowAvaible - data.m_qStatus_TCHFlowAvaible;
        //	result.m_qStatus_TDHWAvaible = m_qStatus_TDHWAvaible - data.m_qStatus_TDHWAvaible;
        //	result.m_qStatus_FlowDHWAvaible = m_qStatus_FlowDHWAvaible - data.m_qStatus_FlowDHWAvaible;
        //	result.m_qStatus_PresureCHAvaible = m_qStatus_PresureCHAvaible - data.m_qStatus_PresureCHAvaible;
        result.m_cHeatingEnable_ByAmbientThermostatAvaible = (result.m_cHeatingEnable_ByAmbientThermostat != VAL_NONE)? true:false;
        result.m_cHeatingEnable_ByChronostatAvaible = (result.m_cHeatingEnable_ByChronostat != VAL_NONE)? true:false;
        result.m_mcFanSetPwmAvaible = (result.m_mcFanSetPwm != VAL_NONE)? true:false;
        result.m_mcGValveSetPwmAvaible = (result.m_mcGValveSetPwm != VAL_NONE)? true:false;
        result.m_mfFanSpeedAvaible = (result.m_mfFanSpeed != VAL_NONE)? true:false;
        result.m_mfGValveVoltageAvaible = (result.m_mfGValveVoltage != VAL_NONE)? true:false;
        result.m_mfFlameIonisationVoltageAvaible = (result.m_mfFlameIonisationVoltage != VAL_NONE)? true:false;
        result.m_userSettings_TCHSetAvaible = (result.m_userSettings_TCHSet != VAL_NONE)? true:false;
        result.m_userSettings_TDHWSetAvaible = (result.m_userSettings_TDHWSet != VAL_NONE)? true:false;
        result.m_userSettings_SeasonSetAvaible = (result.m_userSettings_SeasonSet != VAL_NONE)? true:false;
        result.m_userSettings_ComfortActiveAvaible = (result.m_userSettings_ComfortActive != VAL_NONE)? true:false;
        result.m_userSettings_ChronoActiveAvaible = (result.m_userSettings_ChronoActive != VAL_NONE)? true:false;
        result.m_userSettings_VacationActiveAvaible = (result.m_userSettings_VacationActive != VAL_NONE)? true:false;
        result.m_userSettings_TAMBSetAvaible = (result.m_userSettings_TAMBSet != VAL_NONE)? true:false;
        result.m_userSettings_CoefWallLossAvaible = (result.m_userSettings_CoefWallLoss != VAL_NONE)? true:false;
        result.m_userSettings_BoilerStatusAvaible = (result.m_userSettings_BoilerStatus != VAL_NONE)? true:false;
        result.m_userSettings_LightActiveAvaible = (result.m_userSettings_LightActive != VAL_NONE)? true:false;

        result.m_dummyValue = (m_dummyValue < data.m_dummyValue)? m_dummyValue : data.m_dummyValue;

        return result;
    }

}