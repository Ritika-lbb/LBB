package com.example.dell.lbb;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by dell on 5/25/2015.
 */
public class Category extends ActionBarActivity {

    Context context;
    ArrayList arrayList;
    public static String [] list={"Wendy, Gurgaon","Restaurant","Best Thekas","Treks for Summer","TV & Movie!","A Salad trail!!","Shop at HKV!","Food","LifeStyle","Wendy, Gurgaon","Restaurant","Best Thekas","Treks for Summer","TV & Movie!"};
    public static int [] images={R.drawable.food,R.drawable.bollywood,R.drawable.stock,R.drawable.trek,R.drawable.tv,R.drawable.lbbart,R.drawable.lbbgiveaway,R.drawable.category_food,R.drawable.category_lifestyle,R.drawable.food,R.drawable.bollywood,R.drawable.stock,R.drawable.trek,R.drawable.tv};

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        GridView gridview = (GridView) findViewById(R.id.gridView);
        gridview.setAdapter(new CustomCategoryAdapter(this, list, images));


        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(Category.this, "" + position,
                        Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        getMenuInflater().inflate(R.menu.menu_category, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        if(id == android.R.id.home){
            onBackPressed();
            return true;
        }

        if (id == R.id.action_back) {
            Intent in= new Intent(this, MainLbb.class);
            startActivity(in);
            overridePendingTransition( R.anim.slide_in_down,R.anim.slide_out_down );
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
