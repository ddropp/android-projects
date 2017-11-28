package com.apps.ddragos.thermalmonitor.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.apps.ddragos.thermalmonitor.MC1X.MC1XData;
import com.apps.ddragos.thermalmonitor.R;
import com.apps.ddragos.thermalmonitor.graph.GraphView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.util.HashMap;

public class ValuesFragment extends Fragment {

    private static final String KEY_TITLE = "title";
    private static final String KEY_INDICATOR_COLOR = "indicator_color";
    private static final String KEY_DIVIDER_COLOR = "divider_color";

    private HashMap<String,TextView> textViewMap;

    public static ValuesFragment newInstance(CharSequence title, int indicatorColor,
                                            int dividerColor) {
        Bundle bundle = new Bundle();
        bundle.putCharSequence(KEY_TITLE, title);
        bundle.putInt(KEY_INDICATOR_COLOR, indicatorColor);
        bundle.putInt(KEY_DIVIDER_COLOR, dividerColor);

        ValuesFragment fragment = new ValuesFragment();
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.values_item, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle args = getArguments();

        if (args != null) {
            textViewMap = new HashMap<>();

            textViewMap.put("dhwFlowTv",(TextView)view.findViewById(R.id.dhwFlowTv));
            textViewMap.put("extTempTv",(TextView)view.findViewById(R.id.extTempTv));
            textViewMap.put("chSetTempTv",(TextView)view.findViewById(R.id.chSetTempTv));
            textViewMap.put("chFlowTempTv",(TextView)view.findViewById(R.id.chFlowTempTv));
            textViewMap.put("chReturnTempTv",(TextView)view.findViewById(R.id.chReturnTempTv));
            textViewMap.put("dhwSetTempTv",(TextView)view.findViewById(R.id.dhwSetTempTv));
            textViewMap.put("dhwTempTv",(TextView)view.findViewById(R.id.dhwTempTv));

            textViewMap.put("tankS1TempTv",(TextView)view.findViewById(R.id.tankS1TempTv));
            textViewMap.put("tankS2TempTv",(TextView)view.findViewById(R.id.tankS2TempTv));
            textViewMap.put("exhaustTempTv",(TextView)view.findViewById(R.id.exhaustTempTv));
            textViewMap.put("fanPwmTv",(TextView)view.findViewById(R.id.fanPwmTv));
            textViewMap.put("fanRpmTv",(TextView)view.findViewById(R.id.fanRpmTv));
            textViewMap.put("chPressureTv",(TextView)view.findViewById(R.id.chPressureTv));
            textViewMap.put("ionVoltageTv",(TextView)view.findViewById(R.id.ionVoltageTv));
        }
    }

    public void updateView(MC1XData mc1XData) {
        DecimalFormat decimalFormat = new DecimalFormat("##.##");

        textViewMap.get("dhwFlowTv").setText(decimalFormat.format( mc1XData.GetQValFlowDHW() ));
        textViewMap.get("chFlowTempTv").setText(decimalFormat.format( mc1XData.GetQValTemperatureCHFlow() ));
        textViewMap.get("chReturnTempTv").setText(decimalFormat.format( mc1XData.GetQValTemperatureCHRetur() ));
        textViewMap.get("dhwTempTv").setText(decimalFormat.format( mc1XData.GetQValTemperatureDHW() ));
        textViewMap.get("tankS1TempTv").setText(decimalFormat.format( mc1XData.GetQValTemperatureWaterTankS1() ));
        textViewMap.get("tankS2TempTv").setText(decimalFormat.format( mc1XData.GetQValTemperatureWaterTankS2() ));
        textViewMap.get("exhaustTempTv").setText(decimalFormat.format( mc1XData.GetQValTemperatureExhaust() ));
        textViewMap.get("ionVoltageTv").setText(decimalFormat.format( mc1XData.GetMFFlameIonisationVoltage() ));
        textViewMap.get("fanPwmTv").setText(decimalFormat.format( mc1XData.GetMCFanSetPwm() ));
        textViewMap.get("fanRpmTv").setText(decimalFormat.format( mc1XData.GetMFFanSpeed() ));
        textViewMap.get("extTempTv").setText(decimalFormat.format( mc1XData.GetQValTemperatureExterior() ));
        textViewMap.get("chPressureTv").setText(decimalFormat.format( mc1XData.GetQValPresureCH() ));

        if( mc1XData.GetRequestInstal() == 0 ) // nu exista cerere
        {
            textViewMap.get("chSetTempTv").setText(decimalFormat.format(mc1XData.GetUserSettingsTemperatureCHSet()));
            textViewMap.get("dhwSetTempTv").setText(decimalFormat.format(mc1XData.GetUserSettingsTemperatureDHWSet()));
        }
        if( mc1XData.GetRequestInstal() == 1 ) // cerere pentru instalatia de ACM
        {
            textViewMap.get("chSetTempTv").setText(decimalFormat.format( mc1XData.GetUserSettingsTemperatureCHSet() ));
            textViewMap.get("dhwSetTempTv").setText(decimalFormat.format( mc1XData.GetRequestModSetTemp() ));
        }
        if( mc1XData.GetRequestInstal() == 2 ) // cerere pentru instalatia de AT, incalzire
        {
            textViewMap.get("chSetTempTv").setText(decimalFormat.format( mc1XData.GetRequestModSetTemp() ));
            textViewMap.get("dhwSetTempTv").setText(decimalFormat.format( mc1XData.GetUserSettingsTemperatureDHWSet() ));
        }

    }

}
