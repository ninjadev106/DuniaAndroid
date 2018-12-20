package com.dxd.dxdpay;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoadingPageActivity extends FullscreenActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        Button btnLogin = (Button)findViewById(R.id.button_LogIn);
        Button btnSigUp = (Button)findViewById(R.id.button_Signup);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logIn();
            }
        });

        btnSigUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sigUp();
            }
        });
    }

    private void logIn(){
        Intent intent = new Intent(getBaseContext(), MainActivity.class);
        startActivity(intent);
    }

    private void sigUp(){
        Intent intent = new Intent(getBaseContext(), SignUpActivity.class);
        startActivity(intent);
    }
}
