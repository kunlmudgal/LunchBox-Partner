package com.dscglbajaj.lunchboxpartner.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dscglbajaj.lunchboxpartner.R;
import com.dscglbajaj.lunchboxpartner.adapters.viewholder.StudentViewHolder;
import com.dscglbajaj.lunchboxpartner.models.Student;

import java.util.ArrayList;

public class StudentsAdapter extends RecyclerView.Adapter<StudentViewHolder> implements Filterable {

    private ArrayList<Student> mStudentDataSet;
    private ArrayList<Student> mAllStudentDataSet;
    private Filter mFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            ArrayList<Student> filteredStudents = new ArrayList<>();
            FilterResults filterResults = new FilterResults();
            if (constraint == null || constraint.length() == 0) {
                filterResults.values = mAllStudentDataSet;
            } else {
                for (Student s :
                        mAllStudentDataSet) {
                    if (s.getName().toLowerCase().contains(constraint.toString().toLowerCase().trim())) {
                        filteredStudents.add(s);
                    }
                }
                filterResults.values = filteredStudents;
            }

            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            mStudentDataSet.clear();
            mStudentDataSet.addAll((ArrayList<Student>) results.values);
            notifyDataSetChanged();
        }
    };


    public StudentsAdapter(ArrayList<Student> studentDataSet) {
        this.mStudentDataSet = studentDataSet;
        this.mAllStudentDataSet = new ArrayList<Student>(studentDataSet);
    }

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // create a new view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.student_view_item, parent, false);
        StudentViewHolder studentViewHolder = new StudentViewHolder(view);
        return studentViewHolder;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        Student student = mStudentDataSet.get(position);
        holder.textViewStudentName.setText(student.getName());
        holder.imageViewStudentPhoto.setImageResource(R.drawable.ic_baseline_person_24);
        holder.textViewStudentRoomNo.setText("Room No x");
    }

    @Override
    public int getItemCount() {
        if (mStudentDataSet != null)
            return mStudentDataSet.size();
        return 0;
    }

    @Override
    public Filter getFilter() {
        return mFilter;
    }
}
