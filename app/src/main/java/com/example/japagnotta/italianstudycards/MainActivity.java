package com.example.japagnotta.italianstudycards;

import android.app.Activity;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import layout.Future;
import layout.Imperfect;
import layout.ImperfectEssere;
import layout.PastConditional;
import layout.PastPerfect;
import layout.PastPerfectwEssere;
import layout.Present;
import layout.PresentConditional;
import layout.PresentPerfect;
import layout.PresentSubjunctive;

public class MainActivity extends AppCompatActivity
         {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    FragmentPagerAdapter adapterViewPager;

    /**
     * The {@link ViewPager} that will host the section contents.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        ViewPager mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(adapterViewPager);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Fragment myFrag = adapterViewPager.getItem(position);

                System.out.println(myFrag.toString());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

//    public void onFutureFragmentInteraction(int position){
//        this.getSupportActionBar().setTitle(R.string.future_toolbar);
//    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class MyPagerAdapter extends FragmentPagerAdapter {
        private int NUM_ITEMS = 10;

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            switch (position) {
                case 0: // Fragment # 0 - This will show FirstFragment
                    return Present.newInstance(0, "Page # 1");
                case 1: // Fragment # 0 - This will show FirstFragment different title
                    return PresentPerfect.newInstance(1, "Page # 2");
                case 2: // Fragment # 1 - This will show SecondFragment
                    return Imperfect.newInstance(2, "Page # 3");
                case 3: // Fragment # 1 - This will show SecondFragment
                    return ImperfectEssere.newInstance(3, "Page # 4");
                case 4: // Fragment # 1 - This will show SecondFragment
                    return PastPerfect.newInstance(4, "Page # 5");
                case 5: // Fragment # 1 - This will show SecondFragment
                    return PastPerfectwEssere.newInstance(5, "Page # 6");
                case 6: // Fragment # 1 - This will show SecondFragment
                    return PresentConditional.newInstance(6, "Page # 7");
                case 7: // Fragment # 1 - This will show SecondFragment
                    return PastConditional.newInstance(7, "Page # 8");
                case 8: // Fragment # 1 - This will show SecondFragment
                    return Future.newInstance(8, "Page # 9");
                case 9: // Fragment # 1 - This will show SecondFragment
                    return PresentSubjunctive.newInstance(9, "Page # 10");
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return NUM_ITEMS;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "Page " + (position);
        }
    }
}
