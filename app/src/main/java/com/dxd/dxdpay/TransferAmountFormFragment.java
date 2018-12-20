package com.dxd.dxdpay;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

public class TransferAmountFormFragment extends Fragment {

    private Button buttonTransfer;
    private Button buttonRecipient;
    private Button buttonCollecttion;

    // The onCreateView method is called when Fragment should create its View object hierarchy,
    // either dynamically or via XML layout inflation.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        return inflater.inflate(R.layout.fragment_transfer_amount_form, parent, false);
    }

    // This event is triggered soon after onCreateView().
    // Any view setup should occur here.  E.g., view lookups and attaching view listeners.
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // Setup any handles to view objects here
        // EditText etFoo = (EditText) view.findViewById(R.id.etFoo);


        Button btnAdd = (Button)view.findViewById(R.id.button_AddRecipient);
        buttonTransfer = (Button) view.findViewById(R.id.button_transfer);
        buttonRecipient = (Button) view.findViewById(R.id.button_recipient);
        buttonCollecttion = (Button) view.findViewById(R.id.button_collecttion);
        ImageButton button_BackToHome = (ImageButton)view.findViewById(R.id.button_Back);

        final MainFragment mainFragment = (MainFragment) getParentFragment();


        button_BackToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().popBackStack();
                mainFragment.bottomBar.setVisibility(View.VISIBLE);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainFragment.showFragment(new AddRecipientFragment(),true);
            }
        });

        buttonTransfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainFragment.showFragment(new SetCurrencySenderFragment(),true);
            }
        });

        buttonRecipient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainFragment.showFragment(new SetCurrencySenderFragment(),true);
            }
        });

        buttonCollecttion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainFragment.showFragment(new PaymentModeFragment(),true);
            }
        });

    }
}

