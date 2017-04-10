package in.nrg.sampleapps.scrollingviews.manager;

import java.util.ArrayList;

import in.nrg.sampleapps.scrollingviews.model.Student;

/**
 * Created by nayaneshg on 10/04/17.
 */

public interface OnDataReadyListener {

    void onDataReady(ArrayList<Student> studentArrayList);
}
