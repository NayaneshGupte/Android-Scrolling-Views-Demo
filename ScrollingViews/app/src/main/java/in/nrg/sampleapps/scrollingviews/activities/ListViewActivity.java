package in.nrg.sampleapps.scrollingviews.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import in.nrg.sampleapps.scrollingviews.R;
import in.nrg.sampleapps.scrollingviews.adapters.StudentListViewAdapter;
import in.nrg.sampleapps.scrollingviews.manager.DataManager;
import in.nrg.sampleapps.scrollingviews.manager.OnDataReadyListener;
import in.nrg.sampleapps.scrollingviews.model.Student;

import static in.nrg.sampleapps.scrollingviews.R.id.fab;

public class ListViewActivity extends AppCompatActivity implements View.OnClickListener,
        AdapterView.OnItemClickListener,
        OnDataReadyListener {

    private ListView listView;

    private StudentListViewAdapter studentListViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listView = (ListView) findViewById(R.id.listviewStudents);
        listView.setOnItemClickListener(this);

        studentListViewAdapter = new StudentListViewAdapter(this);
        listView.setAdapter(studentListViewAdapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(this);

        loadData();
    }

    //------------------------------------------------------------------------------------
    //handle onClick for FAB
    //------------------------------------------------------------------------------------

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case fab: {
                studentListViewAdapter.addData(DataManager.getRandomStudentObject());
            }
            break;
        }
    }
    //------------------------------------------------------------------------------------
    //handle item clcik for ListView items
    //------------------------------------------------------------------------------------

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Student student = studentListViewAdapter.getItem(position);
        Toast.makeText(this, "Data: " + student + "\nPosition: " + position, Toast.LENGTH_SHORT).show();
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
        studentListViewAdapter.setData(studentArrayList);
    }
}
