package com.dxd.dxdpay;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.dxd.dxdpay.model.ItemCurrentcySender;

import java.util.ArrayList;
import java.util.List;

public class SetCurrencySenderFragment extends Fragment {
    private ListView lists;
    List<ItemCurrentcySender> array;
    private static final String[] pathsTransferShortName = {"AUD", "CAD", "CHF", "AUD", "CAD", "CHF", "AUD", "CAD", "CHF"};
    private static final String[] pathsTransferFullName = {"Autralian Dollar", "Canadian Dollar", "Swiss Franc", "Autralian Dollar", "Canadian Dollar", "Swiss Franc", "Autralian Dollar", "Canadian Dollar", "Swiss Franc"};

    // The onCreateView method is called when Fragment should create its View object hierarchy,
    // either dynamically or via XML layout inflation.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        return inflater.inflate(R.layout.fragment_set_currency_sender, parent, false);
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
                hideKeyboard(view);
                getFragmentManager().popBackStack();
            }
        });

        lists = (ListView)view.findViewById(R.id.lists);
        //demo
        array = new ArrayList<>();

        for (int i = 0; i < pathsTransferShortName.length; i++) {
            ItemCurrentcySender item1 = new ItemCurrentcySender();
            item1.setShortName(pathsTransferShortName[i]);
            item1.setFullName(pathsTransferFullName[i]);
            array.add(item1);
        }

        ListAdapter customAdapter = new ListAdapter(getContext(), R.layout.cell_currency_sender, array);

        lists.setAdapter(customAdapter);

        lists.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                hideKeyboard(view);
                getFragmentManager().popBackStack();
            }
        });
    }


    private void hideKeyboard(View view){
        InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

    }

    class ListAdapter extends ArrayAdapter<ItemCurrentcySender> {

        private int resourceLayout;
        private Context mContext;
        public List<ItemCurrentcySender> data;

        public ListAdapter(Context context, int resource, List<ItemCurrentcySender> items) {
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

            ItemCurrentcySender p = getItem(position);

            if (p != null) {
                TextView ttName = (TextView) v.findViewById(R.id.textview_ShortName);
                TextView ttFullName = (TextView) v.findViewById(R.id.textview_FullName);

                if (ttName != null) {
                    ttName.setText(p.getShortName());
                }

                if (ttFullName != null) {
                    ttFullName.setText(p.getFullName());
                }

            }

            return v;
        }

    }
}

