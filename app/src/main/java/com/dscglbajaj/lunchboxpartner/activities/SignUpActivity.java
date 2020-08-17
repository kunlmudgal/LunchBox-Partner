package com.dscglbajaj.lunchboxpartner.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.dscglbajaj.lunchboxpartner.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class SignUpActivity extends AppCompatActivity {

    private EditText userName, userEmail, userNumber, userPassword, userVPassword,hostelName;
    private Button regButton;
    private TextView userLogin;
    private CheckBox TermsandCoditions;
    private Spinner userBlood, userGender;
    private List<String> mGender;
    private List<String> bloodGroupList;

    private FirebaseAuth mAuth;
    private DatabaseReference mdatabase;
    ProgressBar progressBar;
    TextView textViewLocation;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        setUIViews();

        mAuth = FirebaseAuth.getInstance();
        mdatabase = FirebaseDatabase.getInstance().getReference();

        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate()){
                    String user_name = userName.getText().toString().trim();
                    String user_password = userPassword.getText().toString().trim();
                    String hostel_name=hostelName.getText().toString().trim();
                    String user_email = userEmail.getText().toString().trim();
                    String user_verifyPassword = userVPassword.getText().toString().trim();
                    String user_mobileNumber = userNumber.getText().toString().trim();

                    if (user_verifyPassword.equals(user_password))   //conform password code
                    {

                        //email and password code
                        mAuth.createUserWithEmailAndPassword(user_email, user_password)
                                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {

                                        if (!task.isSuccessful()) {
                                            Toast.makeText(SignUpActivity.this,
                                                    "Signup Error", Toast.LENGTH_SHORT).show();
                                        } else {

                                            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                                            DatabaseReference databaseReference = firebaseDatabase.getReference();
                                            String user_id = FirebaseAuth.getInstance().getUid();
                                            DatabaseReference current_user_db = mdatabase.child("User").child(user_id);

                                            current_user_db.child("UserName").setValue(userName.getText().toString());
                                            current_user_db.child("Hostel").setValue(hostelName.getText().toString());
                                            current_user_db.child("Phone").setValue(userNumber.getText().toString());
                                            current_user_db.child("Email").setValue(userEmail.getText().toString());


//                                            databaseReference.child("Users").child(userName.getText().toString()).child(user_id)
//                                                    .child("UserPhone").setValue(userName.getText().toString());
//
//                                            databaseReference.child("Users").child(hostelName.getText().toString()).child(user_id)
//                                                    .child("UserName").setValue(hostelName.getText().toString());
//
//
//                                            databaseReference.child("Users").child(userNumber.getText().toString()).child(user_id)
//                                                    .child("UserName").setValue(userNumber.getText().toString());
//
//
//                                            databaseReference.child("Users").child(userEmail.getText().toString()).child(user_id)
//                                                    .child("UserEmail").setValue(userEmail.getText().toString());













//                                            Map<String, String> newPost = new HashMap<>();
//                                            newPost.put("Name", userName.getText().toString());
//                                            newPost.put("Email", userEmail.getText().toString());
//                                            newPost.put("Gender", String.valueOf(mGender));
//                                            newPost.put("Phone", userNumber.getText().toString());
//                                            newPost.put("Blood Group", mBloodGroup);
//                                            newPost.put("City", userCity.getText().toString());
//
//                                            current_user_db.push().setValue(newPost);
                                            Toast.makeText(SignUpActivity.this, "Registrion Successfull", Toast.LENGTH_SHORT).show();
                                            startActivity(new Intent(SignUpActivity.this
                                                    , PartnerActivity.class));
                                            finish();
                                        }
                                    }
                                });
                    } else {
                        Toast.makeText(SignUpActivity.this, "Password didn't match",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }


    private boolean validate() {
        boolean result = false;

        String name = userName.getText().toString();
        String password = userPassword.getText().toString();
        String hostel=hostelName.getText().toString();
        String email = userEmail.getText().toString();
        String verifyPassword = userVPassword.getText().toString();
        String mobileNumber = userNumber.getText().toString();


        if (name.isEmpty()) {
            userName.setError("Name is Required");
            userName.requestFocus();

        } else if (email.isEmpty()) {
            userEmail.setError("Email is Required");
            userEmail.requestFocus();

        } else if (mobileNumber.isEmpty()) {
            userNumber.setError("Phone is Required");
            userNumber.requestFocus();

        } else if (password.isEmpty()) {
            userPassword.setError("Password is Required");
            userPassword.requestFocus();
        } else if (verifyPassword.isEmpty()) {
            userVPassword.setError("Confirm Password");
            userVPassword.requestFocus();

        }else if(hostel.isEmpty()){
            hostelName.setError("Enter Hostel Name");
            hostelName.requestFocus();
        }
        else {


            result = true;

        }

        return result;

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
        finish();
    }
    private void setUIViews() {
        userName = findViewById(R.id.etName);
        hostelName=findViewById(R.id.hostelname);
        userEmail = findViewById(R.id.etEmail);
        userNumber = findViewById(R.id.etPhone);
        userPassword = findViewById(R.id.etPassword);
        userVPassword = findViewById(R.id.etVerifyPassword);
        regButton = findViewById(R.id.btnSignUp);
        userLogin = findViewById(R.id.tvLogin);
        TermsandCoditions = findViewById(R.id.checkBox);


    }
}