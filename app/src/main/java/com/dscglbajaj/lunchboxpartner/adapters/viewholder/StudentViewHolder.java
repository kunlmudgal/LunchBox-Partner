package com.dscglbajaj.lunchboxpartner.adapters.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dscglbajaj.lunchboxpartner.R;

public class StudentViewHolder extends RecyclerView.ViewHolder {
    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public TextView textViewStudentName;
    public ImageView imageViewStudentPhoto;
    public TextView textViewStudentRoomNo;

    public StudentViewHolder(@NonNull View itemView) {
        // each data item is just a string in this case
        super(itemView);
        imageViewStudentPhoto = itemView.findViewById(R.id.student_photo);
        textViewStudentName = itemView.findViewById(R.id.student_name);
        textViewStudentRoomNo = itemView.findViewById(R.id.student_room_no);
    }
}
