package com.example.dell.lbb;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by dell on 5/20/2015.
 */
public class EventFragment extends Fragment {

    public static EventFragment newInstance() {
        EventFragment fragment = new EventFragment();
        Bundle args = new Bundle();
        return fragment;
    }

    public EventFragment() {
        // Required empty public constructor
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (LinearLayout) inflater.inflate(R.layout.event_tab, container, false) ;
    }
}
