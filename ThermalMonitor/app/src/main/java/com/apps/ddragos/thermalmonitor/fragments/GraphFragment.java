package com.apps.ddragos.thermalmonitor.fragments;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.apps.ddragos.thermalmonitor.MC1X.MC1XData;
import com.apps.ddragos.thermalmonitor.R;
import com.apps.ddragos.thermalmonitor.graph.GraphView;


public class GraphFragment extends Fragment {
    private static final String KEY_TITLE = "title";
    private static final String KEY_INDICATOR_COLOR = "indicator_color";
    private static final String KEY_DIVIDER_COLOR = "divider_color";

    private GraphView graphView;
    private SharedPreferences preferences;

    public static GraphFragment newInstance(CharSequence title, int indicatorColor,
                                           int dividerColor) {
        Bundle bundle = new Bundle();
        bundle.putCharSequence(KEY_TITLE, title);
        bundle.putInt(KEY_INDICATOR_COLOR, indicatorColor);
        bundle.putInt(KEY_DIVIDER_COLOR, dividerColor);

        GraphFragment fragment = new GraphFragment();
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public void onResume() {
        super.onResume();

        if (preferences == null)
            preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());

    }

    @Override
    public void onPause() {
        super.onPause();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.graph_item, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle args = getArguments();

        if (args != null) {
            graphView = (GraphView) view.findViewById(R.id.graphView);

        }
    }

    public void updateView(MC1XData mc1XData) {
        graphView.updateGraphs(mc1XData);
//        updatePreferences();
    }

    public void updatePreferences() {
        graphView.setGraphsPreferences(preferences);
    }

}
