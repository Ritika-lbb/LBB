package com.example.dell.lbb;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by dell on 5/21/2015.
 */
public class ArticlePostFragment extends Fragment {
    public static final String EXTRA_MESSAGE = "EXTRA_MESSAGE";

    public static final ArticlePostFragment newInstance(String message)
    {
        ArticlePostFragment f = new ArticlePostFragment();
        Bundle bdl = new Bundle(1);
        bdl.putString(EXTRA_MESSAGE, message);
        f.setArguments(bdl);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String message = getArguments().getString(EXTRA_MESSAGE);
        View v = inflater.inflate(R.layout.relatedpost_layout, container, false);
        // TextView messageTextView = (TextView)v.findViewById(R.id.textView);
        //messageTextView.setText(message);

        return v;
    }
}
