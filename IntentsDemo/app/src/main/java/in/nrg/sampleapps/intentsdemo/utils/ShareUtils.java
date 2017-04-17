package in.nrg.sampleapps.intentsdemo.utils;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import in.nrg.sampleapps.intentsdemo.R;

/**
 * Utils class for handling some implicit intent methods
 *
 * @author Nayanesh Gupte
 */

public class ShareUtils {


    /**
     * Implicit Intent: Intent knows about possible criteria to be satisfied. E.g. Action, mimeType etc.
     * But Intent doesn't know exact Activity class to be be invoked.
     * <p>
     * If criteria passed to intent doesn't match any activity in device then it will
     * throw {@link ActivityNotFoundException}
     * <p>
     * Find all such activities from all the apps installed which support
     * action as Intent.ACTION_SEND and mimeType as "text/*"
     *
     * @param context
     * @param shareText text to be shared
     */
    public static void shareText(Context context, String shareText) {
        Intent sendIntent = new Intent();
        //set action for implicit intent
        sendIntent.setAction(Intent.ACTION_SEND);
        //mime type
        sendIntent.setType("text/*");

        //array of pre-filled emails. (optional)
        sendIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"foo@example.com", "hello@google.com"});
        //subject line (optional)
        sendIntent.putExtra(Intent.EXTRA_SUBJECT, "Test Subject");
        //text to be shared
        sendIntent.putExtra(Intent.EXTRA_TEXT, shareText);

        if (sendIntent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(Intent.createChooser(sendIntent, context.getString(R.string.title_share_chooser)));
        } else {
            Toast.makeText(context, R.string.error_msg_activity_not_found, Toast.LENGTH_SHORT).show();
        }
    }
}
