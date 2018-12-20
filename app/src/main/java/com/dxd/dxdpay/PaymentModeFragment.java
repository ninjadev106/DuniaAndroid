package com.dxd.dxdpay;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.dxd.dxdpay.model.ItemHistory;
import com.dxd.dxdpay.model.ItemPaymentMode;

import java.util.ArrayList;
import java.util.List;

public class PaymentModeFragment extends Fragment {
    private ListView lists;

    // The onCreateView method is called when Fragment should create its View object hierarchy,
    // either dynamically or via XML layout inflation.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        return inflater.inflate(R.layout.fragment_payment_mode, parent, false);
    }

    // This event is triggered soon after onCreateView().
    // Any view setup should occur here.  E.g., view lookups and attaching view listeners.
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // Setup any handles to view objects here
        // EditText etFoo = (EditText) view.findViewById(R.id.etFoo);

        ImageButton button_BackToHome = (ImageButton)view.findViewById(R.id.button_Back);
        button_BackToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().popBackStack();
            }
        });

        lists = (ListView)view.findViewById(R.id.lists);
        //demo
        List<ItemPaymentMode> array = new ArrayList<>();

        ItemPaymentMode item1 = new ItemPaymentMode();
        item1.setName(getString(R.string.bank_account));
        item1.setDescription(getString(R.string.bank_account_des));
        item1.setbState(false);
        array.add(item1);

        ItemPaymentMode item2 = new ItemPaymentMode();
        item2.setName(getString(R.string.debit_credit));
        item2.setDescription(getString(R.string.debit_credit_des));
        item2.setbState(true);
        array.add(item2);

        ItemPaymentMode item3 = new ItemPaymentMode();
        item3.setName(getString(R.string.apple_pay));
        item3.setDescription(getString(R.string.apple_pay_des));
        item3.setbState(false);
        array.add(item3);


        ListAdapter customAdapter = new ListAdapter(getContext(), R.layout.cell_payment_mode, array);

        lists.setAdapter(customAdapter);
    }

    class ListAdapter extends ArrayAdapter<ItemPaymentMode> {

        private int resourceLayout;
        private Context mContext;
        public List<ItemPaymentMode> data;

        public ListAdapter(Context context, int resource, List<ItemPaymentMode> items) {
            super(context, resource, items);
            this.resourceLayout = resource;
            this.mContext = context;
            this.data = items;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {

            View v = convertView;

            if (v == null) {
                LayoutInflater vi;
                vi = LayoutInflater.from(mContext);
                v = vi.inflate(resourceLayout, null);
            }

            ItemPaymentMode p = getItem(position);

            if (p != null) {
                TextView ttName = (TextView) v.findViewById(R.id.textview_Name);
                TextView ttDescription = (TextView) v.findViewById(R.id.textview_Description);
                ImageView imageview_Check = (ImageView) v.findViewById(R.id.imageview_Check);

                if (ttName != null) {
                    ttName.setText(p.getName());
                }

                if (ttDescription != null) {
                    ttDescription.setText(p.getDescription());
                }

                if (imageview_Check != null) {
                    if(p.isbState()){
                        imageview_Check.setImageResource(R.mipmap.checked);
                    }
                    else{
                        imageview_Check.setImageResource(R.mipmap.uncheck);
                    }
                }

                v.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        for (int i = 0; i < data.size(); i++){
                            if (i != position) {
                                data.get(i).setbState(false);
                            }
                            else {
                                data.get(i).setbState(true);
                            }
                        }
                        notifyDataSetChanged();
                    }
                });
            }

            return v;
        }

    }
}

