package in.nrg.sampleapps.scrollingviews.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import in.nrg.sampleapps.R;
import in.nrg.sampleapps.scrollingviews.adapters.StudentListViewAdapter;
import in.nrg.sampleapps.scrollingviews.manager.DataManager;
import in.nrg.sampleapps.scrollingviews.manager.OnDataReadyListener;
import in.nrg.sampleapps.scrollingviews.model.Student;

import static in.nrg.sampleapps.utils.AppConstants.ARG_SECTION_NUMBER;


public class ListViewFragment extends Fragment implements
        AdapterView.OnItemClickListener,
        OnDataReadyListener {

    private ListView listView;

    private StudentListViewAdapter studentListViewAdapter;


    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static ListViewFragment newInstance(int sectionNumber) {
        ListViewFragment fragment = new ListViewFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //disable options menu only for this fragment
        setHasOptionsMenu(false);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list_view, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listView = (ListView) view.findViewById(R.id.listviewStudents);
        listView.setOnItemClickListener(this);

        studentListViewAdapter = new StudentListViewAdapter(getActivity());
        listView.setAdapter(studentListViewAdapter);

        loadData();
    }

    //------------------------------------------------------------------------------------
    //handle item clcik for ListView items
    //------------------------------------------------------------------------------------

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Student student = studentListViewAdapter.getItem(position);
        Toast.makeText(getActivity(), "Data: " + student + "\nPosition: " + position, Toast.LENGTH_SHORT).show();
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
