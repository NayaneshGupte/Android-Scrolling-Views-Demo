package in.nrg.sampleapps.scrollingviews.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import in.nrg.sampleapps.scrollingviews.R;
import in.nrg.sampleapps.scrollingviews.adapters.MultiViewTypeAdapter;
import in.nrg.sampleapps.scrollingviews.manager.DataManager;

public class MultiTypeRecyclerActivity extends AppCompatActivity {

    private RecyclerView recyclerMultiType;

    private MultiViewTypeAdapter multiViewTypeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_type_recycler);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerMultiType = (RecyclerView) findViewById(R.id.recyclerMultiType);

        multiViewTypeAdapter = new MultiViewTypeAdapter(this);
        multiViewTypeAdapter.setData(DataManager.getModelsData());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerMultiType.setLayoutManager(linearLayoutManager);
        recyclerMultiType.setItemAnimator(new DefaultItemAnimator());
        recyclerMultiType.setAdapter(multiViewTypeAdapter);
    }
}
