package in.nrg.sampleapps.scrollingviews.manager;

import android.content.Context;
import android.content.Intent;

import in.nrg.sampleapps.scrollingviews.activities.ListViewActivity;
import in.nrg.sampleapps.scrollingviews.activities.MultiTypeRecyclerActivity;
import in.nrg.sampleapps.scrollingviews.activities.RecyclerViewActivity;

/**
 * Class presenting all methods navigation to different screens
 *
 * @author Nayanesh Gupte
 */

public class NavigationManager {

    public static void showRecyclerViewDemo(Context context) {
        Intent intent = new Intent(context, RecyclerViewActivity.class);
        context.startActivity(intent);
    }

    public static void showListViewDemo(Context context) {
        Intent intent = new Intent(context, ListViewActivity.class);
        context.startActivity(intent);
    }

    public static void showMultiTypeViewDemo(Context context) {
        Intent intent = new Intent(context, MultiTypeRecyclerActivity.class);
        context.startActivity(intent);
    }
}
