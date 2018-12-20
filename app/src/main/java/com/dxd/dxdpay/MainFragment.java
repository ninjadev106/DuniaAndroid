package com.dxd.dxdpay;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

public class MainFragment extends Fragment {
    // The onCreateView method is called when Fragment should create its View object hierarchy,
    // either dynamically or via XML layout inflation.

    public SendFragment sendFragment;
    private HistoryFragment historyFragment;
    private SettingsFragment settingsFragment;
    public BottomBar bottomBar;
    public int afterBack = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        return inflater.inflate(R.layout.fragment_main, parent, false);
    }

    // This event is triggered soon after onCreateView().
    // Any view setup should occur here.  E.g., view lookups and attaching view listeners.
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // Setup any handles to view objects here
        // EditText etFoo = (EditText) view.findViewById(R.id.etFoo);

        sendFragment = new SendFragment();
        historyFragment = new HistoryFragment();
        settingsFragment = new SettingsFragment();

        bottomBar = (BottomBar) view.findViewById(R.id.bottomBar);
        bottomBar.setActiveTabColor(Color.BLACK);//getResources().getColor(R.color.highlightBlue));

        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                if (tabId == R.id.tab_send) {
                    // Update tab images
//                    bottomBar.getTabWithId(R.id.tab_send).getIconView().setImageResource(R.mipmap.location);
//                    bottomBar.getTabWithId(R.id.tab_history).getIconView().setImageResource(R.mipmap.layers);
//                    bottomBar.getTabWithId(R.id.tab_settings).getIconView().setImageResource(R.mipmap.cog);

                    showFragment(sendFragment,false);
                    afterBack = 0;
                    bottomBar.setVisibility(View.VISIBLE);
                }
                else if (tabId == R.id.tab_history) {
//                    // Update tab images
//                    bottomBar.getTabWithId(R.id.tab_send).getIconView().setImageResource(R.mipmap.location_dk);
//                    bottomBar.getTabWithId(R.id.tab_history).getIconView().setImageResource(R.mipmap.layers);
//                    bottomBar.getTabWithId(R.id.tab_settings).getIconView().setImageResource(R.mipmap.cog_dk);
//
                    showFragment(historyFragment,false);
                    afterBack = 1;
                    bottomBar.setVisibility(View.VISIBLE);
                }
                if (tabId == R.id.tab_settings) {
//                    // Update tab images
//                    bottomBar.getTabWithId(R.id.tab_send).getIconView().setImageResource(R.mipmap.location_dk);
//                    bottomBar.getTabWithId(R.id.tab_history).getIconView().setImageResource(R.mipmap.layers_dk);
//                    bottomBar.getTabWithId(R.id.tab_settings).getIconView().setImageResource(R.mipmap.cog);
//
                    showFragment(settingsFragment,false);
//
                    bottomBar.setVisibility(View.INVISIBLE);
                }
            }
        });
    }

    public void showFragment(@NonNull final Fragment fragment, boolean bAdd) {
        try {
            int count = getChildFragmentManager().getBackStackEntryCount();
            if (count > 1){
                getChildFragmentManager().popBackStackImmediate();
            }

            if (!bAdd) {
                getChildFragmentManager().beginTransaction()
                        .replace(R.id.container, fragment, fragment.getClass().getName())
                        .commitAllowingStateLoss();
            }
            else {
                getChildFragmentManager().beginTransaction()
                        .add(R.id.container, fragment, fragment.getClass().getName())
                        .addToBackStack(null)
                        .commitAllowingStateLoss();
            }
        } catch (IllegalStateException ignored) {
        }
    }
}

