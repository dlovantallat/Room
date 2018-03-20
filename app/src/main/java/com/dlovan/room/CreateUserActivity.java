package com.dlovan.room;

import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * MainActivity
 * Created by dlovan on 3/20/18.
 */

public class CreateUserActivity extends AppCompatActivity {

    private static final String TAG = "TAG";
    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);

        final EditText firstName = findViewById(R.id.first_name);
        final EditText lastName = findViewById(R.id.last_name);
        final EditText email = findViewById(R.id.email);
        Button add = findViewById(R.id.add);

        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "users")
                .allowMainThreadQueries() // this is bad thing just for test in real app make it in the background
                .build();

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.userDao().insertAll(new User(firstName.getText().toString(),
                        lastName.getText().toString(), email.getText().toString()));
                finish();
            }
        });
    }
}