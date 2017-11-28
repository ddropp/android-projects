/*
 * Copyright 2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.apps.ddragos.thermalmonitor.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import com.apps.ddragos.thermalmonitor.MC1X.MC1XData;
import com.apps.ddragos.thermalmonitor.R;

/**
 * Simple Fragment used to display some meaningful content for each page in the sample's
 * {@link android.support.v4.view.ViewPager}.
 */
public class LedsFragment extends Fragment {

    private static final String KEY_TITLE = "title";
    private static final String KEY_INDICATOR_COLOR = "indicator_color";
    private static final String KEY_DIVIDER_COLOR = "divider_color";

    private RadioButton ledInitial;
    private RadioButton ledWait;
    private RadioButton ledPrepurge;
    private RadioButton ledInterpurge;
    private RadioButton ledIgnition;
    private RadioButton ledBurning;
    private RadioButton ledExtinction;
    private RadioButton ledPostpurge;
    private RadioButton ledCirculation;
    private RadioButton ledError;


    private TextView tv;

    public static LedsFragment newInstance(CharSequence title, int indicatorColor,
            int dividerColor) {
        Bundle bundle = new Bundle();
        bundle.putCharSequence(KEY_TITLE, title);
        bundle.putInt(KEY_INDICATOR_COLOR, indicatorColor);
        bundle.putInt(KEY_DIVIDER_COLOR, dividerColor);

        LedsFragment fragment = new LedsFragment();
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        return inflater.inflate(R.layout.leds_item, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle args = getArguments();

        if (args != null) {
            ledInitial = (RadioButton) view.findViewById(R.id.initialRb);
            ledWait = (RadioButton) view.findViewById(R.id.waitRb);
            ledPrepurge = (RadioButton) view.findViewById(R.id.prepurgeRb);
            ledInterpurge = (RadioButton) view.findViewById(R.id.interpurgeRb);
            ledIgnition = (RadioButton) view.findViewById(R.id.ignitionRb);
            ledBurning = (RadioButton) view.findViewById(R.id.burnRb);
            ledExtinction = (RadioButton) view.findViewById(R.id.exctinctRb);
            ledPostpurge = (RadioButton) view.findViewById(R.id.postpurgeRb);
            ledCirculation = (RadioButton) view.findViewById(R.id.circulationRb);
            ledError = (RadioButton) view.findViewById(R.id.errorRb);

            tv = (TextView) view.findViewById(R.id.dummyTv);
        }
    }


    public void updateText(String text) {



    }

    public void updateView(MC1XData mc1XData) {
        int value = mc1XData.GetSysMajorStatusState();
        tv.setText("System Major Status: " + value);
        Log.d("SYSTEM MSTATUS: ", value + " " + Integer.toHexString(value));
        ledInitial.setChecked(value == 0x00000000);
        ledWait.setChecked(value == 0x00000011);
        ledPrepurge.setChecked(value == 0x00000020);
        ledInterpurge.setChecked(value == 0x00000021);
        ledIgnition.setChecked(value == 0x00000022);
        ledBurning.setChecked(value == 0x00000023);
        ledExtinction.setChecked(value == 0x00000024);
        ledPostpurge.setChecked(value == 0x00000025);
        ledCirculation.setChecked(value == 0x00000030);
        ledError.setChecked(value == 0x00000040);


    }
}
