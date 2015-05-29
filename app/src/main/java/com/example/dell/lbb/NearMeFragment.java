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
public class NearMeFragment extends Fragment {

    public static NearMeFragment newInstance() {
        NearMeFragment fragment = new NearMeFragment();
        Bundle args = new Bundle();
        return fragment;
    }

    public NearMeFragment() {
        // Required empty public constructor
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (LinearLayout) inflater.inflate(R.layout.near_tab, container, false);
    }
}
