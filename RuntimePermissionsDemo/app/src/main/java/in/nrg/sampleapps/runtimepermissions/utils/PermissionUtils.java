package in.nrg.sampleapps.runtimepermissions.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.content.ContextCompat;

/**
 * @author Nayanesh Gupte
 */

public class PermissionUtils {

    /**
     * Check if permission is already granted only if App is running on device with Android M and above
     *
     * @param context
     * @param permission
     * @return
     */
    public static boolean hasPermission(Context context, String permission) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return (ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED);
        }
        return true;
    }
}
