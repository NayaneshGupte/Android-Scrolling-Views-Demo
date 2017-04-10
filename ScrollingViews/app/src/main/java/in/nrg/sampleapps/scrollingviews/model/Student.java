package in.nrg.sampleapps.scrollingviews.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * POJO class to display data in ListView / RecyclerView
 *
 * @author Nayanesh Gupte
 */
public class Student implements Parcelable {

    private String name;

    private String rollNo;

    private String standard;


    public Student() {
    }

    /**
     * @param name
     * @param rollNo
     * @param standard
     */
    public Student(String name, String rollNo, String standard) {
        this.name = name;
        this.rollNo = rollNo;
        this.standard = standard;
    }

    protected Student(Parcel in) {
        name = in.readString();
        rollNo = in.readString();
        standard = in.readString();
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(rollNo);
        dest.writeString(standard);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", rollNo='" + rollNo + '\'' +
                ", standard='" + standard + '\'' +
                '}';
    }
}
