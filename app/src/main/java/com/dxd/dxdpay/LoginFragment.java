package com.dxd.dxdpay;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class LoginFragment extends Fragment {
    // The onCreateView method is called when Fragment should create its View object hierarchy,
    // either dynamically or via XML layout inflation.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        return inflater.inflate(R.layout.fragment_login, parent, false);
    }

    // This event is triggered soon after onCreateView().
    // Any view setup should occur here.  E.g., view lookups and attaching view listeners.
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // Setup any handles to view objects here
        // EditText etFoo = (EditText) view.findViewById(R.id.etFoo);
        Button btnLogin = (Button)view.findViewById(R.id.button_LogIn);
        Button btnUseTouchId = (Button)view.findViewById(R.id.button_UseTouchId);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(android.R.id.content, new MainFragment()).commit();
            }
        });

        btnUseTouchId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        TextView textViewForgotPassword = view.findViewById(R.id.textview_forgotpassword);
        textViewForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Show forgot password
                ForgotPasswordFragment fragment = new ForgotPasswordFragment();
                MainActivity activity = (MainActivity)getActivity();
                activity.showFragment(fragment);
            }
        });

        ImageButton buttonHelp = view.findViewById(R.id.button_Help);
        buttonHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HelpCenterFragment fragment = new HelpCenterFragment();
                MainActivity activity = (MainActivity)getActivity();
                activity.showFragment(fragment);
            }
        });
    }
}

