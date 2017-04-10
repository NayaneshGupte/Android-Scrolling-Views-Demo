package in.nrg.sampleapps.scrollingviews.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import in.nrg.sampleapps.scrollingviews.R;
import in.nrg.sampleapps.scrollingviews.model.Student;

/**
 * View holder class for RecyclerAdapter. This class represents single row of RecyclerView
 *
 * @author Nayanesh Gupte
 */
class StudentViewHolder extends RecyclerView.ViewHolder {

    View itemView;

    private TextView textViewName;

    private TextView textViewRollNo;

    private TextView textViewStandard;

    public StudentViewHolder(View itemView) {
        super(itemView);

        this.itemView = itemView;
        textViewName = (TextView) itemView.findViewById(R.id.textView_name);
        textViewRollNo = (TextView) itemView.findViewById(R.id.textView_rollno);
        textViewStandard = (TextView) itemView.findViewById(R.id.textView_standard);
    }

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