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
public class DiscoverFragment extends Fragment {

    public static DiscoverFragment newInstance() {
        DiscoverFragment fragment = new DiscoverFragment();
        Bundle args = new Bundle();
        return fragment;
    }

    public DiscoverFragment() {
        // Required empty public constructor
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (LinearLayout) inflater.inflate(R.layout.discover_tab, container, false);
    }
}
