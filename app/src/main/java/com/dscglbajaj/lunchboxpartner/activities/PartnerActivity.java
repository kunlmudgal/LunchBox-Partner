package com.dscglbajaj.lunchboxpartner.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.dscglbajaj.lunchboxpartner.R;
import com.google.firebase.auth.FirebaseAuth;

public class PartnerActivity extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    Button btn_logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partner);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.partner_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId) {
            case R.id.action_logout:
                logout();
                return true;
            case R.id.action_distributor:
                distributor();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void distributor() {
        startActivity(new Intent(PartnerActivity.this, DistributorActivity.class));
        finish();
    }

    private void logout() {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(PartnerActivity.this, LoginActivity.class));
        finish();
    }
}