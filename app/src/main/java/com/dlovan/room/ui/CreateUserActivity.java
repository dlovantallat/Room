package com.dlovan.room.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.dlovan.room.R;
import com.dlovan.room.db.User;

/**
 * MainActivity
 * Created by dlovan on 3/20/18.
 */

public class CreateUserActivity extends AppCompatActivity {

    private static final String TAG = "TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);

        final EditText firstName = findViewById(R.id.first_name);
        final EditText lastName = findViewById(R.id.last_name);
        final EditText email = findViewById(R.id.email);
        Button add = findViewById(R.id.add);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserViewModel userViewModel = ViewModelProviders.of(CreateUserActivity.this)
                        .get(UserViewModel.class);
                userViewModel.insertUser(new User(firstName.getText().toString(),
                        lastName.getText().toString(), email.getText().toString()));
                finish();
            }
        });
    }
}