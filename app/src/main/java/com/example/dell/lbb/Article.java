package com.example.dell.lbb;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 5/19/2015.
 */
public class Article extends ActionBarActivity {

    PageAdapter pageAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.article);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        List<Fragment> fragments = getFragments();
        pageAdapter = new PageAdapter(getSupportFragmentManager(), fragments);
        ViewPager pager =
                (ViewPager) findViewById(R.id.viewpager);
        pager.setAdapter(pageAdapter);
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
            switch(id) {
                case android.R.id.home:
                    onBackPressed();
                    return true;

                case R.id.action_info:
                    // toggleList();
                    Intent intent=new Intent(this,ArticleDialog.class);
                    startActivity(intent);
                    return true;

                case R.id.action_tag:
                    Intent in=new Intent(this,ArticleTagDialog.class);
                    startActivity(in);
                    return true;

                default:
                    return super.onOptionsItemSelected(item);
            }

//        ActionBar mActionBar = getActionBar();
//        mActionBar.setDisplayShowHomeEnabled(false);
//        mActionBar.setDisplayShowTitleEnabled(false);
//
//        LayoutInflater mInflater = LayoutInflater.from(this);
//
//        View mCustomView = mInflater.inflate(R.layout.article_action, null);
//        ImageButton infoButton = (ImageButton) mCustomView
//                .findViewById(R.id.info);
//       // infoButton.setBackgroundResource(R.drawable.info);
//
//        ImageButton tagButton = (ImageButton) mCustomView
//                .findViewById(R.id.tag);
//
//        mActionBar.setCustomView(mCustomView);
//        mActionBar.setDisplayShowCustomEnabled(true);


    }
    class PageAdapter extends FragmentPagerAdapter {

        private List<Fragment> fragments;

        public PageAdapter(FragmentManager fm, List<Fragment> fragments) {
            super(fm);
            this.fragments = fragments;
        }


        @Override
        public Fragment getItem(int position) {
            return this.fragments.get(position);
        }

        @Override
        public int getCount() {
            return this.fragments.size();
        }
    }

    public List<Fragment> getFragments() {
        List<Fragment> fList = new ArrayList<>();

        fList.add(ArticleTitleFragment.newInstance("Fragment Title"));
        fList.add(ArticleDescriptionFragment.newInstance("Fragment Article"));
        fList.add(ArticlePostFragment.newInstance("Fragment Post"));

        return fList;

    }
}
