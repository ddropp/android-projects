package com.apps.ddragos.thermalmonitor.fragments;

import com.apps.ddragos.thermalmonitor.MC1X.MC1XData;
import com.apps.ddragos.thermalmonitor.R;


import android.graphics.Color;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.apps.ddragos.thermalmonitor.slidingTabs.SlidingTabLayout;

import java.util.ArrayList;
import java.util.List;

public class SlidingTabsFragment extends Fragment {

    MyFragmentPagerAdapter adapter;
    private SlidingTabLayout mSlidingTabLayout;
    private ViewPager mViewPager;
    private List<PagerItem> mTabs = new ArrayList<PagerItem>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mTabs.add(new PagerItem(
                getString(R.string.tab_graph), // Title
                Color.BLUE, // Indicator color
                Color.DKGRAY // Divider color
        ));

        mTabs.add(new PagerItem(
                getString(R.string.tab_leds), // Title
                Color.GREEN, // Indicator color
                Color.DKGRAY // Divider color
        ));

        mTabs.add(new PagerItem(
                getString(R.string.tab_values), // Title
                Color.CYAN, // Indicator color
                Color.DKGRAY // Divider color
        ));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.sliding_tabs_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        mViewPager = (ViewPager) view.findViewById(R.id.viewpager);
        adapter = new MyFragmentPagerAdapter(getChildFragmentManager());
        mViewPager.setAdapter(adapter);
        mViewPager.setOffscreenPageLimit(2);

        mSlidingTabLayout = (SlidingTabLayout) view.findViewById(R.id.sliding_tabs);
        mSlidingTabLayout.setViewPager(mViewPager);
        mSlidingTabLayout.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {

            @Override
            public int getIndicatorColor(int position) {
                return mTabs.get(position).getIndicatorColor();
            }

            @Override
            public int getDividerColor(int position) {
                return mTabs.get(position).getDividerColor();
            }

        });

    }

    public void updateFragments(MC1XData mc1XData) {
        Log.d("PPROCESSING", "Fragment thread");

        ((GraphFragment)adapter.getFragment(0)).updateView(mc1XData);
        ((LedsFragment)adapter.getFragment(1)).updateView(mc1XData);
        ((ValuesFragment)adapter.getFragment(2)).updateView(mc1XData);
    }

    public void updatePreferences() {
        ((GraphFragment)adapter.getFragment(0)).updatePreferences();
    }

    static class PagerItem {
        private final CharSequence mTitle;
        private final int mIndicatorColor;
        private final int mDividerColor;

        PagerItem(CharSequence title, int indicatorColor, int dividerColor) {
            mTitle = title;
            mIndicatorColor = indicatorColor;
            mDividerColor = dividerColor;
        }

        Fragment createFragment(FragmentType type) {
            Fragment fragment = null;

            switch (type) {
                case GRAPH:
                    fragment = GraphFragment.newInstance(mTitle, mIndicatorColor, mDividerColor);
                    break;
                case LEDS:
                    fragment = LedsFragment.newInstance(mTitle, mIndicatorColor, mDividerColor);
                    break;
                case VALUES:
                    fragment = ValuesFragment.newInstance(mTitle, mIndicatorColor, mDividerColor);
                    break;
                default:
                    break;
            }
            return fragment;
        }

        CharSequence getTitle() {
            return mTitle;
        }

        int getIndicatorColor() {
            return mIndicatorColor;
        }

        int getDividerColor() {
            return mDividerColor;
        }
    }

    class MyFragmentPagerAdapter extends FragmentStatePagerAdapter {

        private SparseArray<Fragment> fragmentMap;
        private int FRAG_NUM = 3;

        MyFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
            fragmentMap = new SparseArray<>(FRAG_NUM);
        }

        @Override
        public Fragment getItem(int i) {
            Fragment fragment = fragmentMap.get(i);
            if (fragment == null) {
                FragmentType type;
                switch (i) {
                    case 0:
                        type = FragmentType.GRAPH;
                        fragment = mTabs.get(i).createFragment(type);
                        break;
                    case 1:
                        type = FragmentType.LEDS;
                        fragment = mTabs.get(i).createFragment(type);
                        break;
                    case 2:
                        type = FragmentType.VALUES;
                        fragment = mTabs.get(i).createFragment(type);
                        break;
                    default:
                        break;
                }

                if (fragment != null) {
                    fragment.setRetainInstance(true);
                    fragmentMap.put(i, fragment);
                }

            } else
                fragment = fragmentMap.get(i);
            return fragment;
        }

        @Override
        public int getCount() {
            return FRAG_NUM;
        }

        public Fragment getFragment(int pos) {
            return fragmentMap.get(pos);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTabs.get(position).getTitle();
        }


        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            if (position >= getCount()) {
                FragmentManager manager = ((Fragment) object).getFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.remove((Fragment) object);
                transaction.commit();
                fragmentMap.remove(position);
            }
        }
    }

}