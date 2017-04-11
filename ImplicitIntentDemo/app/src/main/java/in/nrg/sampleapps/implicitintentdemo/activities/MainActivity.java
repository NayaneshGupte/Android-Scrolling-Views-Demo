package in.nrg.sampleapps.implicitintentdemo.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import in.nrg.sampleapps.implicitintentdemo.R;

/**
 * Implicit Intent  - Explicit Intent Demo
 * <p>
 * Read more on
 * {@link <a href="https://developer.android.com/guide/components/intents-filters.html">IntentFilter documentation</a>}.
 *
 * @author Nayanesh Gupte
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Explicit intent: Because target activity is specified "EXPLICITLY".
     * <p>
     * StartActivity will invoke only one activity in this same application with exact same
     * class name i.e. ShareTextActivity.class
     */
    public void showShareTextScreen(View view) {
        Intent intent = new Intent(this, ShareTextActivity.class);
        startActivity(intent);
    }
}
