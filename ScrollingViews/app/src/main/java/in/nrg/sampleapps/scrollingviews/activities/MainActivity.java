package in.nrg.sampleapps.scrollingviews.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import in.nrg.sampleapps.scrollingviews.R;
import in.nrg.sampleapps.scrollingviews.manager.NavigationManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void showRecyclerViewDemo(View view) {
        NavigationManager.showRecyclerViewDemo(this);
    }

    public void showListViewDemo(View view) {
        NavigationManager.showListViewDemo(this);
    }
}
