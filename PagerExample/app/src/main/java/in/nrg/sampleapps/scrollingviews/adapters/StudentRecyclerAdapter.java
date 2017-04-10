package in.nrg.sampleapps.scrollingviews.adapters;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import in.nrg.sampleapps.R;
import in.nrg.sampleapps.scrollingviews.model.Student;
import in.nrg.sampleapps.utils.OnRecycleViewItemClickListener;

import static in.nrg.sampleapps.utils.AppConstants.KEY_POSITION;
import static in.nrg.sampleapps.utils.AppConstants.KEY_STUDENT;


/**
 * RecyclerView Adapter
 *
 * @author Nayanesh Gupte
 */
public class StudentRecyclerAdapter extends RecyclerView.Adapter<StudentViewHolder> {

    private LayoutInflater inflater;

    private ArrayList<Student> listStudent;

    private OnRecycleViewItemClickListener onRecycleViewItemClickListener;

    public StudentRecyclerAdapter(Context context) {

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        listStudent = new ArrayList<>();
    }

    public void setOnRecycleViewItemClickListener(OnRecycleViewItemClickListener onRecycleViewItemClickListener) {
        this.onRecycleViewItemClickListener = onRecycleViewItemClickListener;
    }

    public void setData(ArrayList<Student> listStudent) {
        this.listStudent.addAll(listStudent);
        notifyDataSetChanged();
    }

    public void addData(Student Student) {
        this.listStudent.add(Student);
        notifyItemInserted(this.listStudent.size());
    }

    @Override
    public StudentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.row_student_data, parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StudentViewHolder holder, final int position) {
        final Student student = listStudent.get(position);

        //bind data to view holder
        holder.bindData(student);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != onRecycleViewItemClickListener) {
                    Bundle bundle = new Bundle();
                    bundle.putInt(KEY_POSITION, position);
                    bundle.putParcelable(KEY_STUDENT, student);

                    onRecycleViewItemClickListener.onItemClicked(bundle);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return listStudent.size();
    }
}
