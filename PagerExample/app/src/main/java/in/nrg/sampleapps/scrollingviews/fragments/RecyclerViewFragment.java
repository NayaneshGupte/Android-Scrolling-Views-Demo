package in.nrg.sampleapps.scrollingviews.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import in.nrg.sampleapps.R;
import in.nrg.sampleapps.scrollingviews.adapters.StudentRecyclerAdapter;
import in.nrg.sampleapps.scrollingviews.manager.DataManager;
import in.nrg.sampleapps.scrollingviews.manager.OnDataReadyListener;
import in.nrg.sampleapps.scrollingviews.model.Student;
import in.nrg.sampleapps.utils.OnRecycleViewItemClickListener;

import static in.nrg.sampleapps.utils.AppConstants.ARG_SECTION_NUMBER;
import static in.nrg.sampleapps.utils.AppConstants.KEY_POSITION;
import static in.nrg.sampleapps.utils.AppConstants.KEY_STUDENT;


public class RecyclerViewFragment extends Fragment implements
        OnRecycleViewItemClickListener,
        OnDataReadyListener {

    private static final int GRID_COLUMN_COUNT = 2;
    private RecyclerView recyclerView;

    private StudentRecyclerAdapter studentRecyclerAdapter;

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static RecyclerViewFragment newInstance(int sectionNumber) {
        RecyclerViewFragment fragment = new RecyclerViewFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //enable options menu only for this fragment
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recycler_view, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

        studentRecyclerAdapter = new StudentRecyclerAdapter(getActivity());
        studentRecyclerAdapter.setOnRecycleViewItemClickListener(this);
        recyclerView.setAdapter(studentRecyclerAdapter);

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
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    /**
     * Set Horizontal Scrolling
     */
    private void setHorizontalView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);
    }


    /**
     * Set Grid with Vertical Orientation
     */
    private void setVerticalGridView() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), GRID_COLUMN_COUNT);
        gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(gridLayoutManager);
    }

    /**
     * Set Grid with Horizontal orientation
     */
    private void setHorizontalGridView() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), GRID_COLUMN_COUNT);
        gridLayoutManager.setOrientation(GridLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(gridLayoutManager);
    }

    //------------------------------------------------------------------------------------
    //handle optionsMenu
    //------------------------------------------------------------------------------------


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

        inflater.inflate(R.menu.menu_recycler, menu);

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
    //OnItemClick for RecyclerView
    //------------------------------------------------------------------------------------
    @Override
    public void onItemClicked(Bundle bundle) {
        Student student = bundle.getParcelable(KEY_STUDENT);
        int position = bundle.getInt(KEY_POSITION);

        Toast.makeText(getActivity(), "Data: " + student + "\nPosition: " + position, Toast.LENGTH_SHORT).show();
    }
}
