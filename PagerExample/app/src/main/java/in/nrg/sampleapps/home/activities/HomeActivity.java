package in.nrg.sampleapps.home.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import in.nrg.sampleapps.R;
import in.nrg.sampleapps.home.fragments.HomeActivityFragment;

public class HomeActivity extends AppCompatActivity {

    public boolean isTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        addFragment();
    }

    private void addFragment() {
        Bundle bundle = getIntent().getExtras();

        HomeActivityFragment homeActivityFragment = new HomeActivityFragment();
        homeActivityFragment.setArguments(bundle);

        getFragmentManager().
                beginTransaction().
                add(R.id.fragment, homeActivityFragment, "HOME").
                commit();
    }

}
