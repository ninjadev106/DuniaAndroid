package com.dxd.dxdpay;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.reginald.editspinner.EditSpinner;

@SuppressLint("ValidFragment")
public class SenderDetailsFragment extends Fragment {
    private EditSpinner spinnerProfession;
    private static final String[] professions = {"Data Scientist", "Devops Engineer", "Marketing Manager", "Occupational Therapist"};

    // The onCreateView method is called when Fragment should create its View object hierarchy,
    // either dynamically or via XML layout inflation.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        return inflater.inflate(R.layout.fragment_sender_details, parent, false);
    }

    // This event is triggered soon after onCreateView().
    // Any view setup should occur here.  E.g., view lookups and attaching view listeners.
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // Setup any handles to view objects here
        // EditText etFoo = (EditText) view.findViewById(R.id.etFoo);
        Button btnAdd = (Button)view.findViewById(R.id.button_AddRecipient);

        ImageButton button_BackToHome = view.findViewById(R.id.button_Back);
        button_BackToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().popBackStack();
            }
        });

        Button button_Done = view.findViewById(R.id.button_Complete);
        button_Done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().popBackStack();
            }
        });

        spinnerProfession = view.findViewById(R.id.spinner_Profession);
        ArrayAdapter<String> adapterReason = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_spinner_item, professions);
        adapterReason.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerProfession.setAdapter(adapterReason);
    }
}

