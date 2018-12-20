package com.dxd.dxdpay;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dxd.dxdpay.model.ItemHistory;

import java.util.ArrayList;
import java.util.List;

public class HistoryFragment extends Fragment {
    List<ItemHistory> array;

    // The onCreateView method is called when Fragment should create its View object hierarchy,
    // either dynamically or via XML layout inflation.
    private ListView lists;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        return inflater.inflate(R.layout.fragment_history, parent, false);
    }

    // This event is triggered soon after onCreateView().
    // Any view setup should occur here.  E.g., view lookups and attaching view listeners.
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // Setup any handles to view objects here
        // EditText etFoo = (EditText) view.findViewById(R.id.etFoo);
        lists = (ListView)view.findViewById(R.id.lists);
        RelativeLayout relative_no_history = (RelativeLayout)view.findViewById(R.id.relative_no_history);
        LinearLayout layout_history = view.findViewById(R.id.layout_history);

        ImageButton button_BackToHome = (ImageButton)view.findViewById(R.id.button_BackToHome);
        button_BackToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainFragment mainFragment = (MainFragment)getParentFragment();
                mainFragment.bottomBar.selectTabAtPosition(0);
            }
        });


        array = new ArrayList<>();
        //demo
        getListItem();



        if (array.size() == 0){
            relative_no_history.setVisibility(View.VISIBLE);
            layout_history.setVisibility(View.GONE);
        }
        else {
            ListAdapter customAdapter = new ListAdapter(getContext(), R.layout.cell_history, array);
            lists .setAdapter(customAdapter);
        }
    }

    public void getListItem(){
        array.clear();

        for (int i = 0; i < 15; i++){
            ItemHistory item = new ItemHistory();
            item.setName("Arthur kabore");
            item.setContry("Burkina faso");
            item.setAmount("27.500,00");
            item.setBank("FCFA");
            array.add(item);
        }
    }

    class ListAdapter extends ArrayAdapter<ItemHistory> {

        private int resourceLayout;
        private Context mContext;

        public ListAdapter(Context context, int resource, List<ItemHistory> items) {
            super(context, resource, items);
            this.resourceLayout = resource;
            this.mContext = context;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View v = convertView;

            if (v == null) {
                LayoutInflater vi;
                vi = LayoutInflater.from(mContext);
                v = vi.inflate(resourceLayout, null);
            }

            ItemHistory p = getItem(position);

            if (p != null) {
                TextView ttName = (TextView) v.findViewById(R.id.textview_Name);
                TextView ttCountry = (TextView) v.findViewById(R.id.textview_Country);
                TextView ttAmount = (TextView) v.findViewById(R.id.textview_Amount);
                TextView ttBank = (TextView) v.findViewById(R.id.textview_Bank);

                if (ttName != null) {
                    ttName.setText(p.getName());
                }

                if (ttCountry != null) {
                    ttCountry.setText(p.getContry());
                }

                if (ttAmount != null) {
                    ttAmount.setText(p.getAmount());
                }

                if (ttBank != null) {
                    ttBank.setText(p.getBank());
                }
            }

            return v;
        }

    }
}

