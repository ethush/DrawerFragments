package com.smartplace.drawerfragments;

import android.app.Activity;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.widget.ArrayAdapter;
import android.widget.TextView;


public class MainActivity extends Activity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;

    /**
     * Current Fragment reference
     */
    private Fragment mCurrentFragment;

    /**
     * Constants definitions
     */
    private static final int SECTION_1 = 0;
    private static final int SECTION_2 = 1;
    private static final int SECTION_3 = 2;
    private static final int SECTION_4 = 3;
    private static final int SECTION_5 = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //reference to the navigation drawer fragment in the xml
        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        FragmentManager fragmentManager = getFragmentManager();

        //according to the selected drawer item the reference for the current
        //fragment shall change with the new instance.

        //Each fragment contains its own view and code, allowing different
        //contents on each section of the drawer.
        switch (position){
            case SECTION_1:
                mCurrentFragment = SectionOneFragment.newInstance(position);
                break;
            case SECTION_2:
                mCurrentFragment = SectionTwoFragment.newInstance(position);
                break;
            case SECTION_3:
                mCurrentFragment = SectionThreeFragment.newInstance(position);
                break;
            case SECTION_4:
                mCurrentFragment = SectionFourFragment.newInstance(position);
                break;
            case SECTION_5:
                mCurrentFragment = SectionFiveFragment.newInstance(position);
                break;
        }

        //the container view is changed with the new current fragment
        fragmentManager.beginTransaction()
                .replace(R.id.container, mCurrentFragment)
                .commit();
    }

    public void onSectionAttached(int number) {
        //All section's titles shall be added here
        switch (number) {
            case SECTION_1:
                mTitle = getString(R.string.title_section1);
                break;
            case SECTION_2:
                mTitle = getString(R.string.title_section2);
                break;
            case SECTION_3:
                mTitle = getString(R.string.title_section3);
                break;
            case SECTION_4:
                mTitle = getString(R.string.title_section4);
                break;
            case SECTION_5:
                mTitle = getString(R.string.title_section5);
                break;
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.main, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
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

    /**
     * The place holder provided by default here shall be removed
     */
}
