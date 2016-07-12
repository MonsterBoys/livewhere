package com.xu.hasee.livewhere.phone;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.xu.hasee.livewhere.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class PhoneFragment extends Fragment implements View.OnClickListener{


    private ImageButton ib_phhone;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_phone,null);
        ib_phhone = ((ImageButton) view.findViewById(R.id.ib_phone));
        ib_phhone.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        Intent intent =new Intent();

        intent.setAction("android.intent.action.CALL_BUTTON");

        startActivity(intent);
    }
}
