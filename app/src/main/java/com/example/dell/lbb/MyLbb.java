package com.example.dell.lbb;


import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.ActionBarActivity;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by dell on 5/19/2015.
 */

public class MyLbb extends ActionBarActivity {
    Context context;
    ArrayList arrayList;
    public static String [] list={"Wendy, Gurgaon","Restaurant","Best Thekas","Treks for Summer","TV & Movie!","A Salad trail!!","Shop at HKV!","Food","LifeStyle"};
    public static int [] images={R.drawable.food,R.drawable.bollywood,R.drawable.stock,R.drawable.trek,R.drawable.tv,R.drawable.lbbart,R.drawable.lbbgiveaway,R.drawable.category_food,R.drawable.category_lifestyle};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_lbb);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        TextView mTextView=(TextView) findViewById(R.id.name);
        TextView nTextView=(TextView) findViewById(R.id.number);
        mTextView.setText("Adamm Micheal");

        /*Cursor  c = getApplication().getContentResolver().query(ContactsContract.Profile.CONTENT_URI, null, null, null, null);
        try {
            if(c.moveToFirst())
            mTextView.setText(c.getString(c.getColumnIndex(ContactsContract.Profile.DISPLAY_NAME)));
        }

        finally
        {
            c.close();
        }*/

        TelephonyManager telemamanger = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        String getSimNumber = telemamanger.getLine1Number();
        Log.wtf("Number", getSimNumber);
        //nTextView.setText(getSimNumber);
        //Toast.makeText(this, "Phone number: " + getSimNumber,  Toast.LENGTH_LONG).show();


        GridView gridview = (GridView) findViewById(R.id.gridView);
        gridview.setAdapter(new CustomAdapter(this, list, images));


        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(MyLbb.this, "" + position,
                        Toast.LENGTH_SHORT).show();
            }
        });


//        ActionBar mActionBar = getActionBar();
//        mActionBar.setDisplayShowHomeEnabled(false);
//        mActionBar.setDisplayShowTitleEnabled(false);
//
//        LayoutInflater mInflater = LayoutInflater.from(this);
//
//        View mCustomView = mInflater.inflate(R.layout.mylbb, null);
//        ImageButton imageButton = (ImageButton) mCustomView
//                .findViewById(R.id.imageButton);
//
//        TextView mTitleTextView = (TextView) mCustomView.findViewById(R.id.textView);
//        mTitleTextView.setText("MyLBB");
//
//        mActionBar.setCustomView(mCustomView);
//        mActionBar.setDisplayShowCustomEnabled(true);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.mylbb_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        switch(id) {

            case android.R.id.home:
                // toggleList();
                onBackPressed();
                return true;

            case R.id.action_lbb:
                Intent in= new Intent(this,MyLbb.class);
                startActivity(in);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
    }




