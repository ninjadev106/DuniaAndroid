package com.dxd.dxdpay;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

public class SignUpPhoneVerifyFragment extends Fragment {

    private View viewNumber1;
    private View viewNumber2;
    private View viewNumber3;
    private View viewNumber4;

    private String stringInput = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        return inflater.inflate(R.layout.fragment_signup_phoneverify, parent, false);
    }

    // This event is triggered soon after onCreateView().
    // Any view setup should occur here.  E.g., view lookups and attaching view listeners.
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // Setup any handles to view objects here
        // EditText etFoo = (EditText) view.findViewById(R.id.etFoo);

        viewNumber1 = view.findViewById(R.id.view_number1);
        viewNumber2 = view.findViewById(R.id.view_number2);
        viewNumber3 = view.findViewById(R.id.view_number3);
        viewNumber4 = view.findViewById(R.id.view_number4);

        Button button0 = view.findViewById(R.id.button_0);
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Check input number
                checkInputNumber(0);
            }
        });


        Button button1 = view.findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Check input number
                checkInputNumber(1);
            }
        });

        Button button2 = view.findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Check input number
                checkInputNumber(2);
            }
        });

        Button button3 = view.findViewById(R.id.button_3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Check input number
                checkInputNumber(3);
            }
        });

        Button button4 = view.findViewById(R.id.button_4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Check input number
                checkInputNumber(4);
            }
        });

        Button button5 = view.findViewById(R.id.button_5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Check input number
                checkInputNumber(5);
            }
        });

        Button button6 = view.findViewById(R.id.button_6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Check input number
                checkInputNumber(6);
            }
        });

        Button button7 = view.findViewById(R.id.button_7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Check input number
                checkInputNumber(7);
            }
        });

        Button button8 = view.findViewById(R.id.button_8);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Check input number
                checkInputNumber(8);
            }
        });

        Button button9 = view.findViewById(R.id.button_9);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Check input number
                checkInputNumber(9);
            }
        });

        ImageButton buttondelete = view.findViewById(R.id.button_delete);
        buttondelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Check input number
                checkInputNumber(-1);
            }
        });



    }


    private void checkInputNumber(int key){
        if (key >= 0){
            stringInput += key;

            int length = stringInput.length();

            if (length >= 1){
                viewNumber1.setBackground(getResources().getDrawable(R.drawable.numberinputed));
            }

            if (length >= 2){
                viewNumber2.setBackground(getResources().getDrawable(R.drawable.numberinputed));
            }

            if (length >= 3){
                viewNumber3.setBackground(getResources().getDrawable(R.drawable.numberinputed));
            }

            if (length >= 4){
                viewNumber4.setBackground(getResources().getDrawable(R.drawable.numberinputed));
            }
        }
        else {
            int length = stringInput.length();
            if (length > 0) {
                stringInput = stringInput.substring(0, length - 1);
            }

            if (length < 1){
                viewNumber1.setBackground(getResources().getDrawable(R.drawable.numbernotinput));
            }

            if (length < 2){
                viewNumber2.setBackground(getResources().getDrawable(R.drawable.numbernotinput));
            }

            if (length < 3){
                viewNumber3.setBackground(getResources().getDrawable(R.drawable.numbernotinput));
            }

            if (length < 4){
                viewNumber4.setBackground(getResources().getDrawable(R.drawable.numbernotinput));
            }
        }

        if (stringInput.length() >= 4){

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(getContext(), MainActivity.class);
                    startActivity(intent);

                    getActivity().finish();
                }
            }, 200);


        }
    }
}

