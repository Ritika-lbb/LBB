package com.example.dell.lbb;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by dell on 5/21/2015.
 */
public class MyFragment extends Fragment{
    public static final String EXTRA_MESSAGE = "EXTRA_MESSAGE";
    int mylbbflag=0;
    ImageButton imageButton, imageButton2, imageButton3;



    public static final MyFragment newInstance(String message)
    {
        MyFragment f = new MyFragment();
        Bundle bdl = new Bundle(1);
        bdl.putString(EXTRA_MESSAGE, message);
        f.setArguments(bdl);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String message = getArguments().getString(EXTRA_MESSAGE);
        View v = inflater.inflate(R.layout.myfragment_layout, container, false);
//        imageButton = (ImageButton)v.findViewById(R.id.imageButton1);
//        imageButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v1) {
//                openMyLbb(v1);
//            }
//        });
//
//        imageButton2=(ImageButton)v.findViewById(R.id.imageButton2);
//        imageButton2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v3) {
//                openSuggestFriends(v3);
//            }
//        });
//
//        imageButton3=(ImageButton)v.findViewById(R.id.imageButton3);
//        imageButton3.setOnClickListener(new View.OnClickListener(){
//            @Override
//                    public  void onClick(View v2){
//                openToast(v2);
//            }
//
//        });
        // TextView messageTextView = (TextView)v.findViewById(R.id.textView);
        //messageTextView.setText(message);

        return v;
    }

    public void openMyLbb(View view) {
        ///blink the actionbar button here
        //changeActionBar();
        mylbbflag=1;
        //invalidateOptionsMenu();
        Intent intent = new Intent(getActivity(), AddToMyLBB.class);
        this.startActivity(intent);
    }

    public void openSuggestFriends(View view) {
        mylbbflag=0;
        //invalidateOptionsMenu();
        Intent intent = new Intent(getActivity(), SuggestFriends.class);
        // overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
        this.startActivity(intent);

    }


    public void openToast(View view){
        mylbbflag=1;
       // invalidateOptionsMenu();
        //Context context = getApplicationContext();
        CharSequence text = "Added to MYLBB";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(getActivity(), text, duration);
        toast.show();

    }

}
