package in.nrg.sampleapps.scrollingviews.adapters;

import android.widget.TextView;

import in.nrg.sampleapps.scrollingviews.model.Student;


class ListViewHolder {

    TextView textViewName;

    TextView textViewRollNo;

    TextView textViewStandard;

    /**
     * Bind data from ArrayList to respective position in RecyclerView
     *
     * @param student data to set in every row
     */
    void bindData(Student student) {
        textViewName.setText(String.format("Name: %s", student.getName()));

        textViewRollNo.setText(String.format("Roll No: %s", student.getRollNo()));

        textViewStandard.setText(String.format("Standard: %s", student.getStandard()));
    }
}