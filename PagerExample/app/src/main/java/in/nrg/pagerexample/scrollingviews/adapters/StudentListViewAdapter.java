package in.nrg.sampleapps.scrollingviews.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import in.nrg.sampleapps.scrollingviews.R;
import in.nrg.sampleapps.scrollingviews.model.Student;

/**
 * Adapter presenting data in ListView
 *
 * @author Nayanesh Gupte
 */
public class StudentListViewAdapter extends BaseAdapter {

    private ArrayList<Student> listStudents;

    private LayoutInflater inflater;

    public StudentListViewAdapter(Context context) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        listStudents = new ArrayList<>();
    }

    public void addData(Student student) {
        this.listStudents.add(student);
        notifyDataSetChanged();
    }

    public void setData(ArrayList<Student> listStudents) {
        this.listStudents.clear();
        this.listStudents.addAll(listStudents);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return listStudents.size();
    }

    @Override
    public Student getItem(int position) {
        return listStudents.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ListViewHolder holder;

        if (null == convertView) {
            holder = new ListViewHolder();
            convertView = inflater.inflate(R.layout.row_student_data, parent, false);

            holder.textViewName = (TextView) convertView.findViewById(R.id.textView_name);

            holder.textViewRollNo = (TextView) convertView.findViewById(R.id.textView_rollno);

            holder.textViewStandard = (TextView) convertView.findViewById(R.id.textView_standard);

            convertView.setTag(holder);
        } else {

            holder = (ListViewHolder) convertView.getTag();
        }

        Student student = getItem(position);

        holder.bindData(student);

        return convertView;
    }
}
