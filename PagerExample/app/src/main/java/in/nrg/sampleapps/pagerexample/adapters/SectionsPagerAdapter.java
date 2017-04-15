package in.nrg.sampleapps.pagerexample.adapters;


import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentPagerAdapter;

import java.util.ArrayList;


/**
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> fragmentArrayList;


    private ArrayList<String> titleArrayList;

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
        fragmentArrayList = new ArrayList<>();
        titleArrayList = new ArrayList<>();
    }

    public void setData(ArrayList<Fragment> fragmentArrayList) {
        this.fragmentArrayList.addAll(fragmentArrayList);
        notifyDataSetChanged();
    }

    public void setTitleArrayList(ArrayList<String> titleArrayList) {
        this.titleArrayList = titleArrayList;
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

        return fragmentArrayList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentArrayList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleArrayList.get(position);
    }
}