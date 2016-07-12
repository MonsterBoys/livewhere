package com.xu.hasee.livewhere.route;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.xu.hasee.livewhere.R;
import com.xu.hasee.livewhere.myinfo.LoginActivity;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;

/**
 * A simple {@link Fragment} subclass.
 */
public class RouteFragment extends Fragment {


    private Button button;

    public RouteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = null;
        Bmob.initialize(getActivity(), "0f03f96433b9be913fcd8337ea01dc18");
        BmobUser bmobUser = BmobUser.getCurrentUser(getActivity());
        String username = (String) bmobUser.getObjectByKey(getActivity(), "username");
        Log.d("Main", "username: " + username);
        if (username == null) {
            view = inflater.inflate(R.layout.fragment_route, null);
            button = ((Button) view.findViewById(R.id.button));
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getActivity(), LoginActivity.class));
                }
            });
        } else if (username != null) {
            view = inflater.inflate(R.layout.fragment_route1, null);
        }
        return view;
    }

}
