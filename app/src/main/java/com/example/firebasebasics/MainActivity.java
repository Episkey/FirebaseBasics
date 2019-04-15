package com.example.firebasebasics;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button saveButton = findViewById(R.id.buttonSend);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText etPseudo = findViewById(R.id.etPseudo);
                EditText etScore = findViewById(R.id.etScore);

                String pseudo = etPseudo.getText().toString();
                String score = etScore.getText().toString();

                if (pseudo.isEmpty() || score.isEmpty()) {
                    Toast.makeText(MainActivity.this, R.string.fill_all_fields, Toast.LENGTH_SHORT).show();
                } else {
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    final Players players = new Players(pseudo, score);
                    DatabaseReference playerRef = database.getReference("players");
                    playerRef.push().setValue(players);
                }
            }
        });
    }
}
