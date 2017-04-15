package in.nrg.sampleapps.pagerexample.activities;

import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

import in.nrg.sampleapps.R;
import in.nrg.sampleapps.pagerexample.adapters.SectionsPagerAdapter;
import in.nrg.sampleapps.pagerexample.fragments.PlaceholderFragment;
import in.nrg.sampleapps.scrollingviews.fragments.ListViewFragment;
import in.nrg.sampleapps.scrollingviews.fragments.RecyclerViewFragment;

public class TabsActivity extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabs);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mSectionsPagerAdapter.setTitleArrayList(addTitles());

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

        mSectionsPagerAdapter.setData(addFragments());
    }


    private ArrayList<Fragment> addFragments() {
        ArrayList<Fragment> fragmentArrayList = new ArrayList<>();

        fragmentArrayList.add(PlaceholderFragment.newInstance(1));
        fragmentArrayList.add(ListViewFragment.newInstance(2));
        fragmentArrayList.add(RecyclerViewFragment.newInstance(3));

        return fragmentArrayList;
    }

    private ArrayList<String> addTitles() {
        ArrayList<String> titleArrayList = new ArrayList<>();

        titleArrayList.add(getString(R.string.title_plane));
        titleArrayList.add(getString(R.string.title_listView));
        titleArrayList.add(getString(R.string.title_recycler_view));

        return titleArrayList;
    }
}
