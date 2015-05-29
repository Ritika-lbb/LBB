package com.example.dell.lbb;

import android.app.ActionBar;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import java.util.ArrayList;
import java.util.List;

import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Toast;


public class MainLbb extends ActionBarActivity {

    ActionBar actionBar;
    ViewPager viewPager;
    FragmentAdapter sectionPagerAdapter;
    PageAdapter pageAdapter;
    private static final String LIST_FRAGMENT_TAG = "list_fragment";
    int mylbbflag=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //  getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        setContentView(R.layout.activity_main_lbb);

        List<Fragment> fragments = getFragments();
        pageAdapter = new PageAdapter(getSupportFragmentManager(), fragments);
        ViewPager pager =
                (ViewPager) findViewById(R.id.viewpager);
        pager.setAdapter(pageAdapter);
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

        fList.add(MyFragment.newInstance("Fragment 1"));
        fList.add(MyFragment2.newInstance("Fragment 2"));
        fList.add(MyFragment3.newInstance("Fragment 3"));

        return fList;

    }
//        sectionPagerAdapter=new FragmentAdapter(getSupportFragmentManager());
//        viewPager = (ViewPager) findViewById(R.id.pager);
//        viewPager.setAdapter(sectionPagerAdapter);
//        viewPager.setCurrentItem(1);
//    }
//        ft=new FragmentAdapter(getSupportFragmentManager());
//
//
//        actionBar = getActionBar();
//        viewPager.setAdapter(ft);
//
//        //actionBar.setHomeButtonEnabled(true);
//       // actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
//        //actionBar.setTitle("Category");
//
//        actionBar.setDisplayOptions( ActionBar.DISPLAY_SHOW_TITLE | ActionBar.DISPLAY_SHOW_CUSTOM );
//        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
//
//
//        actionBar.addTab(actionBar.newTab().setText("Events").setTabListener(this));
//        actionBar.addTab(actionBar.newTab().setText("Discover").setTabListener(this));
//        actionBar.addTab(actionBar.newTab().setText("NearMe").setTabListener(this));
//        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//                actionBar.setSelectedNavigationItem(position);
//
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });
//
//    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        if(mylbbflag==1){
            String flag=Integer.toString(mylbbflag);
            //Log.wtf("i came here",flag);
            getMenuInflater().inflate(R.menu.menu_main_lbb, menu);
            menu.findItem(R.id.action_mylbb).setIcon(R.drawable.bubble);
        }
        else{
            getMenuInflater().inflate(R.menu.menu_main_lbb, menu);
        }
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
            case R.id.action_settings:

                return true;

            case R.id.action_category:
                // toggleList();
                Intent intent = new Intent(this, Category.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up);
                return true;

            case R.id.action_mylbb:
                Intent in = new Intent(this, MyLbb.class);
                startActivity(in);
                overridePendingTransition( R.anim.pull_in_right,R.anim.slide_out_left );
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

        public void openMyLbb(View view) {
            ///blink the actionbar button here
            //changeActionBar();
            mylbbflag=1;
            invalidateOptionsMenu();
            Intent intent = new Intent(this, AddToMyLBB.class);
            this.startActivity(intent);
        }

    public void openSuggestFriends(View view) {
        mylbbflag=1;
        invalidateOptionsMenu();
        Intent intent = new Intent(this, SuggestFriends.class);
        // overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
        this.startActivity(intent);

    }


    public void openToast(View view){
        mylbbflag=1;
        invalidateOptionsMenu();
        //Context context = getApplicationContext();
        CharSequence text = "Added to MYLBB";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(this, text, duration);
        toast.show();

    }

    public void openArticle(View view){
        Intent in=new Intent(this, Article.class);
        startActivity(in);
        overridePendingTransition(R.anim.slide_in_left, R.anim.stay);
    }

    public void openRightArticle(View view){
        Intent in=new Intent(this, Article.class);
        startActivity(in);
        overridePendingTransition(R.anim.pull_in_right, R.anim.stay);
    }



}

//    @Override
//    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
//        viewPager.setCurrentItem(tab.getPosition());
//
//    }
//
//    @Override
//    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
//
//    }
//
//    @Override
//    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
//
//    }


//    private void toggleList() {
//        Fragment f = getFragmentManager().findFragmentByTag(LIST_FRAGMENT_TAG);
//        if (f != null) {
//            getFragmentManager().popBackStack();
//        } else {
//            getFragmentManager().beginTransaction()
//                    .setCustomAnimations(R.anim.slide_up,
//                            R.anim.slide_down,
//                            R.anim.slide_up,
//                            R.anim.slide_down)
//                    .add(R.id.list_fragment_container, SlidingListFragment
//                                    .instantiate(this, SlidingListFragment.class.getName()),
//                            LIST_FRAGMENT_TAG
//                    ).addToBackStack(null).commit();
//     }

//}

