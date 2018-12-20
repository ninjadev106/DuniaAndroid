package com.dxd.dxdpay;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

public class SettingsFragment extends Fragment {
    // The onCreateView method is called when Fragment should create its View object hierarchy,
    // either dynamically or via XML layout inflation.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        return inflater.inflate(R.layout.fragment_settings, parent, false);
    }

    // This event is triggered soon after onCreateView().
    // Any view setup should occur here.  E.g., view lookups and attaching view listeners.
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // Setup any handles to view objects here
        // EditText etFoo = (EditText) view.findViewById(R.id.etFoo);
        ImageButton btnBack = (ImageButton)view.findViewById(R.id.button_Back);
        final MainFragment mainFragment = (MainFragment) getParentFragment();

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainFragment.bottomBar.selectTabAtPosition(mainFragment.afterBack);
            }
        });

        RelativeLayout relativeMyProfile = (RelativeLayout)view.findViewById(R.id.relative_my_profile);
        relativeMyProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainFragment.showFragment(new ProfileInfoFragment(),true);
            }
        });
    }
}

