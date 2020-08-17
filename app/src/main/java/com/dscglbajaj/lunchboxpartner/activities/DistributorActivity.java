package com.dscglbajaj.lunchboxpartner.activities;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dscglbajaj.lunchboxpartner.R;
import com.dscglbajaj.lunchboxpartner.adapters.StudentsAdapter;
import com.dscglbajaj.lunchboxpartner.models.Student;

import java.util.ArrayList;

public class DistributorActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private RecyclerView recyclerView;
    private StudentsAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private ArrayList<Student> students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distributor);

        recyclerView = findViewById(R.id.students_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        mAdapter = new StudentsAdapter(getSampleStudentsData());
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.distributor_menu, menu);
        MenuItem menuItem = menu.findItem(R.id.app_bar_search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("Search By name, room no");
        searchView.setOnQueryTextListener(this);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        //TODO: Filer the students
        mAdapter.getFilter().filter(newText);
        return false;
    }


    private ArrayList<Student> getSampleStudentsData() {
        students = new ArrayList<>();
        //TODO: Refract sample data to fetch data from database
        students.add(new Student("Kunal Mudgal"));
        students.add(new Student("Mayank Tyagi"));
        students.add(new Student("Utkarsh Singh"));
        students.add(new Student("Yash Talan"));
        return students;
    }
}