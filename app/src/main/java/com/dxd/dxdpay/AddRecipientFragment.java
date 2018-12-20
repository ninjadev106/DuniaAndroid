package com.dxd.dxdpay;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.reginald.editspinner.EditSpinner;

public class AddRecipientFragment extends Fragment {
    private EditSpinner spinnerReason;
//    private static final String[] pathsReason = {"Reason for sending", "VND"};

    // The onCreateView method is called when Fragment should create its View object hierarchy,
    // either dynamically or via XML layout inflation.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        return inflater.inflate(R.layout.fragment_add_recipient, parent, false);
    }

    // This event is triggered soon after onCreateView().
    // Any view setup should occur here.  E.g., view lookups and attaching view listeners.
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // Setup any handles to view objects here
        // EditText etFoo = (EditText) view.findViewById(R.id.etFoo);
        Button btnComplete = (Button)view.findViewById(R.id.button_Complete);

        final MainFragment mainFragment = (MainFragment) getParentFragment();

        ImageButton button_BackToHome = (ImageButton)view.findViewById(R.id.button_Back);
        button_BackToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideKeyboard(view);
                getFragmentManager().popBackStack();
            }
        });

        btnComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int count = getFragmentManager().getBackStackEntryCount();
                for (int i = 0; i <= count; i++){
                    getFragmentManager().popBackStack();
                }
                mainFragment.bottomBar.setVisibility(View.VISIBLE);
            }
        });

        final String[] pathsReason = {getString(R.string.reason_for_sending), "abc"};

        spinnerReason =  view.findViewById(R.id.spinner_Reason);
        ArrayAdapter<String> adapterReason = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_spinner_item, pathsReason);
        adapterReason.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerReason.setAdapter(adapterReason);
    }

    private void hideKeyboard(View view){
        InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

    }

}

