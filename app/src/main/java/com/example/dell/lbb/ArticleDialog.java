package com.example.dell.lbb;


import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import java.util.List;

/**
 * Created by dell on 5/22/2015.
 */
public class ArticleDialog extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        setContentView(R.layout.info_layout);

        if (getWindow().isFloating()) ArticleDialog.maxinumDialogWindowHeight(getWindow());
    }

    public static void maxinumDialogWindowHeight(Window window) {
        WindowManager.LayoutParams layout = new WindowManager.LayoutParams();
        layout.copyFrom(window.getAttributes());
        layout.height = WindowManager.LayoutParams.MATCH_PARENT;
        window.setAttributes(layout);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_article, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id) {
            case android.R.id.home:
                onBackPressed();
                return true;

            case R.id.action_info:
                // toggleList();
                Intent intent = new Intent(this, ArticleDialog.class);
                startActivity(intent);
                return true;

            case R.id.action_tag:
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
//    public Dialog onCreateDialog(Bundle savedInstanceState){
//        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
//        LayoutInflater inflater = getActivity().getLayoutInflater();
//        builder.setView(inflater.inflate(R.layout.info_layout, null));
//
//        return builder.create();
//    }
    }
}
