package com.user.goservice;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      // new Task().execute();
        if (FirebaseAuth.getInstance().getCurrentUser() == null) {
            Intent intent = new Intent(this, AuthenticationActivity.class);
            startActivity(intent);
        } else {
          FirebaseAuth.getInstance().signOut();

            Intent intent = new Intent(this, AuthenticationActivity.class)
                    .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }
}