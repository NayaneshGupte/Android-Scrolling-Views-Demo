package in.nrg.sampleapps.scrollingviews.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import in.nrg.sampleapps.scrollingviews.R;
import in.nrg.sampleapps.scrollingviews.adapters.StudentRecyclerAdapter;
import in.nrg.sampleapps.scrollingviews.manager.DataManager;
import in.nrg.sampleapps.scrollingviews.manager.OnDataReadyListener;
import in.nrg.sampleapps.scrollingviews.model.Student;
import in.nrg.sampleapps.scrollingviews.utils.OnRecycleViewItemClickListener;

import static in.nrg.sampleapps.scrollingviews.utils.AppConstants.KEY_POSITION;
import static in.nrg.sampleapps.scrollingviews.utils.AppConstants.KEY_STUDENT;

public class RecyclerViewActivity extends AppCompatActivity implements View.OnClickListener,
        OnRecycleViewItemClickListener,
        OnDataReadyListener {

    private static final int GRID_COLUMN_COUNT = 2;
    private RecyclerView recyclerView;

    private StudentRecyclerAdapter studentRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        studentRecyclerAdapter = new StudentRecyclerAdapter(this);
        studentRecyclerAdapter.setOnRecycleViewItemClickListener(this);
        recyclerView.setAdapter(studentRecyclerAdapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(this);

        //set default orientation
        setVerticalView();

        loadData();
    }

    /**
     * Load data and display in RecyclerView using adapter
     */
    private void loadData() {
        DataManager dataManager = new DataManager(this);
        dataManager.getStudentsData();
    }

    //------------------------------------------------------------------------------------
    //OnDataReadyListener callback
    //------------------------------------------------------------------------------------
    @Override
    public void onDataReady(ArrayList<Student> studentArrayList) {
        studentRecyclerAdapter.setData(studentArrayList);
    }

    //------------------------------------------------------------------------------------
    //Methods to change orientations
    //------------------------------------------------------------------------------------

    /**
     * Set Vertical Scrolling
     */
    private void setVerticalView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    /**
     * Set Horizontal Scrolling
     */
    private void setHorizontalView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);
    }


    /**
     * Set Grid with Vertical Orientation
     */
    private void setVerticalGridView() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, GRID_COLUMN_COUNT);
        gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(gridLayoutManager);
    }

    /**
     * Set Grid with Horizontal orientation
     */
    private void setHorizontalGridView() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, GRID_COLUMN_COUNT);
        gridLayoutManager.setOrientation(GridLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(gridLayoutManager);
    }

    //------------------------------------------------------------------------------------
    //handle optionsMenu
    //------------------------------------------------------------------------------------

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_recycler, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_linear_vertical: {
                setVerticalView();
            }
            break;

            case R.id.action_linear_horizontal: {
                setHorizontalView();
            }
            break;

            case R.id.action_grid_vertical: {
                setVerticalGridView();
            }
            break;

            case R.id.action_grid_horizontal: {
                setHorizontalGridView();
            }
            break;
        }
        return super.onOptionsItemSelected(item);
    }

    //------------------------------------------------------------------------------------
    //handle onClick for FAB
    //------------------------------------------------------------------------------------

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab:
                studentRecyclerAdapter.addData(DataManager.getRandomStudentObject());
                break;
        }
    }

    //------------------------------------------------------------------------------------
    //OnItemClick for RecyclerView
    //------------------------------------------------------------------------------------
    @Override
    public void onItemClicked(Bundle bundle) {
        Student student = bundle.getParcelable(KEY_STUDENT);
        int position = bundle.getInt(KEY_POSITION);

        Toast.makeText(this, "Data: " + student + "\nPosition: " + position, Toast.LENGTH_SHORT).show();
    }
}
