package in.nrg.sampleapps.pagerexample.adapters;


import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentPagerAdapter;

import in.nrg.sampleapps.pagerexample.fragments.PlaceholderFragment;
import in.nrg.sampleapps.scrollingviews.fragments.ListViewFragment;
import in.nrg.sampleapps.scrollingviews.fragments.RecyclerViewFragment;


/**
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    /**
     * getItem is called to instantiate the fragment for the given page
     * Return a PlaceholderFragment (defined as a static inner class below).
     *
     * @param position
     * @return
     */

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0: {
                return PlaceholderFragment.newInstance(position + 1);
            }
            case 1: {
                return ListViewFragment.newInstance(position + 1);
            }

            case 2: {
                return RecyclerViewFragment.newInstance(position + 1);
            }
        }

        return null;
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "PLANE";
            case 1:
                return "LIST VIEW";
            case 2:
                return "RECYCLER VIEW";
        }
        return null;
    }
}