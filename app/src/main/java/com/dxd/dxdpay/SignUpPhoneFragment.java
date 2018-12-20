package com.dxd.dxdpay;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

import com.reginald.editspinner.EditSpinner;

public class SignUpPhoneFragment extends Fragment {

    private String[] countries = {"USA", "GB", "Vietnam"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        return inflater.inflate(R.layout.fragment_signup_phone, parent, false);
    }

    // This event is triggered soon after onCreateView().
    // Any view setup should occur here.  E.g., view lookups and attaching view listeners.
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // Setup any handles to view objects here
        // EditText etFoo = (EditText) view.findViewById(R.id.etFoo);

        Button buttonComplete = view.findViewById(R.id.button_Complete);
        buttonComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SignUpActivity activity = (SignUpActivity)getActivity();
                activity.showChildFragment(SignUpActivity.FRAGMENT_ID_VERIFYPHONE);
            }
        });

        EditSpinner spinner = view.findViewById(R.id.spinner_Country);
        ArrayAdapter<String> adapterReason = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_spinner_item, countries);
        adapterReason.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapterReason);

    }


}

