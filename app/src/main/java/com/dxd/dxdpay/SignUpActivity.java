package com.dxd.dxdpay;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;

public class SignUpActivity extends FullscreenActivity {
    public static final int FRAGMENT_ID_INPUTINFO = 1;
    public static final int FRAGMENT_ID_INPUTPHONE = 2;
    public static final int FRAGMENT_ID_VERIFYPHONE = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        showChildFragment(FRAGMENT_ID_INPUTINFO);

    }

    public void showChildFragment(int fragmentId){

        Fragment fragment = null;
        if (fragmentId == FRAGMENT_ID_INPUTINFO){
            fragment = new SignUpInfoFragment();
        }
        else if (fragmentId == FRAGMENT_ID_INPUTPHONE){
            fragment = new SignUpPhoneFragment();
        }
        else if (fragmentId == FRAGMENT_ID_VERIFYPHONE){
            fragment = new SignUpPhoneVerifyFragment();
        }

        if (fragment != null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(android.R.id.content, fragment).commit();
        }
    }

}
