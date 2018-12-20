package com.dxd.dxdpay;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

public class MainActivity extends FullscreenActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Begin the transaction
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        // Replace the contents of the container with the new fragment
        ft.replace(R.id.fragment_placeholder, new LoginFragment());
        // Complete the changes added above
        ft.commit();
    }

    public void showFragment(@NonNull final Fragment fragment) {
        try {

                getSupportFragmentManager().beginTransaction()
                        .add(R.id.fragment_placeholder, fragment, fragment.getClass().getName())
                        .addToBackStack(null)
                        .commit();

        } catch (IllegalStateException ignored) {
        }

    }
}
