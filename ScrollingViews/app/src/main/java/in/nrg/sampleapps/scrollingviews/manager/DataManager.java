package in.nrg.sampleapps.scrollingviews.manager;

import java.util.ArrayList;

import in.nrg.sampleapps.scrollingviews.R;
import in.nrg.sampleapps.scrollingviews.model.Model;
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
     * @return sample {@link ArrayList} of type {@link Student}
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
     * @return sample {@link ArrayList} of type {@link Model}
     */
    public static ArrayList<Model> getModelsData() {
        ArrayList<Model> list = new ArrayList<>();
        list.add(new Model(Model.TEXT_TYPE, "Hello. This is the Text-only View Type. ", 0));
        list.add(new Model(Model.IMAGE_TYPE, "Hi. I display a cool image too besides the omnipresent TextView.", R.drawable.wtc));
        list.add(new Model(Model.AUDIO_TYPE, "Hey. Pressing the FAB button will playback an audio file on loop.", R.raw.sound));
        list.add(new Model(Model.IMAGE_TYPE, "Hi again. Another cool image here. Which one is better?", R.drawable.snow));
        list.add(new Model(Model.TEXT_TYPE, "Hello. This is the Text-only View Type. ", 0));
        list.add(new Model(Model.IMAGE_TYPE, "Hi again. Another cool image here. Which one is better?", R.drawable.snow));
        list.add(new Model(Model.IMAGE_TYPE, "Hi. I display a cool image too besides the omnipresent TextView.", R.drawable.wtc));
        list.add(new Model(Model.TEXT_TYPE, "Hello. This is the Text-only View Type. ", 0));
        list.add(new Model(Model.TEXT_TYPE, "Hello. This is the Text-only View Type. ", 0));
        list.add(new Model(Model.TEXT_TYPE, "Hello. This is the Text-only View Type. ", 0));
        list.add(new Model(Model.IMAGE_TYPE, "Hi. I display a cool image too besides the omnipresent TextView.", R.drawable.wtc));

        return list;
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
