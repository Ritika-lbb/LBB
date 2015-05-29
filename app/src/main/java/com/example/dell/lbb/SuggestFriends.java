package com.example.dell.lbb;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.example.dell.lbb.MainLbb;
import com.example.dell.lbb.R;

/**
 * Created by Simran on 5/13/2015.
 */
public class SuggestFriends extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.suggest_friends_layout);

        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        WindowManager.LayoutParams wmlp = getWindow().getAttributes();
        wmlp.gravity = Gravity.NO_GRAVITY;
    }

    public void openDiscover(View view){
//go to discover fragment
        Intent intent = new Intent(this, MainLbb.class);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
        this.startActivity(intent);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        //inflater.inflate(R.menu.menu_addtomylbb, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
