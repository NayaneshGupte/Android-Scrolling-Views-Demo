package in.nrg.sampleapps.scrollingviews.manager;

import java.util.ArrayList;

import in.nrg.sampleapps.scrollingviews.model.Student;

/**
 * DataManager  is generating dummy data. Actual data can be retrieved from
 * Server / Firebase / Database etc.
 * <p>
 * OnDataReadyListener is used to simulate loading of dummy data.
 *
 * @author Nayanesh Gupte
 */
public class DataManager {

    private OnDataReadyListener onDataReadyListener;

    public DataManager(OnDataReadyListener onDataReadyListener) {
        this.onDataReadyListener = onDataReadyListener;
    }

    /**
     * @return {@link ArrayList} of type {@link Student}
     */
    public void getStudentsData() {
        ArrayList<Student> listStudents = new ArrayList<>();

        listStudents.add(new Student("Nayanesh", "10", "10th"));
        listStudents.add(new Student("Rahul", "11", "10th"));
        listStudents.add(new Student("Yash", "12", "10th"));
        listStudents.add(new Student("Aditi", "13", "10th"));
        listStudents.add(new Student("Kunal", "14", "10th"));
        listStudents.add(new Student("Saurabh", "15", "10th"));
        listStudents.add(new Student("Prachi", "16", "10th"));
        listStudents.add(new Student("Harsh", "17", "10th"));
        listStudents.add(new Student("Abhishek", "18", "10th"));
        listStudents.add(new Student("Aakanksha", "19", "10th"));
        listStudents.add(new Student("Deepa", "20", "10th"));
        listStudents.add(new Student("Aditya", "21", "10th"));

        onDataReadyListener.onDataReady(listStudents);
    }

    /**
     * Create new Student object to add to RecyclerView
     *
     * @return
     */
    public static Student getRandomStudentObject() {
        return new Student("Abc", "99", "10th");
    }
}
