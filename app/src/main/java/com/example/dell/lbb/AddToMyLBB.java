package com.example.dell.lbb;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.ImageButton;

/**
 * Created by dell on 5/22/2015.
 */
public class AddToMyLBB extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_ACTION_BAR);
        setContentView(R.layout.addtomylbb_layout);
        WindowManager.LayoutParams wmlp = getWindow().getAttributes();
        wmlp.gravity = Gravity.TOP;
        getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        ImageButton select=(ImageButton)findViewById(R.id.ib_heart);
        Animation mAnimation = new AlphaAnimation(1, 0);
        mAnimation.setDuration(200);
        mAnimation.setInterpolator(new LinearInterpolator());
        mAnimation.setRepeatCount(Animation.INFINITE);
        mAnimation.setRepeatMode(Animation.REVERSE);
        select.startAnimation(mAnimation);
        select.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                v.clearAnimation();


            }
        });
        //getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        // getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);

        //WindowManager.LayoutParams wmlp = getWindow().getAttributes();
        //wmlp.gravity = Gravity.TOP;
    }

    public void openDiscover(View view){
//go to discover fragment
        Intent intent = new Intent(this, MainLbb.class);
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
