package com.dscglbajaj.lunchboxpartner.adapters;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dscglbajaj.lunchboxpartner.adapters.viewholder.StudentViewHolder;
import com.dscglbajaj.lunchboxpartner.models.Student;

import java.util.ArrayList;

public class StudentsAdapter extends RecyclerView.Adapter<StudentViewHolder> {

    private ArrayList<Student> mStudentDataSet;

    public StudentsAdapter(ArrayList<Student> studentDataSet) {
        this.mStudentDataSet = studentDataSet;
    }


    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
