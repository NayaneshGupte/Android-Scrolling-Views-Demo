package in.nrg.sampleapps.storage.preferences;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Handle all shared preferences operations through this class
 *
 * @author Nayanesh Gupte
 */
public class SharedPreferenceManager {

    private Context context;

    private SharedPreferences preferences;

    private static SharedPreferenceManager sInstance;

    private SharedPreferenceManager(Context context) {
        this.context = context;
        preferences = context.getSharedPreferences("LOGIN_APP", Context.MODE_PRIVATE);
    }


    public static SharedPreferenceManager getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new SharedPreferenceManager(context);
        }
        return sInstance;
    }

    public void addValue(String key, int value) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(key, value);
        editor.commit();
    }


    public void addValue(String key, String value) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public void addValue(String key, boolean value) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    public int getValue(String key, int defaultValue) {
        return preferences.getInt(key, defaultValue);
    }

    public String getValue(String key, String defaultValue) {
        return preferences.getString(key, defaultValue);
    }

    public boolean getValue(String key, boolean defaultValue) {
        return preferences.getBoolean(key, defaultValue);
    }


    public void clearPreferences() {
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
    }

    public void remove(String key) {

        SharedPreferences.Editor editor = preferences.edit();
        editor.remove(key);
    }
}
